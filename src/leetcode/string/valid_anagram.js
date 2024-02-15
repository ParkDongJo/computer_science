//https://leetcode.com/problems/valid-anagram/submissions/1175080198/
/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
// 83msf
var isAnagram = function (s, t) {
  // t가 s의 아나그램이냐 아니냐
  // - 아나그램이면 true
  // - 아나그램이 아니면 false

  // 아나그램은
  // s = abcd
  // t = bcad

  // O(N)
  // O(NlogN)

  // table
  // s -> table
  // t -> s check

  // table check 되어 있을 시 true
  if (s.length !== t.length) {
    return false;
  }

  let map = new Map();

  for (let i = 0; i < s.length; i++) {
    if (map.has(s[i])) {
      map.set(s[i], map.get(s[i]) + 1);
    } else {
      map.set(s[i], 1);
    }
  }

  for (let i = 0; i < t.length; i++) {
    if (map.has(t[i])) {
      map.set(t[i], map.get(t[i]) - 1);
    }
  }

  for (let [_, v] of map) {
    if (v !== 0) {
      return false;
    }
  }
  return true;
};

// 남이 푼 문제
// 40ms
var isAnagram = function (s, t) {
  if (s.length !== t.length) return false;
  const count = Array(256).fill(0);
  for (const c of s) {
    count[c.charCodeAt(0) - "a".charCodeAt(0)]++;
  }
  for (const c of t) {
    count[c.charCodeAt(0) - "a".charCodeAt(0)]--;
  }
  return count.every((c) => c === 0);
};

// 43ms
var isAnagram = function (s, t) {
  if (s.length !== t.length) return false;

  const freq = Array(26).fill(0);

  for (let i = 0; i < s.length; i++) {
    freq[s.charCodeAt(i) - "a".charCodeAt(0)]++;
    freq[t.charCodeAt(i) - "a".charCodeAt(0)]--;
  }

  return freq.every((count) => count === 0);
};
