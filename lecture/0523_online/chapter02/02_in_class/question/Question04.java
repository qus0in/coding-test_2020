package question;

public class Question04 {
  public static void input(int[] caseArray, int[] answerArray) {
    System.out.println("1부터 n까지 연속한 정수의 곱을 구하는 알고리즘 (팩토리얼)");
    System.out.println("솔루션 1 : for문으로 순서대로 곱하기");
    for (int i = 0; i < caseArray.length; i++) {
      System.out.printf("입력 : %d\n출력(예상) : %d\n출력(실제) : %d\n", caseArray[i], answerArray[i], solution(caseArray[i]));
    }
    System.out.println("솔루션 2 : 재귀호출로 구하기");
    for (int i = 0; i < caseArray.length; i++) {
      System.out.printf("입력 : %d\n출력(예상) : %d\n출력(실제) : %d\n", caseArray[i], answerArray[i], solution2(caseArray[i]));
    }
  }
  // 문제 : 1부터 n까지 연속한 숫자의 곱 구하기
  // 입력 : (타입) 정수, n
  // 출력 : (타입) 정수, 1부터 n까지 연속한 숫자의 곱

  // 솔루션 1 : for문으로 순서대로 곱하기
  public static int solution(int n) {
    // 곱을 기록할 정수 타입의 m 변수 선언 & 초기화
    int m = 1; // 0이면 답이 무조건 0이 나옴(곱하기)
    // for문으로 정수 i에 1부터 n까지의 숫자를 1씩 증가시키면서 반복
    for (int i = 1; i <= n; i++) {
      // [for문 내부]
      // m에다가 i를 곱한다음 다시 대입 
      m *= i; // 대입연산자
    }
    return m;
  }

  // 솔루션 2 : 재귀 호출로 구하기
  public static int solution2(int n) {
    // 종료 조건 : n == 1
    if (n == 1) {
      return 1;
    }
    // 1부터 n까지의 합
    // => 1부터 n-1까지의 합 + n
    return n * solution2(n - 1);
    // n * n - 1 * solution2(n - 2)
    // n * n - 1 * n - 2 + solution2(n - 3)
    // n * ... * 1 * 0 ???? => 0??
    // 삼항 조건 연산자로 리팩토링한 코드
    // return n == 1 ? 1 : n * solution2(n -1);
  }
}