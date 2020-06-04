import java.util.*;

class Solution {
    public long solution(int N) {
        // 입력 : 피보나치 수열로 한 변의 길이가 늘어나는 타일의 갯수 (N) int
        // 출력 : N개로 구성된 직사각형의 둘레 길이 long
        // 문제 : 둘레를 구하라.
        // 둘레의 합
        // = An * 3 + An-1 * 2 + An-2 * 2 + An-3 *1
        // = An * 4 + An-1 * 2
        if (N == 1) {
            return 4;
        }
        List<Long> dp = new ArrayList<>(); // n번째의 값들을 기록해줄 메모이제이션을 위한 리스트
        // A1, A2는 추가 해주고 시작해야 됨
        dp.add(Long.valueOf(1)); // int -> long
        dp.add(Long.valueOf(1)); // A1, A2
        // System.out.println(dp); // [1, 1]
        for (int i = 1; i < N - 1; i++) {
            // i가 1부터 시작해야하는 이유?
            dp.add(dp.get(i - 1) + dp.get(i)); // A0 + A1 ... An-1 + An-2 => An
            // System.out.println(dp);
        }
        return dp.get(dp.size() - 1) * 4 + dp.get(dp.size() - 2) * 2; // An * 4 + An-1 * 2 
    }
}