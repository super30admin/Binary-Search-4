def medianOfTwoSortedArrays(arr1, arr2):
    l1 = len(arr1)
    l2 = len(arr2)
    if l1 > l2: return medianOfTwoSortedArrays(arr2, arr1)
    start = 0
    end = len(arr1) - 1
    while start <= end:
        p1 = (start + end) // 2
        p2 = (l1 + l2 + 1) // 2 - p1

        maxLeftX = float("-inf") if p1 == 0 else arr1[p1-1]
        minRightX = float("inf") if p1 == l1 else arr1[p1]

        maxLeftY = float("-inf") if p2 == 0 else arr2[p2-1]
        minRightY = float("inf") if p2 == l2 else arr2[p2]

        if maxLeftX <= minRightY and maxLeftY <= minRightX:
            #Found
            if (l1+l2) % 2 == 0:
                return (max(maxLeftX, maxLeftY) + min(minRightX, minRightY))/2
            else: return max(maxLeftX, maxLeftY)
        elif maxLeftX > minRightY:
            end = p1 - 1
        else:  start = p1 + 1


print(medianOfTwoSortedArrays([1,3,8,9,15],[7,11,18,19,21,25]))
print(medianOfTwoSortedArrays([0,2,3,5,11,19],[0,1,2,8,9,10]))
print(medianOfTwoSortedArrays([23,26,31,35],[3,5,7,9,11,16]))
        