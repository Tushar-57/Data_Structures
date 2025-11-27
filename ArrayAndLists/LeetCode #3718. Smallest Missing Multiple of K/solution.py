My Solution:

class Solution:
    def missingMultiple(self, nums: List[int], k: int) -> int:
        temp = set(nums)
        for i in range(k, 1000, k):
            if i not in temp:
                return i
        return -1



-------
Better Solution:


class Solution:
    def missingMultiple(self, nums: List[int], k: int) -> int:
        i= 1
        while True:
            if k*i not in nums:
                return k*i
            i+= 1
