def solution(genres, plays):
    best_table = {}
    for i in range(len(genres)):
        key, val = genres[i], plays[i]
        tmp = best_table.get(key, [0, (-1, -1), (-1, -1)])
        best_table[key] = [tmp[0] + val, (i, val) if val > tmp[1][1] else tmp[1], tmp[1] if val > tmp[1][1] else (i, val) if val > tmp[2][1] else tmp[2]]
    return [data[0] for data in [song for genre in sorted(best_table.values(), key=lambda x: x[0], reverse=True) for song in genre[1:]] if data[0] != -1]