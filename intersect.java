class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        if(nums1.length>nums2.length){
            return intersect(nums2,nums1);
        }

        HashMap<Integer,Integer> hmap = new HashMap<>();

        for(int i = 0; i < nums1.length;i++){
            if(!hmap.containsKey(nums1[i])){
                hm.put(nums1[i],1);
            }else{
                hmap.put(nums1[i],hm.get(nums1[i])+1);
            }
        }

        int k = 0;
        for(int i = 0; i<nums2.length; i++){
            if(hm.containsKey(nums2[i])){
                int cnt = hm.getOrDefault(nums2[i],0);
                if(cnt > 0){
                    nums1[k++] = nums2[i];
                    hm.put(nums2[i],cnt-1);
                }
            }
        }

        return Arrays.copyOf(nums1, k);
    }
}