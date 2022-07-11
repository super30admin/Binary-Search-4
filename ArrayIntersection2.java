public class ArrayIntersection2 {
    // TC is O(m+n) where m and n are array lengths respectively
    // SC is O(m) length of smaller array
    public int[] intersect(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        if(l1>l2) return intersect(nums2, nums1);
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<l1;i++){
            map.put(nums1[i], map.getOrDefault(nums1[i],0)+1);
        }
        
        for(int i=0; i< l2;i++){
            if(map.containsKey(nums2[i])){
                result.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i])-1);
                map.remove(nums2[i],0);
            }
        }
        int[] inter = new int[result.size()];
        for(int i=0; i< result.size(); i++){
            inter[i]=result.get(i);
        }
        return inter;
    }
}
