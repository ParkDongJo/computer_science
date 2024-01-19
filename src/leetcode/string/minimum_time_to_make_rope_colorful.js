// https://leetcode.com/problems/minimum-time-to-make-rope-colorful/description/

/**
 * @param {string} colors
 * @param {number[]} neededTime
 * @return {number}
 */
// 나의 풀이
// 82ms
var minCost = function(colors, neededTime) {
  let cursor = undefined;
  let accCount = 0;
  let acc = 0;
  let max = 0;
  let result = 0;

  for (let i = 0; i<colors.length; i++) {
      if (cursor !== colors[i]) {
          if (accCount !== 1) {
              result += acc - max;
          }
          accCount = 1;
          cursor = colors[i];
          acc = neededTime[i];
          max = neededTime[i];
      } else {
          accCount++;
          acc += neededTime[i];
          if (neededTime[i] > max) {
              max = neededTime[i];
          }
      }
  }
  if (accCount > 1) {
      result += acc - max;
  }
  return result;
};

// 다른 사람 풀이
// 62ms
var minCost = function(colors, neededTime) {
  let res = 0;

  for (let i = 1; i < colors.length; i++) {
      if (colors[i] === colors[i - 1]) {
          if (neededTime[i] < neededTime[i - 1]) {
              res += neededTime[i];
              neededTime[i] = neededTime[i - 1];
          } else {
              res += neededTime[i - 1];
          }
      }
  }

  return res;
};
