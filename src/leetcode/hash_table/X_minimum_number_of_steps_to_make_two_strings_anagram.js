// https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
/**
 * @param {string} s
 * @param {string} t
 * @return {number}
 */
// 123ms
var minSteps = function(s, t) {
    // leetcode
    // { l: 1, e: 3, t: 1, c: 1, o: 1 d: 1 }
    // practice
    // { p: 1, e: 1, t: 1, c: 2, r: 1, a: 1, i: 1}

    // { l: 1, e: 2, o: 1, d: 1 }
    // { p: 1, c: 1, r: 1, a: 1, i: 1 }

    const sMem = {};
    const tMem = {};

    for (let i = 0; i < s.length; i++) {
        if (sMem[s[i]]) {
            sMem[s[i]] += 1;
        } else {
            sMem[s[i]] = 1;
        }
    }
    for (let i = 0; i < t.length; i++) {
        if (tMem[t[i]]) {
            tMem[t[i]] += 1;
        } else {
            tMem[t[i]] = 1;
        }
    }

    for (const key of Object.keys(tMem)) {
        if (sMem[key]) {
            let rest = sMem[key] - tMem[key];
            if (rest >= 0) {
                if (rest == 0) {
                    delete sMem[key];
                } else {
                    sMem[key] = rest;
                }
                delete tMem[key];
            } else {
                tMem[key] = -rest;
                delete sMem[key];
            }
        }
    }

    return Object.values(sMem).reduce((acc, a) => acc + a, 0);
};


// 55ms
var minSteps = function(s, t) {
    const countS = new Array(26).fill(0);
    const countT = new Array(26).fill(0);

    for (let i = 0; i < s.length; i++) {
        countS[s.charCodeAt(i) - 'a'.charCodeAt(0)]++;
        countT[t.charCodeAt(i) - 'a'.charCodeAt(0)]++;
    }

    let steps = 0;
    for (let i = 0; i < 26; i++) {
        steps += Math.abs(countS[i] - countT[i]);
    }

    return Math.floor(steps/2)
};
