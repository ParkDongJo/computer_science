// https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
/**
 * @param {character[]} letters
 * @param {character} target
 * @return {character}
 */
var nextGreatestLetter = function (letters, target) {
  let sorted = [];
  if (letters.indexOf(target) !== -1) {
    sorted = letters.sort((a, b) => a.charCodeAt(0) - b.charCodeAt(0));
  } else {
    sorted = [...letters, target].sort(
      (a, b) => a.charCodeAt(0) - b.charCodeAt(0)
    );
  }
  const index = sorted.indexOf(target);

  if (index !== sorted.length - 1) {
    for (let i = index + 1; i < sorted.length; i++) {
      if (target === sorted[i]) {
        continue;
      } else {
        return sorted[i];
        break;
      }
    }
    return letters[0];
  } else {
    return letters[0];
  }
};

// console.log(nextGreatestLetter(["c", "f", "j"], "a")); // c
console.log(
  nextGreatestLetter(["e", "e", "e", "e", "e", "e", "n", "n", "n", "n"], "e")
); // n

// 다른 사람 풀이
// 39ms
var nextGreatestLetter = function (letters, target) {
  for (let i = 0; i < letters.length; i++) {
    if (letters[i] > target) {
      return letters[i];
    }
  }
  // If no element is greater than the target, return the first element
  return letters[0];
};

// 다른 사람 풀이
// 43ms
function nextGreatestLetter(letters, target) {
  let left = 0;
  let right = letters.length - 1;
  while (left <= right) {
    const middle = Math.floor((left + right) / 2);
    if (letters[middle] <= target) {
      left = middle + 1;
    } else {
      right = middle - 1;
    }
  }
  return letters[left % letters.length];
}
