// https://leetcode.com/problems/backspace-string-compare/description/
/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
// 50ms
var backspaceCompare = function (s, t) {
  let sStack = [];
  let tStack = [];

  for (let i = 0; i < s.length; i++) {
    if (s[i] === "#") {
      sStack.pop();
    } else {
      sStack.push(s[i]);
    }
  }

  for (let i = 0; i < t.length; i++) {
    if (t[i] === "#") {
      tStack.pop();
    } else {
      tStack.push(t[i]);
    }
  }

  let sStr = sStack.join("");
  let tStr = tStack.join("");

  return sStr === tStr;
};

// 남의 풀이
// 37ms
var backspaceCompare = function (s, t) {
  function build(s) {
    let stack = [];
    for (let i = 0; i < s.length; i++) {
      if (s[i] == "#") stack.pop();
      else stack.push(s[i]);
    }
    return stack.join("");
  }
  return build(s) == build(t);
};
