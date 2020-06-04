// https://programmers.co.kr/learn/courses/30/lessons/64061
import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        // 리스트를 해도 되지만 맵으로 해도 됩니다
        // 스택을 넣어준 맵 (인덱스와 moves 안에 담긴 값이 일치 하지 않아서...)
        Map<Integer, Deque<Integer>> stMap = new HashMap<>();
        /// board의 세로 줄
        for (int i = 0; i < board.length; i++) {
            // board의 가로 줄
            for (int j = 0; j < board[0].length; j++) {
                // 해당 좌표가 0이 아니면
                if (board[i][j] != 0) {
                    // 해당 맵에서 자료 받아서
                    Deque<Integer> st = stMap.getOrDefault(j+1, new ArrayDeque<>());
                    // 세로열을 의미하는 i가 0(아래쪽)부터 시작하기 때문에 add로 추가해줍니다 (먼저 오는 값이 head가 될 수 있게)
                    st.add(board[i][j]);
                    // 다시 집어넣어줌
                    stMap.put(j+1, st);
                }
            }
        }
        // System.out.println(stMap);
        // 담아주는 바구니 스택
        Deque<Integer> basket = new ArrayDeque<>();
        // 터진 인형 카운트해줄 함수
        int answer = 0;
        for (int m : moves) { // moves를 순회해서
            if (!stMap.get(m).isEmpty()) { // moves를 통해 호출하는 map 속의 스택이 비어있지 않는다면      
                int doll = stMap.get(m).pop(); // 맨 위를 pop 해줌
                // 바구니가 비어있지 않고, peek으로 조회한 head가 doll과 일치하면
                if(!basket.isEmpty() && basket.peek() == doll) {
                    basket.pop(); // 같은 인형이므로 터트려줍니다
                    answer += 2; // 2개 터지는 거니까 2 더 해줌
                } else {
                    basket.push(doll); // 아니면 해당 인형을 추가
                }
            }
            // System.out.println(basket);
        }
        return answer; // 터진 숫자 리턴
    }
}