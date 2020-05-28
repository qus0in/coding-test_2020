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
  // 입력 : (타입) int 배열 numArray, (타입) int num
  // 출력 : (타입) int. 찾으면 그 값의 위치. 못 찾으면 -1
  // 복잡도 : O(n)
  public static int solution(int[] numArray, int num) {
    // 어떤 for문을 써줘야하지?
    // 어떻게 for문을 써줘야하지?
    for (int i = 0; i < numArray.length; i++) {
      // [for문 내부] 찾으려는 숫자(num)와 배열의 현재 인덱스에 있는 값 (numArray[i])이 같은가? 
      if (num == numArray[i]) {
        return i;
      }
    }
    return -1; // 모두 탐색했는데도 못 찾음
  }
}