// https://leetcode.com/problems/assign-cookies/description/
/**
 * @param {number[]} g
 * @param {number[]} s
 * @return {number}
 */
// 75ms
var findContentChildren = function (g, s) {
  // g와 s를 오름차순으로 정렬시킨다.
  // g 와 s의 요소를 개별적으로 비교해서
  g.sort((a, b) => a - b);
  s.sort((a, b) => a - b);

  let gIdx = 0;
  let sIdx = 0;
  while (gIdx < g.length && sIdx < s.length) {
    if (g[gIdx] <= s[sIdx]) {
      gIdx++;
    }
    sIdx++;
  }
  return gIdx;
};

// 57ms
var findContentChildren = function (g, s) {
  let sortg = g.sort((a, b) => a - b);
  let sorts = s.sort((a, b) => a - b);

  let sizeg = sortg.length;
  let sizes = sorts.length;

  let i = 0,
    j = 0;
  while (i < sizeg && j < sizes) {
    if (s[j] >= g[i]) {
      i++;
    }
    j++;
  }
  return i;
};
