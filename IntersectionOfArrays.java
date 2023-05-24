import java.util.*;
public class IntersectionOfArrays {
    // Binary search approach TC=O(nlogm) SC =O(1)
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1==null||nums2==null)return new int[0];
        if(nums1.length<nums2.length)return intersect(nums2,nums1);
        int m = nums1.length; // greater array
        int n = nums2.length; //smaller array
        List<Integer> li = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int low = 0;
        int high = m-1;
        for(int i=0;i<n;i++){
            int bindex = BinarySearch(nums1,low,high,nums2[i]);
            if(bindex!=-1){
                low=bindex+1;
                li.add(nums2[i]);
            }
        }
        int[] result = new int[li.size()];
        for(int i=0;i<li.size();i++){
            result[i] = li.get(i);
        }
        return result;

    }

    private int BinarySearch(int[] nums,int low,int high,int target){
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid] == target){
                // return the leftmost occurence of that value
                if(low==mid||nums[mid-1]<nums[mid]){
                    return mid;
                }
                else{
                    high = mid-1;
                }

            }
            else if(nums[mid]>target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }
}
