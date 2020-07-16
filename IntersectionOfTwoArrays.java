class Solution {
    // Time Complexity : O(N1+N2)  N1: first array size; N2:second array size
// Space Complexity : O(largest of N1 and N2)  list and hashMap size in worst case
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


 // Your code here along with comments explaining your approach
 /* 
 Bruteforce
 1. Maintain num and count of it in a hashMap of one array.
 2. Now iterate through other array and find if it exist in HashMap.
 */
    public int[] intersect(int[] nums1, int[] nums2){
        if(nums1.length == 0 || nums2.length==0) return new int[0];
        List<Integer> list = new ArrayList<Integer>();
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int i =0 ; i<nums1.length; i++){
            if(!hm.containsKey(nums1[i])){
                hm.put(nums1[i], 1);
            }
            else{
                hm.put(nums1[i], hm.get(nums1[i])+1);
            }
        }
        for(int i =0;i<nums2.length; i++){
            if(hm.containsKey(nums2[i])){
                list.add(nums2[i]);
                hm.put(nums2[i], hm.get(nums2[i])-1);
                if(hm.get(nums2[i])==0){
                    hm.remove(nums2[i]);
                }
            }
        }
        Object[] arr = list.toArray();
        int[] result = new int[arr.length];
        for(int i =0 ; i<arr.length; i++){
            result[i] = (int)arr[i];
        }
        return result;
    }
}




class Solution {
        // Time Complexity : O(N1logN1 + N2logN2)  N1: first array size; N2:second array size
// Space Complexity : O(largest of N1 and N2)  list size in worst case
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

 // Your code here along with comments explaining your approach
 /* 
 Two-Pointers
 1. Sort the arrays.
 2. Maintain two pointers at start of each array.
 3. Now if compare two elements of each array and increment the pointer.
 */

    public int[] intersect(int[] nums1, int[] nums2){
        if(nums1.length == 0 || nums2.length==0) return new int[0];
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0; int p2 =0;
        while(p1 != nums1.length && p2 != nums2.length){
            if(nums1[p1] == nums2[p2]){
                list.add(nums1[p1]);
                p1++;
                p2++;
            }
            else if(nums1[p1] < nums2[p2]){
                p1++;
            }
            else{
                p2++;
            }
        }
        Object[] arr = list.toArray();
        int[] result = new int[arr.length];
        for(int i =0 ; i<arr.length; i++){
            result[i] = (int)arr[i];
        }
        return result;
    }
}




