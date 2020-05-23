package question;

public class Question01 {
  public static void input(int[] caseArray, int[] answerArray) {
    System.out.println("1부터 n까지의 합을 구하는 알고리즘");
    System.out.println("for문으로 직접 더하기");
    for (int i = 0; i < caseArray.length; i++) {
      System.out.printf("입력 : %d\n출력(예상) : %d\n출력(실제) : %d\n", caseArray[i], answerArray[i], solution(caseArray[i]));
    }
    System.out.println("가우스의 합 공식 사용");
    for (int i = 0; i < caseArray.length; i++) {
      System.out.printf("입력 : %d\n출력(예상) : %d\n출력(실제) : %d\n", caseArray[i], answerArray[i], solution2(caseArray[i]));
    }
  }

  // 문제 : 1부터 n까지 연속한 숫자의 합 구하기
  // 입력 : (타입) 정수, n
  // 출력 : (타입) 정수, 1부터 n까지의 합
  // 복잡도 : O(n)
  public static int solution(int n) {
    // 합을 기록할 정수 타입의 변수를 선언 및 초기화
    int sum = 0;
    // for문으로 정수 i에 1부터 n까지의 숫자를 1씩 증가시키면서 반복
    for (int i = 1; i <= n; i++) {
      // 기존의 sum에다가 i를 더하고, 그 값을 sum에 다시 대입
      // sum = sum + i;
      sum += i;
    }
    // for문이 끝났을 때 sum(합을 기록한 변수)을 결과값으로 출력
    return sum;
  }
  // 가우스의 합 공식을 통한 풀이
  // 복잡도 : O(1)
  public static int solution2(int n) {
    // // 합을 기록할 정수 타입의 변수를 선언 및 초기화
    // int sum = 0;
    // // 가우스의 합 공식 : n ( n + 1 ) / 2
    // sum = n * (n + 1) / 2;
    // return sum;
    return n * (n + 1) / 2;
  }
}
// 추가 문제 : 1부터 n까지 연속한 제곱의 합을 구하는 알고리즘 - for문으로 구해보기 or 공식 사용하기