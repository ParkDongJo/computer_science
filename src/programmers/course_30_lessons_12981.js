// https://school.programmers.co.kr/learn/courses/30/lessons/12981

function solution(n, words) {
  var answer = [];
  const record = new Map();

  record.set(words[0], true);
  let lastC = words[0].slice(-1);

  for (let i = 1; i < words.length; i++) {
    if (!record.get(words[i]) && lastC === words[i].slice(0, 1)) {
      record.set(words[i], true);
      lastC = words[i].slice(-1);
    } else {
      answer.push((i + 1) % n === 0 ? n : (i + 1) % n);
      answer.push(
        (i + 1) % n === 0 ? (i + 1) / n : Math.floor((i + 1) / n + 1)
      );
      break;
    }
  }

  return answer.length === 0 ? [0, 0] : answer;
}

console.log(
  solution(3, [
    "tank",
    "kick",
    "know",
    "wheel",
    "land",
    "dream",
    "mother",
    "robot",
    "tank",
  ])
);
console.log(
  solution(5, [
    "hello",
    "observe",
    "effect",
    "take",
    "either",
    "recognize",
    "encourage",
    "ensure",
    "establish",
    "hang",
    "gather",
    "refer",
    "reference",
    "estimate",
    "executive",
  ])
);

// 다른 사람 풀이
function solution(n, words) {
  let answer = 0;
  words.reduce((prev, now, idx) => {
    answer =
      answer ||
      (words.slice(0, idx).indexOf(now) !== -1 || prev !== now[0]
        ? idx
        : answer);
    return now[now.length - 1];
  }, "");

  return answer ? [(answer % n) + 1, Math.floor(answer / n) + 1] : [0, 0];
}

// 다른 사람 풀이
function solution(n, words) {
  let set = new Set();
  set.add(words[0]);
  for (let i = 1; i < words.length; i++) {
    if (set.has(words[i])) {
      return [(i % n) + 1, Math.floor(i / n) + 1];
    } else {
      set.add(words[i]);
    }
    if (words[i - 1][words[i - 1].length - 1] !== words[i][0]) {
      return [(i % n) + 1, Math.floor(i / n) + 1];
    }
  }
  return [0, 0];
}
