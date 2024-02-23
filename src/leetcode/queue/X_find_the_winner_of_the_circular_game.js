// https://leetcode.com/problems/find-the-winner-of-the-circular-game/
/**
 * @param {number} n
 * @param {number} k
 * @return {number}
 */
// 271ms
var findTheWinner = function (n, k) {
  // n명 원으로 시계방향으로 앉아있고
  // k번 만큼 시계방향으로 돈다. 그 k번째에 해당하는 아이가 아웃된다.
  const queue = Array(n)
    .fill()
    .map((_, i) => i + 1);
  let count = 0;

  while (queue.length > 1) {
    count++;
    let n = queue.splice(0, 1)[0];
    if (count === k) {
      count = 0;
      continue;
    }
    queue.push(n);
  }

  return queue.pop();
};

// 47ms
var findTheWinner = function (n, k) {
  const array = [];
  // INITIALIZE ARRAY
  for (let i = 1; i <= n; i++) {
    array[i - 1] = i;
  }

  let index = 0;
  while (array.length > 1) {
    const loserIndex = (index + k - 1) % array.length;
    array.splice(loserIndex, 1);

    if (loserIndex === array.length) {
      index = 0;
    } else {
      index = loserIndex;
    }
  }

  return array[0];
};

// 52ms
var findTheWinner = function (n, k) {
  let arr = Array.from({ length: n }, (_, index) => index + 1); // create array
  let index = 0; // 0
  //        i
  // array [3,5]
  while (arr.length > 1) {
    // while we don't have a winner
    index = (index + k - 1) % arr.length; // 1%2 => 1
    arr.splice(index, 1); // (position, remove)
  }

  return arr[0];
};
