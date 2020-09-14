# 입력값 : 알파벳 대문자, 숫자 0~9, 길이 10,000 이하
# 문제 : 알파벳을 오름차순으로 정렬한뒤 그 뒤에 모둔 숫자를더한값 출력
# 입력값의 알파벳, 숫자 분류
# 알파벳 정렬후 숫자합을 뒤에 붙인다

data = input()
result = []
value = 0

# 문자를 하나씩 확인
for x in data:
    # 알파벳 체크
    if x.isalpha():
        result.append(x)
    else:
        value += int(x)

# 알파벳 오름차순 정렬
result.sort()

# 숫자 있으면 붙이기
if value != 0:
    result.append(str(value))

#배열을 문자열로 출력
print(''.join(result))