/*
    Time Complexity: O(mlogn) where m length of array1 and binarysearch on array2 logn
    Space Complexity:O(m) //shortest array
*/


class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
       // int p1=0; int p2=0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> li = new ArrayList<>();
        int index=0;
        for(int num : nums1){
            int bsIndex = binarySearch(nums2, num, index, nums2.length-1);
            if(bsIndex!=-1){
                li.add(num);
                index=bsIndex+1;
            }	
        }
            int []ar = new int[li.size()];
            for(int i=0;i<ar.length;i++){
                ar[i]=li.get(i);
            }
            return ar;
        }
    }

    public int binarySearch(int []nums, int target, int low, int high){
            while(low<=high){
                int mid=low + (high-low)/2;
                if(nums[mid]==target){
                    if(mid==low || nums[mid-1]<nums[mid]){
                        return mid;
            } else {
                high=mid-1;
                }
            } else {
            if(nums[mid]>target){
                high=mid-1;
            } else {
                low=mid+1;
                }
            }
        }
        return -1;
    }
}

