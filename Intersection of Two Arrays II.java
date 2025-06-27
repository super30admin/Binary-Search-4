Approach:
Iterate over the first array(smaller array) and search for thr element in the 2nd array(first occurance only)
if the element is found in 2nd array update the low index to mid+1 so we do not check the same element again

TC : m log n
m = lower size array
n = larger array

SC : O(1)

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 > n2)
            return intersect(nums2,nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res = new ArrayList<>();
        int low = 0;
        for(int i=0;i<n1;i++){
            int index = firstIndexSearch(nums1[i],nums2,low, n2-1);
            if(index != -1){
                low = index + 1;
                res.add(nums1[i]);
            }
        }

        int [] ans = new int[res.size()];
        for(int i =0; i < res.size();++i)
            ans[i] = res.get(i);

        return ans;
    }

    private int firstIndexSearch(int target , int[] arr, int low, int high){   
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == target){
                if(mid == low || arr[mid-1] != arr[mid])
                    return mid;
                else
                    high = mid -1;
            } else if(arr[mid] > target){
                high = mid-1;
            } else{
                low = mid + 1;
            }
        }
        return -1;
    }
}
