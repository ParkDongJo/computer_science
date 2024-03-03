// https://leetcode.com/problems/largest-submatrix-with-rearrangements/solutions/4331142/video-give-me-10-minutes-how-we-think-about-a-solution
/**
 * @param {number[][]} matrix
 * @return {number}
 */
var largestSubmatrix = function (matrix) {
  // 1을 앞으로 정렬한다.
  // 4각형의 조건
  // - (0, 0) null    null
  // - (1, 0) (1, 1), (1, 2)
  // - (2, 0) (2, 1), null

  // 각각의 위치에서 만들수 있는 사각형의 넓이를 계산해놓는 것
  // 9개 계산 ->
  //  - 0이면 해당 행 idx 저장!
  //  - 열이 0이면 계산 중단(break)
  let results = [];
  let boundCol = matrix[0].length - 1;
  for (let i = 0; i < matrix.length; i++) {
    for (let j = 0; j < matrix[i].length; j++) {
      let sum = 0;
      if (matrix[i][j] === 0) {
        continue;
      }
      for (let row = j; row < matrix.length; row++) {
        for (let col = i; col < boundCol; col++) {
          console.log("sum : ", i, j, row, col);
          if (matrix[col][row] === 1) {
            sum++;
          } else {
            boundCol = col;
            break;
          }
        }
      }
      results.push(sum);
    }
    console.log(results);

    return Math.max(...results);
  }
};

/*
높이 계산
[0,0,1]   [0,0,1]
[1,1,1] → [1,1,2]
[1,0,1]   [2,0,3]

너비 계산 = 열길이 - idx
[0,0,1]   [0,0,1]
[1,1,2] → [1,1,2]
[2,0,3]   [0,2,3]

각 컬럼별로 넓이 계산
[0,0,1]
[2,2,2]
[0,4,3]

하지만, 각 컬럼별로 넓이 최대값 계산
[0,0,1]
[3,3,3]
[3,4,4]

결과값 4

*/
var largestSubmatrix = function (matrix) {
  const row = matrix.length;
  const col = matrix[0].length;

  // Calculate heights for each column
  for (let i = 1; i < row; i++) {
    for (let j = 0; j < col; j++) {
      if (matrix[i][j] === 1) {
        matrix[i][j] += matrix[i - 1][j];
      }
    }
  }

  let res = 0;
  for (let i = 0; i < row; i++) {
    // Sort the heights in ascending order
    matrix[i].sort((a, b) => a - b);

    // Iterate through the sorted heights
    for (let j = 0; j < col; j++) {
      const height = matrix[i][j];
      const width = col - j;
      res = Math.max(res, height * width);
    }
  }

  return res;
};
