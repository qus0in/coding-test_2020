import java.util.*;

class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> dp = new ArrayList<>();
        // 연산을 통해 나온 값들이 dp로 들어가고,
        // 인덱스마다 i + 1 번의 N을 사용해서 연산값이
        // 연산값들이 중복 발생 => 중복을 방치하면 다음 단계의 값이 더 복잡해짐 => Set.
        for (int v = 0; v < 8; v++) {
            // N이라는 숫자를 이어 붙여서 5, 55, 555, 5555... 표현
            Set<Integer> set = new HashSet<>();
            set.add(Integer.parseInt(Integer.toString(N).repeat(v + 1)));
            dp.add(set);
        }
        // System.out.println(dp);
        // N을 사용하는 최솟값을 구해줄텐데, 최솟값이 8이 넘어가면 (9부터는) -1을 그냥 리턴해주도록
        // i가 1부터 시작하는 이유는 i=0일 때의 연산은 N을 한 번 사용하는 연산인데 이것은 무조건 N밖에 나올 수 없음
        for (int i = 1; i < 8; i++) { // 8번 N을 사용하는 연산을 하고
            // n을 1번 사용해서 연산
            // n을 2번 사용해서 연산 => n을 1번 사용해서 연산 & n을 1번 사용해서 연산 (1, 1)
            // n을 3번 사용해서 연산 => (1, 2) (2, 1) => (1, 2)
            // n을 4번 사용해서 연산 => (1, 3) (2, 2) ...
            for (int j = 0; j < i; j++) {
                // i에서 j만큼을 뺀 쌍들을 연산해줄겁니다
                // 5개를 쓴다 (0 = 1개를 쓴 것, n= n+1개를 쓴것)
                // (1, 4) (2, 3) <==> (3, 2) (4, 1) ... (절대값)
                // get(0) get(3) / g(1) g(2) ...
                // a, b
                // 6번
                // a = j 0부터 시작 (1번)
                // b = i-j-1 5번  
                for (int a : dp.get(j)) { // j번째 인덱스에 있는 j + 1 번 N을 사용한 ... => (1, i - 1) (2, i - 2) ... (i / 2 => j) 중복되는 연산은 일어나지 X
                    for (int b : dp.get(i - j - 1)) { // i - j - 1 번째 인덱스에 있는 i - j번 N을 사용한 연산 값들의 셋 => 연산된 값들 a에 담아서 처리
                        // 사칙연산한 값들을 dp에 추가
                        // i+1개의 N을 사용해서 연산한 값
                        dp.get(i).add(a + b);
                        dp.get(i).add(a - b);
                        dp.get(i).add(a * b);
                        if (b != 0) {
                            dp.get(i).add(a / b); // 나눌 때 0이 되지 않게                 
                        }
                    }
                    // dp.get(i) = i + 1개의 N을 사용해서 만들 수 있는 모든 수의 집합(set)
                    if (dp.get(i).contains(number)) {
                        return i + 1; // 최솟값
                    }
                }
            }
        }
        return -1; // 9번째부터는 바로 -1 반환
    }
}