import java.util.*;

class Main {
  public static void main(String[] args) {
    System.out.println(fact(5));
    System.out.println(factDP(5));
  }
  // 재귀 호출의 경우
  public static int fact(int n) {
    // 종료 조건
    if (n == 1) {
      return 1;
    }
    // 큰 문제를 작은 문제로 => 점화식
    return n * fact(n-1);
  }
  // 동적계획법의 경우
  public static int factDP(int n) {
    // 메모이제이션 해줄 자료 구조
    int[] dp = new int[n];
    dp[0] = 1;
    for (int i = 1; i < n; i++ ) {
      // 큰 문제를 작은 문제로 => 점화식
      dp[i] = dp[i-1] * (i + 1);
    }
    return dp[n-1];
  }
}