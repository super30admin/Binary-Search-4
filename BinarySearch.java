import java.util.*;
public class BinarySearch{
    /// time complexity : nlogn + mlogm + mlogn
    // space complexity : 1
    // did it run on leetcode : yes
    // any doubts : no
    // https://leetcode.com/problems/intersection-of-two-arrays-ii/
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        if(nums1.length>nums2.length) intersect(nums2,nums1);
        int low = 0;
        int high = nums2.length-1;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for(int i =0;i<nums1.length;i++){
            int bsindex = binarySearch(nums2,low,high,nums1[i]);
            if(bsindex != -1){
                result.add(nums2[bsindex]);
                low = bsindex +1;
            }
        }
        int[] arr = new int[result.size()];
        for(int i =0;i<arr.length;i++){
            arr[i]= result.get(i);
            
        }
        return arr;
    }
    
    private int binarySearch(int[] num, int low, int high , int target){
        
        while(low <= high){
            int mid = low + (high - low)/2;
            if(num[mid] == target){
                if(mid == low || num[mid]>num[mid-1]){
                    return mid;
                }else{
                    high = mid-1 ;
                }
            }else if ( num[mid]> target){
                high = mid-1;
            }else{
                low = mid + 1;
            }
            
        }
        return -1;
    }

     /// time complexity : log(n1)
    // space complexity : 1
    // did it run on leetcode : yes
    // any doubts : no
    // https://leetcode.com/problems/median-of-two-sorted-arrays/submissions/
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0 && nums2.length ==0) return 0.00;
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 > n2) return findMedianSortedArrays(nums2,nums1);
        
        int low = 0;
        int high = n1;
        while(low <= high){
            int partx = low + (high - low)/2;
            int party = (n1+n2)/2 - partx;
            
            double l1 = partx == 0 ? Integer.MIN_VALUE : nums1[partx-1];
            
            double r1 = partx == n1 ? Integer.MAX_VALUE : nums1[partx];
            
            double l2 = party == 0 ? Integer.MIN_VALUE : nums2[party-1];
            
            double r2 = party == n2 ? Integer.MAX_VALUE : nums2[party];
            if(l1 <= r2 && l2 <= r1){
                if((n1+n2)%2 ==0){
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2;
                }else{
                    return Math.min(r1,r2);
                }
            }else if(l1 > r2){
                high = partx-1;
            }else{
                low = partx + 1;
            }
        }
        return 0;
    }
}