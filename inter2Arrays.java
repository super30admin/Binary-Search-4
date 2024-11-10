//time O(m \log m + n \log n + m \log n)
//space O(1)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int leftIndex = 0;
        for(int num: nums1) {
            
            int index = binarySearch(nums2, num, leftIndex);
            if(index != -1){
                result.add(num);
                leftIndex = index + 1;
            }   
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
        
    //[4,4,15,99]

    //[4,4,9,9,15,99]
    private int binarySearch(int[] arr, int target, int left) {
        
        int index = -1;
        int right = arr.length-1;
        while(left <= right) {
            int mid = left + (right-left)/2;
            if(arr[mid] == target) {
                index = mid;
                right = mid -1;
            } else if(arr[mid] < target)  {
                left = mid + 1;
            } else if(arr[mid] > target)  {
                right = mid - 1;
            }
        }
        return index;
    }
}
