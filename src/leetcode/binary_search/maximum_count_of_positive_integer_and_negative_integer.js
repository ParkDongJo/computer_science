// https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/

/**
 * @param {number[]} nums
 * @return {number}
 */
var maximumCount = function(nums) {
    let front = 0;
    let tail = nums.length;
    let mid;
    let zeroCount = 0;

    while (front <= tail) {
        mid = front + Math.floor((tail - front) / 2);
        if (nums[mid] < 0) {
          front = mid + 1;
        } else if (nums[mid] > 0) {
          tail = mid - 1;
        } else {
          tail = mid - 1;
        }
    }
    nums.slice(front, nums.length).forEach(num => {
      if (num == 0) zeroCount++;
    })
    return Math.max(front, nums.length - front - zeroCount);
};

console.log(maximumCount([-9,-7,-4,1,5,8,9]));
console.log(maximumCount([-9,-7,-4,-2,1,5,8,9]));
console.log(maximumCount([-3,-2,-1,0,0,1,2]));
console.log(maximumCount([0,0,0,0,0,0,0]));
