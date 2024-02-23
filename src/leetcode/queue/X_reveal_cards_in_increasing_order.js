// https://leetcode.com/problems/reveal-cards-in-increasing-order/
/**
 * @param {number[]} deck
 * @return {number[]}
 */
// 74ms
var deckRevealedIncreasing = function (deck) {
  // 17, 13, 11 - 2
  // [] <- 17
  // [13, 17]
  // [11, 17, 13]
  // [7, 13, 11, 17]
  if (deck.length === 1) {
    return deck;
  }
  let results = [];
  deck.sort((a, b) => b - a);

  results.push(deck[1]);
  results.push(deck[0]);

  for (let i = 2; i < deck.length; i++) {
    let last = results.splice(-1);
    results = [deck[i], last, ...results];
  }

  console.log(results);

  return results;
};

// 47ms
var deckRevealedIncreasing = function (deck) {
  let stack = deck.sort((a, b) => b - a);
  let queue = [stack.shift()];
  while (stack.length > 0) {
    queue.unshift(queue.pop());
    queue.unshift(stack.shift());
  }
  return queue;
};
