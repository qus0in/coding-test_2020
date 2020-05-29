package question;

import java.util.Arrays;

public class Question07 {
  public static void input(int[] numArray, int[] caseArray, int[] answerArray) {
    System.out.println("오름차순으로 정렬된 배열에서 특정 숫자의 위치 찾기");
    System.out.println("솔루션 : 이분 탐색");
    System.out.printf("제공된 배열 : %s\n", Arrays.toString(numArray));
    for (int i = 0; i < caseArray.length; i++) {
      System.out.printf("입력 : %d\n출력(예상) : %d\n출력(실제) : %d\n", caseArray[i], answerArray[i],
          solution(numArray, caseArray[i]));
    }
  }

  // 문제 : 배열에서 특정 숫자의 위치 찾기 (이분 탐색)
  // 입력 : (타입) 배열, arr (대상이 된 배열) & (타입) 정수, x (찾는 값)
  // 출력 : 찾으면 그 값의 위치, 못 찾으면 -1
  // 복잡도 : O(logn) (밑 2)
  public static int solution(int[] arr, int x) {
    // 탐색할 범위를 저장하는 변수 start, end
    // 배열 전체를 범위로 탐색 시작 (0 - ~arr.length-1)
    int start = 0;
    int end = arr.length - 1;
    int mid; // 중간 위치
    // 탐색할 범위가 남아 있는 한 반복
    while (start <= end) {
      mid = (start + end) / 2; // 탐색 범위의 중간 위치
      System.out.printf("시작 : %d, 중간 : %d, 끝 : %d\n", start, mid, end);
      if (x == arr[mid] ) { // 값을 찾으면
        return mid;
      } else if (x  > arr[mid]) {
        start = mid + 1; // x 값이 중간 값보다 크므로 오른쪽을 찾음
      } else {
        end = mid - 1; // x 값이 중간 값보다 작으므로 왼쪽을 찾음
      }
    }
    return -1; // 값을 못 찾음
  }
}