//https://leetcode.com/problems/sort-characters-by-frequency/description/
/**
 * @param {string} s
 * @return {string}
 */
// 내가 푼 코드
var frequencySort = function (s) {
  const map = new Map();
  let answer = "";

  for (let i = 0; i < s.length; i++) {
    if (map.has(s[i])) {
      map.set(s[i], map.get(s[i]) + 1);
    } else {
      map.set(s[i], 1);
    }
  }

  const sorted = [...map].sort((a, b) => {
    return b[1] - a[1];
  });

  for (let i = 0; i < sorted.length; i++) {
    const [k, v] = sorted[i];
    for (let j = 0; j < v; j++) {
      answer += k;
    }
  }

  return answer;
};

// 남이 푼 코드
var frequencySort = function (s) {
  const mp = new Map();

  for (let c of s) {
    mp.set(c, (mp.get(c) || 0) + 1);
  }

  const lst = [...mp];
  lst.sort((a, b) => b[1] - a[1]);

  const ans = lst.map((l) => l[0].repeat(l[1])).join("");

  return ans;
};
