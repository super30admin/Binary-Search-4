// Time Complexity : O(  n log n) n = elements in array nums1 or if m>n O(m log m) , m = elements in array nums2. 
 
// Space Complexity : O(1) or O(k ) using the response list of size k, worst case k == to length of smallest array.


// Did this code successfully run on Leetcode :yes. 

// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//  do a binary search and recursion ;

//Runtime: 2 ms, faster than 98.44% of Java online submissions for Intersection of Two Arrays II.
//Memory Usage: 39.5 MB, less than 77.52% of Java online submissions for Intersection of Two Arrays II.
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int pt1=0;
        int pt2=0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> resp= new ArrayList<>();
        while ( (pt1 <nums1.length) && (pt2<nums2.length)){
            if (nums1[pt1]==nums2[pt2]){
                resp.add(nums1[pt1]);
                pt1++;
                pt2++;
            }else if (nums1[pt1]>nums2[pt2]){
                pt2++;
            }else{
                pt1++;
            }
        }
        
        //how to pass array list to array.
       int[] ans= new int[resp.size()];
        for (int i=0;i<resp.size(); i++){
            ans[i]=resp.get(i);
        }
        return ans;
    }
}