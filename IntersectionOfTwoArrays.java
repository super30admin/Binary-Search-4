/*
    L.C 350. Intersection of Two Arrays II

    Approach: Array Sorting and Binary Search

    Time Complexity:O(m log m + n log n) O(m log n) +
    Space Complexity: O(min(m, n)) //worst case if all elements are in the intersection for one array

 */
class IntersectionOfTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {

        if( nums1 == null || nums2 == null) {
            return null;
        }

        int m = nums1.length;
        int n = nums2.length;

        if(m<n) {
            intersect(nums2, nums1);
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int low = 0;
        int high = n-1;
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<m;i++) {

            int val = nums1[i];

            int bs = binarySearch(nums2, low, high, nums1[i]);

            if(bs!=-1){
                res.add(nums1[i]);
                low = bs +1; //setting the search range bs +1 to avoid picking up the same index for same element
            }
        }

        int[] resArr = new int[res.size()];

        for(int i=0;i<res.size(); i++) {

            resArr[i] = res.get(i);
        }

        return resArr;
    }

    private int binarySearch(int[] nums, int low, int high, int target) {


        while(low<=high) {


            int mid = low +(high-low)/2;

            if(nums[mid] == target) {
                //for finding the first occurance of the element
                if(mid == low || nums[mid-1]!=target) {
                    return mid;
                }
                high = mid -1;
            }
            else if(nums[mid] < target) { //if target is greater then it willbe on the right side
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        return -1;
    }
}
