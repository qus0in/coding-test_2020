import java.util.*;

class Solution {
    // people 배열 -> 몸무게. ? 정렬 되어 있는 상태 X
    // 정렬을 해주면 좋겠다...
    public int solution(int[] people, int limit) {
        // 가장 가벼운 사람 ~ 가장 무거운 사람까지 => 정렬 (오름차순 정렬)
        Arrays.sort(people); // 오름차순으로 정렬 (가벼운 순으로 정렬)
        // System.out.println(Arrays.toString(people));
        // 가장 무거운 사람(?) 만약에 보트를 limit 넘기지 않고 같이 탈 수 있다 (1명 이상 있다...)
        // 적어도 가장 가벼운 사람은 거기에 포함된다
        // 가장 가벼운 사람 + 가장 무거운 사람 짝 지워서
        // => 제한을 넘기는지 보는 것
        int maxIdx = people.length - 1; // 가장 무거운 사람 위치
        int answer = 0; // 보트가 필요한 갯수
        for (int i = 0; i <= maxIdx; i++) { // 가장 가벼운 사람부터 탐색
            // 1. 최댓값 인덱스가 최솟값과 일치하지 않는 조건
            // 2. 최소값 + 최대값 > 제한 무게보다 높으면은 최솟값을 그대로 두고 최댓값만 바꿔넣어주는...
            answer++; // 최솟값 1명당 1개의 보트는 확보
            while (maxIdx > i && people[i] + people[maxIdx--] > limit) {
                // 최댓값 != 최솟값 && 둘을 합했을 때 제한 조건을 넘긴다 = 즉 최댓값이 혼자 타야한다는 조건
                answer++; //  보트 하나 더 필요
            }
        }
        return answer;
    }
}