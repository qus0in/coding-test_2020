from collections import Counter
from functools import reduce

def solution(clothes):
    # https://docs.python.org/ko/3.7/library/collections.html#collections.Counter
    # https://docs.python.org/ko/3.7/tutorial/datastructures.html#list-comprehensions
    # https://docs.python.org/ko/3.7/library/functools.html#functools.reduce
    # 리스트 컴프리헨션으로 카테고리 값(인덱스 1)을 추려서 counter 객체를 생성해줌
    # counter = Counter([c[1] for c in clothes])
    # print(counter)
    # values 메소드를 사용해서 카테고리별 count된 결과만 받음
    # print(counter.values())
    # reduce 메소드를 사용해서 람다식으로 1부터 카운트 된 값 + 1을 곱해주는 식 구현
    # print(reduce(lambda x, y: x * (y + 1), counter.values(), 1))
    # 마지막으로 -1까지 해서 답을 리턴
    # return reduce(lambda x, y: x * (y + 1), counter.values(), 1) - 1
    # 결과적으로 모두 축약한 한 줄의 파이썬 코드
    return reduce(lambda x, y: x * (y + 1), Counter([c[1] for c in clothes]).values(), 1) - 1
