# 링크드 리스트 정리
1. d9.MyIntLinkedList : 싱글 링크드 리스트, int
2. d10.MyStringLikedList : 싱글 링크드 리스트, string
3. d10.MyLinkedList : 싱글 링크드 리스트, T (size 추가된 거 말고 변화 x)
4. d10.MyDoubleLinkedList : 더블 링크드 리스트.
   1. add 에서 addLast() 를 내부적으로 사용하도록 (뭐 쓰든 상관 x)
   2. remove() 에서 null 일 때 고려한 걸 전날 추가함 (라스트, 퍼스트 둘 다)
5. d11.MLNew : 최종 싱글 리스트
   1. add 간략화
   2. size(index) 추가

### 11주차 공지 참고, 링크드 리스트

* 링크드리스트 마무리
* 중간고사에서처럼, 링크드리스트 안에 링크드리스트, 어레이든 뭐든 넣어서 복잡한 자료구조를 활용
   * 예를 들어, 10주차 MyScheduler 같은 거 : linked< linked> 또는 linked< Array> ?
   * 이런 복잡한 자료구조를 잘 다뤘으면 좋겠음
   * 기말에 낼 거임
* 사이즈를 리커전으로 만들어라 ->  MLNew.size(Node p)
   * 기말은 이런 식으로, 우리가 했던 메서드 중 리커전으로 바꿔봐라 할 거임
      * 파라미터 추가 -> base condition -> 리커전
   * 단, MLNew.size(Node p) 실제 이렇게 하진 않음. 다만 리커전 연습하려고.

---

# 트리
1. d11.SimpleTree : 링크드 리스크 관련해서 트리
    ![Screenshot 2025-06-12 at 11.32.44 PM.png](..%2F..%2F..%2F..%2F..%2F..%2F..%2Fvar%2Ffolders%2F_r%2F_k5_0g9969vc5ws69yv8cjzc0000gn%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_XssxTG%2FScreenshot%202025-06-12%20at%2011.32.44%E2%80%AFPM.png)
    ![Screenshot 2025-06-12 at 11.31.53 PM.png](..%2F..%2F..%2F..%2F..%2F..%2F..%2Fvar%2Ffolders%2F_r%2F_k5_0g9969vc5ws69yv8cjzc0000gn%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_AmilRk%2FScreenshot%202025-06-12%20at%2011.31.53%E2%80%AFPM.png)
2. d12.BST : 이진탐색트리
    
    1. 인서트를 리커전으로 하는 거 이해
   
    2. __이진 탐색 트리(Binary Search Tree)__ 는 모든 노드에 대해 왼쪽 서브트리는 현재 노드보다 작고, 오른쪽 서브트리는 크다는 속성을 가진 이진 트리입니다.
   ![Screenshot 2025-06-12 at 11.35.44 PM.png](..%2F..%2F..%2F..%2F..%2F..%2F..%2Fvar%2Ffolders%2F_r%2F_k5_0g9969vc5ws69yv8cjzc0000gn%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_k3bVN8%2FScreenshot%202025-06-12%20at%2011.35.44%E2%80%AFPM.png)![Screenshot 2025-06-12 at 11.36.27 PM.png](..%2F..%2F..%2F..%2F..%2F..%2F..%2Fvar%2Ffolders%2F_r%2F_k5_0g9969vc5ws69yv8cjzc0000gn%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_0mdU8b%2FScreenshot%202025-06-12%20at%2011.36.27%E2%80%AFPM.png)

3. d13.BSTBalanceTree : 트리의 균형을 맞추는 이진탐색트리
<details>
<summary>트리 균형 이해</summary>
<div markdown="1">
   
`d13.BSTBalanceTree`는 `d12.BST`보다 **한 단계 발전된 이진 탐색 트리 (BST)**이며,  
핵심은 바로 **“트리의 균형(balance)”을 맞추는 것**입니다.

---

## 🔍 먼저 정리: `d13.BSTBalanceTree`는 어떤 클래스인가?

| 항목 | 내용 |
|------|------|
| 목적 | BST의 불균형 문제를 해결하기 위한 회전(Rotate) 기법 실습 |
| 기반 구조 | 이진 탐색 트리 (`d12.BST`)와 동일한 삽입/탐색 로직 |
| 추가 개념 | **좌회전(rotateLeft)** / 우회전(rotateRight)과 트리의 균형 조정 |
| 활용 기술 | 부모 포인터를 유지하여 회전 후 관계를 재설정 |
| 특징 | 완전한 AVL 트리는 아님 (자동 균형은 없음), 회전 원리 이해용 수업 예제 |

