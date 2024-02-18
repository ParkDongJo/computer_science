// https://leetcode.com/problems/license-key-formatting/description/
/**
 * @param {string} s
 * @param {number} k
 * @return {string}
 */
// 53ms
/*
  조건은 잘 생각했는데, 구현 시 생각이 부족한 부분이 있었다.
  뒤늦게
  const str = s.split("").filter((c) => c !== "-");

  이렇게 미리 가공하는 로직을 넣었고,
  slice, join 등등의 유용한 기능들을 빠르게 떠올리지 못했다.

*/
var licenseKeyFormatting = function (s, k) {
  // [조건]
  // - 기존 s를 대시를 재조정한다, k 갯수 만큼 그룹핑
  // - 그룹핑할 시 나머지가 있을 때, 이 나머지는 가장 첫번째 그룹에 적용하도록
  const str = s.split("").filter((c) => c !== "-");
  const r = str.length % k;
  let start = r > 0 ? r : k;
  let result = str.slice(0, start).join("");
  let count = 0;

  for (let i = start; i < str.length; i++) {
    if (i === start) {
      result += "-";
    }
    if (count >= k) {
      result += `-${str[i]}`;
      count = 1;
    } else {
      result += str[i];
      count++;
    }
  }
  return result.toUpperCase();
};
