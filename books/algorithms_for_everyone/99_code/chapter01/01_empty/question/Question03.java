package question;

import java.util.HashSet;
import java.util.Arrays;

public class Question03 {
  public static void input(String[][] caseArray, String[][] answerArray) {
    System.out.println("n명의 사람 이름 중에서 같은 이름을 찾아 집합으로 만들어 돌려주는 알고리즘");
    for (int i = 0; i < caseArray.length; i++) {
      System.out.printf("입력 : %s\n출력(예상) : %s\n출력(실제) : %s\n", Arrays.toString(caseArray[i]), Arrays.toString(answerArray[i]), Arrays.toString(solution(caseArray[i]).toArray()));
    }
  }

  // 문제 : 
  // 입력 : 
  // 출력 : 
  // 복잡도 :
  public static HashSet<String> solution(String[] nameArray) {
    return null;
  }
}
// 추가 문제 : n명 중 두 명을 뽑아 짝을 짓는다고 할 때 짝을 지을 수 있는 모든 조합을 출력하는 알고리즘