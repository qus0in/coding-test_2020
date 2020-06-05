import java.util.*;
 
class Solution {
    public static int solution(int[] people, int limit) {
        Arrays.sort(people); // 숫자 오름차순으로 정렬  
        int answer = 0; // 보트 갯수
        int index = people.length - 1; // 조회할 최댓값 인덱스   
        for(int i = 0; i <= index; i++, answer++) { // 어차피 어떤 케이스든 보트 하나는 타고 가니까 answer++ 해줌
            // 1. 한 명 남으면 그냥 타고 감
            // 2. 최소값과 최대값을 매칭했을 때
            // 2-1. 최대값 + 최소값이 한계를 넘었다 : 최대값이 보트 타고 최소값은 그대로 (1개 처리)
            // 2-2. 최대값 + 최소값이 한계 이하 : 둘이 같이 보트 타고 다음 최소값 (2개 처리)
            // 1명 이상 남았고 (인덱스 일치 X) / 최솟값과 현재 최댓값 합이 한계 넘었으면 배 하나 더 해줌
            while(index > i && people[i] + people[index--] > limit) {
                // 2-2인 경우 하나 더 처리해줌
                // 최댓값은 index-- 해주면서 하나 전 최댓값이 되었지만, 아직 최솟값은 그대로 이므로, 여전히 2명 이상이고 (인덱스 일치 안 하고) 최댓값이랑 합쳤을 때 제한 넘기면 계속적으로 보트 수 늘려줌 (최솟값이 곧 최댓값 될 때까지)
                answer++;
            }
        }
    return answer;
    }
}