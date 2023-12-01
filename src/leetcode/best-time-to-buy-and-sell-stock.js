/**
 * @param {number[]} prices
 * @return {number}
 */
// 핵심은 싸게 팔아서 비싸기 판다
// 배열 크기 상 동적계획법을 고려해봐야한다
// [7, 1, 5, 3, 6, 4]
// [[1, 2], [3, 4], [4, 6], [5, 3], [6, 5], [7, 1]]
// 이때, 사는 날짜가 파는 날짜보다 무조건 작아야한다.

var maxProfit = function(prices) {
  const map = new Map();
  for (let day = 0; day < prices.length; day++) {
    map.set(day, prices[day]);
  }
  const mapToArr = Array.from(map);
  mapToArr.sort((a, b) => a[1] - b[1])
  console.log(mapToArr)
  let max = 0;
  for (let i = 0; i < mapToArr.length; i++) {
    const start = mapToArr[i];
    for (let j = mapToArr.length - 1; j !== i; j--) {
      if (mapToArr[i][0] < mapToArr[j][0]) {
        const profit = mapToArr[j][1] - mapToArr[i][1]
        max = profit > max ? profit : max
      }
    }
  }
  return max;
};

console.log(maxProfit([7, 1, 5, 3, 6, 4]))
console.log(maxProfit([7,6,4,3,1]))
console.log(maxProfit([3,2,6,5,0,3]))
