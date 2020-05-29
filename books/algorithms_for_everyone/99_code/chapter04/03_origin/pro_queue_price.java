import java.util.*; // 사용할 API들 미리 import

public class Solution {
	public static int[] solution(int[] prices) {
        // [설계]
        // 0. prices와 사이즈가 같은 빈 배열 answer에 생성
        // 1. prices 배열을 queue (qu)에 넣음
        // 2. prices의 length 만큼 for문을 돌림 (i)
        //  - poll로 맨 앞 값을 추출해준 다음 queue 안에 있는 값들과 forEach
        //  2.0. 주식 가격이 유지된 초를 받아줄 변수 sec 초기화 (= 0)
        //  2.1. 주식 가격이 유지되었다면 sec++
        //  2.2. 주식 가격이 유지되지 않았다면 sec을 answer[i]에 넣어주고 break
        // 3. 다 돌면 answer를 리턴
        // [코드]
        // p와 같은 크기의 배열 선언 및 초기화 
        int[] answer = new int[prices.length];
        Deque<Integer> qu = new ArrayDeque<>(); // 순서대로 값을 처리해줄 queue 생성 (qu)
        for (int e : prices) {
            qu.add(e); // prices의 요소들을 qu에 추가
        }
        // System.out.println(qu); // [1, 2, 3, 2, 3]
        int head; // 비교를 위한 임시 변수
        int sec; // 유지된 초를 세기 위한 변수
        for (int i = 0; i < prices.length; i++) {
            sec = 0; // 0으로 fo문이 돌 때마다 초기화
            head = qu.poll(); // qu의 맨 앞 값 추출 (FIFO)
            // System.out.println(qu); // 추출된 이후 qu
            for (int e : qu) { // qu의 남은 값들과 forEach
                // System.out.printf("head : %d, now : %d\n", head, e); // head와 현재 값 비교
                sec++; // 1초가 지남
                if (head > e) { // 가격이 하락 했다면
                    break; // 순회 종료
                }
            }
            answer[i] = sec; // answer의 i번째에 sec(유지된 초)를 넣어줌
            // System.out.printf("유지된 초 : %d\n", sec); // 유지된 초
        }
		return answer; // answer 배열을 리턴
	}
}