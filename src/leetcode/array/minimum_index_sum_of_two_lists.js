// https://leetcode.com/problems/minimum-index-sum-of-two-lists/
/**
 * @param {string[]} list1
 * @param {string[]} list2
 * @return {string[]}
 */
// 124ms
var findRestaurant = function (list1, list2) {
  // list1, list2 있는 요소들을 모두 비교해야할거 같다
  // 같은 문자를 찾아야한다.
  // 찾고, 각 인덱스를 저장한다.
  // 그리고 자료구조를 돌면서, 더한 값을 정렬한다.
  let map = new Map();
  let results = [];

  for (let i = 0; i < list1.length; i++) {
    for (let j = 0; j < list2.length; j++) {
      if (list1[i] === list2[j]) {
        if (map.has(i + j)) {
          map.set(i + j, [...map.get(i + j), list1[i]]);
        } else {
          map.set(i + j, [list1[i]]);
        }
      }
    }
  }
  return Array.from(map).sort((a, b) => a[0] - b[0])[0][1];
};

// 60ms
var findRestaurant = function (list1, list2) {
  let result = new Array();
  let min = 9999;

  for (let i = 0; i < list1.length; i++) {
    let j = list2.indexOf(list1[i]);
    if (j !== -1) {
      if (i + j < min) {
        result = [list1[i]];
        min = i + j;
        continue;
      }
      if (i + j === min) {
        result.push(list1[i]);
        min = i + j;
      }
    }
  }

  return result;
};

// 63ms
var findRestaurant = function (list1, list2) {
  let memory = new Map();
  let sol = [];
  // 최소값을 아래와 같이 최초 설정해놓고
  let minimum = list1.length + list2.length + 1;
  for (let i = 0; i < list1.length; i++) {
    memory.set(list1[i], i);
  }
  for (let i = 0; i < list2.length; i++) {
    if (memory.has(list2[i])) {
      const sum = memory.get(list2[i]) + i;
      // 이때 결과값을 넣는다.
      if (sum < minimum) {
        sol = [list2[i]];
        minimum = sum;
      } else if (sum == minimum) {
        sol.push(list2[i]);
      }
    }
  }
  return sol;
};
