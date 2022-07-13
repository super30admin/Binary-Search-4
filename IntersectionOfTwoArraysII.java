//Time Complexity=O(nlogm)
//Space Complexity=O(n)
public class IntersectionOfTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {

        if(nums1.length>nums2.length) return intersect(nums2,nums1);
        int n=nums1.length;
        int m=nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int low=0,high=m-1;
        List<Integer> li=new ArrayList<>();
        for(int i=0;i<n;i++){
            int binaryIndex=binarySearch(nums2,low,high,nums1[i]);
            if(binaryIndex!=-1){
                li.add(nums1[i]);
                low=binaryIndex+1;
            }
        }

        int[] result=new int[li.size()];

        for(int i=0;i<result.length;i++){
            result[i]=li.get(i);
        }
        return result;
    }

    private int binarySearch(int[] nums,int low,int high,int target){

        while(low<=high){
            int mid=low+(high-low)/2;

            if(nums[mid]==target){
                if(mid==low || nums[mid]!=nums[mid-1]){
                    return mid;
                }else{
                    high=mid-1;
                }
            }else if(nums[mid]>target){
                high=mid-1;
            }else if(nums[mid]<target){
                low=mid+1;
            }
        }

        return -1;
    }
}
