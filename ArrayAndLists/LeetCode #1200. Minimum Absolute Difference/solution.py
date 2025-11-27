My Solution:

class Solution:
    def minimumAbsDifference(self, arr: List[int]) -> List[List[int]]:
        minDiff = float('inf')
        arr.sort()

        for i in range(len(arr)-1):
            current_diff = arr[i+1] - arr[i]
            if current_diff < minDiff:
                minDiff = current_diff
        res = []
        
        for i in range(len(arr)-1):
            if arr[i+1] - arr[i] == minDiff:
                    res.append([arr[i],arr[i+1]])
        print(res)
        return res




-------
Better Solution:

class Solution:
    def minimumAbsDifference(self, arr: List[int]) -> List[List[int]]:
        sort_arr = sorted(arr)
        min_diff = sort_arr[1] - sort_arr[0]
        result = [[sort_arr[0], sort_arr[1]]]
        
        for i in range(1, len(sort_arr) - 1):
            a = sort_arr[i]
            b = sort_arr[i+1]
            diff = b - a

            if diff < min_diff:
                min_diff = diff
                result = [[a, b]]
            
            elif diff == min_diff:
                result.append([a, b])
                
        return result
