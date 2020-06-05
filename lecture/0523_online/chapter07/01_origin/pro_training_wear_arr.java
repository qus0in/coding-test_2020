// https://programmers.co.kr/learn/courses/30/lessons/42862
import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // n만큼의 빈 (0으로 초기화된) 배열 만듦
        int[] arr = new int[n];
        for (int v : lost) {
            arr[v - 1] = -1; // 잃어버린 사람들은 -1을 해줌
        }
        for (int v : reserve) {
            arr[v - 1]++; // 여분이 있는 사람들은 +1을 해줌
            // 이 과정에서 잃어버렸는데 여분이 있는 사람은 0이 됨
            // 1 = 여분 있음, 0 = 자기것밖에 없음, -1 = 자기것도 없음
        }
        // System.out.println(Arrays.toString(arr));
        int answer = 0; // 체육 수업 나갈 수 있는 사람
        for (int i = 0; i < arr.length; i++) {
            // System.out.println(String.format("%d번째 교환 전 : %s", i+1, Arrays.toString(arr)));
            if (arr[i] == -1) { // 도난 당한 사람이면 (-1)
                if(i != 0 && arr[i - 1] == 1) { // 맨 앞사람이 아니고, 앞 사람이 여분이 있으면
                    arr[i - 1] = arr[i] = 0; // 체육복 빌림
                } else if (i != arr.length - 1 && arr[i + 1] == 1) { // 맨 끝 사람 아니고, 뒷 사람이 여분이 있으면
                    arr[i + 1] = arr[i] = 0; // 체육복 빌림
                } else {
                    continue; // 체육복 없어서 수업 못나감
                }
            }
            answer++; // 여분 있는 사람 or 자기것 있는 사람이면 체육 수업 나감
            // System.out.println(String.format("%d번째 교환 후 : %s", i+1, Arrays.toString(arr)));
        }
        return answer;
    }
}