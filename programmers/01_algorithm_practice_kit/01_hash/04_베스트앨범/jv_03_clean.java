import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> sumMap = new HashMap<>();
        Map<String, List<List<Integer>>> songMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String key = genres[i];
            sumMap.put(key, sumMap.getOrDefault(key, 0) + plays[i]);
            List<List<Integer>> bestSong = songMap.getOrDefault(key, Arrays.asList(Arrays.asList(-1, 0), Arrays.asList(-1, 0)));
            if (bestSong.get(0).get(1) < plays[i]) {
                bestSong.set(1, Arrays.asList(bestSong.get(0).get(0), bestSong.get(0).get(1)));
                bestSong.set(0, Arrays.asList(i, plays[i]));
            } else if (bestSong.get(1).get(1) < plays[i]) {
                bestSong.set(1, Arrays.asList(i, plays[i]));
            }
            songMap.put(key, bestSong);
        }
        return sumMap.entrySet().stream()
            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
            .map(e -> songMap.get(e.getKey()))
            .collect(ArrayList::new, List::addAll, List::addAll)
            .stream().map(e -> (Integer) ((List) e).get(0))
            .filter(e -> e > -1).mapToInt(x -> x).toArray();
    }
}