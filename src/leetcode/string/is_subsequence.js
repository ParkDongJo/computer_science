// https://leetcode.com/problems/is-subsequence/
/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isSubsequence = function(s, t) {
  if (s === "") return true;

  let cursor = 0;
  for (let i = 0; i < t.length; i++) {
      if (cursor === s.length) {
          break;
      }
      if (t[i] === s[cursor]) {
          cursor++;
          continue;
      }
  }
  return cursor === s.length ? true : false
};

console.log(isSubsequence("abc", "ahbgdc"));
console.log(isSubsequence("c", "b"));
