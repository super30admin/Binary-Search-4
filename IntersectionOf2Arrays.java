//TC = O(m+n)
//SC = O(1)
//Here we are using two pointer apporch. First we will sort both the list. then use two pointers to compare.
class IntersectionOf2Arrays{
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int m = nums1.length;
        int n = nums2.length;
        if(m>n) intersect(nums2, nums1);
        List<Integer> li = new List<Integer>();
        int p1 = 0;
        int p2 = 0;
        while(p1<m && p2<n){
            if(nums1[p1] == nums2[p2]){
                li.add(nums1[p1]);
            }
            else if(nums1[p1]<nums2[p2]){
                p1++;
            }else{
                p2++;
            }
        }
        int res = new int[li.size()];
        for(int i = 0; i<li.size(); i++){
            res[i] = li.get(i);
        }
        return res;
    }
}