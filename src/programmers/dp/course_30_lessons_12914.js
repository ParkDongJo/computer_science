// https://school.programmers.co.kr/learn/courses/30/lessons/12914

/*
  멀리뛰기 연습 중
  한번에 1칸 또는 2칸 뛸 수 있음
  총 4칸이 있을 시, 멀리뛰기를 하는 방법으로 5가지가 있음
  그 방법에다가 1234567을 나눈 나머지를 리턴하는 함수를 만들라
*/

function solution(n) {
  if (n == 1) return 1;
  if (n == 2) return 2;

  let dp = [];
  dp[1] = 1;
  dp[2] = 2;

  for (let i = 3; i <= n; i++) {
    dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
  }

  return dp[n];
}

console.log(solution(4));
console.log(solution(3));
