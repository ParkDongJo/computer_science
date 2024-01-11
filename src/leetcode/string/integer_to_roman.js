// https://leetcode.com/problems/integer-to-roman/submissions/1142931489/
/**
 * @param {number} num
 * @return {string}
 */

// 내가 푼  방법
// runtime: 134ms
const symbols = {
  1: 'I',
  4: 'IV',
  5: 'V',
  9: 'IX',
  10: 'X',
  40: 'XL',
  50: 'L',
  90: 'XC',
  100: 'C',
  400: 'CD',
  500: 'D',
  900: 'CM',
  1000: 'M',
}
const getRoman = (num, digit) => {
  const romans = [];
  const count = Math.floor(num / digit);
  if (count === 0) {
      return ['', num];
  }

  for (let i = 0; i < count; i++) {
      romans.push(symbols[digit]);
  }
  return [romans, num - count * digit];  
}
var intToRoman = function(num) {
  const results = [];
  let digits = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1];
  let rest = num;

  for (let i = 0; i < digits.length; i++) {
      const [r, n] = getRoman(rest, digits[i]);
      results.push(r);
      rest = n;
  }
  
  // 여기서 시간이 많이 걸린 느낌
  return results.toString().replaceAll(',', '');
};


// Runtime: 80ms
// 상위권이 푼 방법
/**
 * @param {number} num
 * @return {string}
 */
var intToRoman = function(num) {
  const romanNumerals = [
      {numeral: 'M', val: 1000},
      {numeral: 'CM', val: 900},
      {numeral: 'D', val: 500},
      {numeral: 'CD', val: 400},
      {numeral: 'C', val: 100},
      {numeral: 'XC', val: 90},
      {numeral: 'L', val: 50},
      {numeral: 'XL', val: 40},
      {numeral: 'X', val: 10},
      {numeral: 'IX', val: 9},
      {numeral: 'V', val: 5},
      {numeral: 'IV', val: 4},
      {numeral: 'I', val: 1}
  ];

  let result = '';

  for (const { numeral, val } of romanNumerals) {
      const count = Math.floor(num / val);
      // 이 연산은 어떤 결과를 낼까?
      // num = num % val; 의 줄임 연산인걸로 보인다.
      num %= val;
      // repeat() 이라는 메서드!!! 괜찮은데?
      result += numeral.repeat(count);
  }

  return result;
}