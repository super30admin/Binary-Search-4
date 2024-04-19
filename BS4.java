//time complexity log(mn) and space O(1)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1==null || nums2==null) return 0.0;
        int n = nums1.length;
        int m = nums2.length;

        if(n>m) return findMedianSortedArrays(nums2,nums1);

        int low =0;
        int high = n;

        while(low<=high){
            int partX = low + (high-low)/2;
            int partY = (n+m)/2 - partX;
            double L1 = partX==0?Integer.MIN_VALUE:nums1[partX-1];
            double L2 = partY==0?Integer.MIN_VALUE:nums2[partY-1];
            double R1 = partX==n?Integer.MAX_VALUE:nums1[partX];
            double R2 = partY==m?Integer.MAX_VALUE:nums2[partY];

            if(L1<=R2 && L2<=R1){
                if((n+m)%2==0){
                    double max = Math.max(L1,L2);
                    double min = Math.min(R1,R2);
                    return (max + min)/2;
                }else{
                    double min = Math.min(R1,R2);
                    return min;
                }
            }else if(L1>R2){
                high = partX-1;
            }else{
                low = partX+1;
            }
        }
        return 7.9;
        
    }
}

//time complexity nlogn and space O(1)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
         int n = nums1.length;
        int m = nums2.length;

        if(n>m) intersect(nums2,nums1);

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> li = new ArrayList<>();
        int low =0;
        int high = m-1;
        for(int i=0;i<n;i++){
            int bsIdx = binarySearch(nums2, low, high, nums1[i]);
            if(bsIdx!=-1){
                li.add(nums1[i]);
                low = bsIdx+1;
            }
        }

        int[] res = new int[li.size()];
        for(int i=0;i<li.size();i++){
            res[i] = li.get(i);
        }

        return res;
        
    }

    public int binarySearch(int[] nums, int low, int high, int target){
        
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                if(mid==low || nums[mid]>nums[mid-1]){
                    return mid;
                }else{
                    high = mid-1;
                }
                
            }else if(nums[mid]>target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }
}
