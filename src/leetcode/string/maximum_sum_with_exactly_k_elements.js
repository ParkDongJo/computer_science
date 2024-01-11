// https://leetcode.com/problems/maximum-sum-with-exactly-k-elements/description/
// runtime 118ms
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var maximizeSum = function(nums, k) {
  let result = 0;
  const sorted = [...nums].sort((a, b) => b - a);
  
  for (let i = 0; i < k; i++) {
      let max = sorted[0];
      result += max;
      sorted[0] = max + 1;
  }

  return result;
};

// 다른 사람이 푼 문제
// runtime 85ms
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var maximizeSum = function(nums, k) {
  return k * Math.max(...nums) + (k - 1) * k / 2;
};