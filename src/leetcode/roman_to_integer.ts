
type RomanNum = 'I' | 'V' | 'X' | 'L' | 'C' | 'D' | 'M';
const ROMAN_NUMS: {[r in RomanNum]: number } = {
  "I": 1,
  "V": 5,
  "X": 10,
  "L": 50,
  "C": 100,
  "D": 500,
  "M": 1000
}

function romanToInt(s: string): number {
  let result = 0;
  let prev = 0;
  for (let i = s.length - 1; i >= 0; i--) {
    const num = ROMAN_NUMS[s[i] as RomanNum];
    if (num >= prev) {
      result += num;
    } else {
      result -= num;
    }
    prev = num;
  }
  return result;
};

console.log(romanToInt('III'));
console.log(romanToInt('LVIII'));
console.log(romanToInt('MCMXCIV'));
