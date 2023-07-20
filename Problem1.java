// Time Complexity : O(n1*logn2)
// Space Complexity : O(1)


class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1>n2)
            return intersect(nums2, nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int startIdx = 0;
        List<Integer> li = new ArrayList<>();
        for(int i=0;i<n1;i++){
            System.out.println(nums1[i]);
            int idx = binarySearch(nums2,startIdx, n2-1,nums1[i]);
            if(idx!=-1){
                startIdx = idx+1;
                li.add(nums1[i]);
            }
        }
        int size = li.size();
        int[] res = new int[size];
        for(int i=0;i<size;i++)
            res[i] = li.get(i);
        return res;
    }
    private int binarySearch(int arr[], int low, int high, int target){
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]==target)
                if(mid==low || arr[mid]!=arr[mid-1])
                    return mid;
                else
                    high = mid-1;
            else if(arr[mid]>target)
                high = mid-1;
            else
                low = mid+1;

        }
        return -1;
    }
}