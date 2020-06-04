import java.util.*;

class Main {
  public static void main(String[] args) {
    System.out.println(fact(5));
    System.out.println(factDP(5));
  }
  // 재귀 호출의 경우
  public static int fact(int n) {
    // 종료 조건
    // 팩토리얼은 1부터 n까지의 곱
    // n이 1보다 작아지면 의미가 없어요
    // 0! = 1 <= 0! = 1 
    // n * fact(n - 1) = n * (n-1) * fact(n - 2) ...
    if (n == 1) {
      return 1; // 종료 조건
    }
    // 큰 문제를 작은 문제로 => 점화식
    // 팩토리얼의 정의는 1부터 n까지의 곱을 모두 곱해놓은 값
    // n! = n * (n - 1)!
    // fact(n) = n * fact(n- 1)
    return n * fact(n - 1);
  }
  // 동적계획법의 경우
  public static int factDP(int n) {
    // 메모이제이션 해줄 자료 구조
    // int[] dp = new int[n];
    List<Integer> dp = new ArrayList<>();
    // dp = dynamic programming
    // dpList, dpArr, dpMap ... dp 굳이 한개일 필요 없음. 본인 생각하기에 dp 3개가 필요하다?? 그러면은 3개 만들면 됨 
    dp.add(1);
    // dp[0] = 1; // 0번째, 즉 첫번째 값은 넣어줘야 되는 경우가 많음 == 종료조건
    // 재귀호출 => 큰 문제를 먼저 호출하고, 그 안에서 작은 문제를 해결하는 함수를 계속적으로 호출하는 과정
    // 동적계획법 => 작은 문제를 해결한 뒤 그 값을 저장하고, 다음 작은 문제를 해결할 때 그 값을 불러서 사용
    // 큰 문제를 작은 문제로 => 점화식
    for (int i = 1; i < n; i++) {
      dp.add(dp.get(i-1) * (i + 1));
      // dp[i] = dp[i-1] * (i + 1);
      // i가 1일 때면, 2!을 의미
      // 2! = 1! * 2 / dp[1] = dp[0] * 2
      // i가 2일 때면, 3!을 의미
      // 3! = 2! * 3 / dp[2] = dp[1] * 3
      System.out.println(dp);
    }
    return dp.get(dp.size() - 1);
    // return dp[n - 1];
  }
}