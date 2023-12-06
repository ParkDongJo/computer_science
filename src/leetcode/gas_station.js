/**
 * @param {number[]} gas
 * @param {number[]} cost
 * @return {number}
 */
// gas를 반복문을 돈다.
// 그리고 그 안에서 gas의 출발점에 따라
// 비용 계산을 한다. 이때 gas 갯수만큼 반복문을 돌아야한다
// - 반복문이 다 돌기도 전에 음수가 나오면 계속 다음 gas 부터 시작한다. 모든 gas를 다돌았는데도 음수만 나왔다면 -1을 리턴한다
// - 반복문이 다 돌면, 전체 반복문을 중단하고 해당 gas 인덱스를 리턴한다.
var canCompleteCircuit = function(gas, cost) {
  let start = -1;
  let tank = 0;
  let used = 0;
  for (let i = 0; i < gas.length; i++) {
    start = i;
    tank = 0;
    used = 0;
    for (let j = i; j < gas.length + i; j++) {
      let step = j - i;
      let pointer = j >= gas.length ? j - gas.length : j
      const current = tank + gas[pointer] + used
      if (current < cost[pointer]) {
        start = -1;
        break;
      } else {
        tank = current
        used = -cost[pointer];
      }
    }
    if (start !== -1) {
      return start;
      break;
    }
  }
  return start;
};

console.log(canCompleteCircuit([1,2,3,4,5], [3,4,5,1,2]))
console.log(canCompleteCircuit([2,3,4], [3,4,3]))
