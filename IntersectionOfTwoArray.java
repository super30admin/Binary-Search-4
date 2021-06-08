//Time:O(m+n+a)
//        where m= length of nums1
//              n = length of nums2
//              a = length of output array ans
//space: O(m)
// did it run successfully on leetcode: yes
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        //map to store count of unique values in nums1
        HashMap<Integer, Integer> map = new HashMap<>();
        //loop through nums1
        for(int i=0; i<nums1.length; i++){
            //add count of current value to map
            map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);

        }

        //list to store intersection
        List<Integer> res = new ArrayList<>();
        //loop through nums2 array
        for(int i=0; i<nums2.length; i++){
            //if there is an intersection
            if(map.containsKey(nums2[i])){
                //add value to result
                res.add(nums2[i]);
                //update count of value in map
                map.put(nums2[i], map.get(nums2[i])-1);
                //remove value if its count is 0
                map.remove(nums2[i], 0);
            }

        }
        //array to store output
        int[] ans = new int[res.size()];
        int j=0;
        //loop to list of intersections
        for(int val: res){
            //add to ans array
            ans[j]=val;
            j++;
        }
        return ans;
    }
}