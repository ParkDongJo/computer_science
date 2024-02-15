// https://leetcode.com/problems/crawler-log-folder/
/**
 * @param {string[]} logs
 * @return {number}
 */
// 내가 푼 문제
// 112ms

/*
  내가 푼 문제가 효율이 안좋은 이유는 정규표현식으로 문자열을 체크하는 부분 때문이다.
  ../ ./ 문자에 대해서만 체크하면 효율이 더 좋아진다.
*/
var minOperations = function (logs) {
  // [문제 이해]
  // ../ 상위폴더로 이동
  // ./ 같은 폴더
  // x/ x의 하위로 이동
  // logs 의 최종 위치에서, 다시 main 폴더로 돌아가는데 최소 작업횟수

  // logs 을 반복해서 돌고
  // 각각 요소들을 빼서, 분기문으로 체크를 한다.
  // - x/ 형태의 문자열이면 depth++
  // - ../ 형태의 문자열이면 depth-- (depth가 0일때는 연산 X)
  // - ./ 일때도 연산 X
  let depth = 0;

  for (let log of logs) {
    if (/\w+\//g.test(log)) {
      depth++;
    } else if (/..\//g.test(log) && depth > 0) {
      depth--;
    }
  }

  return depth;
};

// 다른 사람의 풀이
// 42ms
var minOperations = function (logs) {
  let result = 0;
  for (let i = 0; i < logs.length; i++) {
    if (logs[i] == "../" && result != 0) {
      result--;
    } else if (logs[i].indexOf(".") == -1) {
      result++;
    }
  }
  return result;
};
