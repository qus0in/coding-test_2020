import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> sumMap = new HashMap<>();
        Map<String, List<List<Integer>>> songMap = new HashMap<>(); // 이번엔 배열이 아닌 리스트 위주로
        for (int i = 0; i < genres.length; i++) {
            String key = genres[i];
            sumMap.put(key, sumMap.getOrDefault(key, 0) + plays[i]);
            // 기본적으로 -1, 0으로 구성된 값을 가지게 함 (0 인덱스와 겹치지 않게)
            List<List<Integer>> bestSong = songMap.getOrDefault(key, Arrays.asList(Arrays.asList(-1, 0), Arrays.asList(-1, 0)));
            if (bestSong.get(0).get(1) < plays[i]) {
                bestSong.set(1, Arrays.asList(bestSong.get(0).get(0), bestSong.get(0).get(1)));
                bestSong.set(0, Arrays.asList(i, plays[i]));
            } else if (bestSong.get(1).get(1) < plays[i]) {
                bestSong.set(1, Arrays.asList(i, plays[i]));
            }
            // System.out.println(String.format("%s, %s", key, bestSong));
            songMap.put(key, bestSong); // songMap에 넣어줌
        }
        // System.out.println(sumMap);
        // System.out.println(songMap);
        // 한 번에 스트림화하고 처리한 다음에 answer로 리턴
        // List<Object> list = sumMap.entrySet().stream()
        //     .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
        //     .map(e -> songMap.get(e.getKey())) // key로 바로 songMap에서 호출
        //     .collect(ArrayList::new, List::addAll, List::addAll) // 이중리스트를 평탄화
        //     .stream().map(e -> ((List) e).get(0))
        //     .filter(e -> (Integer) e > -1)
        //     .collect(java.util.stream.Collectors.toList());
        // System.out.println(list);
        return sumMap.entrySet().stream()
            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
            .map(e -> songMap.get(e.getKey()))
            .collect(ArrayList::new, List::addAll, List::addAll)
            .stream().map(e -> (Integer) ((List) e).get(0))
            .filter(e -> e > -1).mapToInt(x -> x).toArray();
    }
}