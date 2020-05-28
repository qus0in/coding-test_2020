package question;

public class Question01 {
  public static void input(int[] caseArray, int[] answerArray) {
    System.out.println("1부터 n까지의 합을 구하는 알고리즘");
    System.out.println("");
    for (int i = 0; i < caseArray.length; i++) {
      System.out.printf("입력 : %d\n출력(예상) : %d\n출력(실제) : %d\n", caseArray[i], answerArray[i], solution(caseArray[i]));
    }
    System.out.println("");
  }

  // 문제 : 
  // 입력 : 
  // 출력 : 
  // 복잡도 :
  public static int solution(int n) {
    return 0;
  }
}
// 추가 문제 : 1부터 n까지 연속한 제곱의 합을 구하는 알고리즘 - for문으로 구해보기 or 공식 사용하기