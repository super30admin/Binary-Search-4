// Time Complexity : O(nlog n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :
// 	Difficult to figure out solution

// Your code here along with comments explaining your approach
class Solution {
  public int hIndex(int[] citations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int res = 0;
        for (int c : citations) {
            if (res <= c) {
                pq.offer(c);
            }
            while (!pq.isEmpty() && pq.peek() < pq.size()) {
                pq.poll();
            } 
            res = pq.size();
        }
        return res;
    }
}
