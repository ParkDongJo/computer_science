// https://school.programmers.co.kr/learn/courses/30/lessons/17681

// 나의 풀이
function getBinaryRow(num, n) {
  let binary = num.toString(2);
  if (binary.length < n) {
    binary = "0".repeat(n - binary.length) + binary;
  }
  return binary;
}
function mergeMap(map1, map2, n) {
  const map = [];
  for (let i = 0; i < map1.length; i++) {
    let row = "";
    for (let j = 0; j < n; j++) {
      if (map1[i][j] !== map2[i][j]) {
        row += "#";
      } else {
        row += map1[i][j] == "1" ? "#" : " ";
      }
    }
    map.push(row);
  }
  return map;
}

function solution(n, arr1, arr2) {
  var answer = [];
  let map1 = arr1.map((num) => {
    return getBinaryRow(num, n);
  });

  let map2 = arr2.map((num) => {
    return getBinaryRow(num, n);
  });

  return mergeMap(map1, map2, n);
}

console.log(solution(5, [9, 29, 28, 18, 11], [30, 1, 21, 17, 28]));

// 다른 사람 풀이
function solution(n, arr1, arr2) {
  return arr1.map((v, i) =>
    addZero(n, (v | arr2[i]).toString(2)).replace(/1|0/g, (a) =>
      +a ? "#" : " "
    )
  );
}

const addZero = (n, s) => {
  return "0".repeat(n - s.length) + s;
};
