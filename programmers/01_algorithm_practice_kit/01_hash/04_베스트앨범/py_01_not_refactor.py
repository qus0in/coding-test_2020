def solution(genres, plays):
    # https://docs.python.org/ko/3.7/library/stdtypes.html#typesmapping
    # for문을 사용해 genres와 plays로 구성된 dictionary (매핑 객체) 구성
    best_table = {} # 받아줄 매핑 객체
    for i in range(len(genres)): # 두 리스트를 동시 돌리므로 인덱스로 처리
        key = genres[i] # 키로 쓸 장르명
        # 넣어줄 values, 만약에 없는 key라면 디폴트로 리스트를 받아옴
        # genres가 key, value는 각각 play 총합, 최다 재생 곡 인덱스 & 재생수, 다음 최다 재생 곡 인덱스 & 재생수 리스트
        values = best_table.get(key, [0, (-1, -1), (-1, -1)])
        values[0] = values[0] + plays[i] # 장르별 재생 수를 더해줌
        # 장르 내 최다 재생곡보다 재생수가 많다면
        if values[1][1] < plays[i] :
            values[2] = values[1] # 원래 베스트를 뒤로 미뤄주고
            values[1] = (i, plays[i]) # 새로 베스트를 넣어줌
        # 장르 내 다음 최다 재생곡보다 재생수가 많다면
        elif values[2][1] < plays[i] :
            values[2] = (i, plays[i]) # 두번째 베스트에 넣어줌
        best_table[genres[i]] = values # values를 직접 대입
    # 구성이 끝난 후에 values를 받아서, play 총합 순으로 sort하고, 정렬된 순서대로 인덱스 받아서 리턴
    answer = [] # 답으로 제출될 리스트
    # https://docs.python.org/ko/3.7/library/functions.html#sorted
    # values의 0번째(총 재생 횟수)를 기준으로 desc으로 sorting
    for v in sorted(best_table.values(), key=lambda x: x[0], reverse=True):
        answer.append(v[1][0]) # 장르별 최다 재생
        if v[2][0] != -1: # -1 이면 빈 공간임
            answer.append(v[2][0]) # 장르별 다음 최다 재생
    return answer