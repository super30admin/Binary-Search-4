
//  tc : O(m+n)
//  sc : O(min(m,n))

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n2>n1){
            return intersect(nums2, nums1);
        }
        int[] ans = new int[n2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums2){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        int i = 0;
        for(int num : nums1){
            if(map.containsKey(num)&&map.get(num)!=0){
                ans[i++]=num;
                map.put(num,map.get(num)-1);
            }
        }
        return Arrays.copyOfRange(ans,0,i);
    }
}
