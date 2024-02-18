// https://leetcode.com/problems/baseball-game/description/
/**
 * @param {string[]} operations
 * @return {number}
 */
// 54ms
var calPoints = function (operations) {
  // 숫자는 stack 에 넣구요.
  // 연산자는 바로바로 연산을해서, 결과를 stack 에 넣거나 뺀다.
  let stack = [];
  let result = 0;

  for (let i = 0; i < operations.length; i++) {
    if (stack.length >= 2 && operations[i] === "+") {
      let a = stack.pop();
      let b = stack.pop();
      stack.push(b);
      stack.push(a);
      stack.push(a + b);
    } else if (stack.length > 0 && operations[i] === "D") {
      let a = stack.pop();
      stack.push(a);
      stack.push(a * 2);
    } else if (stack.length > 0 && operations[i] === "C") {
      stack.pop();
    } else {
      stack.push(Number(operations[i]));
    }
  }

  for (let i = 0; i < stack.length; i++) {
    result += stack[i];
  }

  return result;
};

// 37ms
var calPoints = function (operations) {
  let scores = [];
  for (let operation of operations) {
    if (parseInt(operation)) {
      scores.push(parseInt(operation));
    } else if (operation === "C") {
      scores.pop();
    } else if (operation === "+") {
      scores.push(scores[scores.length - 1] + scores[scores.length - 2]);
    } else if (operation === "D") {
      scores.push(scores[scores.length - 1] * 2);
    }
  }
  return scores.reduce((a, b) => a + b, 0);
};
