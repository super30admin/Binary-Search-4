//The idea here is to use Binary Search to find the h-index
//At each mid, we check if the difference between n and mid is equal to the value in array, if yes, that's the h-index, if difference is greater, then low goes to mid + 1, else high goes to mid - 1
//At the end when both low and high cross, then h-index will be at index low with value of diff there, which is n-low
//Time Complexity: O(log n)
//Space Complexity: O(1)
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int low = 0;
        int high = n-1;
        while(low <= high){
            int mid = low + (high - low)/2;
            int diff = n-mid;
            if(diff == citations[mid]){
                return diff;//just as linear case
            } else if(diff > citations[mid]){
                low = mid + 1;
            } else{
                high = mid - 1;
            }
        }
        return n - low; //whenever we cross, then h-index will be at index low which is n-low
    }
}
