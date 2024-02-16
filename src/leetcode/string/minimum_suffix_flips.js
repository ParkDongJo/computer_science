// https://leetcode.com/problems/minimum-suffix-flips/description/
/**
 * @param {string} target
 * @return {number}
 */
// 시간 초과
var minFlips = function (target) {
  // 10111
  // 00000

  // 11111
  // 10000
  // 10111
  let s = Array(target.length).fill("0");
  let result = 0;

  for (let i = 0; i < target.length; i++) {
    if (target[i] !== s[i]) {
      s.fill(s[i] === "0" ? "1" : "0", i);
      result++;
    }
  }

  return result;
};

/**
 * @param {string} target
 * @return {number}
 */
// 66ms
var minFlips = function (target) {
  // 10111
  // 00000

  // 11111
  // 10000
  // 10111

  // 앞에서 변경해줬다면,
  // - 현재 같으면 -> 변경
  // - 현재 다르면 -> 변경 X
  // 앞에서 변경 X
  // - 현재 다르면 -> 변경
  // - 현재 같으면 -> 변경 X

  // 같안변 / 다변 -> 같변 / 다안변 -> 같안변 / 다변경

  let flagForChange = true;

  let s = Array(target.length).fill("0");
  let result = 0;

  for (let i = 0; i < s.length; i++) {
    if (target[i] !== s[i]) {
      if (flagForChange) {
        result++;
        flagForChange = false;
      }
    } else {
      if (!flagForChange) {
        result++;
        flagForChange = true;
      }
    }
  }

  return result;
};

// 남이 푼 코드
// 45ms
var minFlips = function (target) {
  let ans = 0;
  let flipNum = "0";
  for (let i = 0; i < target.length; i++) {
    let char = target.charAt(i);
    // flipNum 이라는 것이, 이후 인덱스에서 이미 변경되어 있는 숫자니까
    // 그 숫자랑 같냐 다르냐만 체크하면 된다.
    // 나는 flagForChange 가 불필요한 변수였다.
    if (char !== flipNum) {
      flipNum = flipNum === "0" ? "1" : "0";
      ans++;
    }
  }
  return ans;
};
