// https://programmers.co.kr/learn/courses/30/lessons/42895
import java.util.*;

class Solution {
    public int solution(int N, int number) {
        // 재귀 호출이 전체 해를 쪼개서 부분해를 연속적으로 호출해서 구하는 방식이라면,
        // 동적계획법은 부분해를 map이나 list 등에 저장해놓고 빼서 쓰는 방식
        // N을 i개 조합해서 만들 수 있는 모든 수를 dp에 넣고 진행 (중복 막기 위해 set)
        if (N == number) {
            return 1; // 같은 값이면 바로 리턴해준다
        }
        // 동적계획법으로 기록해줄 리스트 (원소는 정수 set으로 된)
        List<Set<Integer>> dp = new ArrayList<>();
        // dp의 각 인덱스에 N번만큼 반복된 값을 미리 저장)
        for (int i = 0; i < 8; i++) {
            dp.add(new HashSet<>( // dp에 HashSet을 add 해줄 건데
                Arrays.asList( // Arrays.asList로 값을 넣어줄 거임
                    Integer.parseInt(Integer.toString(N).repeat(i + 1)) // 그건 N을 i + 1 번 반복한 값
            )));
        }
        // System.out.println(dp);
        for (int i = 1; i < 8; i++) { // 인덱스상 1번째~7번째 (2~8개의 N을 쓴 수)를 구하기 위해
            for (int j = 0; j <= (i / 2); j++) { // 두 쌍을 구해서 사칙연산을 해줌
                for (int a : dp.get(i - j - 1)) { // i - j - 1 번째 => a
                    for (int b : dp.get(j)) { // j 번째 => b (둘은 0에서 j 안의 범위에서 서로 사칙연산 해줌) => 결과적으로 보면 i가 1일 때 (0, 0), i가 2일 때 (1,0), (0,1) 이런 식으로 짝을 찾아줌. 중복 일어나는 점에서 착안해서 j가 들어간 for문에서 j의 범위를 절반만 주는 것
                        dp.get(i).add(a + b);
                        dp.get(i).add(a - b);
                        dp.get(i).add(a * b);
                        if (b != 0 ) { // 0으로 나누면 안되니까
                            dp.get(i).add(a / b);                         
                        }
                    }
                    if(dp.get(i).contains(number)) {
                        // System.out.println(dp.get(i));
                        return i + 1; // 만약에 쌍으로 구해준 것 중에 답이 있으면 현재 사용한 N의 갯수 (i+1)를 리턴
                    }
                }
            }
        }
        return -1; // 끝까지 찾아도 없으면 -1 리턴
    }
}