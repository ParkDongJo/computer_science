// https://leetcode.com/problems/reduction-operations-to-make-the-array-elements-equal/description/

/**
 * @param {number[]} nums
 * @return {number}
 */
var reductionOperations = function(nums) {
    // [1,1,2,2,3,4,4,5]

    // [5,4,3,2,2,1,1]
    // 5 -> 1 (1)
    // [3,3,3,2,2,1,1]
    // 4,4 -> 2 (1+1)
    // [2,2,2,2,2,1,1]
    // 3,3,3 -> 3 (1+1+1)
    // [1,1,1,1,1,1,1]
    // 2,2,2,2,2 -> (1+1+1+2)
    
    // 1+ 1+1+ 1+1+1+ 1+1+1+2
    nums.sort((a, b) => b - a);

    let acc = 0;
    let currMax = nums[0];
    for (let i = 0; i < nums.length; i++) {
        if (currMax !== nums[i]) {
            currMax = nums[i];
            if (currMax === nums[nums.length - 1]) {
                break;
            }
            acc += acc;
        }
        if (currMax === nums[nums.length - 1]) {
            break;
        }
        acc += 1;
    }
    return acc;
};

// 162
const reductionOperations = function(nums) {
    let count = 0;

    nums.sort((a, b) => a - b);

    for (let i = nums.length - 1; i > 0; i--) {
        if (nums[i] > nums[i - 1]) {
            count += nums.length - i;
        }
    }

    return count;
};

// 169ms
var reductionOperations = function(nums) {
    nums = nums.sort((a,b)=> b-a);

    let c=0;

    for (let i = 1; i < nums.length; i++) {
        if (nums[i] < nums[i - 1]) {
            c += i;
        }
    }

    return c
};