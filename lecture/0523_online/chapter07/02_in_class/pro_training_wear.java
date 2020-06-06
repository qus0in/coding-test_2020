import java.util.*; // 유틸 가져오기

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // n은 전체 학생의 수
        // lost는 도난 당한 학생들의 번호
        // reserve 여분이 있는 학생들의 번호
        int[] arr = new int[n]; // 여기에 여분이 있는지와 도난 당했는지 등을 표시
        for (int l : lost) { // 도난당한 학생들 배열을 탐색해서 arr에 표시
            arr[l - 1] -= 1; // 잃어버린 사람들의 배열의 위치에 -1을 해줄거에요. - 1 ? 인덱스는 0부터 시작하니까
        }
        // System.out.println(Arrays.toString(arr));
        for (int r : reserve) {
            arr[r - 1] += 1; // 여분이 있는 사람들의 배열 위치에 +1을 해준다 (그러면 도난 & 여분의 경우엔 0이 됨)
            // 1 : 여분 있음
            // 0 : 도난을 안당했거나, 도난당했지만 여분 있음
            // -1 : 도난 당해서 체육복이 없음 (=> answer)
        }
        // System.out.println(Arrays.toString(arr));
        int answer = 0; // 입고 나갈 수 있는 학생 수
        // 체육복을 빌려주는 과정
        for (int i = 0; i < arr.length; i++) {
            // 4가지 경우
            // 0 : 그냥 수업 들으러 가면 됨
            if (arr[i] != -1) {
                answer++; // 수업 들으러 감
            } else {
                // 1 : 앞사람이 여분 있음
                if (i > 0 && arr[i - 1] == 1) {
                    arr[i - 1]--;
                    answer++;
                // 2 : 뒷사람이 여분 있음
                } else if (i + 1 < arr.length && arr[i + 1] == 1) {
                    arr[i + 1]--;
                    answer++;
                }
                // 3 : 여분있는 사람이 없음
            }
        }
        return answer;
    }
}