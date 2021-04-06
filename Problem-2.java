//Time Complexity :O(Max(n,m)log(Max(n,m)))
//Space Complexity :O(1)

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int p1=0;
        int p2=0;
        int n=nums1.length;
        int m=nums2.length;
        
        List<Integer> output = new ArrayList<>();
        
        while(p1<n && p2<m){
            if(nums1[p1] == nums2[p2])
            {
                output.add(nums1[p1]);
                p1++;
                p2++;
            }
            else if(nums1[p1] < nums2[p2])
            {
                p1++;
            }
            else{
                p2++;
            }
        }
        int[] result = new int[output.size()];
        for(int x=0; x<output.size(); x++){
            result[x] = output.get(x);
        }
        return result;
    }
}