/**
 * @param {number[]} nums
 * @return {number[]}
 */
var minSubsequence = function(nums) {
  const sorted = [...nums].sort((a, b) => b - a);
  const results = [];
  let inSum = 0;
  let outSum = 0;

  for (let i = 0; i < sorted.length; i++) {
      results.push(sorted[i]);
      inSum += sorted[i];
      for (let j = i + 1; j < sorted.length; j++) {
          outSum += sorted[j];
      }
      if (inSum > outSum) {
          break;
      } else {
          outSum = 0;
      }
  }
  return results;
};