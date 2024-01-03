// https://leetcode.com/problems/di-string-match
/**
 * @param {string} s
 * @return {number[]}
 */
var diStringMatch = function(s) {
  let results = [];
  let nums = [];

  for (let i = 0; i < s.length + 1; i++) {
      nums.push(i);
  }

  for (const c of s) {
      if (c === "I") {
          results.push(nums[0]);
          nums.splice(0, 1)
      } else {
          results.push(nums[nums.length - 1]);
          nums.splice(nums.length - 1, 1)
      }
  }
  results.push(nums[0]);
  return results;
};