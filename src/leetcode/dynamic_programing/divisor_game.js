// https://leetcode.com/problems/divisor-game/description/
// 나의 풀이 45ms
/**
 * @param {number} n
 * @return {boolean}
 */
var divisorGame = function (n) {
  let curr = n;
  let isTurnAlice = true;
  while (curr > 1) {
    curr = curr - 1;
    isTurnAlice = !isTurnAlice;
  }
  return !isTurnAlice;
};

// 다른 사람 풀이
// 34ms
/**
 * @param {number} n
 * @return {boolean}
 */
var divisorGame = function (n) {
  return n % 2 === 0;
};
