//https://school.programmers.co.kr/learn/courses/30/lessons/172927?language=javascript

// 틀린 풀이법
const table = [
  [1, 1, 1],
  [5, 1, 1],
  [25, 5, 1],
];
const mineralIdx = {
  diamond: 0,
  iron: 1,
  stone: 2,
};

// function solution(picks, minerals) {
//   var answer = 0;
//   let useCount = 0;
//   let pickCurr = 0;
//   let mineralsCurr = 0;

//   for (let i = 0; i < minerals.length; i++) {
//     if (picks[pickCurr] === 0) {
//       pickCurr++;
//     }
//     if (pickCurr > 2) {
//       break;
//     }
//     useCount++;
//     answer += table[pickCurr][mineralIdx[minerals[i]]];

//     if (useCount === 5 * picks[pickCurr]) {
//       useCount = 0;
//       pickCurr++;
//     }
//   }

//   return answer;
// }

// 다른 놈이 푼 방법
// https://supersfel.tistory.com/450
function solution(picks, minerals) {
  // picks는 무조건 3개의 배열이고, 곡갱이 다이아몬드, 철, 스톤의 갯수가 순서대로 들어간다.
  // 문제는 minerals는 광물 다이아몬드, 철, 스톤이 랜덤하게 들어가있다.
  // 각 곡갱이 1개당 사용은 5번까지가 최대이고, 5번을 넘어가면 다음 곡갱으로 넘어간다.

  let records = [];
  let pickCurr = 0;
  let len = Math.ceil(minerals.length / 5);

  for (let i = 0; i < minerals.length; i++) {
    const diaCount = table[0][mineralIdx[minerals[i]]] * picks[0];
    const ironCount = table[1][mineralIdx[minerals[i]]] * picks[1];
    const stoneCount = table[2][mineralIdx[minerals[i]]] * picks[2];

    records.push([diaCount, ironCount, stoneCount]);
  }
}
