# 중복 여부까지 감안해서 카운트하는 문제이므로 collections 중 Counter 클래스 사용
# https://docs.python.org/ko/3.7/library/collections.html#collections.Counter
from collections import Counter

def solution(participant, completion):
    # list를 Counter 생성자에 넣으면 자동으로 값을 key, 해당 값의 빈도를 value로 카운트해 줌
    # 이 상황에서 큰 쪽에서 작은 쪽을 빼면 key별 연산이 가능함
    # print(Counter(participant) - Counter(completion))
    # 연산된 것을 리스트 변환 후 맨 첫번째 요소를 반환
    return list(Counter(participant) - Counter(completion))[0]