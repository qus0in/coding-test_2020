package question;


public class Q06 {
  public static void input(int[] caseArray) {
    System.out.println("하노이의 탑 알고리즘");
    for (int i = 0; i < caseArray.length; i++) {
      System.out.printf("입력 : %d\n", caseArray[i]);
      solution(caseArray[i], 1, 3, 2);
    }
  }
  /*
  문제 : 하노이의 탑
  입력 : (타입) 정수, 옮기려는 원반의 개수 n
         (타입) 정수 : 옮길 원반이 현재 있는 출발점 기둥 fromPos
         (타입) 정수 : 원반을 옮길 도착점 기둥 toPos
         (타입) 정수 : 옮기는 과정에서 사용할 보조 기둥 auxPos
  출력 : 원반을 옮기는 순서
  솔루션 : 재귀 호출
  복잡도 : O(2의 n승)
  */
  public static void solution(int n, int fromPos, int toPos, int auxPos) {
    /*
      1 - A : 원반이 한 개면 그냥 옮기면 됨 (종료 조건)
      1 - B : 원반이 n 개 (n > 1) 일 때
        1 : 1번 기둥에 있는 n개 원반 중 n-1개를 2번 기둥으로 옮김 (3번 기둥을 보조 기둥으로 사용)
        2 : 1번 기둥에 남아 있는 가장 큰 원반을 3번 기둥으로 옮김
        3 : 2번 기둥에 있는 n-1개 원반을 다시 3번 기둥으로 옮김 (1번 기둥을 보조 기둥으로 사용)
      원반 n개를 풀려면 n - 1 개 원반 문제를 풀어야 하는데, 이는 '좀 더 작은 값으로 자기 자신을 호출하는' 과정 => 재귀 호출 알고리즘
    */
    if (n == 1) { // 원반 1개일 경우
      // 이동 시켜줌
      System.out.printf("%d -> %d\n", fromPos, toPos);
      return; // 리턴하여 종료
    }
    // 원반 n - 1 개를 auxPos로 이동 (to_pos를 보조 기둥으로)
    solution(n - 1, fromPos, auxPos, toPos);
    // 가장 큰 원반을 목적지로 이동
    System.out.printf("%d -> %d\n", fromPos, toPos);
    // auxPos에 있는 원반 n-1개를 목적지로 이동(fromPos를 보조 기둥으로)
    solution(n - 1, auxPos, toPos, fromPos);
  }
}