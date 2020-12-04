TC: O(n)
SC: O(n)

Runtime: 2 ms, faster than 92.25% of Java online submissions for Intersection of Two Arrays II.
Memory Usage: 37.6 MB, less than 53.23% of Java online submissions for Intersection of Two Arrays II.

Approach: Two pointer method. We first sort the arrays, then keep two pointers in bothe the arrays.When the values of current indices are 
same , it is added to the output array.If it is different, we will increase the index of lower value to reach till the higher 
value of the other array in its current index.

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
      Arrays.sort(nums1);
      Arrays.sort(nums2);
      List<Integer> returnList = new ArrayList<>();
      int i=0, j=0;
      while(i<= nums1.length-1 && j<= nums2.length-1){
          int val1  = nums1[i];
          int val2  = nums2[j];
          if( val1 == val2){
              returnList.add(val1);
              i++;
              j++;
          }
          else if(val1< val2){
              i++;
          }
          else{
              j++;
          }
      }
        int [] arr  = new int[returnList.size()];
    for(int k=0;k<returnList.size(); k++){
        arr[k]= returnList.get(k);
    }
    return arr;
    }
}
