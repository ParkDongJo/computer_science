// https://leetcode.com/problems/minimum-absolute-difference/

/**
 * @param {number[]} arr
 * @return {number[][]}
 */
var minimumAbsDifference = function(arr) {
  const sorted = [...arr].sort((a, b) => a - b);
  let min = 0;
  let results = [];

  for(let i = 0; i < sorted.length; i++) {
      if (i === sorted.length - 1) {
          break;
      }
      const diff = Math.abs(sorted[i] - sorted[i + 1]);
      if (!min || min > diff) {
          min = diff;
          results = [];
          results.push([sorted[i], sorted[i + 1]]);
      } else if (min === diff) {
          results.push([sorted[i], sorted[i + 1]]);
      }
  }
  return results;
};
