// x 의 길이를 측정한다.
// x의 길이가 짝수인지 홀수인지 판별한다.
// 길이가 홀수 이면, 가운데 숫자를 제외한 양쪽의 숫자를 비교한다.
// 길이가 짝수 이면, 양쪽의 숫자를 비교한다.
// 이때 음수는 false를 반환한다.
function isPalindrome(x: number): boolean {
  if (x < 0) {
    return false;
  }
  const str = x.toString();
  const len = str.length;
  const mid = Math.floor(len / 2);

  for (let i = 0; i < mid; i++) {
    if (str[i] !== str[len - 1 - i]) {
      return false;
    }
  }

  return true;
};

console.log(isPalindrome(121));
console.log(isPalindrome(-121));
console.log(isPalindrome(10));
console.log(isPalindrome(123));
console.log(isPalindrome(1221));
