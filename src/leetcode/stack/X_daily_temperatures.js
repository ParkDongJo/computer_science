// https://leetcode.com/problems/daily-temperatures/

/**
 * @param {number[]} temperatures
 * @return {number[]}
 */
// 시간 초과
var dailyTemperatures = function (temperatures) {
  let lens = temperatures.length;
  let results = Array(lens).fill(0);
  let cursor = 0;

  for (let i = 0; i < lens; i++) {
    cursor = i;
    while (results[i] === 0) {
      cursor++;
      if (cursor > temperatures.length) {
        results[i] = 0;
        break;
      }
      if (temperatures[i] < temperatures[cursor]) {
        results[i] = cursor - i;
        break;
      }
    }
  }
  console.log(results);

  return results;
};

// 남이 푼 문제
// stack 으로 풀었다.
// 하지만 결국 O(n^2) 으로 보이는데, 뭐가 다를까
var dailyTemperatures = function (temperatures) {
  let n = temperatures.length;
  let answer = new Array(n).fill(0);
  let stack = [];

  for (let i = 0; i < n; i++) {
    while (
      stack.length > 0 &&
      temperatures[i] > temperatures[stack[stack.length - 1]]
    ) {
      let index = stack.pop();
      answer[index] = i - index;
    }
    stack.push(i);
  }

  return answer;
};
