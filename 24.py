#!/usr/bin/python3
# -*- coding: utf-8 -*-
# author: ❤ ❤ Yihao Wang ❤ ❤

while True:
    nums = []
    data = input("Please input 4 whole numbers:\n")
    data = data.split()
    if len(data) != 4:
        print("Invalid input!\n")
        continue
    try:
        for n in data:
            nums.append(int(n))
        break
    except:
        print("Invalid input!\n")
nums = list(map(str, nums))
ans = []
ops = ['+', '-', '*', '/']
for i in range(4):
    for j in range(4):
        for k in range(4):
            ans.append(''.join(['((', nums[0], ops[i], nums[1], ')', ops[j], nums[2], ')', ops[k], nums[3]]))
            ans.append(''.join(['(' , nums[0], ops[i], '(', nums[1], ops[j], nums[2], '))', ops[k], nums[3]]))
            ans.append(''.join(['(' , nums[0], ops[i], nums[1], ')', ops[j], '(', nums[2], ops[k], nums[3], ')']))
            ans.append(''.join([nums[0], ops[i], '((', nums[1], ops[j], nums[2], ')', ops[k], nums[3], ')']))
            ans.append(''.join([nums[0], ops[i], '(' + nums[1], ops[j],'(', nums[2], ops[k], nums[3], '))']))
res = []
for i in range(len(ans)):
    try:
        r = eval(ans[i])
        res.append(r)
    except:
        res.append(0)
count = 0
for i in range(len(res)):
    if res[i] == 24:
        count += 1
        print("solution {}: {}\n".format(count, ans[i]))
if count == 0:
    print("No possible solution\n")
