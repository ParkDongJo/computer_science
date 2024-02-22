// https://leetcode.com/problems/arithmetic-subarrays/
/**
 * @param {number[]} nums
 * @param {number[]} l
 * @param {number[]} r
 * @return {boolean[]}
 */
// 433ms
var checkArithmeticSubarrays = function (nums, l, r) {
  // [4,6,5,9,3,7] 시작 [0,0,2] 끝 [2,3,5]
  // table [[], [], []]
  // [4,6,5] -> [6,5,4]
  // for() -> 6 - 5 / 5 - 4
  let table = [];
  for (let i = 0; i < l.length; i++) {
    table.push(nums.slice(l[i], r[i] + 1));
  }
  let memo = 0;

  for (let i = 0; i < table.length; i++) {
    table[i].sort((a, b) => b - a);
    for (let j = 0; j < table[i].length; j++) {
      if (j === table[i].length - 1) {
        break;
      }
      let diff = table[i][j] - table[i][j + 1];
      if (j === 0) {
        memo = diff;
      } else {
        if (memo !== diff) {
          table[i] = false;
          break;
        }
      }
    }
    if (typeof table[i] !== "boolean") {
      table[i] = true;
    }
  }
  return table;
};

// 84ms
var checkArithmeticSubarrays = function (nums, l, r) {
  let result = [];
  for (let i = 0; i < l.length; i++) {
    result.push(isArithmetic(nums.slice(l[i], r[i] + 1)));
  }
  return result;
};

function isArithmetic(arr) {
  let min = Math.min(...arr);
  let max = Math.max(...arr);

  if (min == max) {
    return true;
  }

  let step = (max - min) / (arr.length - 1);

  if (step != Math.floor(step)) {
    return false;
  }

  let set = new Set();
  for (let x of arr) {
    if (set.has(x)) {
      return false;
    }

    set.add(x);
  }

  for (let x = min; x <= max; x += step) {
    if (!set.has(x)) {
      return false;
    }
  }

  return true;
}

// 68ms
const checkArithmeticSubarrays = (nums, l, r) => {
  const res = [];
  for (let i = 0; i < l.length; ++i) {
    let min = Infinity;
    let max = -Infinity;
    for (let p = l[i]; p <= r[i]; ++p) {
      if (nums[p] < min) min = nums[p];
      if (nums[p] > max) max = nums[p];
    }
    if (min === max) {
      res.push(true);
    } else {
      const diff = (max - min) / (r[i] - l[i]);
      const arr = new Array(r[i] - l[i] + 1).fill(0);
      for (let p = l[i]; p <= r[i]; ++p) {
        const ind = (nums[p] - min) / diff;
        if (ind % 1 || ++arr[ind] > 1) break;
      }
      // 비트연산을 쓰네..
      // 이걸 이해하려면 비트연산에 대해서 알아야한다.
      res.push(!~arr.indexOf(0));
    }
  }
  return res;
};
