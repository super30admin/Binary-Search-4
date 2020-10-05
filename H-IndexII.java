//Steps
//1-Do Binary Search
//Calculate h_index
//Compare element equals h_index
//Else move accordingly
//Time Complexity- O(logn)
//Space Complexity-O(1)
class Solution {
    public int hIndex(int[] citations) {
        int length=citations.length;
        int low=0;
        int high=length-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int hIndex=length-mid;
            if(hIndex==citations[mid])
            {
                return hIndex;
            }
            else if(hIndex>citations[mid])
            {
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return length-low;
        
    }
}