function solution(genres, plays) {
	const sumMap = new Map();
	const songMap = new Map();
	for (const [i, v] of genres.entries()) {
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
	return Array.from(sumMap.entries())
		.sort((a, b) => b[1] - a[1])
		.map((x) =>
			songMap
				.get(x[0])
				.map((x) => Number(x[0]))
				.filter((x) => x != -1)
		) 
		.reduce((acc, val) => acc.concat(val), []);
}
