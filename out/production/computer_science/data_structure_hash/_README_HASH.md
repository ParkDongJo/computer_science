 HASH 
 =====
 #####[INTRO]
 해쉬(Hash)는 배열(Array)가 검색(Search)에 유리하다는 장점과 연결리스트(Linked list)가
 입력(insert)과 삭제(delete)에 유리하다는 장점을 서로 합쳐서 만든 자료구조이다.
 
 두 장점을 취하였기 때문에, 검색속도를 보장하면서도 데이터 입력,삭제가 용이하다.
 아이디어는 매우 비효율 적인 배열(Array)라고 보면된다.
 
 예를 들어,
 
    [1,null,null,null,null,2,null,null,null,null,null,3,,null,null,null,null]
    
 
 위와같이 비효율적으로 빈공간을 두고 언제든 들어올 데이터에 대해 대비한다. 이는 하드웨어의 성능이 받쳐주기 때문에
 공간에 대한 제약이 많이 사라졌기 때문이다.
 
 #####[문제점]
 1. 데이터가 쌓이면 쌓일 수록 배열(Array)과 다를 바 없다.<br>
 2. 효율적인 데이터 배치가 필요하다.
 
 
 #####[해결]
 1. 해쉬 함수(Hash function)를 통해 해쉬 테이블(Hash Table)의 적절한 위치에 위치시킨 후 해쉬코드(Hash code)를
 반환한다. 데이터가 최대한 몰리지 않고 서로간 간격을 확보 할 수 있도록 한다.
 2. 적절한 배치를 한다고 해도 충돌(collision)이 날 수 밖에 없다. 그럴때 마다 충돌을 피하는 방법이 있는데
  크게
  
  - Chaining
  
 
    Chaining은 충돌이 나는 지점에 연결리스트(Linked List)를 만들어 낸다. 하지만 성능을 위해
    연결 리스트(Linked List)는 적절 수를 넘어가지 않도록 제어를 해야한다.
    
  - Probing
   > Linear probing<br>
   > Quad Probing<br>
   > Double Hashing<br>
   > Re hashing
   
    Linear Probiding은 충돌이 난 지점에서 하나씩 이동하며 빈 공간을 찾는 프로세스다.
    Quad Probing은 2배씩 뛰어넘어 가며 빈 공간을 찾는 방법이다
    Double Hashing은 해쉬테이블(Hash table)을 두개씩 운영하는 방법이다.
    Re hashing은 아예 해쉬테이블(Hash table)을 리셋하여 새롭게 셋팅 하는 방법이다.
    
    이 네가지 방법 중 한가지를 채택하거나 모두를 단계별로 적용할 수 있다.