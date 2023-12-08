// https://leetcode.com/problems/missing-number/
/**
 * @param {number[]} nums
 * @return {number}
 */
var missingNumber = function(nums) {
    const sorted = nums.sort((a, b) => a - b);
    let cursor = 0;

    for (let i = 0; i < sorted.length; i++) {
        if (cursor === sorted[i]) {
            cursor++;
        } else {
            break;
        }
    }
    return cursor;
};

console.log(missingNumber([3,0,1]));
console.log(missingNumber([0,1]));
console.log(missingNumber([9,6,4,2,3,5,7,0,1]));
