//problem1
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        if(n1>n2){
            return intersect(nums2,nums1);
        }
        List<Integer> res=new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int left=0,right=n2-1;
        for(int num:nums1){
            int id=binarysearch(nums2,num,left,right);
            if(id!=-1){
                res.add(num);
                left=id+1;
            }
        }
        int[] ans=new int[res.size()];
        for(int i=0;i<res.size();i++){
            ans[i]=res.get(i);
        }
        return ans;
    }
    public int binarysearch(int[] nums,int target,int left,int right){
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                if(mid==left||nums[mid-1]!=nums[mid]){
                    return mid;
                }else{
                    right=mid-1;
                }
            }else if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return -1;
    }
}
//problem2
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        if(n1>n2){
            return findMedianSortedArrays(nums2,nums1);
        }
        int left=0;
        int right=nums1.length;
        while(left<=right){
            int partx=left+(right-left)/2;
            int party=(n1+n2)/2-partx;
            int l1=partx==0?Integer.MIN_VALUE:nums1[partx-1];
            int l2=party==0?Integer.MIN_VALUE:nums2[party-1];
            int r1=partx==n1?Integer.MAX_VALUE:nums1[partx];
            int r2=party==n2?Integer.MAX_VALUE:nums2[party];
            if(l1<=r2 && l2<=r1){
                if((n1+n2)%2==0){
                    return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                }else{
                    return Math.min(r1,r2);
                }
            }else if(l2>r1){
                left=partx+1;
            }else{
                right=partx-1;
            }
        }
        return 8.00;
    }
}
