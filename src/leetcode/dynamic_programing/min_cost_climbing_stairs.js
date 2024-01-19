/**
 * @param {number[]} cost
 * @return {number}
 */
var minCostClimbingStairs = function (cost) {
  let cursor = 0;
  let total = 0;
  while (cost.length > cursor + 1) {
    if (
      cost[cursor] + (isNaN(cost[cursor + 2]) ? 0 : cost[cursor + 2]) <=
      cost[cursor + 1]
    ) {
      total += cost[cursor];
      cursor = cursor + 1;
    } else {
      total += cost[cursor + 1];
      cursor = cursor + 2;
    }
  }

  return total;
};
