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
  // 출력 : 1부터 n까지 연속한 숫자의 곱
  // 솔루션 1 : for문으로 순서대로 곱하기
  // 복잡도 : O(n)
  public static int solution(int n) {
    // 곱을 기록할 정수 타입의 f 선언 및 1로 초기화
    int f = 1;
    // for문으로 정수 i에 1부터 n까지의 숫자를 1씩 증가시키며 반복
    for (int i = 1; i <= n; i++) {
      // [for문 내부] 기존의 f에 i를 곱하여 얻은 값을 다시 f에 대입
      f *= i;
    }
    // for문이 끝났을 때 f 값이 결과 값 (출력)
    return f;
  }
  // 솔루션 2 : 재귀 호출로 구하기
  // 복잡도 : O(n)
  public static int solution2(int n) {
    // 종료 조건 : n이 1보다 같거나 작을 때
    if (n <= 1) {
      return 1; // 더 이상 호출하지 않음
    }
    // n 값을 넣은 다음, n - 1 을 넣어서 다시금 호출 해 줌
    return n * solution2(n - 1);
    // 실제로는 n * (n - 1) * (n- 2) * ... * 1 이 됨
  }
}
// 추가 문제 : Q01과 Q02를 재귀 호출로 구해 보기