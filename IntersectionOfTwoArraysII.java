class IntersectionOfTwoArraysII {

    // Time Complexity: O(max(n,m) log max(n,m))    (where n -> length of array1 and m -> length of array2)
    // Therefore, time Complexity --> time required to sort the larger array
    // Space Complexity: O(1) 

    public int[] intersect(int[] nums1, int[] nums2) {
        // Edge Case Checking
        if(nums1 == null || nums1.length == 0 || nums2.length == 0 || nums2.length == 0)
            return new int[]{-1};
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int n = nums1.length;
        int m = nums2.length;
        
        int p1 = 0;
        int p2 = 0;
        List<Integer> result = new ArrayList<>();
        while(p1 < n && p2 < m){
            if(nums1[p1] == nums2[p2]){
                result.add(nums1[p1]);
                p1++;
                p2++;
            }else if(nums1[p1] < nums2[p2])
                p1++;
            else
                p2++;
        }
        
        int[] output = new int[result.size()];
        for(int i = 0; i < output.length; i++){
            output[i] = result.get(i);
        }
        return output;
    }
}