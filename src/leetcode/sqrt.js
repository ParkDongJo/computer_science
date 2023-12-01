/**
 * @param {number} x
 * @return {number}
 */
//2^32 2^16
var mySqrt = function(x) {
  for (let i = 1; i <= 65536; i ++) {
    if (i * i > x) {
      return (i - 1);
      break;
    }
  }
};

console.log(mySqrt(4));
console.log(mySqrt(8));
