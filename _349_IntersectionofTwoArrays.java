// Time Complexity : nlogn + mlogn + min(n,n)log(max(n,m)) here n and m are lengtn of arrays
// Space Complexity : o(1)

// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach
// for each element of of m array find its first find last Occurence in bigger array, if found discard that elemnt and all elements in left
  //for further consideration
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        List<Integer> res = new ArrayList<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int[] small = nums1.length<=nums1.length? nums1 : nums2;
        int[] big = nums1.length>nums1.length? nums1 : nums2;

        int start = 0;
        int end = big.length-1;

        for(int i=0; i<small.length; i++){
            int index = findLastOccurence(big, small[i], start, end);
            if(index != -1){
                start = index + 1;
                res.add(small[i]);
            }
        }

        return res.stream().mapToInt(i->i).toArray();

    }


    public int findLastOccurence(int[] nums, int target, int start, int end){

        int mid = start + (end-start)/2;

        while(start <= end){

            mid = start + (end-start)/2;

            if(start == mid){
                if(nums[end] == target) return end;
                else if(nums[start] == target) return start;
                else return -1;

            }
            else if(nums[mid] == target){
                start = mid;
            }
            else if(nums[mid] < target){
                start = mid + 1;
            }
            else{
                end = mid -1;
            }

        }

        return -1;

    }
}
