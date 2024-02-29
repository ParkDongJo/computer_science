// https://leetcode.com/problems/build-an-array-with-stack-operations/
/**
 * @param {number[]} target
 * @param {number} n
 * @return {string[]}
 */
// 45ms
var buildArray = function (target, n) {
  // target <= 만들어야할 목표물
  // cursor = 0
  // stack top 요소가 target 같은 위치 요소와
  // - 같을 때 push
  // - 같지 않을때(작을때) pop / push
  // stack의 길이와 target의 길이가 같으면, return

  const stack = [];
  const history = [];

  for (let i = 1; i <= n; i++) {
    if (stack.length === target.length) {
      break;
    }
    stack.push(i);
    history.push("Push");
    const idx = stack.length - 1;
    if (stack[idx] !== target[idx]) {
      stack.pop();
      history.push("Pop");
    }
  }

  return history;
};
