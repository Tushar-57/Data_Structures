def rotateArray(arr: list, k: int) -> list:
    def reverse(arr, s, e):
        while e > s:
            arr[s], arr[e] = arr[e], arr[s]
            s += 1
            e -= 1

    sizee = len(arr)
    
    # Handle cases where k is negative or larger than the array size
    k = k % sizee 
    
    # If no rotation is needed after normalization, return early
    if sizee == 0 or k == 0:
        return arr 

    # Apply the reversal algorithm
    reverse(arr, 0, k - 1)
    reverse(arr, k, sizee - 1)
    reverse(arr, 0, sizee - 1)
    
    # Return the modified array (optional if modifying in-place)
    return arr

