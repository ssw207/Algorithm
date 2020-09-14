# 거스름돈을 가장 적은 동전의 개수로 거슬러주기
# 동전의 종류가 K일때 시간복잡도는 O(K)
# 동전의 종류가 하나 늘어날때마다 알고리즘의 순회 횟수가 1씩증가 하기때문

# 거슬러줘야할 잔돈
money = 1260
# 돈전수
count = 0

# 상위동전은 하위 동전의 배수여야 한다
arr = [500, 100, 50, 10]

# 큰 동전 부터 몆개씩 거슬러줄수있는지 체크
for coin in arr: # 동전을 하나 꺼낸다
    count += money # coin # 몆개 동전을 거슬러 줄 수 있는지 샌다
    money %= coin # 거슬러주고 남은 돈을 구한다
    print(money, count)

print(count) # 거슬러준 동전수
