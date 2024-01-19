// https://leetcode.com/problems/simplified-fractions/description/

/**
 * @param {number} n
 * @return {string[]}
 */

// 내 풀이
// runtime : 120
const div = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47];
const loopDiv = (mo, de) => {
    let divIndex = 0;
    let currDiv = div[divIndex];
    let nextMo = mo;
    let nextDe = de;

    while(divIndex < div.length) {
        if (nextDe % currDiv === 0 && nextMo % currDiv === 0) {
            nextMo = nextMo / currDiv
            nextDe = nextDe / currDiv
        } else {
            divIndex++;
            currDiv = div[divIndex];
        }
    }

    return [nextMo, nextDe];
}

var simplifiedFractions = function(n) {
    const set = new Set();
    for (let mo = 1; mo < n; mo++) {
        for (let de = mo + 1; de <= n; de++) {
            const [m, d] = loopDiv(mo, de)
            set.add(`${m}/${d}`);
        }
    }
    return Array.from(set);
};


// 다른 사람의 풀이
// runtime : 79
/**
 * @param {number} n
 * @return {string[]}
 */
var simplifiedFractions = function(n) {
  let fracs = []
  for (let i = 1; i < n; i++) {
      for (let j = i + 1; j <= n; j++) {
          if (gcd(j, i) === 1 ) {
              fracs.push(`${i}/${j}`)
          }
      }
  }

  function gcd(a, b) {
      if (b === 0) {
          return a;
      }
      return gcd(b, a % b);
  }
  return fracs
};


function simplifiedFractions(n) {
  const gcd = (a, b) => !a ? b : gcd(b % a, a);
  const fractions = [];
  for (let denominator = 2; denominator <= n; denominator++) {
      for (let numerator = 1; numerator < denominator; numerator++) {
          if (gcd(numerator, denominator) !== 1) continue;
          fractions.push(`${numerator}/${denominator}`);
      }
  }
  return fractions;
}