class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return intersect(nums2,nums1);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res = new ArrayList<>();
        int low = 0;
        int slow=0;
        int high = nums2.length-1;
        int shigh=nums2.length-1;
        for(int num:nums1){
            low=slow;
            high=shigh;
            while(low<=high){
                int mid = low + (high - low)/2;
                if(nums2[mid]==num){
                    if(low==mid || nums2[mid]!=nums2[mid-1]){
                        res.add(num);
                        slow=mid+1;
                        break;
                    }
                    else{
                        high=mid-1;
                    }

                }
                else if(nums2[mid]>num){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }
        }
        int[] ans = new int[res.size()];
        for(int i=0;i<res.size();i++){
            ans[i]=res.get(i);
        }
        return ans;
    }
}
