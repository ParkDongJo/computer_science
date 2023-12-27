// https://leetcode.com/problems/minimum-size-subarray-sum/
/**
 * @param {number} target
 * @param {number[]} nums
 * @return {number}
 */
// 정렬로 문제를 풀어서는 안된다.
// subarray는 연속된 배열이다. 이걸가지고 풀라고 했기 때문에 정렬로 풀면 안된다.

// var minSubArrayLen = function(target, nums) {
//   let sum = 0;
//   let count = 0;
//   nums.sort((a, b) => b - a)
//   for (let i = 0; i < nums.length; i++) {
//     if (sum < target) {
//         sum += nums[i];
//         count++;
//     } else {
//         break;
//     }
//   }
//   return (sum < target) ? 0 : count;
// };

// sliding window 방식으로 풀어야 한다.
var minSubArrayLen = function(target, nums) {
  let left = 0;
  let right = 0;
  let sum = nums[0];
  let answer = nums.length + 1;
  while(true) {
    if (sum >= target) {
      answer = Math.min(answer, right - left + 1);
      sum -= nums[left++];
    } else {
      if (right == nums.length - 1) {
        break;
      } else {
        sum += nums[++right];
      }
    }
  }

  return answer == nums.length + 1 ? 0 : answer;
};

// console.log(minSubArrayLen(7, [2,3,1,2,4,3]))
// console.log(minSubArrayLen(4, [1,4,4]))
// console.log(minSubArrayLen(11, [1,1,1,1,1,1,1,1]))
console.log(minSubArrayLen(213, [12,28,83,4,25,26,25,2,25,25,25,12]))

