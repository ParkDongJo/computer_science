// https://school.programmers.co.kr/learn/courses/30/lessons/12973

// 나의 풀이
function solution(s) {
  let stack = [];
  for (const c of s) {
    if (stack.length === 0 || stack[stack.length - 1] !== c) {
      stack.push(c);
      continue;
    }
    if (stack.length > 0 && stack[stack.length - 1] === c) {
      stack.pop();
    }
  }

  return stack.length > 0 ? 0 : 1;
}

// 다른 사람 풀이
function solution(s) {
  const result = [];
  for (let chr of s) {
    if (result.length === 0) result.push(chr);
    else if (result[result.length - 1] == chr) result.pop();
    else result.push(chr);
  }
  return result.length == 0 ? 1 : 0;
}