---

## ✅ d12.BST 와 d13.BSTBalanceTree의 차이점

| 항목 | `d12.BST` | `d13.BSTBalanceTree` |
|------|------------|-------------------------|
| 트리 구조 | 이진 탐색 트리 (BST) | BST + 회전 메서드 포함 |
| 삽입 | 값 기준으로 재귀 삽입 | 동일 |
| 삭제 | `deleteANode()`, `deleteANodeSuccessor()` | 없음 (중점 아님) |
| 부모 노드 | 구현 X | `parent` 필드 명시적으로 사용 |
| 회전(Rotate) | 없음 | `rotateLeft(Node pp)`, `rotateRight(Node pp)` 구현 |
| 균형 유지 | X (왼쪽/오른쪽 치우침 가능) | 수동으로 회전하여 균형 맞춤 가능 |

---
    
    ## 🌀 회전(Rotation)의 핵심 개념
    
이진 탐색 트리는 **삽입 순서**에 따라 트리의 **높이 차이가 커질 수 있고**,  
이로 인해 **탐색 속도는 O(log N) → O(N)**으로 퇴화할 수 있습니다.

이를 방지하기 위해 **회전(rotate)**을 통해 트리의 균형을 맞추는 것이 핵심입니다.

### ▶ 좌회전(rotateLeft)

- **상황**: 한 노드의 오른쪽 자식이 더 많을 때
- **결과**: 오른쪽 자식이 부모가 되고, 기존 부모는 왼쪽 자식이 됨

```plaintext
Before:
      x
       \
        y
After rotateLeft(x):
        y
       /
      x
```

### ▶ 우회전(rotateRight) - 구현은 생략됐지만 연습해볼만한 과제
- **상황**: 한 노드의 왼쪽 자식이 더 많을 때
- **결과**: 왼쪽 자식이 부모가 되고, 기존 부모는 오른쪽 자식이 됨

---

## 📌 d13.BSTBalanceTree의 핵심 기능 분석

### 1. `Node` 클래스
- `parent` 포인터가 있음 → 회전 후 관계 재구성에 필요

### 2. `rotateLeft(Node pp)`
```java
if (pp == root) {
    root = pp.right;
    pp.right.parent = null;
    pp.right.left = pp;
    pp.parent = pp.right;
    pp.right = null;
}
```
- **루트일 경우 별도 처리**, 그렇지 않으면 `pp.parent.left` 또는 `pp.parent.right`로 링크 변경

### 3. `showLevel()`
- BFS 방식으로 트리의 각 레벨 출력 (Level-order traversal)
- `level()` 메서드로 노드의 깊이를 계산

---

## 💡 핵심 요약

| 포인트 | 설명 |
|--------|------|
| 왜 필요한가? | 트리의 균형이 깨지면 탐색 성능이 급격히 저하됨 |
| 무엇을 배웠는가? | BST 구조와 함께, **회전 기법을 통해 트리의 모양을 바꾸는 법** |
| 수업 목표는? | 자동 균형을 잡는 AVL/Red-Black Tree까지 가기 전, **회전 원리 이해** |
| 시험 출제 가능성 | 회전 후 트리 구조를 그리기, 회전 메서드 직접 작성하기 등 |

---

## 🧪 예시 입력과 회전 전후 비교

```java
int[] keys = {4, 7, 5, 1, 0, 3, 9, 2, 6, 8};
```

- 불균형 상태의 트리 구성됨 → `rotateLeft()` 연속 호출로 점차 균형 맞춤
- `showLevel()`에서 레벨 구조 변화를 확인할 수 있음

---

## ✅ 결론

- `d13.BSTBalanceTree`는 단순 BST인 `d12.BST`에 비해 **균형 조정 기능을 갖춘 확장형 트리 구조**
- 하지만 **자동 회전(Auto-rebalancing)은 없으며**, **수동으로 회전을 호출하는 방식**임
- **수업 목적**은 AVL/Red-Black 같은 고급 트리 이해를 위한 **회전 원리의 직관적 습득**

필요하다면 `rotateRight()` 구현도 같이 제공드릴 수 있습니다.
    </div>
    </details>

4. d13.MinHeap : 항상 루트 노드가 최소값이 되도록하는 이진탐색트리
    1. MaxHeap : finalExamStudy.MaxHeap 
   2. List Heap : d13_class.HeapInList
   3. 