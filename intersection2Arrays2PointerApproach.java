//TC for sorted = O(mlogm)+O(nlogn)
//SC =O(1)
//amazon interview
//2 pointer approach consider two pointers p1 and p2 then move p2 because I'should make them equal both the array lists.then record the result in resultant list.If both are same modes then move parallely to check the exhausted appraoch the one of these arrays and match all the elements in one of these arrays ,I shoyd be stopping at this movement .If not given in sorted order these arrays ofcourse I will sort them.
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
       if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
           return new int[] {};
       } 
        //2 pointer solution
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n2<n1){
            return intersect(nums2,nums1);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> result = new ArrayList<>();
        int p1=0,p2=0;
        while(p1<n1 && p2<n2){
            if(nums1[p1] == nums2[p2]){
                result.add(nums1[p1]);
                p1++;
                p2++;
            }else if(nums1[p1]<nums2[p2]){
                p1++;
            }
            else{
                p2++;
            }
        }
        int[] answer = new int[result.size()];
        for(int i=0;i<result.size();i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}