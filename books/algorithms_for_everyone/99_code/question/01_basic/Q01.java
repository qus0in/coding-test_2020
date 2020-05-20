package question;

public class Q01 {
  public static void input(int[] caseArray, int[] answerArray) {
    System.out.println("1부터 n까지의 합을 구하는 알고리즘");
    System.out.println("솔루션 1 : for문으로 직접 더하기");
    for (int i = 0; i < caseArray.length; i++) {
      System.out.printf("입력 : %d\n출력(예상) : %d\n출력(실제) : %d\n", caseArray[i], answerArray[i], solution(caseArray[i]));
    }
    System.out.println("솔루션 2 : 가우스의 합 공식");
    for (int i = 0; i < caseArray.length; i++) {
      System.out.printf("입력 : %d\n출력(예상) : %d\n출력(실제) : %d\n", caseArray[i], answerArray[i], solution2(caseArray[i]));
    }
  }

  // 문제 : 1부터 n까지 연속한 숫자의 합 구하기
  // 입력 : (타입) 정수, n
  // 출력 : (타입) 정수, 1부터 n까지의 합
  // 솔루션 1 : for문으로 직접 더하기
  // 복잡도 : O(n)
  public static int solution(int n) {
    // 합을 기록할 정수 타입의 s 선언 및 0으로 초기화
    int s = 0;
    // for문으로 정수 i에 1부터 n까지의 숫자를 1씩 증가시키며 반복
    for (int i = 1; i <= n; i++) {
      // [for문 내부] 기존의 s에 i를 더하여 얻은 값을 다시 s에 대입
      s += i;
    }
    // for문이 끝났을 때 s 값이 결과 값 (출력)
    return s;
  }

  // 솔루션 2 : 가우스의 합 공식
  // 복잡도 : O(1)
  public static int solution2(int n) {
    return n * (n + 1) / 2;
  }
}
// 추가 문제 : 1부터 n까지 연속한 제곱의 합을 구하는 알고리즘 - for문으로 구해보기 or 공식 사용하기