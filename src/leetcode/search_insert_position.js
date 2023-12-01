/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
const binarySearch = (nums, target) => {
  const midIdx = parseInt(nums.length / 2)

  if (nums.length === 1) {
    return nums[0];
  }
  if (nums[midIdx] == target) {
    return nums[midIdx];
  } else if (nums[midIdx] > target) {
    return binarySearch(nums.slice(0, midIdx), target)
  } else if (nums[midIdx] < target) {
    return nums.length - 1 === midIdx 
      ? nums[midIdx]
      : binarySearch(nums.slice(midIdx + 1), target)
  }
}

var searchInsert = function(nums, target) {
    const val = binarySearch(nums, target);
    const idx = nums.indexOf(val);

    if (val < target) {
      return idx + 1;
    } else {
      return idx;
    }
};

// console.log(searchInsert([1,3,5,6], 5))
// console.log(searchInsert([1,3,5,6], 2))
// console.log(searchInsert([1,3,5,6], 7))
// console.log(searchInsert([1,3,5,6], 0))
console.log(searchInsert([1,3], 4))
