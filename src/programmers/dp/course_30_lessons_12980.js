// https://school.programmers.co.kr/learn/courses/30/lessons/12980

/*
  K칸을 앞으로 점프하거나, 현재까지 온 거리 x 2 해당하는 위치로 순간이동 가능
  K만큼 이동시 K 만큼 건전지 사용량이 줄어듬
  순간이동은 건전지 사용량이 그대로

  건전지 사용량을 최소화 하면서 거리 N만큼 이동하려고 함
*/
// 내가 만약 푼다면
// 너무 잘못 생각했음
function solution(n) {
  let distance = n;
  let answer = 1;
  let jump = 1;
  while (distance > 0) {
    jump *= 2;
    if (n - jump > 0) {
      distance = n - jump;
    } else {
      answer += distance;
      break;
    }
  }
  return answer;
}

// function solution(n) {
//   var ans = 0;

//   while (n > 0) {
//     if (n % 2 === 0) {
//       n /= 2;
//     } else {
//       n -= 1;
//       ans++;
//     }
//   }

//   return ans;
// }

// console.log(solution(5));
console.log(solution(6));
console.log(solution(5000));

// DP 문제라는데..
// https://dongminyoon.tistory.com/23
