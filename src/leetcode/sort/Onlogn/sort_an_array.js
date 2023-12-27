/**
 * @param {number[]} nums
 * @return {number[]}
 */
// merge sort 로 풀어보기
function merge(left, right) {
  let sortedArr = [];

  while(left.length && right.length) {
      if (left[0] > right[0]) {
          sortedArr.push(right.shift());
      } else {
          sortedArr.push(left.shift());
      }
  }
  return [...sortedArr, ...left, ...right];
}

function mergeSort(nums) {
  if (nums.length == 1) return nums;
  const halfIdx = Math.floor(nums.length / 2);

  const left = mergeSort(nums.slice(0, halfIdx));
  const right = mergeSort(nums.slice(halfIdx, nums.length));

  return merge(left, right)
}

// quick sort 로 풀어보기
// 이 문제에서는 Quick Sort를 사용하면 Time Limit Exceeded가 발생합니다.
function quickSort(nums) {
  if (nums.length <= 1) return nums;
  const pivot = nums[0];
  const left = [];
  const right = [];

  for (let i = 1; i < nums.length; i++) {
      if (nums[i] > pivot) {
          right.push(nums[i]);
      } else {
          left.push(nums[i]);
      }
  }

  const sortedLeft = quickSort(left);
  const sortedRight = quickSort(right);

  return [...sortedLeft, pivot, ...sortedRight];
}

var sortArray = function(nums) {
  return mergeSort(nums);
  // return quickSort(nums);
};

console.log(sortArray([5,2,3,1]));
