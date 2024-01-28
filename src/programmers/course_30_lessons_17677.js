// https://school.programmers.co.kr/learn/courses/30/lessons/17677

/*
  두 문자열의 교집합과 합집합을 구하고
  교집합 / 합집합 을 리턴한다.

  입력으로는 str1과 str2가 들어온다.
  입력으로 들어온 문자열은 두 문자씩 끊어서 하나의 원소로 만든다.

  하지만 두문자씩 끊어서 만들 때, 특수문자나 공백이 있을 시 그 문자는 버린다.
  그리고 두 문자의 대소문자는 구분하지 않는다.
*/

function solution(str1, str2) {
  var answer = 0;
  str1 = str1.toLowerCase();
  str2 = str2.toLowerCase();

  let str1Arr = [];
  let str2Arr = [];

  for (let i = 0; i < str1.length - 1; i++) {
    if (str1[i].match(/[a-z]/) && str1[i + 1].match(/[a-z]/)) {
      str1Arr.push(str1[i] + str1[i + 1]);
    }
  }
  for (let i = 0; i < str2.length - 1; i++) {
    if (str2[i].match(/[a-z]/) && str2[i + 1].match(/[a-z]/)) {
      str2Arr.push(str2[i] + str2[i + 1]);
    }
  }

  let intersection = [];
  let union = [];

  for (let i = 0; i < str1Arr.length; i++) {
    let index = str2Arr.indexOf(str1Arr[i]);
    if (index != -1) {
      intersection.push(str2Arr.splice(index, 1));
    }
    union.push(str1Arr[i]);
  }
  union = union.concat(str2Arr);

  if (union.length == 0) return 65536;

  answer = Math.floor((intersection.length / union.length) * 65536);
  return answer;
}

console.log(solution("FRANCE", "french"));
console.log(solution("handshake", "shake hands"));
console.log(solution("aa1+aa2", "AAAA12"));
