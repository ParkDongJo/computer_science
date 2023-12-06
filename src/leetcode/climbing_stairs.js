/**
 * @param {number} n
 * @return {number}
 */
// 2로만 갔을 때 최대값 2의 n승과 같을 시, 2의 n승을 하고
// 적다면, 2의 n승보다 1을 뺀 값이다.
// var climbStairs = function(n) {
//   let i = 1;
//   let result = 0;
//   while (n > result) {
//     result = 2 * i;
//     i++;
//   }
//   return n == result ? result : result - 1;
// };

// console.log(climbStairs(2));
// console.log(climbStairs(3));
// console.log(climbStairs(4));


// 각 숫자 개수의 조합들을 구하고
// 각 조합들이 배치될 수 있는 순열 수를 구하여서 더함
const factorial = (n) => {
  if (n == 0) {
    return 1
  }
  return n * factorial(n - 1);
}

var climbStairs = function(n) {
  const map = new Map();
  let i = 0;
  let j = 0;

  while (i <= n) {
    j = Math.floor((n - i) / 2);
    if (i + (2 * j) == n) {
      map.set(i, j)
    }
    i++;
  }

  let count = 0;
  for (let [oneCnt, twoCnt]  of map) {
    count += factorial(oneCnt + twoCnt) / (factorial(oneCnt) * factorial(twoCnt))
  }
  return count;
};

console.log(climbStairs(2));
console.log(climbStairs(3));
console.log(climbStairs(4));
