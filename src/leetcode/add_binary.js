/**
 * @param {string} a
 * @param {string} b
 * @return {string}
 */
// 둘 중 가장 긴 바이너리를 기준으로 반복문을 돈다
// 반복문에 맞춰 a, b 를 거꾸로 하나씩 꺼낸다
// 각각 문자를 숫자로 변환하고 두 수를 더해서 (disit에 숫자가 있으면 그 숫자까지 더한다)
//  - 3이면 disit 에 1을 넣고, 1을 result 에 넣은 다음 다음 순서로 넘어간다
//  - 2면 disit 에 1을 넣고, 0을 result 배열에 넣은 다음 다음 순서로 넘어간다
//  - 1이면 result 배열에 넣은 다음 다음 순서로 넘어간다
const parseBinary = (str) => {
  if (str == "1") {
    return 1
  }
  return 0
}
var addBinary = function(a, b) {
    const len = a.length > b.length ? a.length : b.length
    let result = "";
    let disit = 0;
    let aArr = a.split('').reverse();
    let bArr = b.split('').reverse();

    for (i = 0; i < len; i++) {
      const sum = parseBinary(aArr[i]) + parseBinary(bArr[i]) + disit
      if (sum == 3) {
        disit = 1;
        result = "1" + result
      } else if (sum == 2) {
        disit = 1;
        result = "0" + result
      } else if (sum == 1) {
        disit = 0;
        result = "1" + result
      } else {
        disit = 0;
        result = "0" + result
      }
    }
    if (disit) {
      result = "1" + result
    }
    return result
};

console.log(addBinary("11", "1"))
// console.log(addBinary("1010", "1011"))
