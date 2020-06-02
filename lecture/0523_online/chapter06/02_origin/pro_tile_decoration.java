import java.util.*;

class Solution {
    public long solution(int N) {
        // N이 1일 때는 공식이 안 통하므로 4로 바로 값을 리턴해준다
        if (N == 1) {
            return 4;
        }
        // 동적계획법으로 메모이제이션해줄 리스트 만들기
        List<Long> dp = new ArrayList<>();
        // Long 자료형을 쓰므로 Long.valueOf 메소드를 통해 1번째, 2번째 피보나치 수를 넣어줌
        dp.add(Long.valueOf(1));
        dp.add(Long.valueOf(1));
        // 동적계획법으로 피보나치 구하기
        for (int i = 1; i < N - 1; i++) {
            long v1 = dp.get(i - 1); // i-1번째
            long v2 = dp.get(i); // i번째 수를 불러내서
            dp.add(v1 + v2); // 둘을 합쳐 i+1번째 수를 만들어줌 (이를 위해 1, 2번째를 미리 넣어줌)
        }
        // System.out.println(dp);
        // 둘레의 공식은 N >= 2일 경우, 가장 긴 길이 * 4 + 다음으로 긴 길이 * 2
        return dp.get(dp.size() - 1) * 4 + dp.get(dp.size() - 2) * 2;
    }
}