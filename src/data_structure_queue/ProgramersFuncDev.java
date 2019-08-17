package data_structure_queue;

import java.util.*;

public class ProgramersFuncDev {

    /**
     [문제 설명]
     프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.

     또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고,
     이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.

     먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의
     개발 속도가 적힌 정수 배열 speeds가 주어질 때 각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.

     제한 사항
     작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다.
     작업 진도는 100 미만의 자연수입니다.
     작업 속도는 100 이하의 자연수입니다.
     배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다.
     예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.
     입출력 예
     progresses	speeds	return
     [93,30,55]	[1,30,5]	[2,1]
     입출력 예 설명
     첫 번째 기능은 93% 완료되어 있고 하루에 1%씩 작업이 가능하므로 7일간 작업 후 배포가 가능합니다.
     두 번째 기능은 30%가 완료되어 있고 하루에 30%씩 작업이 가능하므로 3일간 작업 후 배포가 가능합니다.
     하지만 이전 첫 번째 기능이 아직 완성된 상태가 아니기 때문에 첫 번째 기능이 배포되는 7일째 배포됩니다.
     세 번째 기능은 55%가 완료되어 있고 하루에 5%씩 작업이 가능하므로 9일간 작업 후 배포가 가능합니다.

     따라서 7일째에 2개의 기능, 9일째에 1개의 기능이 배포됩니다.

     */

    /*
        [ 알아두면 좋을 것들 ]
        - Array를 바로 출력하기
        배열에 대한 결과값을 바로 확인하고 싶을 때가 있다.
        그때 for문을 통해서 코드를 짜기 보다는, util에서 제공되는 Arrays 객체의 도움을 받는 것이 좋다

        System.out.println(Arrays.toString(array));

        - ArrayList -> Array
        배열이 아닌 링크드 리스트의 특징을 이용하고 싶을 때가 있다.
        직접 링크드 리스트를 구현하는 것보다는 java에서 제공해주는 util ArrayList를 이용하는 것이 좋다
        ArrayList는 나중에 Array 타입으로 변형하기에 좋다. 아래와 같이 변형하면 된다.
        ArrayList<Integer> list = new ArrayList<>();
        int[] array = list.stream().mapToInt(i->i).toArray();

        - java에서 Queue 사용하기
        Queue를 사용하고자 할 때, 직접 구현해서 쓰기 보다는 자바에서 제공해주는 util을 써서
        구현하는 것이 좋다. 기본적으로 java에서는 LinkedList를 통해 Queue 인터페이스를 구현해준다.

        Queue<Integer> queue = new LinkedList<>();

     */

    /*
        [ 문제 해설 ]
        자료구조를 이용하는 문제는 두 가지 프로세스로 문제를 접근하면 될것 같다.(느낌상..)

        첫번째는 어떤 의미의 값을 자료구조(큐,스텍 등등)에 넣을까를 고민하는 것이다.
        두번째는 자료구조에 들어가 있는 값을 어떻게 가공할 것인가를 고민하는 것이다.

        요약 정리하면,

        1. 무엇을 어떻게 넣을까
        2. 뽑아내서 어떻게 가공할까


        이번 문제는 기준 데이터가 추가 작업시간이다.
        그와 동시에 처음 데이터 순서대로 결과값을 가공해야하기 때문에, 큐 자료구조를 이용하는 것이 좋고
        큐 자료구조에 기준 데이터(추가 작업시간)을 저장해 둔다.

        그리고 차례대로 기준 데이터를 뽑아내서,
        결과값과 같은 형태를 만들어 내면 된다.
        끝!!!
     */

    public static void main(String[] args) {
        int[] progresses = { 93,30,55 };
        int[] speeds = { 1,30,5 };

        System.out.println(Arrays.toString(solution(progresses, speeds)));

    }

    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        int current;
        int days;

        for (int i=0; i<progresses.length; i++) {
            current = progresses[i];
            days = 0;

            while (current < 100) {
                current += speeds[i];
                days++;
            }
            queue.add(days);
        }

        int cursor;
        int pre = queue.poll();
        int count = 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            cursor = queue.poll();

            if (pre >= cursor) {
                count++;
            } else {
                list.add(count);
                count = 1;
                pre = cursor;
            }
        }
        list.add(count);

        return list.stream().mapToInt(i->i).toArray();
    }

    /*
        코드가 훨씬 간결하다.
        java 8 이상부터 가능한 접근인 듯 한데, java8 이상의 변화내용을 한번 볼 필요는 있는것 같다.

        어째든 대부분의 큐,스텍 문제는 꼭 자료구조를 이용하지 않더라도 풀이가 가능하다.

        다만 아래의 코드는 코드상으로는 매우 간결하지만,
        사실 성능상으로는 비효율적인 면이 없지 않아 있다.
        특히, 어떠한 input 값이 들어와도 최소 100번의 반복문의 타야한다는 점이다.
        마지막에 dayOfend[] 배열을 어떠한 경우이든 모두 돌게하는 코드가 그러하다.
     */
    public static int[] bestSolution(int[] progresses, int[] speeds) {
        int[] dayOfend = new int[100];
        int day = -1;
        for(int i=0; i<progresses.length; i++) {
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
    }
}


