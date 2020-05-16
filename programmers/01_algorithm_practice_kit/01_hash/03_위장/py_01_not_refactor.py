def solution(clothes):
    # https://docs.python.org/ko/3.7/library/stdtypes.html#typesmapping
    # clothes를 의상의 종류별로 count할 dictionary 생성
    clothes_table = {}
    # clothes를 순회
    for c in clothes:
        # c의 1번째 값, 즉 옷의 종류를 키 값으로 호출, 해당 값에 1을 더해주고 재대입
        # get 메소드를 사용해서 만약에 키가 없다면 0 값을 불러오게 해서 key Error 방지
        clothes_table[c[1]] = clothes_table.get(c[1], 0) + 1
    # print(clothes_table)
    answer = 1 # 답을 리턴할 변수 지정
    # dictionary의 value만 받아주는 메소드로 이터러블 생성하여 순회
    for v in clothes_table.values():
        answer *= (v + 1) # 각 옷의 종류당 +1 해서 곱해줌 (입지 않는다 + 옷의 갯수)
    return answer - 1 # 아예 옷을 입지 않는다는 제외하므로 1 마지막으로 빼줌