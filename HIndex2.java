/*
Author: Akhilesh Borgaonkar
Problem: 275. Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher, 
	write a function to compute the researcher's h-index.
Approach: Scanning through the integer array of citations and returning the index as h if there are h integers after current index that are atleast
	equal to integer at current index h. Using iterative approach here.
Time complexity: O(n) where n is number of citations in the array.
Space complexity: O(n) where n is number of citations in the array.
Improvement: Using binary search I improved the time complexity to O(log n). Implemented this below iterative approach.
LC verified both.
*/

class Solution {
    public int hIndex(int[] citations) {
        //iterative brute force approach
        int N = citations.length;
        for(int i = 0; i < citations.length; i++){	//iterating over input integer array
            if(citations[i] >= N - i)				//checking if there are h integers ahead which are atleast equal to h
                return (N-i);
        }
        return 0;
    }
}


                
class Solution {
    public int hIndex(int[] citations) {
        //binary search approach
        int N = citations.length;
        int low = 0, high = N-1, mid = 0;

        while(low<=high){                   //not letting two pointers cross to avoid infinite loop
            mid = low + (high - low)/2;     //finding mid of current subset
            if(citations[mid] == N-mid)     //if h is found return h
                return (N-mid);
            
            if(citations[mid] > N-mid){     //if h is greater(or even if found) we look for smaller h
                high = mid - 1;
            }
        
            if(citations[mid] < N-mid){     //if h is smaller then look into upper subset of array
                low = mid + 1;
            }
            
            
        }
        return N - low;
    }
}