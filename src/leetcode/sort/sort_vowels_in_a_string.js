// https://leetcode.com/problems/sort-vowels-in-a-string/
/**
 * @param {string} s
 * @return {string}
 */
const VOWELS_MAP = {
  a: true,
  e: true,
  i: true,
  o: true,
  u: true,
};
// 203ms
var sortVowels = function (s) {
  // [문제 이해]
  // 문자열 s가 주어지고, 재배열해서, 새로운 문자 t 반환
  // 자음
  // - idx 0 <= i < s 길이
  // - t[i] = s[i] 그대로 전달
  // 모음
  // - 재정렬 대상 아스키값이 작은순서부터
  // - idx 0 <= i < j < s 길이
  // - s[i], s[j] 재정렬 시 -> t[i] < t[j]

  // [로직]
  // 반복문을 돌면서,
  // - 자음은 그대로 배치
  // - 모음일때는 따로 임시 arr 빼놓고
  // - undefined 기입
  // - 모음 arr 를 재정렬 (오름차순)
  // 반복문 돌면서
  // - 요소가 undefined 일때
  // - 모음 arr 에서 하나씩 대입한다.
  // - cursor를 따로 둔다.
  let results = [];
  let vowels = [];
  for (let i = 0; i < s.length; i++) {
    if (VOWELS_MAP[s[i].toLowerCase()]) {
      vowels.push(s[i]);
      results.push(undefined);
    } else {
      results.push(s[i]);
    }
  }

  vowels.sort((a, b) => a.charCodeAt() - b.charCodeAt());

  let cursor = 0;
  for (let i = 0; i < s.length; i++) {
    if (!results[i]) {
      results[i] = vowels[cursor];
      cursor++;
    }
  }

  return results.join("");
};

// 1등과 코드 원리는 비슷하다. 다ㄴ 차이는 results를 배열로 받는게 아니라
// 문자열로 받아서 그대로 리턴하는 형식으로 하면 비슷한 성능을 낼 수 있다.
//101ms
var sortVowels = function (s) {
  s = [...s];
  const vowels = "AEIOUaeiou";
  const count = new Array(vowels.length).fill(0);

  for (let i = 0; i < s.length; i++) {
    const pos = vowels.indexOf(s[i]);
    if (pos !== -1) {
      s[i] = "_";
      count[pos]++;
    }
  }

  let str = "";
  let i = 0;

  for (const c of s) {
    if (c === "_") {
      while (!count[i]) i++;
      str = str.concat(vowels[i]);
      count[i]--;
    } else {
      str = str.concat(c);
    }
  }

  return str;
};
