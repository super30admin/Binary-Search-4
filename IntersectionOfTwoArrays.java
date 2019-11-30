//Time Complexity :O(N1Log(N1)+N2Log(N2)).
//Space Complexity :O(1)
//Did this code successfully run on Leetcode :yes
//Any problem you faced while coding this :Nope


//Your code here along with comments explaining your approach

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        List<Integer> intersectionList = new ArrayList<>();
        while(i < nums1.length && j < nums2.length){
            if(nums1[i]<nums2[j]){
                i++;
            }else if(nums1[i] > nums2[j]){
                j++;
            }else{
                intersectionList.add(nums1[i]);
                i++;
                j++;
            }
        }
        int result[] = new int[intersectionList.size()];
        for(i = 0; i < intersectionList.size(); i++){
            result[i] = intersectionList.get(i);
        }
    return result;
    }
}