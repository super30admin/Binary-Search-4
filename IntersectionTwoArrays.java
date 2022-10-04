// Time Complexity : O(N)
// Space Complexity: O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach:
/*
Maintain freq map, put nums1 elements in map.
iterate over nums2, whenever found add to result and decrease freq.
finally convert arraylist to array
*/
public class IntersectionTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1==null || nums2==null || nums1.length*nums2.length==0) return new int[]{};
        //ensure always small array in hashmap to optimize space
        if(nums2.length<nums1.length) return intersect(nums2,nums1);

        HashMap<Integer,Integer> hm= new HashMap<>();
        ArrayList<Integer> result= new ArrayList<>();
        for(int num:nums1)
            hm.put(num,hm.getOrDefault(num,0)+1);

        for(int num:nums2){
            if(hm.containsKey(num) && hm.get(num)>0){
                result.add(num);
                hm.put(num,hm.get(num)-1);
            }
        }

        int[] res= new int[result.size()];
        int i=0;
        for(int num: result){
            res[i]=num;
            i++;
        }

        return res;
    }
}
