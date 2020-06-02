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
  // 입력 : (타입) 배열, numArray & (타입) 정수, n
  // 출력 : 찾으면 그 값의 위치, 못 찾으면 -1
  // 복잡도 : O(n) (최악의 경우)
  public static int solution(int[] numArray, int num) {
    // 배열 numArray의 값을 차례대로 보기 위해 numArray의 전체 길이를 기준으로 for문 작성
    for (int i = 0; i < numArray.length; i++) {
      // [for문 내부] numArray의 i번째 값이 찾으려는 n과 일치하는가?
      if (num == numArray[i]) {
        // 일치하면 해당 값의 인덱스 역할을 하는 i를 리턴 (이로서 솔루션 종료)
        return i;
      }
    }
    // 끝까지 찾았는데도 안나왔으면 -1
    return -1;
  }
}