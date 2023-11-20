//Write a function to find the longest common prefix string amongst an array of strings.
//If there is no common prefix, return an empty string "".
function longestCommonPrefix(strs: string[]): string {
  if (strs.length === 0) {
    return '';
  }
  let prefix = '';
  let count = 0
  for (let i = 0; i < strs[0].length; i++) {
    const c = strs[0][i];
    for (let j = 1; j < strs.length; j++) {
      if (c === strs[j][i]) {
        count++;
      } else {
        return prefix;
      }
    }
    if (count === strs.length - 1) {
      prefix += c;
      count = 0;
    }
  }
  return prefix;
};

console.log(longestCommonPrefix(["flower","flow","flight"]));
console.log(longestCommonPrefix(["dog","racecar","car"]));
console.log(longestCommonPrefix(["c","acc","ccc"]));

// longestCommonPrefix 함수 코드를 개선해보자
function longestCommonPrefix2(strs: string[]): string {
  let prefix = '';
  for (let i = 0; i < strs[0].length; i++) {
    for (let j = 1; j < strs.length; j++) {
      if (strs[0][i] !== strs[j][i]) {
        return prefix;
      }
    }
    prefix += strs[0][i];
  }
  return prefix;
}

console.log(longestCommonPrefix2(["flower","flow","flight"]));
console.log(longestCommonPrefix2(["dog","racecar","car"]));
console.log(longestCommonPrefix2(["c","acc","ccc"]));
