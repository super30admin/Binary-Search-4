class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        List<Integer> ans = new ArrayList<Integer>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        
        for(int i=0, j=0; i<nums1.length && j<nums2.length; ){
            
               
                if(nums1[i] == nums2[j]){
                    ans.add(nums1[i]);
                    i++;
                    j++;
                }else if(nums1[i] < nums2[j]){
                    i++;
                }else{
                    j++;
                }
               
        }
        
        int[] l = new int[ans.size()];
        int i=0;
        for(Integer k: ans){
            l[i++] = k;
        }
   

     return l;
    }
}
//SC=(n)
//TC=O(nlogn)
//sorted two arrays and traversed them to find the intersecting elements
