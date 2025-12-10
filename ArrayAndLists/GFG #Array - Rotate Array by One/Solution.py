class Solution:
    def rotate(self, arr):
        s = 0
        e = len(arr) -1
        temp = arr[-1]
        # Looping till 1st element and not 0th, since we will manually put the temp value stored
        while e > s: 
            arr[e], arr[e-1] = arr[e-1], -1
            e -= 1
        arr[0] = temp
    return arr
