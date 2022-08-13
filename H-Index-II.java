// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No 

// Your code here along with comments explaining your approach

public int hIndex(int[] citations) {
    if(citations == null || citations.length == 0) return 0;
    
    int n = citations.length;

    for(int i=0;i<n;i++){
        if(citations[i] >= n-i){
            return n-i;
        }
    }      
    
    return 0;
}

// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No 

// Your code here along with comments explaining your approach
public int hIndex(int[] citations) {
    if(citations == null || citations.length == 0) return 0;
    
    int n = citations.length;
    int low=0;
    int high=n-1;
    
    while(low<=high){
        int mid = low + (high-low)/2;
        int papers = n-mid; // calculating the papers
        if(citations[mid]<papers){
            low=mid+1;
        }else{
            high=mid-1;
        }
    }
    
    return n-low;
}