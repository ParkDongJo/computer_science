/**
 * @param {string} haystack
 * @param {string} needle
 * @return {number}
 */
// cursor를 0 으로 셋팅한다
// haystack 한 글자씩 반복문을 돈다
// 한 글자마다 needle에 cursor의 인덱스 값을 꺼내와서 비교한다.
// 동일하면,
// - haystack 도 다음으로 넘어가고
// - cursor도 +1 올린다
// 다르면,
// - haystack 도 다음으로 넘어가고
// - cursor는 초기화 된다
var strStr = function(haystack, needle) {
    let count = 0;

    for (let i = 0; i < haystack.length; i++) {
      for (let j = i; j < i + needle.length; j++) {
        if (haystack[j] === needle[j - i]) {
          count++;
        } else {
          break;
        }
      }
      if (count === needle.length) {
        return i;
      } else {
        count = 0;
      }
    }
    return -1
};

console.log(strStr("sadbutsad", "sad"))
console.log(strStr("leetcode", "leeto"))
console.log(strStr("aaa", "aaaa"))
console.log(strStr("mississippi", "issip"))
