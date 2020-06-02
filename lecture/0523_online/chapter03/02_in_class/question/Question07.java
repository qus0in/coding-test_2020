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

  // 문제 : 정렬된 배열에서 특정 숫자의 위치 찾기 (이분 탐색)
  // 입력 : 정수 배열 arr, 찾으려는 숫자 x
  // 출력 : 찾았으면 인덱스 못찾으면 -1
  // 복잡도 : 
  public static int solution(int[] arr, int x) {
    // 탐색할 범위를 저장하는 변수
    // start, end (int)
    int start = 0;
    int end = arr.length -  1;
    int mid; // 중간 지점을 나타내는 변수
    // start > end <- 좀 이따 설명
    while (start <= end) {
      mid = (start + end) / 2;
      // 중간 인덱스 구해주기
      System.out.printf("시작 : %d, 중간 : %d, 끝 : %d\n", start, mid, end);
      // 만약에 찾으려는 값 x와 중간 인덱스 값인 arr[mid]가 같으면 (값을 찾은 것)
      if (x == arr[mid]) {
        return mid; // mid 자체가 중간 인덱스
      } else if (x > arr[mid]) {
        start = mid + 1;
        // x 값이 중간값보다 크므로 오른쪽으로 시작지점을 이동시켜줌
      } else {
        end = mid - 1;
        // x 값이 중간값보다 작아서 왼쪽으로 종료지점을 이동시켜 줌
      }
    }
    // 끝까지 값을 못 찾은 경우엔
    return -1;
  }
}