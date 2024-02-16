//https://leetcode.com/problems/max-pair-sum-in-an-array/
// 위 문제는 이해를 위한 설명이 정말 거지같지만,
// 이 문제를 풀어가는데 있어서 괜찮은 아이디어가 있다.
// 숫자를 받으면 뒤집는 함수를 만들어보는 것인데, 이걸 한번 해보자
/**
 * @param {number[]} nums
 * @return {number}
 */
// 숫자연산으로 바꾸는 방법
function makePairByNum(num) {
  let result = 0;
  let numStr = num.toString();
  for (let i = numStr.length - 1; i >= 0; i--) {
    result = result * 10 + parseInt(numStr[i]);
  }
  return result;
}

// 문자열로 바꾸는 방법
function makePairByString(num) {
  return parseInt(num.toString().split("").reverse().join(""));
}

console.log(makePairByNum(1234)); // 4321
