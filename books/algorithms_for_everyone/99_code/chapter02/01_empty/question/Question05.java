package question;
import java.util.Arrays;

public class Question05 {
  public static void input(int[][] caseArray, int[] answerArray) {
    System.out.println("두 자연수 a와 b의 최대공약수를 구하는 알고리즘");
    System.out.println("솔루션 1 : while문으로 모듈러스 연산");
    for (int i = 0; i < caseArray.length; i++) {
      System.out.printf("입력 : %s\n출력(예상) : %d\n출력(실제) : %d\n", Arrays.toString(caseArray[i]), answerArray[i], solution(caseArray[i][0], caseArray[i][1]));
    }
    // System.out.println("솔루션 2 : 유클리드 방식 (재귀)");
    // for (int i = 0; i < caseArray.length; i++) {
    //   System.out.printf("입력 : %s\n출력(예상) : %d\n출력(실제) : %d\n", Arrays.toString(caseArray[i]), answerArray[i], solution2(caseArray[i][0], caseArray[i][1]));
    // }
    // System.out.println("솔루션 3 : 유클리드 방식 (반복)");
    // for (int i = 0; i < caseArray.length; i++) {
    //   System.out.printf("입력 : %s\n출력(예상) : %d\n출력(실제) : %d\n", Arrays.toString(caseArray[i]), answerArray[i], solution3(caseArray[i][0], caseArray[i][1]));
    // }
  }
  // 문제 : 
  // 입력 : 
  // 출력 : 

  // 솔루션 1 : while문으로 모듈러스 연산
  public static int solution(int a, int b) {
    /* 최대공약수 : 두 개 이상의 정수의 공통 약수 중 가장 큰 값
    // (1) 두 수의 약수 중에서
    // (2) 공통된 것을 찾아
    // (3) 그 값 중 최댓값인 것을 찾아야 함
    */
    return 0;
  }

  // 솔루션 2 : 유클리드 방식 (재귀)
  public static int solution2(int a, int b) {
    // (1) a와 b의 최대 공약수는 b와 a % b 의 최대공약수와 같음
    // (2) 어떤 수와 0의 최대공약수는 자기 자신
    return 0;
  }
  // 솔루션 3 : 유클리드 방식 (반복)
  public static int solution3(int a, int b) {
    return 0;
  }
}