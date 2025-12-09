arr = [0,1,2,0,2,1,1,0,1,2,0,0,2]
s = m = 0
e = len(arr) -1
while m <= e:
    if arr[m] == 0:
        arr[s], arr[m] = arr[m], arr[s]
        s+=1
        m+=1
    elif arr[m] == 1:
        m += 1
    else:
        arr[m], arr[e] = arr[e], arr[m]
        e -=1
