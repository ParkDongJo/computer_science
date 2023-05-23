// https://school.programmers.co.kr/learn/courses/13213/lessons/91081?language=javascript
/**
 문제 설명
스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.

속한 노래가 많이 재생된 장르를 먼저 수록합니다.
장르 내에서 많이 재생된 노래를 먼저 수록합니다.
장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.

제한사항
genres[i]는 고유번호가 i인 노래의 장르입니다.
plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
장르 종류는 100개 미만입니다.
장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
모든 장르는 재생된 횟수가 다릅니다.
입출력 예
genres	plays	return
["classic", "pop", "classic", "classic", "pop"]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
입출력 예 설명
classic 장르는 1,450회 재생되었으며, classic 노래는 다음과 같습니다.

고유 번호 3: 800회 재생
고유 번호 0: 500회 재생
고유 번호 2: 150회 재생
pop 장르는 3,100회 재생되었으며, pop 노래는 다음과 같습니다.

고유 번호 4: 2,500회 재생
고유 번호 1: 600회 재생
따라서 pop 장르의 [4, 1]번 노래를 먼저, classic 장르의 [3, 0]번 노래를 그다음에 수록합니다.

장르 별로 가장 많이 재생된 노래를 최대 두 개까지 모아 베스트 앨범을 출시하므로 2번 노래는 수록되지 않습니다.
※ 공지 - 2019년 2월 28일 테스트케이스가 추가되었습니다.

 */

function solution(genres, plays) {
    var answer = [];
    // genres 의 배열 요소의 값을 key 값으로 하는 Map 자료구조의 playsPerGenres 테이블을 만든다.
    // key 값이 같은 genre는 plays 값을 더한다.
    // 완성된 테이블 을 내림차순으로 sort 한다.
    // sort 된 테이블을 을 순회하면서, genres 도 순회한다, 이때 테이블에서 뽑은 값과 genres 에서 같은 값의 index를 뽑아낸다.
    // 뽑아낸 index의 plays의 값을 빼내어서 playsPerIndex 테이블을 만든다.
    // playsPerIndex 테이블을 value 의 내립차순으로 sort 한다.
    // 각 playsPerIndex의 0, 1번째의 index를 answer에 넣는다.

    const playsPerGenres = new Map();
    genres.forEach((genre, index) => {
        const playsPerGenre = playsPerGenres.get(genre) || 0;
        playsPerGenres.set(genre, playsPerGenre + plays[index]);
    });

    const sortedPlaysPerGenres = [...playsPerGenres.entries()].sort((a, b) => b[1] - a[1]);

    console.log(sortedPlaysPerGenres)

    sortedPlaysPerGenres.forEach((genre) => {
        const genreName = genre[0];
        const genrePlays = new Map();

        genres.forEach((genre, index) => {
            if (genre === genreName) {
                genrePlays.set(index, plays[index]);
            }
        });

        const sortedGenrePlays = new Map([...genrePlays.entries()].sort((a, b) => b[1] - a[1]));
        const keys = [...sortedGenrePlays.keys()];

        // answer.push(keys[0]);
        // answer.push(keys[1]);

        keys.forEach((key, index) => {
            index < 2 && answer.push(key)
        });
    });


    return answer;
}
console.log(solution(["classic", "pop", "classic", "classic", "pop"], [500, 600, 150, 800, 2500]));


// 첫 오답 풀이 접근의 문제법
/*
    다 풀어 놓고 문제의 조건을 빠져먹은게 있다.

    '장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.'

    이 말인 즉슨 꼭! genre 가 2개 이상이 아닐 수도 있다는 말이다.
    즉 내가 작성한 마지막

        // answer.push(keys[0]);
        // answer.push(keys[1]);
    
    이 코드는 무조건 2개 이상의 genre 가 있다는 가정하에 작성한 코드이다.
*/

// 조심할 점
/*
    문제를 풀다보면, 문제의 조건을 빠뜨리는 경우가 많다.
    빠뜨리는건 어쩔수 없다. 뭐 신경쓰자!! 이런 피드벡은 무의미하다.

    오히려 아래와 같이 규칙을 가지자

    오답이 나오면!! 

    - 내가 푼 코드가 틀린곳이 없는지 확인한다.
    - 코드가 틀린게 없다면, 조건을 다시 확인한다!
    - 함정 또는 미쳐 생각못한 조건을 발견하면, 바로 적용해본다!!
*/