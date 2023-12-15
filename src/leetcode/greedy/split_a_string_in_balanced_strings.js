/**
 * @param {string} s
 * @return {number}
 */
var balancedStringSplit = function(s) {
  let balance = 0;
  let count = 0;
  for (let i = 0; i < s.length; i++) {
    balance += s[i] == 'R' ? -1 : 1;
    if (balance === 0) {
      count++;
    }
  }
  return count;
};

console.log(balancedStringSplit("RLRRLLRLRL"));
console.log(balancedStringSplit("RLRRRLLRLL"));