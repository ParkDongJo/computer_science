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

  while (true) {
    let num = pushed;
  }

  return true;
};
