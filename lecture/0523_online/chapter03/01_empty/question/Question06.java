package question;

import java.util.Arrays;

public class Question06 {
  public static void input(int[] numArray, int[] caseArray, int[] answerArray) {
    System.out.println("배열에서 특정 숫자의 위치 찾기");
    System.out.println("솔루션 : for문을 통한 순차 탐색");
    System.out.printf("제공된 배열 : %s\n", Arrays.toString(numArray));
    for (int i = 0; i < caseArray.length; i++) {
      System.out.printf("입력 : %d\n출력(예상) : %d\n출력(실제) : %d\n", caseArray[i], answerArray[i],
          solution(numArray, caseArray[i]));
    }
  }

  // 문제 : 배열에서 특정 숫자의 위치 찾기
  // 입력 : 
  // 출력 : 
  // 복잡도 : 
  public static int solution(int[] numArray, int num) {
    return 0;
  }
}