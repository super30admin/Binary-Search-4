// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Use of minHeap and maxHeap 
class Solution {
    Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    Queue<Integer> minHeap = new PriorityQueue<>();
    
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        for(int n: nums1){
            add(n);
        }
        for(int n: nums2){
            add(n);
        }
        
        if(maxHeap.size() == minHeap.size()){
            return (maxHeap.peek() + minHeap.peek())/2.0;
        }else{
            return (double) (maxHeap.peek() * 1.0);
        }
        
    }
    
    private void add(int n){
        if(maxHeap.isEmpty()){
           maxHeap.add(n); 
        }else if(maxHeap.size() > minHeap.size()){
            if(n > maxHeap.peek() ){
                minHeap.add(n);
            }else{
                maxHeap.add(n);
                minHeap.add(maxHeap.remove());
            }
        }else{
             if(n > minHeap.peek() ){
                minHeap.add(n);
                maxHeap.add(minHeap.remove());
            }else{
                maxHeap.add(n);
            }
        }
    }
}