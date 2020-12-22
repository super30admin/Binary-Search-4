class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // System.out.println(nums1.length+" "+nums2.length);
        if (nums1.length>nums2.length){
            return intersect(nums2, nums1);
        }
        
        HashMap<Integer,Integer> freq=  new HashMap();
        //enter smaller array in hashmap
        for( int num :nums1){
            freq.put(num,freq.getOrDefault(num, 0)+1 );
        }
        
        
        int k=0;
        // System.out.println(nums1.length+" "+nums2.length);
        
        for(int n :nums2){
            if (freq.containsKey(n)){
            int cnt =freq.getOrDefault(n,0);
            if (cnt>0){
                
                nums1[k]=n;
                k++;
                cnt--;
                freq.put(n,cnt);
            }
            }
            
        }
        
        
        return Arrays.copyOfRange(nums1, 0, k);
        
        
        
    }
}
