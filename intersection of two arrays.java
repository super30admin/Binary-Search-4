//Timecomplexity:-O(log(m+n);
//Spacecomplexity:-O(m+n);
//Did it run on leetcode:- yes;
//What problems did you face?:got wrong answers initially.
//Your code with approach:- initially arrrays are sorted and added to temp arraylist by following two point approach.

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
      Arrays.sort(nums1);
      Arrays.sort(nums2);
      ArrayList<Integer> temp=new ArrayList<>();
      int i=0;
      int j=0;
      while(i<nums1.length && j<nums2.length){
          if(nums1[i]<nums2[j]){
              i=i+1;
          }
          else if(nums1[i]>nums2[j]){
              j=j+1;
          }
          else{
              temp.add(nums1[i]);
               i=i+1;
               j=j+1;
          }
      }
        int[] output=new int[temp.size()];
        for(int i1=0;i1<output.length;i1++){
            output[i1]=temp.get(i1);
        }
return output;}
}