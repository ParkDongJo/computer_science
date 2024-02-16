// https://leetcode.com/problems/watering-plants/
/**
 * @param {number[]} plants
 * @param {number} capacity
 * @return {number}
 */
// 56ms
var wateringPlants = function (plants, capacity) {
  let water = capacity;
  // 앞으로는 당장 체크를 할때, 배열을 활용하자. sum 으로 하지말고
  let checked = [];
  let step = 0;
  let cursor = 0;

  while (checked.length < plants.length) {
    water -= plants[cursor];
    // water > 조건만 체크해서, 0이 되는 경우를 놓쳤었고,
    // 이때문에 시간이 지체되었다.
    if (water >= 0) {
      checked.push(true);
      step++;
      cursor++;
    } else {
      step = step + cursor * 2;
      water = capacity;
    }
  }

  return step;
};

// 42ms
var wateringPlants = function (plants, capacity) {
  let steps = 0;
  let cap = capacity;
  for (let i = 0; i < plants.length; i++) {
    if (cap >= plants[i]) {
      cap = cap - plants[i];
      steps = steps + 1;
    } else {
      cap = capacity;
      cap = cap - plants[i];
      steps = steps + ((i + 1) * 2 - 1);
    }
  }
  return steps;
};
