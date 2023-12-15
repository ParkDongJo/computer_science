//https://leetcode.com/problems/minimum-sum-of-four-digit-number-after-splitting-digits/

/**
 * @param {number} num
 * @return {number}
 */
// 그리디 문제이다.
// 그리디는 항상 당장의 최적해를 선택해서 결과를 도출하는 알고리즘이다.
// 그래서 전체의 최적의 해를 보장하지는 않는다.

// 그렇다면, 그리디로 풀만한 문제의 유형을 빨리 알아차리는게 중요하다.

// 또한 그리디로 접근하는 방법은 모든 경우의 수를 다 검토 후 비교하는 방법이 아니다.
// 당장 이득이 될만한 경우를 선택해서 이들만 연산 하는 방식으로 접근해야한다.

var minimumSum = function(num) {
  const numArr = num.toString().split('').map(n => parseInt(n));
  numArr.sort((a, b) => a - b);
  return numArr[0] * 10 + numArr[1] * 10 + numArr[2] + numArr[3];
};

console.log(minimumSum(2932));
