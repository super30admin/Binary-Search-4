/*
This solution uses binary search on sorted arrays to solve the problem. It goes over each element in the first 
array(which is the smaller) and searches for it in the second array. Each time it finds the element in the second 
array, it adds it to the intersection array, and thus builds the solution.
This problem can also be solved using HashMaps with unsorted arrays in O(m+n) time

Did this code run on leetcode: Yes
*/
class Solution {
    //Time Complexity: O(mlog(n))
    //Space Complexity: O(1)
    public int[] intersect(int[] nums1, int[] nums2) {
    
    if(nums1.length > nums2.length)
        return intersect(nums2, nums1);
        
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    List<Integer> li = new ArrayList<>();
    
    int low = 0;
    int high = nums2.length - 1;
        
    for(int i = 0; i < nums1.length; i++)
    {
        int bsIndex = binarySearch(nums2, low, high, nums1[i]);
        if(bsIndex != -1)
        {
            li.add(nums1[i]);
            //We reduce the search space such that if there are duplicate elements, we only search ahead of the
            //index we find the intersection element at, so as to not cause false intersections in the result array.
            low = bsIndex + 1;
        }   
    }
        
    int[] result = new int[li.size()];
        
    for(int i = 0; i < result.length; i++)
        result[i] = li.get(i);
    
    return result;
    }
    //We use a modified binary search wherein we return the first occurence of the target element, incase of dunplicate elements
    int binarySearch(int nums[], int low, int high, int target)
    {
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            
            if(nums[mid] == target)
            {
                if(mid == low || nums[mid] != nums[mid - 1])
                    return mid;
                else
                    high = mid - 1;
            }
            else if(nums[mid] < target)
            {
                low = mid + 1;
            }
            else
                high = mid - 1;
        }
        
        return -1;
    }
}