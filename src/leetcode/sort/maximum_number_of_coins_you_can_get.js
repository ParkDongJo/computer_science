// https://leetcode.com/problems/maximum-number-of-coins-you-can-get/
/**
 * @param {number[]} piles
 * @return {number}
 */
// 169ms
var maxCoins = function (piles) {
  // [9,8,7,6,5,1,2,3,4]
  // (9,8,1) (7,6,2) (5,4,3)
  // 가장 적은 수를 각각의 그룹에 배치
  let result = 0;
  piles.sort((a, b) => a - b);

  const rest = piles.slice(piles.length / 3, piles.length);

  for (let i = 0; i < rest.length; i += 2) {
    result += rest[i];
  }
  return result;
};

// 143ms
var maxCoins = function (piles) {
  piles.sort((a, b) => a - b);

  let alice = piles.length - 1;
  let me = alice - 1;
  let bob = 0;
  let x = 0;
  while (me > bob) {
    x += piles[me];
    me -= 2;
    alice -= 2;
    bob += 1;
  }
  return x;
};

// 79ms
var maxCoins = function (piles) {
  let max = 0;
  let n = piles.length;

  for (let i of piles) {
    if (max < i) max = i;
  }

  let freq = new Array(max + 1).fill(0);

  for (let i of piles) {
    freq[i]++;
  }

  let coins = 0;
  let chance = Math.floor(n / 3);
  let turn = 1;
  let i = max;

  while (chance !== 0) {
    if (freq[i] > 0) {
      if (turn === 1) turn = 0;
      else {
        chance--;
        turn = 1;
        coins += i;
      }
      freq[i]--;
    } else {
      i--;
    }
  }

  return coins;
};
