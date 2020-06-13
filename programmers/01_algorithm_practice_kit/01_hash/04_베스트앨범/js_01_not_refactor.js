function solution(genres, plays) {
    // 사용될 맵 2개
    const sumMap = new Map(); // 장르별 총 합
    const songMap = new Map(); // 장르별 많이 재생된 수
    // genres 기준으로 get in으로 순회하면서 plays를 체크
    for (const i in genres) {
        const key = genres[i]; // 이번에 사용될 키 = 장르명
        // console.log(key)
        // sumMap에는 장르별 재생횟수가 들어 있음
        sumMap.set(key, (sumMap.get(key) || 0) + plays[i]); // sumMap에 장르별 합계를 카운팅
        const bestSong = songMap.get(key) || [[-1, -1], [-1, -1]]; // 장르별 최다 재생 노래 변수
        if (bestSong[0][1] < plays[i]) { // 0번째 노래보다 현재 노래가 재생 많이 되었다면
            bestSong[1] = [bestSong[0][0], bestSong[0][1]];
            bestSong[0] = [i, plays[i]]; // 한 칸씩 미뤄줌
        } else if (bestSong[1][1] < plays[i]) { // 1번째 노래보다 ...
            bestSong[1] = [i, plays[i]]; // 바꿔줌
        }
        songMap.set(key, bestSong); // songMap에 세팅해줌
    }
    // https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Operators/Spread_syntax
    // console.log(...sumMap);
    // console.log(...songMap);
    // console.log(...sumMap.entries());
    // https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Global_Objects/Array/sort
    // 재생횟수 기준으로 내림차순 정렬 (sumMap)
    const sorted = Array.from(sumMap.entries()).sort((a, b) => b[1] - a[1]);
    // console.log(sorted);
    // sumMap의 키 정보로 songMap 호출한 뒤, 인덱스 정보만 남김. 만약에 -1이라는 인덱스가 있다면 그것은 빈 값이므로 지워줌
    // https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Global_Objects/Array/map
    // https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Global_Objects/Array/filter
    const filtered = sorted.map(x => songMap.get(x[0])
                           .map(x => Number(x[0]))
                           .filter(x => x != -1));
    // console.log(filtered);
    // https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Global_Objects/Array/flat
    // reduce + concat을 사용해서 평탄화
    const flattend = filtered.reduce((acc, val) => acc.concat(val), []);
    // console.log(flattend);
    return flattend
}