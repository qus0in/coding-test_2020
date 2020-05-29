import java.util.*; // 필요한 API import

class Solution {
    public int[] solution(int[] heights) {
        // 스택 풀이
        int[] answer = new int[heights.length];
        // heights의 length 만큼의 answer 배열
        Deque<Integer> st = new ArrayDeque<>(); // 스택 생성
        Deque<Integer> qu = new ArrayDeque<>(); // 큐 생성 <- 굳이 큐가 아니라 ArrayList 등 반복 가능한 객체면 됨
        for (int e : heights) {
            st.push(e); // 스택에 데이터 추가
        }
        // System.out.println(st);
        int head; // 임시로 담아줄 변수
        int idx = heights.length - 1; // 탐색하는 인덱스는 이후에 스택 -> 큐로 뒤집어서 할 것이기 때문에 answer는 뒤집어서 넣어줄 것임
        // 스택에 원소가 남아 있다면 계속
        while (st.size() > 0) {
            head = st.pop(); // 스택의 맨 윗 값을 기준 점으로
            qu.clear(); // 큐는 초기화 
            for (int e : st) { // 스택에 남은 값들을 forEach
                qu.add(e); // 큐에 스택에 추가된 내용을 추가 해줌 (heights에 비해서 뒤집어진 형태)
            }
            // System.out.println(qu);
            for (int i = 0; i < st.size(); i++) { // qu의 사이즈는 이후에 poll로 변동이 있으므로 st의 사이즈를 통해서 안정적으로 순회
                // System.out.printf("탑 높이 비교 = %d (HEAD) vs %d\n", head, qu.peek());
                if (head < qu.poll()) { // 탐색하려는 값이 새로 뽑은 값보다 작다 (= 탑이 신호를 수신할 수 있다)
                    answer[idx] = qu.size() + 1;
                    // 답 배열에 현재 탐색 중인 위치를 넣어주어야 하는데
                    // 현재 탐색 중인 위치는 인덱스 개념으로는 qu.size()와 같음
                    // 하지만 이 문제에서 수신하는 탑의 위치는 1부터 시작하므로
                    // +1을 해줘야함
                    // System.out.printf("송신 탑 : %d, 수신 탑 : %d\n", idx + 1, qu.size() + 1);
                    break;
                }
            }
            // 배열 초기화하면서 0이 들어갔기 때문에 굳이 별도로 수신 되지 않은 탑을 위해 0을 넣어줄 필요 없음
            idx--; // 다음 송신 탑 조회
        }
        return answer; // 정답 리턴
    }
}