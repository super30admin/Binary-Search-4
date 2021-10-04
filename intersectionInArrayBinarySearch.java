// Time Complexity: O(nlog(n)+log(k))
// Space: O(1)
// Idea here is to run binary search on larger array for each value of smaller
// if mid is found keep checking if it is first occurence of that number,
// when it is return mid else continue searching for first occurence
// if number is found add it to result and start low from the first index found +1
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        if(nums1 == null || nums2==null || nums1.length==0 || nums2.length==0) return new int[0];
        if(nums1.length>nums2.length) return intersect(nums2, nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int l = 0; int h = nums2.length-1;
        for(int i = 0; i< nums1.length; i++) {
            int bIndex = binarySearch(l, h, nums2, nums1[i]);
            if(bIndex != -1) {
                result.add(nums1[i]);
                l = bIndex+1;
            }
        }
        int[] arr = new int[result.size()];
        for(int i=0; i<result.size();i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }
    
    public int binarySearch(int l, int h, int [] nums2, int target) {
        while(l<=h) {
            int mid = l + (h-l)/2;
            if(nums2[mid] == target) {
                if(mid==l || nums2[mid] > nums2[mid-1]) {
                    return mid;
                } else {
                    h = mid-1;
                }
            } else if(nums2[mid] < target) {
                l = mid+1;
            } else {
                h = mid-1;
            }
        }
        return -1;
    }
}