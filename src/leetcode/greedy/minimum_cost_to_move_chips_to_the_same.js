/**
 * @param {number[]} position
 * @return {number}
 */
// 잘못 접근
// 짝수가 많은지, 홀수가 많은지를 확인해야함
// var minCostToMoveChips = function(position) {
//   const map = new Map();
//   let target = 0;
//   let maxCnt = 0;
//   let cost = 0;

//   for(let i = 0; i < position.length; i++) {
//       if (map.has(position[i])) {
//           map.set(position[i], map.get(position[i]) + 1)
//       } else {
//           map.set(position[i], 1);
//       }
//   }

//   for (const [p, v] of map) {
//       if (maxCnt < v) {
//           maxCnt = v;
//           target = p - 1;
//       }
//   }

//   for (let i = 0; i < position.length; i++) {
//       if (position[i] - 1 === target) {
//           continue;
//       }
//       const distance = Math.abs(target - (position[i] - 1));
//       if (distance % 2 === 1) {
//           cost++;
//       }
//   }
//   console.log(target)
//   return cost;
// };
var minCostToMoveChips = function(position) {
    const map = new Map();
    let target = {
        even: 0,
        odd: 1,
    };
    let evenCnt = 0;
    let oddCnt = 0;
    let cost = 0;

    for(let i = 0; i < position.length; i++) {
        if (position[i] % 2 === 0) {
            target.even = position[i] - 1;
            evenCnt++;
        } else {
            target.odd = position[i] - 1;
            oddCnt++;
        }
    }

    if (evenCnt > oddCnt) {
        const tmp = target.even;
        target = tmp
    } else {
        const tmp = target.odd;
        target = tmp
    }

    for (let i = 0; i < position.length; i++) {
        if (position[i] - 1 === target) {
            continue;
        }
        const distance = Math.abs(target - (position[i] - 1));
        if (distance % 2 === 1) {
            cost++;
        }
    }
    return cost;
}
console.log(minCostToMoveChips([6,4,7,8,2,10,2,7,9,7]));
