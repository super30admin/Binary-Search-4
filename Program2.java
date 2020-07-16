//Time Complexity : O(m+n)
//Space Complexity : O(n)

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
      int size1 = nums1.length;
      int size2 = nums2.length;
      int index=0;
      Set<Integer> numSet = new HashSet<>();
     
    
     if(size1 > 0 && size2> 0){
         
         for(int i=0; i<size1; i++){
             numSet.add(nums1[i]);
         }
         
         for(int i=0; i<size2; i++){
             if(numSet.contains(nums2[i])){
                nums1[index] = nums2[i];
                index++;
                 numSet.remove(nums2[i]);
             }
         }
         
         
         
         
     }
        
    return Arrays.copyOf(nums1,index);
       
        
        
    }
    
   
}