class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
    if (nums1.length > nums2.length){
        int [] t =nums1;
        nums1 = nums2;
        nums2 =t;
    }

    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int i   =0;
    List<Integer> a = new ArrayList<>();
    for(int n : nums1){
        
        while (i< nums2.length-1 &&   n > nums2[i] ){
        

        ++i;
    }
    if(i< nums2.length && n == nums2[i]){
    
            // while(i != 0 && nums2[i] == nums2[i-1] &&  i!= nums2.length-1){
            //     --i;
            // }
            a.add(n);
            // if(i< nums2.length-1){
            ++i;
    }}
    int[] aa = new int[a.size()];
    for(int m = 0; m<a.size(); ++m){
        aa[m] = a.get(m);
    }

    return aa;}
}
//tc=O(m+n)
//sc=O(m+n)
