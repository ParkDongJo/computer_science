const binarySearch = (nums, target) => {
  const mid = Math.floor(nums.length / 2)

  if (nums.length === 1) {
    return nums[0];
  }
  if (nums[mid] == target) {
    return nums[mid];
  } else if (nums[mid] > target) {
    return binarySearch(nums.slice(0, mid), target)
  } else if (nums[mid] < target) {
    return nums.length - 1 === mid 
      ? nums[mid]
      : binarySearch(nums.slice(mid + 1), target)
  }
}