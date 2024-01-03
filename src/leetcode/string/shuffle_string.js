// https://leetcode.com/problems/shuffle-string
/**
 * @param {string} s
 * @param {number[]} indices
 * @return {string}
 */
var restoreString = function(s, indices) {
  const map = new Map();
  let results = [];

  for (let i = 0; i < s.length; i++) {
      map.set(indices[i], s[i]);
  }

  for (const [k, v] of map) {
      results[k] = v;
  }

  return results.join("")
};
