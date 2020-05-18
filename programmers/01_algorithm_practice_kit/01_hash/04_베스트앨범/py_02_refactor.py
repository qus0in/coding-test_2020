def solution(genres, plays):
    best_table = {}
    for i in range(len(genres)):
        # key = 처리할 장르 이름, tmp = 임시로 불러온 장르별 데이터, val은 재생수
        key, val = genres[i], plays[i]
        tmp = best_table.get(key, [0, (-1, -1), (-1, -1)])
        best_table[key] = [tmp[0] + val, # 장르별 재생수 합치기
        (i, val) if val > tmp[1][1] else tmp[1], # 신규 재생수가 높다면 바꿔줌
        tmp[1] if val > tmp[1][1] else (i, val) if val > tmp[2][1] else tmp[2]] # 두번째도 바꿔줌
    
    # https://docs.python.org/ko/3/tutorial/datastructures.html#nested-list-comprehensions
    return [data[0] for data in [song # 3. 중첩된 리스트 컴프리헨션을 통해 정리된 데이터에서 인덱스만 호출해줌
        for genre in sorted(best_table.values(), key=lambda x: x[0], reverse=True)
        # 1. 장르별 재생수를 기준으로 sorting 한 것의 요소를 genre로 받음
        for song in genre[1:]] # 2. 그 중 재생수 부분을 제거하고 개별 곡의 인덱스와 재생수를 가진 부분을 song으로 받음
        if data[0] != -1] # 4. 그 중에 -1(기본값)인 빈 데이터를 제거해줌