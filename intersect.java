// Time Complexity : n1logn2
// Space Complexity : O(min(n1,n2)) for result list
// n1 = nums1 array length n2 = nums2 array length
/* Approach : The approach used in your intersect function involves first sorting both input arrays and then using two pointers to 
traverse them. By comparing elements at the current positions of the pointers, the function identifies common elements and adds them 
to a result list. If the elements match, both pointers are incremented; otherwise, the pointer of the smaller element is incremented. 
Finally, the result list is converted to an array and returned.
*/

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        // If either array is empty, return null
        if (n1 == 0 || n2 == 0) return null;
        
        // Sort both arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i = 0;
        int j = 0;
        
        // List to store the intersection elements
        List<Integer> result = new ArrayList<>();
        
        // Traverse both arrays
        while (i < n1 && j < n2) {
            if (nums1[i] == nums2[j]) {
                // If elements are equal, add to result and move both pointers
                result.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                // Move pointer j if nums2[j] is smaller
                j++;
            } else {
                // Move pointer i if nums1[i] is smaller
                i++;
            }
        }
        
        // Convert the result list to an array
        int[] res = new int[result.size()];
        for (int k = 0; k < result.size(); k++) {
            res[k] = result.get(k);
        }
        
        return res;
    }
}
