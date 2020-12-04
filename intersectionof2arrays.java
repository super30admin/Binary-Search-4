//Time complexity:O(nlogn) nlogn which will be the time taken to sort the biggest array.
//Space Complexity: O(N) ,the temp list in this case.
//Approach- Sorting the two lists and having two pointers, one for the first array and the other for the next. If the element pointed by the both the arrays are equal, add them to the list, otherwise, if the element piinted by the first pointer is less than the second, increment first, else increment the second. This loop will run until we reach the end of the smallest array.
//This code was executed successfully and got accepted in leetcode.
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> temp=new ArrayList<>();
        if(nums1.length==0||nums2.length==0){
            int[] output=new int[temp.size()];
            output=temp.stream().mapToInt(i->i).toArray();
            return output;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int j=0,k=0;
        while(j<nums1.length&&k<nums2.length){
            if(nums1[j]==nums2[k]){
                temp.add(nums1[j]);
                j++;
                k++;
            }
            else if(nums1[j]<nums2[k]){
                j++;
            }
            else{
                k++;
            }
        }
        int[] output=new int[temp.size()];
        output=temp.stream().mapToInt(i->i).toArray();
        return output;
    }
}