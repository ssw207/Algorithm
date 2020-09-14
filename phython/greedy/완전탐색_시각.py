# 시간H를 입력 받는다
# 00시00분00초 ~ H시00분00초까지
# 3이 하나라도 있는 숫자 구하기

# 시간 입력받기
h = int(input());

# 3이 있는 시간 개수
count = 0;

# 전체 경우의 수
print(24*60*60)

# 입력받은 시간까지의 모든 경우의수 
for i in range(h + 1): # 시
    for j in range(60): # 분
        for k in range(60): # 초
            if '3' in str(i) + str(j) + str(k): # '시분초'에 '3'이있으면 카운트
                count += 1

print(count)