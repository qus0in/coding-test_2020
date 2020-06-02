import java.util.*;

class Main {
  public static void main(String[] args) {
    // [큐(Queue)]
    // LinkedList<String> qu = new LinkedList<String>(); // 큐의 생성
    Deque<String> qu = new ArrayDeque<>();

    // add() 메소드를 이용한 요소의 저장
    qu.add("넷");
    qu.add("둘");
    qu.add("셋");
    qu.add("하나");

    // peek() 메소드를 이용한 요소의 반환
    System.out.println(qu.peek()); // "넷"
    System.out.println(qu); // [넷 둘 셋 하나]
    
    // poll() 메소드를 이용한 요소의 반환 및 제거
    System.out.println(qu.poll()); // "넷"
    System.out.println(qu); // [둘 셋 하나]

    // remove() 메소드를 이용한 요소의 제거
    qu.remove("하나");
    System.out.println(qu); // [둘 셋]

    // [스택(Stack)]
    // Stack<Integer> st = new Stack<Integer>(); // 스택의 생성
    Deque<Integer> st = new ArrayDeque<>();

    // push() 메소드를 이용한 요소의 저장
    st.push(4);
    st.push(2);
    st.push(3);
    st.push(1);

    // peek() 메소드를 이용한 요소의 반환
    System.out.println(st.peek()); // 1
    System.out.println(st); // [4, 2, 3, 1]

    // pop() 메소드를 이용한 요소의 반환 및 제거
    System.out.println(st.pop()); // 1
    System.out.println(st); // [4, 2, 3]
  }
}