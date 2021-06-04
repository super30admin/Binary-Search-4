class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int [] count = new int[1001];
        
        List<Integer> li = new ArrayList<>();
        // put elements of nums1 in count array
        for(int num : nums1){
            count[num]++;
        }
        for(int num : nums2){
            //if elements are present at index num, add to list
            if(count[num] > 0){
                li.add(num);
                count[num]--;
            }
        }
        int [] res = new int[li.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = li.get(i);
        }
        return res;
    }
}
