// https://leetcode.com/problems/sort-the-matrix-diagonally/description/
/**
 * @param {number[][]} mat
 * @return {number[][]}
 */
var diagonalSort = function (mat) {
  // 각 대각선 마다 재정렬, 오름차순
  // 각 대각선 마다
  // 6(m) x 3(n)
  // mat[2][0], mat[3][1], mat[4][2]
  // mat[4][2] <-- 2 + 1 가 끝이라고 판다

  // 끝에 대한 판단
  // x 가 x + 1 = m
  // y 가 y + 1 = n

  // 행
  let idx = 0;
  let prevY = -Infinity;
  for (let s = 0; s < mat[s].length; s++) {
    let z = s;
    prevY = 0;
    for (let y = 1; y < mat.length; y++) {
      if (mat[z][prevY] > mat[z][y]) {
        let temp = mat[z][y];
        mat[z][y] = mat[z][prevY];
        mat[z][prevY] = temp;
        prevY = y;
      }
      z++;
    }
  }

  console.log(mat);

  // 열
  for (let i = 0; i < mat.length; i++) {}
};

// 동일한 생각을 했는데,
// 다른 방법으로 풀었다.
// 나도 이런 방법을 생각했지만, 더 직접적으로 데이터를 다루고자 했다 하지만, 더 어렵게 풀는 꼴이였다.
// 아래와 같이 풀면 더 간단하게 풀 수 있다.
// 82ms
var diagonalSort = function (mat) {
  let width = mat[0].length;
  let height = mat.length;

  for (let j = 0; j < width; j++) {
    sortDiagonal(mat, 0, j);
  }
  for (let i = 0; i < height; i++) {
    sortDiagonal(mat, i, 0);
  }

  return mat;
};

function sortDiagonal(mat, i, j) {
  let arr = [];

  let k = i;
  let l = j;
  while (k < mat.length && l < mat[0].length) {
    arr.push(mat[k][l]);
    k++;
    l++;
  }

  arr.sort((a, b) => a - b);

  k = i;
  l = j;
  for (let x of arr) {
    mat[k][l] = x;
    k++;
    l++;
  }
}

// 53ms
var diagonalSort = function (mat) {
  const m = mat.length;
  const n = mat[0].length;

  // Helper function to sort the elements along a diagonal
  const sortDiagonal = (startRow, startCol) => {
    const diagonal = [];
    let i = startRow;
    let j = startCol;

    // Collect elements in the current diagonal
    while (i < m && j < n) {
      diagonal.push(mat[i][j]);
      i++;
      j++;
    }

    // Sort the diagonal elements
    diagonal.sort((a, b) => a - b);

    // Place the sorted elements back into the matrix
    i = startRow;
    j = startCol;
    let k = 0;
    while (i < m && j < n) {
      mat[i][j] = diagonal[k];
      i++;
      j++;
      k++;
    }
  };

  // Sort diagonals starting from the top row
  for (let i = 0; i < m; i++) {
    sortDiagonal(i, 0);
  }

  // Sort diagonals starting from the left column
  for (let j = 1; j < n; j++) {
    sortDiagonal(0, j);
  }

  return mat;
};
