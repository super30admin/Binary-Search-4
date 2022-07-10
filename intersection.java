class Solution {
    //Time complexity: O(mlogn)
    //Space complexity: O(1)
    public int[] intersect(int[] nums1, int[] nums2) {
        int m=nums1.length,n=nums2.length;
        if(m>n)
            return intersect(nums2,nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> li=new ArrayList<>();
        int l=0,h=n-1;
        for(int i=0;i<m;i++){
            int bi=binarySearch(nums2,nums1[i],l,h);
            if(bi!=-1){
                li.add(nums1[i]);
                l=bi+1;
            }
        }
        int[] res=new int[li.size()];
        for(int i=0;i<li.size();i++){
            res[i]=li.get(i);
        }
        return res;
    }
    private int binarySearch(int[] nums1,int target,int l,int h){
        while(l<=h){
            int m=l+(h-l)/2;
            if(nums1[m]==target){
                if(m==l || nums1[m]!=nums1[m-1]){
                    return m;
                }
                else
                    h=m-1;
            }
            else if(nums1[m]>target)
                h=m-1;
            else
                l=m+1;
        }
        return -1;
    }
}