// https://leetcode.com/problems/minimum-additions-to-make-valid-string/
/**
 * @param {string} word
 * @return {number}
 */
// 165ms
// 비효율적인 코드
var addMinimum = function (word) {
  let stack = [];
  let temp = word.split("");
  let idx = 0;
  let result = 0;

  while (temp.length > 0 || stack[stack.length - 1] !== "c") {
    const r = idx % 3;
    if (r === 0) {
      if (temp[0] !== "a") {
        stack.push("a");
        result++;
      } else {
        stack.push(temp.splice(0, 1)[0]);
      }
    } else if (r === 1) {
      if (temp[0] !== "b") {
        stack.push("b");
        result++;
      } else {
        stack.push(temp.splice(0, 1)[0]);
      }
    } else if (r === 2) {
      if (temp[0] !== "c") {
        stack.push("c");
        result++;
      } else {
        stack.push(temp.splice(0, 1)[0]);
      }
    }
    idx++;
  }

  return result;
};

// 57ms
var addMinimum = function (A) {
  let ans = 0;

  for (let left = 0; left < A.length; ) {
    let right = left + 1;
    while (right < A.length && A[right] > A[right - 1]) {
      right++;
    }
    ans += 3 - (right - left);
    left = right;
  }
  return ans;
};

// 64ms
var addMinimum = function (word) {
  let i = 0;
  let output = 0;

  while (i < word.length) {
    let k = 0;
    if (word[i] === "a") {
      i++;
      k++;
    }

    if (i < word.length && word[i] === "b") {
      i++;
      k++;
    }

    if (i < word.length && word[i] === "c") {
      i++;
      k++;
    }

    output += 3 - k;
  }

  return output;
};
