// https://school.programmers.co.kr/learn/courses/30/lessons/42860

const alpha = [
  "A",
  "B",
  "C",
  "D",
  "E",
  "F",
  "G",
  "H",
  "I",
  "J",
  "K",
  "L",
  "M",
  "N",
  "O",
  "P",
  "Q",
  "R",
  "S",
  "T",
  "U",
  "V",
  "W",
  "X",
  "Y",
  "Z",
];

function solution(name) {
  let loop = true;
  let cursor = 0;
  let front = 0;
  let frontCnt = 0;
  let back = 0;
  let backCnt = 0;
  let totalCnt = 0;

  name.split("").map((c) => {
    console.log(c);
    while (loop) {
      if (alpha[front] === c && alpha[back] === c) {
        totalCnt += frontCnt > backCnt ? backCnt : frontCnt;
        front = 0;
        back = 0;
        frontCnt = 0;
        backCnt = 0;
        loop = false;
      }
      if (alpha[front] !== c) {
        if (front === 0) {
          front = alpha.length - 1;
        } else {
          front--;
        }
        frontCnt++;
      }
      if (alpha[back] !== c) {
        if (back === alpha.length - 1) {
          back = 0;
        } else {
          back++;
        }
        backCnt++;
      }
    }
    loop = true;
  });
  return totalCnt;
}

console.log(solution("JAZ") === 11);
// console.log(solution("JEROEN") === 56);
// console.log(solution("JAN") === 23);

// 다른 풀이법
function solution(name) {
  var answer = 0;
  let len = name.length;
  let min = len - 1;

  for (let i = 0; i < len; i++) {
    // 조이스틱 상, 하 이동
    // A: 65, Z: 90
    let c = name.charCodeAt(i);
    let mov = c - 65 < 90 - c + 1 ? c - 65 : 90 - c + 1;
    answer += mov;

    // 조이스틱 좌, 우 이동
    let nextIndex = i + 1;
    while (nextIndex < len && name.charCodeAt(nextIndex) === 65) {
      nextIndex += 1;
    }

    min = Math.min(
      min,
      i * 2 + len - nextIndex, // 먼저 오른쪽으로 가기
      i + (len - nextIndex) * 2 // 처음부터 반대로 가기
    );
  }
  answer += min;
  return answer;
}
