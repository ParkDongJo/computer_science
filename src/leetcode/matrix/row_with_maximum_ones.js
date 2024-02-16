// https://leetcode.com/problems/row-with-maximum-ones/

/**
 * @param {number[][]} mat
 * @return {number[]}
 */
// 119ms
var rowAndMaximumOnes = function (mat) {
  let table = [];
  for (let i = 0; i < mat.length; i++) {
    table[i] = [i, mat[i].filter((e) => !!e).length];
  }

  table.sort((a, b) => b[1] - a[1] || a[0] - b[0]);

  return table[0];
};
