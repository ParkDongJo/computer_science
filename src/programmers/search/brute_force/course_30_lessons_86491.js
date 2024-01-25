/*
    지갑의 크기를 정하는데, 가장 최소의 크기를 만들고자 한다.
    지갑에 넣을 명함 크기가 2차원 배열로 들어온다.
    sizes = [[60, 50], [30, 70], [60, 30], [80, 40]]
    이 경우  2번째 명함 같은 경우 가로로 눕혀서 넣는 것이 더 작은 크기가 된다.
    이때 80 x 40 의 크기로 지갑을 만들면, 모든 명함을 넣을 수 있는 최소의 크기가 된다.
*/
function solution(sizes) {
    var answer = 0;
    // 위의 문제를 기반으로 지갑의 크기를 정한다.
    for(const size of sizes) {
        size.sort((a, b) => a - b);
    }
    console.log(sizes);
    const wMax = Math.max(...sizes.map((size) => size[0]));
    const hMax = Math.max(...sizes.map((size) => size[1]));

    return wMax * hMax;
}

console.log(solution([[60, 50], [30, 70], [60, 30], [80, 40]]));