// https://leetcode.com/problems/matrix-diagonal-sum/
/**
 * @param {number[][]} mat
 * @return {number}
 */
// 46ms
var diagonalSum = function (mat) {
  let result = 0;
  for (let i = 0; i < mat.length; i++) {
    result += mat[i][i];
    if (i !== mat.length - 1 - i) {
      result += mat[i][mat.length - 1 - i];
    }
  }
  return result;
};

// 34ms
var diagonalSum = function (mat) {
  let m = mat.length - 1;
  let sum = 0;
  for (let i = 0; i < mat.length; i++) {
    sum += mat[i][i];
    if (i != m) {
      sum += mat[i][m];
    }
    m--;
  }
  return sum;
};
