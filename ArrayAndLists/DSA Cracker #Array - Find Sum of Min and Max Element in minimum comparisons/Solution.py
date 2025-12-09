arr = [1,2, 5,7,3, 9, 8]
sizee = len(arr)
s_p = 0
mini = maxi = 0
if sizee % 2 ==0:
    s_p = 2
    mini = min(arr[0], arr[1])
    maxi = max(arr[0], arr[1])
else:
    s_p = 1
    mini = maxi = arr[0]
    
for i in range(s_p, sizee, 2):
    if arr[i] > arr[i+1]:
        if arr[i] > maxi:
            maxi = arr[i]
        if arr[i+1] < mini:
            mini = arr[i+1]
    else:
        if arr[i+1] > maxi:
            maxi = arr[i+1]
        if arr[i] < mini:
            mini = arr[i]


print(maxi+mini)
