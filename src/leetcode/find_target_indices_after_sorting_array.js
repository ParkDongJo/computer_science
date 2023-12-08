//https://leetcode.com/problems/find-target-indices-after-sorting-array/
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var targetIndices = function(nums, target) {
    const result = [];
    const sorted = nums.sort((a, b) => a - b)
    for (let i = 0; i < sorted.length; i++) {
        if (target == sorted[i]) {
            result.push(i);
        }
    }
    return result;
};

// console.log(targetIndices([1,2,5,2,3], 2))
// console.log(targetIndices([1,2,5,2,3], 3))
// console.log(targetIndices([1,2,5,2,3], 5))
console.log(targetIndices([48,90,9,21,31,35,19,69,29,52,100,54,21,86,6,45,42,5,62,77,15,38], 6))
