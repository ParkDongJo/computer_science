// https://leetcode.com/problems/groups-of-special-equivalent-strings/description/
// var numSpecialEquivGroups = function(words) {
//     // 짝수 끼리만 또는 홀수 끼리만 교환 가능

//     // abcd, cdab -> adcb -> abcd
//     //     , cbad -> abcd

//     let result = 0;

//     for (let i = 0; i < words.length; i++) {
//         for (let j = 0; j < words.length; j++) {
//             if (i === j) {
//                 continue;
//             }
//             if (isEquivalent(words[i], words[j])) {
//                 result++;
//             }
//         }
//     }

//     return result
// };



var numSpecialEquivGroups = function(A) {
    const groupSet = new Set();
    A.forEach(a => {
        let s = transform(a);
        console.log('a - ', a, ' s - ', s)
        return groupSet.add(s)
    });
    console.log(groupSet)
    return groupSet.size;
};

const transform = S => {
    const even = S.split('').filter((_, i) => i % 2 === 0);
    const odd = S.split('').filter((_, i) => i % 2 === 1);
    even.sort();
    odd.sort();
    return `${even.join('')}${odd.join('')}`;
};

console.log(numSpecialEquivGroups(["abcd","cdab","cbad","xyzz","zzxy","zzyx"]))