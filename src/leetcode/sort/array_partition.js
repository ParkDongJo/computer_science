// https://leetcode.com/problems/array-partition/

/**
 * @param {number[]} nums
 * @return {number}
 */

function merge(left, right) {
  let sorted = [];

  while(left.length && right.length) {
      if (left[0] < right[0]) {
          sorted.push(left.splice(0, 1)[0]);
      } else {
          sorted.push(right.splice(0, 1)[0]);
      }
  }
  return [...sorted, ...left, ...right];
}

function mergeSort(nums) {
  if (nums.length <= 1) return nums
  let mid = Math.floor(nums.length / 2);
  
  let left = mergeSort(nums.slice(0, mid));
  let right = mergeSort(nums.slice(mid));

  return merge(left, right);
}

var arrayPairSum = function(nums) {
  const sorted = mergeSort(nums);
  let result = 0;
  
  for (let i = 0; i < sorted.length; i = i + 2) {
      result += sorted[i];
  }

  return result;
};

console.log(arrayPairSum([1,4,3,2]));
