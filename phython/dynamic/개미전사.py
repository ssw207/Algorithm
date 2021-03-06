# 식량창고가 K개있다
# 인접한 식량창고는 털지 못한다
# 최대로 얻을수 있는 식량은?
# 입력값 N 1~100
# 식량창고 K 0~ 1000

# 접근방법
# 바로 코드를 작성하지말고 실제로 값을 넣어 경우의 수를 구한다
# N =4이고 1 3 1 5를 입력받았을때 경우의 수
# (1),(3),(1),(5), (1,1),(1,5),(3,5),()
# 최대 8
# ai = i 번째 창고까지 얻을 수 있는 최대 식량
# a0 = 1, a1= 3, a2 = 3, a4 = 8
# i번째 식량 창고를 털지 안 털지는 i-1번째까지 얻을수 있는 최대식량과 i-2번째 까지 얻을수 있는 최대식량 + i번째 식량창고의 식량의 양 을 비교후 더 큰 값을 선택한다.
# i번째 식량창고에 있는 식략의 양 K
# ai = max(ai-1, ai-2 + ki)
# 경우의 수로부터 점화식을 도출하고 점화식을 코드로 옮김

# n = int(input()) # 4
# arr = list(map(int, input().split())) # 1 3 4 5
n = 4
arr = [1,3,4,5]

d = [0] * 100 # 식량창고의 범위

# 첫번째 배열 순회지 n-2조건에서 에러날수 있으므로 최초할당
d[0] = arr[0]
d[1] = max(arr[0], arr[1])

for i in range(2, n): # 0,1번 배열의 값은 위쪽에서 이미 할당
    d[i] = max(d[i-1], d[i-2] + arr[i]) # 현재와 이전 최대식량을 비교

# N번째 창고까지 얻을수 있는 최대 식량
print(d[n-1]) # 배열 인덱스이므로 n-1
