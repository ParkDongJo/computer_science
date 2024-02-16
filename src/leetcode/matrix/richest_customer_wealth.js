// https://leetcode.com/problems/richest-customer-wealth/submissions/1177052571/
/**
 * @param {number[][]} accounts
 * @return {number}
 */
// 47ms
var maximumWealth = function (accounts) {
  let wealth = [];
  for (let i = 0; i < accounts.length; i++) {
    wealth.push(accounts[i].reduce((acc, curr) => (acc += curr), 0));
  }
  return Math.max(...wealth);
};
