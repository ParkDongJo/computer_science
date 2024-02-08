// https://leetcode.com/problems/guess-number-higher-or-lower/description/
/**
 * Forward declaration of guess API.
 * @param {number} num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * var guess = function(num) {}
 */

/**
 * @param {number} n
 * @return {number}
 */
// 57ms
var guessNumber = function (n) {
  return binaryGuess(0, n);
};

function binaryGuess(s, e) {
  let m = Math.floor((s + e) / 2);
  if (s > e) {
    return m;
  }
  const r = guess(m);

  if (r === -1) {
    return binaryGuess(s, m - 1);
  } else if (r === 1) {
    return binaryGuess(m + 1, e);
  } else {
    return m;
  }
}

// 다른사람이 푼 풀이
/**
 * @param {number} n
 * @return {number}
 */
// 35ms
var guessNumber = function (n) {
  let low = 0,
    high = n,
    result;
  while (low <= high) {
    let mid = Math.floor(low + (high - low) / 2);
    result = guess(mid);
    if (result === 0) return mid;
    else if (result === 1) {
      low = mid + 1;
    } else {
      high = mid - 1;
    }
  }
};
