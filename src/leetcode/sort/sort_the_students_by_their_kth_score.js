// https://leetcode.com/problems/sort-the-students-by-their-kth-score/
/**
 * @param {number[][]} score
 * @param {number} k
 * @return {number[][]}
 */
// 117ms
var sortTheStudents = function (score, k) {
  // [[1,2], [2,3]] k = 1
  // [[2,3], [1,2]]
  // sort();
  score.sort((a, b) => b[k] - a[k]);
  return score;
};
