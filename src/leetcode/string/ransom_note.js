// https://leetcode.com/problems/ransom-note/description/

// map 을 만들거고
// map 에는 a를 반복문 돌려서, { key: false }
// b 반복문 돌면서,
// has() 통해서 key 가 있으면, true 값을 변경
// 77ms
function test(a, b) {
  let map = new Map();
  for (let i = 0; i < ransomNote.length; i++) {
    if (map.has(ransomNote[i])) {
      map.set(ransomNote[i], map.get(ransomNote[i]) + 1);
    } else {
      map.set(ransomNote[i], 1);
    }
  }

  for (let i = 0; i < magazine.length; i++) {
    if (map.has(magazine[i])) {
      map.set(magazine[i], map.get(magazine[i]) - 1);
    }
  }

  for (let [_, v] of map) {
    if (v > 0) {
      return false;
    }
  }
  return true;
}

// 다른 사람의 풀이
// 50ms
var canConstruct = function (ransomNote, magazine) {
  if (ransomNote.length > magazine.length) return false;
  for (let i = 0; i < ransomNote.length; i++) {
    if (magazine.includes(ransomNote[i])) {
      magazine = magazine.replace(ransomNote[i], "");
    } else return false;
  }
  return true;
};
