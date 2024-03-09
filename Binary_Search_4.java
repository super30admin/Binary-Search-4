//1st Intersection of 2 linked List
//Time Complexity- > O(nlogn)
//Space Complexity - > O(nlogn)
class Solution {
    //Using Binary Search 
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> li = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int low = 0;
        int high = nums2.length-1;
        for(int i = 0 ;i <nums1.length;i++){
            int bsIndex = searchBinarySearchIndex(nums2,low,high,nums1[i]);
            if(bsIndex!=-1){
                li.add(nums1[i]);
                low = bsIndex + 1;
            }
        }
        int[] result = new int[li.size()];
        for(int i = 0 ;i<li.size();i++){
            result[i] = li.get(i);
        }
        return result;
    }

    private int searchBinarySearchIndex(int[] nums,int low,int high,int target){
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == low || nums[mid]>nums[mid-1]){
                    return mid;
                }else{
                    high = mid - 1;
                }
            }else if(nums[mid]>target){
                    high = mid - 1;
            }else{
                    low = mid + 1;
            }
            
        }
        return -1;
    }
}

//2nd Median of 2 sorted arrays
//Time Complexity -> O(logn)
//Space Complexity - > O(1)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null && nums2 == null) return 0.0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 > n2) return findMedianSortedArrays(nums2, nums1); //we will invert the arrays 
        int low = 0;
        int high = n1 - 1 + 1; //this is because we are dealing with partititons
        while(low <= high){
            int partX = low + (high - low)/2;
            int partY = (n1 + n2)/2 - partX;
            double l1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            double l2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            double r1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX +1 -1];
            double r2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY + 1-1];
            if(l1 <= r2 && l2 <=r1){
                //we found the median
                if((n1 + n2)%2!=0){
                    //it is odd elements
                    return Math.min(r1,r2);
                }else{
                    return (Math.max(l1, l2)+Math.min(r1,r2))/2;
                }
            }else if(l2 >r1){
                low = partX + 1;
            }else{
                high = partX - 1;
            } 
        }
         
        return 2.00000;
    }
    
}