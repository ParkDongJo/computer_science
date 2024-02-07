// https://leetcode.com/problems/binary-search/description/
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
// 60Ms
var search = function (nums, target) {
  return binarySearch(nums, 0, nums.length - 1, target);
};

const binarySearch = (nums, start, end, target) => {
  if (start > end) {
    return -1;
  }

  const mid = Math.floor((start + end) / 2);

  if (nums[mid] === target) {
    return mid;
  } else if (nums[mid] > target) {
    return binarySearch(nums, start, mid - 1, target);
  } else {
    return binarySearch(nums, mid + 1, end, target);
  }
};

// 다른 사람이 푼 풀이
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
// 36ms
var search = function (nums, target) {
  let low = 0;
  let high = nums.length - 1;
  while (low <= high) {
    const mid = Math.floor((low + high) / 2);
    if (nums[mid] === target) {
      return mid;
    } else if (nums[mid] < target) {
      low = mid + 1;
    } else {
      high = mid - 1;
    }
  }
  return -1;
};
