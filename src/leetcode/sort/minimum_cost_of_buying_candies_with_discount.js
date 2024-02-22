// https://leetcode.com/problems/minimum-cost-of-buying-candies-with-discount/
/**
 * @param {number[]} cost
 * @return {number}
 */
var minimumCost = function (cost) {
  // [6,5,7,9,2,2]
  // sort - [9,7,6,5,2,2]
  // 9,7 - 6
  // 1,2 - 3
  // 5,2 - 2
  // 4,5 - 6
  let sum = 0;
  cost.sort((a, b) => b - a);

  for (let i = 0; i < cost.length; i++) {
    if ((i + 1) % 3 !== 0) {
      sum += cost[i];
    }
  }
  return sum;
};
