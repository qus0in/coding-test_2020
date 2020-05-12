# [해시] 완주하지 못한 선수 🏃
## ❓ 문제
> 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다. <br> 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, **완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성**해주세요.
* [자세히 보기](https://programmers.co.kr/learn/courses/30/lessons/42576)

## 🔬 분석
- participant와 completion 배열은 요소들이 짝을 이루는데, 한 명(완주 못한 선수)은 짝을 이루지 못함
- 짝을 이루는지 판단하기 위해서 Key-Value로 짝이 있는 Hash 계열 자료구조를 사용
  - completion_table = completion를 기반으로 이름을 key, 명 수를 value로 하는 맵(또는 딕셔너리)
  - participant를 반복문으로 돌려서 completion_table에서 key로 호출
    - 해당 key가 존재하지 않으면 -> 해당 key가 완주 못한 선수이므로 return
    - 해당 key가 존재하면 -1 을 빼준다 -> (동명이인 이슈) -> 0보다 작으면 해당 key가 완주 못한 선수이므로 return
  - **해시를 쓰는 장점?** : 정렬을 하지 않아도 된다는 이점이 있음 (속도 개선)