// https://leetcode.com/problems/search-insert-position/
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
const binarySearch = (nums, sliced, target) => {
    const center = Math.floor(sliced.length / 2);

    if (sliced.length === 1) {
        const index = nums.indexOf(sliced[0])
        if (sliced[0] > target) {
            return index == 0 ? index : index - 1;
        } else if (sliced[0] < target) {
            return index + 1;
        } else {
            return index;
        }
    }

    
    if (sliced[center] > target) {
        return binarySearch(nums, sliced.slice(0, center), target)
    } else if (sliced[center] < target) {
        return binarySearch(nums, sliced.slice(center, nums.length), target);
    } else {
        return nums.indexOf(sliced[center]);
    }
}

var searchInsert = function(nums, target) {
    return binarySearch(nums, [...nums], target)
    
};

// console.log(searchInsert([1,3,5,6], 5))
// console.log(searchInsert([1,3,5,6], 2))
// console.log(searchInsert([1,3,5,6], 7))
// console.log(searchInsert([1,3,5], 4))
console.log(searchInsert([1,3,5], 5))