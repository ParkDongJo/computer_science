// https://leetcode.com/problems/find-players-with-zero-or-one-losses/description/

/**
 * @param {number[][]} matches
 * @return {number[][]}
 */
// 내가 푼 코드
// 480ms
var findWinners = function (matches) {
  // [w, l]
  // 모든 선수에 대해서 진 수를 센다. table에 기록
  // 이 table을 돌면서 1 이상 이하 진 선수만
  // result 에 기록한다.

  // [피드벡]
  // 굳이 다 기록할 필요 있는가?

  const results = [[], []];
  const map = new Map();
  let lastMem = 1;

  for (let i = 0; i < matches.length; i++) {
    const [w, l] = matches[i];
    if (!map.has(w)) {
      map.set(w, 0);
    }
    if (map.has(l)) {
      map.set(l, map.get(l) + 1);
    } else {
      map.set(l, 1);
    }
  }
  // console.log(map)

  // for (let i = 1; i <= lastMem; i++) {
  //     if (map.has(i)) {
  //         if (map.get(i) === 1) {
  //             results[1].push(i);
  //         }
  //     } else {
  //         results[0].push(i);
  //     }
  // }

  const sorted = [...map].sort((a, b) => a[1] - b[1]).filter(([_, v]) => v < 2);

  for (let i = 0; i < sorted.length; i++) {
    const [k, v] = sorted[i];
    if (v === 0) {
      results[0].push(k);
    } else {
      results[1].push(k);
    }
  }

  results[0].sort((a, b) => a - b);
  results[1].sort((a, b) => a - b);

  return results;
};

// 남이 푼 코드
// 244ms
var findWinners = function (matches) {
  let losses = new Array(100001).fill(0);

  for (const [winner, loser] of matches) {
    if (losses[winner] === 0) losses[winner] = -1;
    if (losses[loser] === -1) losses[loser] = 1;
    else losses[loser]++;
  }

  let zeroLoss = [];
  let oneLoss = [];

  for (let i = 1; i <= 100000; ++i) {
    if (losses[i] === -1) zeroLoss.push(i);
    else if (losses[i] === 1) oneLoss.push(i);
  }

  return [zeroLoss, oneLoss];
};
