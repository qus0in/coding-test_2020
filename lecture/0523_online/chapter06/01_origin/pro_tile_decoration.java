import java.util.*;

class Solution {
    public long solution(int N) {
        if (N == 1) {
            return 4;
        }
        List<Long> dp = new ArrayList<>();
        dp.add(Long.valueOf(1));
        dp.add(Long.valueOf(1));
        for (int i = 1; i < N - 1; i++) {
            long v1 = dp.get(i - 1);
            long v2 = dp.get(i);
            dp.add(v1 + v2);
        }
        // System.out.println(dp);
        return dp.get(dp.size() - 1) * 4 + dp.get(dp.size() - 2) * 2;
    }
}