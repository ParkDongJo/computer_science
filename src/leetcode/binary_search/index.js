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
      ? null
      : binarySearch(nums.slice(midIdx + 1), target)
  }
}

const nums = [1, 3, 5, 7, 9];
const target = 10;

console.log(binarySearch(nums, target));
