// https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var smallerNumbersThanCurrent = function(nums) {
  const sorted = [...nums].sort((a, b) => a - b);
  const map = new Map();
  const results = []

  for (let i = 0; i < sorted.length; i++) {
      if (map[sorted[i]] === undefined) {
         map[sorted[i]] = i;
      }
  }

  for (let i = 0; i < nums.length; i++) {
      results.push(map[nums[i]]);
  }
  return results;
};