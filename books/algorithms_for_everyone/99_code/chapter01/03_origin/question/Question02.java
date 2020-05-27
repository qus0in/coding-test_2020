package question;
import java.util.Arrays;

public class Question02 {
  public static void input(int[][] caseArray, int[] answerArray, int[] answerArray2) {
    System.out.println("주어진 숫자 n개 중 가장 큰 숫자를 찾는 알고리즘");
    for (int i = 0; i < caseArray.length; i++) {
      System.out.printf("입력 : %s\n출력(예상) : %d\n출력(실제) : %d\n", Arrays.toString(caseArray[i]), answerArray[i],
          solution(caseArray[i]));
    }
    System.out.println("주어진 숫자 n개 중 가장 큰 숫자의 인덱스를 찾는 알고리즘");
    for (int i = 0; i < caseArray.length; i++) {
      System.out.printf("입력 : %s\n출력(예상) : %d\n출력(실제) : %d\n", Arrays.toString(caseArray[i]), answerArray2[i],
          solution2(caseArray[i]));
    }
  }

  // 문제 : 
  // 입력 : 
  // 출력 : 
  // 복잡도 :
  public static int solution(int[] nArray) {
    return 0;
  }

  // 문제 : 
  // 입력 : 
  // 출력 : 
  // 복잡도 :
  public static int solution2(int[] nArray) {
    return 0;
  }
}
// 추가 문제 : 숫자 n개를 배열로 입력받아 최솟값을 구하는 알고리즘