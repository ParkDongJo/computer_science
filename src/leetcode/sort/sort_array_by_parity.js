// https://leetcode.com/problems/sort-array-by-parity/submissions/
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var sortArrayByParity = function(nums) {
  const oddNums = [];
  const evenNums = [];

  for (let i = 0; i < nums.length; i++) {
      if (nums[i] % 2 === 0) {
          evenNums.push(nums[i]);
      } else {
          oddNums.push(nums[i]);
      }
  }

  return [...evenNums, ...oddNums];
};
