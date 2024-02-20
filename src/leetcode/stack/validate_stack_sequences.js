// https://leetcode.com/problems/validate-stack-sequences/
/**
 * @param {number[]} pushed
 * @param {number[]} popped
 * @return {boolean}
 */
var validateStackSequences = function (pushed, popped) {
  // stack = []
  // push 우선
  // 방금 push 한 숫자가 popped 의 첫번째 요소로 있을때 pop
  // pushed 가 비었을 때, pop
  // pop할때 stack의 top에 해당 pop 숫자가 없으면 false
  // 배열이 비면 true

  // pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
  // 반복문 돌리기
  // 1 <= [2,3,4,5]
  // if (1 !== popped[0])
  // 맞으면 -> pop()
  // 틀리면 -> continue

  const stack = [];

  while (pushed.length > 0) {
    let num = pushed.splice(0, 1)[0];
    stack.push(num);
    if (num === popped[0]) {
      stack.pop();
      popped.splice(0, 1);
    }
  }

  console.log(pushed, popped, stack);

  while (stack.length > 0) {
    const num = stack.pop();
    if (num === popped[0]) {
      popped.splice(0, 1);
    }
  }

  console.log(pushed, popped, stack);

  return popped.length === 0;
};

console.log(validateStackSequences([2, 1, 0], [1, 2, 0]));
// true 가 되어야 하지만,
// false 가 나온다.
// 이유는 stack에 데이터가 있고, stack의 top이 popped의 첫번째 요소를 비교하면서 pop을 하지 않는다.

// 55ms
var validateStackSequences = function (pushed, popped) {
  let idx = 0;
  let stack = [];

  for (let num of pushed) {
    stack.push(num);

    while (stack.length && stack[stack.length - 1] === popped[idx]) {
      stack.pop();
      idx++;
    }
  }

  return !stack.length;
};
