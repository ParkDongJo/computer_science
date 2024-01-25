// https://school.programmers.co.kr/learn/courses/30/lessons/12924
// 내가 푼 문제
function solution(n) {
  var answer = 0;
  let cursor = 0;
  let sum = 0;

  for (let i = 1; i < n; i++) {
    sum = 0;
    sum += i;
    cursor = i + 1;
    while (sum < n) {
      sum += cursor;
      cursor++;
    }
    if (sum === n) {
      answer++;
    }
  }
  return answer + 1;
}

// 다른 사람 풀이
function solution(n) {
  var answer = 0;
  let i = 0;
  while (n > 0) {
    i++;
    if (n % i === 0) answer++;
    n -= i;
  }
  return answer;
}
