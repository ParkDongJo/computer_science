/**
 * @param {number[]} target
 * @param {number[]} arr
 * @return {boolean}
 */

// const binarySearch = (target, nums) => {
//   if (nums.length === 0) {
//       return -1;
//   }
//   const mid = Math.floor(nums.length / 2);
  
//   if (target === nums[mid]) {
//       return nums[mid];
//   } else if (target > nums[mid]) {
//       return nums.length === 1 ? -1 : binarySearch(target, nums.slice(mid));
//   } else if (target < nums[mid]) {
//       return nums.length === 1 ? -1 : binarySearch(target, nums.slice(0, mid));
//   }
// }
// var canBeEqual = function(target, arr) {
//   const sorted = [...arr].sort((a, b) => a - b);
  
//   for (let i = 0; i < target.length; i++) {
//       const equalNum = binarySearch(target[i], sorted);
//       if (equalNum === -1) {
//           return false;
//           break;
//       }
//   }
//   return true;
// };

/*
  배열안의 숫자가 중복이 될 수 있음을 인지하고 풀어야함
*/
var canBeEqual = function(target, arr) {
  target.sort((a, b) => a - b);
  arr.sort((a, b) => a - b);

  for(let i = 0; i < target.length; i++) {
      if (target[i] !== arr[i]) {
          return false;
          break;
      }
  }
  return true;
};
