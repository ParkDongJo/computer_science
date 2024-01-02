// https://leetcode.com/problems/add-strings/
/**
 * @param {string} num1
 * @param {string} num2
 * @return {string}
 */
var addStrings = function(num1, num2) {
  const rNum1 = num1.split("").reverse()
  const rNum2 = num2.split("").reverse()
  const len = rNum1.length >= rNum2.length ? rNum1.length : rNum2.length;
  let digit = 0;
  let results = []

  for(let i = 0; i < len; i++) {
      let sum = Number(rNum1[i] || 0) + Number(rNum2[i] || 0) + digit;
      if (sum >= 10) {
          digit = 1;
          results.push(sum - 10);
      } else {
          digit = 0;
          results.push(sum);
      }
  }
  if (digit === 1) {
      results.push(digit)
  }
  return results.reverse().join("");
};
