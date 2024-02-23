// https://leetcode.com/problems/custom-sort-string/submissions/1183960793/
/**
 * @param {string} order
 * @param {string} s
 * @return {string}
 */
// 58ms
var customSortString = function (order, s) {
  // order 주축으로 반복문을 돈다.
  // o 문자가 s에 있는지 찾는다.'
  // 있으면, 나열한다.
  // 나열된 글자가 s 보다 길이가 적으면, s에서 남은 글자들을 맨 뒤로 붙인다.

  // 비효율적이다?

  // order -> table { k: '', v: i }
  // s.sort(i) 기준으로 나열
  let map = new Map();

  for (let i = 0; i < order.length; i++) {
    map.set(order[i], i);
  }

  return s
    .split("")
    .sort((a, b) => (map.get(a) || 0) - (map.get(b) || 0))
    .join("");
};
