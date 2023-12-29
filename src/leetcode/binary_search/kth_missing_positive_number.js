/**
 * @param {number[]} arr
 * @param {number} k
 * @return {number}
 */
var findKthPositive = function(arr, k) {
  const map = new Map();
  const lastVal = arr[arr.length - 1];
  let count = 0;
  let result = 0;

  for (let i = 0; i < arr.length; i++) {
      map.set(arr[i], i);
  }

  for (let i = 1; i < lastVal + k + 1; i++) {
    console.log(i, map.has(i));
    if (!map.has(i)) {
        count++;
    }
    if (count === k) {
        result = i;
        break;
    }
  }
  return result;
};


// 이거 솔직히 이해가 안간다.
// https://inner-game.tistory.com/524
var findKthPositive = function(arr, k) {
  let left = 0;
  let right = arr.length - 1;

  while (left <= right) {
      const pivot = (left + right) / 2

      if (arr[pivot] - pivot - 1 < k) {
        left = pivot + 1
      } else {
        right = pivot - 1
      }
  }
  return left + k
}

// console.log(findKthPositive([2,3,4,7,11], 5));
console.log(findKthPositive([1,2,3,4], 2));
// console.log(findKthPositive([1,2], 1));
