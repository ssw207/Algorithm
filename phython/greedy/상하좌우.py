# 지도 크기 1 ~100
n = int(input())

# 최초 위치
x, y = 1, 1

# 이동 방향 L R U D
plans = input().split()

# 방향 백터
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]
move_types = ['L', 'R', 'U', 'D']

# 이동 계획 개수만큼 순회
for plan in plans: # 배열의 값을 순회
    # 이동계획 종류 개수만큼 순회
    for i in range(len(move_types)):
        # 이동계획과 일치하면 좌표세팅
        if plan == move_types[i]:    
            nx = x + dx[i]
            ny = y + dy[i]
            continue

    # 이동가능한 위친지 좌표검증
    if nx < 1 or ny < 1 or nx > n or ny > n:
        continue

    x = nx
    y = ny

print(x, y)


    

