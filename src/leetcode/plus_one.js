// 배열을 반대로 돌리는 반복문을 만든다.
// 각 자리수에 1을 더한다.
// 각 자리수를 더한 값이 10이 넘는지 확인한다.
// - 각 자리수에 1을 더한 값이 10을 넘지 않으면 -> 다시 그 수를 넣어준다. 그리고 그 자리에서 break를 건다.
// - 각 자리수에 1을 더한 값이 10을 넘으면, 다음 요소로 넘어가 1을 더한다.
var plusOne = function(digits) {
    let result = [];
    let isDone = false;
    for (let i = digits.length - 1; i >= 0; i--) {
      let next = isDone ? digits[i] : digits[i] + 1;
      if (isDone || next < 10) {
        result.unshift(next);
        isDone = true;
      } else {
        result.unshift(0);
      }
    }
    if (!isDone) {
      result.unshift(1);
    }
    return result;
};

console.log(plusOne([1, 2, 3]));
console.log(plusOne([4, 3, 2, 1]));
console.log(plusOne([9]));
console.log(plusOne([1,9,9]));
console.log(plusOne([8,9]));
