/**
 * @param {number} num
 * @return {number}
 */
var maximum69Number  = function(num) {
  let max = '';
  let change = 0;
  for (const n of num.toString()) {
      if (change == 0 && n != 9) {
          max += '9'
          if (change == 0)change++;
      } else {
          max += n
      }
  }
  return max;
};

console.log(maximum69Number(9669));
