// https://leetcode.com/problems/flatten-deeply-nested-array/

// function flatOnce(arr) {
//   let result = [];
//   for (let i = 0; i < arr.length; i++) {
//     result = Array.isArray(arr[i]) ? [...result, ...arr[i]] : [...result, arr[i]]
//   }
//   return result;
// }

// var flat = function (arr, n) {
//   let count = 0;
//   while (count < n) {
//     arr = flatOnce(arr);
//     count++;
//   }
//   return arr;
// };

var flat = function (arr, n) {
  let count = 0;
  let result = []
  let queue = [...arr];
  while(queue.length) {
    const item = queue.shift();
    if (Array.isArray(item)) {
      queue = [...item, ...queue];
    } else {
      result.push(item);
    }
  }
  return result;
};

console.log(flat([1, 2, 3, [4, 5, 6], [7, 8, [9, 10, 11], 12], [13, 14, 15]], 1));