function solution(genres, plays) {
	const sumMap = new Map();
	const songMap = new Map();
	for (const [i, v] of genres.entries()) {
        // https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Global_Objects/Array/entries
		// entries는 배열의 인덱스와 값을 마치 키, 값처럼 리턴하므로 파이썬의 enumerate 처럼 쓸 수 있음
		// console.log(i, v)
		sumMap.set(v, (sumMap.get(v) || 0) + plays[i]);
		const bestSong = songMap.get(key) || [
			[-1, -1],
			[-1, -1],
		];
		if (bestSong[0][1] < plays[i]) {
			bestSong[1] = [bestSong[0][0], bestSong[0][1]];
			bestSong[0] = [i, plays[i]];
		} else if (bestSong[1][1] < plays[i]) {
			bestSong[1] = [i, plays[i]];
		}
		songMap.set(key, bestSong);
	}
	// array 관련 메소드 합쳐줌
	return Array.from(sumMap.entries()) // sumMap에서 entry를 들고 와서 배열로 바꿔준 다음
		.sort((a, b) => b[1] - a[1]) // 재생수 기준으로 내림차순 정렬해준 다음에
		.map((x) =>
			songMap
				.get(x[0]) // 해당 키 값으로 songMap을 들고 와서
				.map((x) => Number(x[0])) // 해당 부분의 인덱스만 들고 오고 (혹시 모르니 Number로 변환)
				.filter((x) => x != -1) // -1이라는 빈 부분을 날려주면서 map이 종료
		) 
		.reduce((acc, val) => acc.concat(val), []); // 장르별로 이중배열되어 있는 것을 평탄화
}
