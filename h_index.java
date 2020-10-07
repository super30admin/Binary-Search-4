// TC: )(logn)
//SC: Constant time


class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int start = 0;
        int end = n;
        
        while(start < end){
            int mid = (start + end) / 2;
            // we try to find the first index which is such that the element at that index is greater than the total number of elements present after it
            // we apply binary search here to shrink the array to find the first index that satisifies the above property.
            if(citations[mid] > n - mid){
                end = mid;
            }else if(citations[mid] < n - mid){
                start = mid + 1;
            }else {
                return n - mid;
            }
        }
        //When you find start, from 0 to start - 1, they are smaller than h, from start to n - 1, they are larger than or equal to h.
        return n - start;
    }
}