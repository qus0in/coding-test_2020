package question;

public class Question04 {
  public static void input(int[] caseArray, int[] answerArray) {
    System.out.println("1부터 n까지 연속한 정수의 곱을 구하는 알고리즘 (팩토리얼)");
    System.out.println("솔루션 1 : for문으로 순서대로 곱하기");
    for (int i = 0; i < caseArray.length; i++) {
      System.out.printf("입력 : %d\n출력(예상) : %d\n출력(실제) : %d\n", caseArray[i], answerArray[i], solution(caseArray[i]));
    }
    // System.out.println("솔루션 2 : 재귀호출로 구하기");
    // for (int i = 0; i < caseArray.length; i++) {
    //   System.out.printf("입력 : %d\n출력(예상) : %d\n출력(실제) : %d\n", caseArray[i], answerArray[i], solution2(caseArray[i]));
    // }
  }
  // 문제 : 
  // 입력 : 
  // 출력 : 

  // 솔루션 1 : for문으로 순서대로 곱하기
  public static int solution(int n) {

    return 0;
  }

  // 솔루션 2 : 재귀 호출로 구하기
  public static int solution2(int n) {
    
    return 0;
  }
}
