// 라이브 코테에서 마주해봤던 문제
// [[2021-08-12, 2021-08-16], [2021-08-13, 2021-08-18], [2021-08-04, 2021-08-08]]
// 위 배열을 아래와 같이 수정하는 문제
// [[2021-08-04, 2021-08-08], [2021-08-13, 2021-08-18]]

function dateSort(arr) {
  let results = [];
  arr.sort((a, b) => new Date(a[0]) - new Date(b[0]));

  // [[2021-08-04, 2021-08-08], [2021-08-12, 2021-08-16], [2021-08-13, 2021-08-18], [2021-08-14, 2021-08-20]]
  // - date[0][1] < date[1][0] -> 포함관계 아님
  // - date[0][1] >= date[1][0] -> 포함관계
  //    - 겹쳐있다 -> date[0][0] <= date[1][0] && date[0][1] <= date[1][1]
  //    - 포함된다 -> date[0][0] <= date[1][0] && date[0][1] >= date[1][1]
  results.push([arr[0][0], arr[0][1]]);

  for (let i = 1; i < arr.length; i++) {
    const top = results.pop();
    if (new Date(top[1]) < new Date(arr[i][0])) {
      // 포함관계가 아니다
      results.push(top);
      results.push([arr[i][0], arr[i][1]]);
    } else {
      // 포함관계다
      if (new Date(top[1]) < new Date(arr[i][1])) {
        results.push([top[0], arr[i][1]]);
      }
      if (new Date(top[1]) > new Date(arr[i][1])) {
        results.push([top[0], top[1]]);
      }
      if (new Date(top[1]) === new Date(arr[i][1])) {
        results.push([top[0], top[1]]);
      }
    }
  }

  return results;
}

console.log(
  dateSort([
    ["2021-08-12", "2021-08-16"],
    ["2021-08-13", "2021-08-18"],
    ["2021-08-04", "2021-08-08"],
    ["2021-08-14", "2021-08-20"],
  ])
);
