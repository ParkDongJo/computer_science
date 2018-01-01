# 컴공 원론 정리
###### 해당 repository는 **컴퓨터공학**에 관한 이론과 개념을 스스로 학습하고 정리하기 위한 공간입니다. 
 
-----

자료구조

	1) 자료구조란
	2) 정렬
	3) 스텍
	4) 큐
	5) 트리
	6) 힙
	7) 그래프
	8) 다익스트라.크루스칼,프라임
	9) 해쉬
	
자료구조란
=====
Data Structure = Data + Interface

자료(Data)의 집합의 의미하며, 
각 원소들이 논리적으로 정의된 규칙에 의해 나열되며 자료에 대한 처리를 효율적으로 수행할 수 있도록 자료를 구분하여 표현

 - 추상적 자료형 ex> Stack,Queue,Tree,List,Heap,Set,Bag,Graph ...

 - 구현체 ex> Array, Linked-list
    
    
    1) Array       [ A, B, C]
       -장점 : 메모리에 보다 많은 데이터가 적재되기 때문에, 데이터 읽기에 유리하다 
       -단점 : 데이터 추가,삭제 시 비용이 든다. 데이터 구조 내의 데이터 공간 관리가 필요하기 때문
    
    2) Linked list  A->B->C
       -장점 : 데이터 추가,삭제가 편리하고 쉽다.
       -단점 : 데이터가 주소로 연결되어 있기 때문에, 메모리에 적재 시 한꺼번에 로드 시킬 수 없어 읽기 속도가
              저하 될 수도 있다.
 
 
#### ADT(Abstract Data Type)
##### 추상적 자료형

- SET, BAG
- LIST
- STACK
- QUEUE => 우선순위 큐, 원형 큐
- TREE  => 이진트리,이진 탐색 트리,자가 균형 이진트리, AVL트리, 레드블랙 트리,B 트리
- GRAPH => Kruskal, Prim, Dijsktra
- HEAP
- HASH




알고리즘

    1. Devide & conquer
        - binary search
        - merge sort
        - Quick sort
        - Strassen's Matrix Multiplication
    2.Dyramic programming
        - Binomial coefficient
        - Floydis algorithm
        - Optimization problem
        - TSP
    3.The Greedy Approach
        - MST
        - Dijkstra's
        - Scheduling
        - Huffmun Code
        - Knapsack problem
    4.Back Tracking
        - n-Queen Problem
        - Monte Carlo
        - Cdoriny numitonian ciruit


알고리즘이란
=====
Algorithm = The step-by-step procedure for solving problem

어떠한 문제를 해결하기 위한 여러 동작들의 모임이다. 유한성을 가지며, 언젠가는 끝나야 하는 속성을 가지고 있다.
알고리즘은 다음의 조건을 만족해야 한다.

    입력 : 외부에서 제공되는 자료가 0개 이상 존재해야한다.
    출력 : 적어도 1개 이상의 서로 다른 결과를 내어야 한다.(즉 모든 입력에 하나의 출력이 나오면 안됨)
    명확성 : 수행 과정은 명확하고 모호하지 않은 명령어로 구성되어야 한다.
    유한성(종결성) : 알고리즘의 명령어들은 끝이 있는 계산을 수행한 후에 종료해야 한다.(출처-동아출판 중학교 정보책 날짜-2017-7-11)
    효율성 : 모든 과정은 명백하게 실행 가능(검증 가능)한 것이어야 한다.