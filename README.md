# Binary-Search-4



## Problem1 
Intersection of Two Arrays II (https://leetcode.com/problems/intersection-of-two-arrays-ii/)
//Time Complexity: O (m log n) where n is huge, m is small
//Space Complexity: O(min(m,n)) - common elements are stored in a linked list 
class Solution {
    private int binarySearch(int[] arr, int low, int high, int target)
    {
        while(low <= high)
        {
            int mid = low + (high-low)/2;
            if(arr[mid] == target && (mid == low || arr[mid] > arr[mid-1]))
            {
                return mid;
            }
            else if (arr[mid] >= target)
            {
                 high = mid-1;
            }
            else
            {
                low = mid + 1;
            }
        }
        
        return -1;
    }
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null) return new int[0];
        List<Integer> l1 = new ArrayList<Integer>();
        if(nums1.length> nums2.length) return intersect(nums2, nums1);
        int index=0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for(int i=0; i< nums1.length ; i++)
        {
            //search for this element in the second array
            int target = nums1[i];
            int result = binarySearch(nums2, index, nums2.length-1, target);
            if(result!=-1)
            {
                l1.add(target);
                index = result +1;
            }
           
        }
       int result_arr[] = new int[l1.size()];
       int k=0;
       for(int elem: l1)
       {
           result_arr[k] = elem;
           k++;
       }
        
        return result_arr;
    }
}



## Problem2
Median of Two Sorted Arrays (https://leetcode.com/problems/median-of-two-sorted-arrays)
//Time Complexity: O(log n) - n= size of smaller array
//Space Complexity: O(1)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length ==0 && nums2.length == 0) return 0.0;
        int n1 = nums1.length; 
        int n2 = nums2.length;
        //we always perform binary search on the smallest array
        if(n1 > n2)return findMedianSortedArrays(nums2, nums1);
        //binary search on the smaller array partitions
        int high = n1;
        int low = 0;
        while(low <=high)
        {
            //take two partitions 
            int partitionX = low + (high-low)/2;
            int partitionY = (n1+n2)/2 - partitionX;
            
            //values needed to check if condition one is satisfied i.e. L1 < R2
            double l1 = partitionX == 0?Integer.MIN_VALUE:nums1[partitionX-1];
            double r2 = partitionY == n2?Integer.MAX_VALUE:nums2[partitionY];
            //values needed to check if condition two is satisfied i.e. L2 < R1
            double l2 = partitionY == 0?Integer.MIN_VALUE:nums2[partitionY-1];
            double r1 = partitionX == n1?Integer.MAX_VALUE:nums1[partitionX];
            
            //condition check 
            if(l1 <= r2  && l2 <= r1)
            {
                //aha! found the correct partition 
                //1. if n1+n2 is odd
                if((n1+n2)%2 != 0)
                {
                    //take the smallest element from the right partitions of both arrays 
                    return Math.min(r1, r2);
                }
                else
                {
                   //2. if n1+n2 is EVEN! then take the average of the middle two elements 
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2;
                }
            }
            else if(l1 > r2 )
            {
                //sadly, correct partition  not found - first condition check failed! :(
                high = partitionX -1;
                
            }else 
            {
                // sadly, correct partition  not found - second condition check failed! :(
                low = partitionX + 1;
            }
        }
        return -1;
    }
}