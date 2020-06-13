import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 사용될 맵
        Map<String, Integer> sumMap = new HashMap<>(); // 장르별 총 합
        Map<String, int[][]> songMap = new HashMap<>(); // 장르별 많이 재생된 수
        // genres 기준으로 for 문으로 순회하면서 plays를 체크
        for (int i = 0; i < genres.length; i++) {
            String key = genres[i]; // 이번에 사용될 키 = 장르명
            // sumMap에는 장르별 재생횟수를 넣어줌
            sumMap.put(key, sumMap.getOrDefault(key, 0) + plays[i]); // sumMap에 장르별 합계를 카운팅
            int[][] bestSong = songMap.getOrDefault(key, new int[2][2]); // 장르별 최다 재생 노래 변수
            if (bestSong[0][1] < plays[i]) { // 0번째 노래보다 현재 노래가 재생 많이 되었다면
                bestSong[1][0] = bestSong[0][0];
                bestSong[1][1] = bestSong[0][1];
                bestSong[0][0] = i;
                bestSong[0][1] = plays[i]; // 한 칸씩 미뤄줌
            } else if (bestSong[1][1] < plays[i]) { // 1번째 노래보다 ...
                bestSong[1][0] = i;
                bestSong[1][1] = plays[i]; // 바꿔줌
            }
            // System.out.println(String.format("%s, %s, %s", key, Arrays.toString(bestSong[0]), Arrays.toString(bestSong[1])));
            songMap.put(key, bestSong); // songMap에 넣어줌
        }
        // System.out.println(sumMap);
        // 재생횟수 기준으로 내림차순 정렬
        // https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html
        List<String> sorted = sumMap.entrySet().stream() // entrySet으로 변환후 stream화
                           .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())) // 해당 set에서 재생횟수(value) 기준으로 오름차순화
                           .map(e -> e.getKey()) // key = 장르명으로 매핑
                           .collect(java.util.stream.Collectors.toList()); // 리스트화
        // System.out.println(sorted);
        List<Integer> list = new ArrayList<>(); // 음악들 인덱스 담아줄 리스트
        for (String v : sorted) { // 장르별 정렬된 리스트로
            int[][] songArr = songMap.get(v); // 인덱스, 재생횟수로 되어 있는 값을 호출해서
            for (int[] a : songArr) { 
                if (a[1] != 0) { // 재생수가 0, 즉, 빈 인덱스가 아니면
                    list.add(a[0]); // 해당 인덱스를 넣어줍니다
                }
            }
        }
        int[] answer = new int[list.size()]; // 최종 답 배열
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i); // get으로 해당 인덱스에 넣어줌
        }
        return answer;
    }
}