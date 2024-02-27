
/**
 * @param {string} s
 * @return {string}
 */
// 88ms
var removeStars = function(s) {
  let stack = [];

  for (let i = 0; i < s.length; i++) {
      if (s[i] === "*") {
          stack.pop();
      } else {
          stack.push(s[i]);
      }
  }
  return stack.join("");
};

// 남이 푼 코드
// 50ms
var removeStars = function(s) {
  let str = [];

  for (let i = 0; i < s.length; i++) {
      if (s[i] === "*") {
          str.pop();
      } else {
          str.push(s[i]);
      }
  }

    return str.join("");
};
