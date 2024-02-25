/**
 * @param {number[]} nums
 * @return {number}
 */
// 279ms
var minPairSum = function (nums) {
  // [문제 이해]
  // nums = [3,5,2,3]
  // [3, 3] [5, 2]
  // max(6, 7)
  // 7, 8 가장 적은 max 를 뱉어내는 숫자의 쌍조합
  // 최소의 max 값

  // [전략]
  // 정렬! 내림차순
  // 가장 큰값과 + 가장 작은값
  // 그다음 가장 큰값과 + 그댜음 가장 작은값
  // [3,5,2,3] -> [5,3,3,2]
  // 5 + 2 / 3 + 3
  // [3,5,4,2,4,6] -> [6,5,4,4,3,2]
  // 6 + 2 / 5 + 3 / 4 + 4

  nums.sort((a, b) => b - a);

  let tail = nums.length - 1;
  const sums = [];
  for (let i = 0; i < nums.length / 2; i++) {
    sums.push(nums[i] + nums[tail]);
    tail--;
  }

  return Math.max(...sums);
};

// 좀 더 성능 개선을 해본다면, Math.max 를 배열을 전체 모아서 돌리기 보다.
// 두 숫자만 비교하는 식으로 한다면 성능이 좀 더 나아질 수ㅜ 있다.
// 127ms
var minPairSum = function (nums) {
  nums.sort((a, b) => a - b);

  let max = -Infinity;
  let i = 0;
  let j = nums.length - 1;
  while (i < j) {
    let num1 = nums[i];
    let num2 = nums[j];
    max = Math.max(max, num1 + num2);
    i++;
    j--;
  }
  return max;
};
