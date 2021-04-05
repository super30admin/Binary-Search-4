// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//create a hashmap with the ele and its freq for 1st array
//loop through the second array and check if it exists in the hashmap, if so, check if the freq is 0 or not
//if it is then move to next step, else add to the output list and decrease the freq by 1
//connvert the list to array to return

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res=new ArrayList<>();
        HashMap<Integer, Integer> hm=new HashMap<>();
        for (int i=0;i<nums1.length;i++){
            hm.put(nums1[i],hm.getOrDefault(nums1[i],0)+1);
            }
        for(int j=0;j<nums2.length;j++){
            
            if(hm.containsKey(nums2[j])){
                if(hm.get(nums2[j])==0){
                    continue;
                }
                hm.put(nums2[j],hm.get(nums2[j])-1);
                res.add(nums2[j]);
            }
        }
        int[] out=new int[res.size()];
        for(int k=0;k<res.size();k++){
            out[k]=res.get(k);
        }
        return out;
        }
}