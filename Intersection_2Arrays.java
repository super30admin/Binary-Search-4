/**
 *Brute Force: check each ele in the other ele O(m*n)
 *HashMap<number, count> -- m+n
 * 2 ptrs: O(max(mlogm,nlogn))
 */
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int p1 = 0,p2 =0;
        List<Integer> res = new ArrayList<Integer>();
        int[] retres;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while(p1<nums1.length && p2<nums2.length){
            if(nums1[p1] == nums2[p2]){
                res.add(nums1[p1]);
                p1++;
                p2++;
            }else if(nums1[p1] < nums2[p2])
                p1++;
            else p2++;
        }
        retres = new int[res.size()];
        for(int i=0;i<res.size();i++)
            retres[i] = res.get(i);
        return retres;
    }
}