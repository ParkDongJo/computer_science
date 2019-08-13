AVL 트리 
 =====
 #####[INTRO]
 ###왜? AVL트리인가?
  분할 정복법은
 1. step1 : Divide, 문제를 하나 또는 둘 이상의 인스턴스로 나눈다.
 2. step2 : Conquer, 나눠진 문제가 충분히 작고 해결가능 하다면 해결하고, 그렇지 않으면 다시 나눈다.
 3. step3 : Combine, 필요하다면, 나눠진 문제들을 다시 하나로 합친다.
 
  이진 검색은 분할정복의 대표적인 사례이다. 이진 검색은 검색을 두개로 분할해가며 검색하는 방식이다.
  이때, 이진 검색은 필요조건이 있다. __정렬__ 이 되어 있어야 한다. 근데, 정렬을 하게되면, N^2의 시간이 들어간다.
  BIG O = N^2가 된다.
  
  문제점1> 이진검색을 위해 정렬을 하다보니, N^2 시간이 걸린다.
  해결점1> 이진트리 자료구조를 활용하면, 삽입,삭제 시 정렬이 자동으로 된다.
  
  이진 트리 구조를 활용했을 때 삽입,삭제시 정렬에 대한 문제는 해결된다. 하지만 단순 이진 트리만을 이용했을 시는
  편향 현상이 일어난다. 그리고, 공간활용이 굉장이 비효율적이다.
  
  문제점2> 이진 트리 구조에서 편향 현상이 일어날 수 있다. 균형이 필요하다.
  해결점1> AVL 트리를 통해 데이터 삽입,삭제 시 트리의 구조를 잡아준다.
  
  
  ### AVL 트리의 특징
  모든 노드에 대해 왼쪽 서븥트리의 높이와 오른쪽 서브트리의 높이의 차이가 1보다 크지 않은 성질을 만족하는 트리.
  => 높이 균형 트리
  
        balance factor(균형인수) = height of left subtree - height of right subtree
        rotation(회전) -> balance factor > 1
        
  
  ####Rotation(회전)
  - LL(left of left)
    : 불균형으로 판명된 노드의 좌측자식의 좌측 서브트리에 삽입
  - RR(right of right)
    : 불균형으로 판명된 노드의 우측자식의 우측 서브트리에 삽입
  - LR(left of right)
    : 불균형으로 판명된 노드의 좌측자식의 우측 서브트리에 삽입
  - RL(right of left)
    : 불균형으로 판명된 노드의 우측자식의 좌측 서브트리에 삽입
    
   
   [참고링크](http://m.blog.daum.net/kimjaehun12/172)
   [참고링크](http://egloos.zum.com/printf/v/913998)
  
  
  
  ####인터페이스
  insert()
  delete()
  search()
  rebalance()
  rotateLeft()
  rotateRight()
  rotateLeftTheRight()
  rotateRightThenLeft()
  height()
  print()