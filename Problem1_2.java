//Time Complexity: O(m*log(m)) + 0(n*log(n)) + O(m+n); where m is the length of nums1 and n is the length of nums2.
//Space Complexity: O(i); where i is the no. of elements in the intersection.
//Code run successfully on LeetCode.

public class Problem1_2 {

    public int[] intersect(int[] nums1, int[] nums2){
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> result = new ArrayList<>();
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        int p1 = 0;
        int p2 = 0;
        
        while( p1 < n1 && p2 < n2){
            
            if(nums1[p1] < nums2[p2])
                p1++;
            
            else if(nums2[p2] < nums1[p1])
                p2++;
            
            else{
                result.add(nums1[p1]);
                p1++;
                p2++;
            }
        }
        
        int n = result.size();
        int[] res = new int[n];
        
        for(int i =0; i < n; i++)
            res[i] = result.get(i);
        
        return res;
    }
}
