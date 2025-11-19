/**
 * @author Aditya Sinha
 * Use hashmap
 * Time Complexity - O(m+n)
 * Space Complexity - O(1)
 */
public class MedianSortedArrays {

	 public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	        int m = nums1.length, n = nums2.length;
	        int totalLen = m + n;
	        int mid = totalLen / 2;
	        
	        int p1 = 0, p2 = 0, count = 0;
	        int prev = 0, curr = 0;
	        
	        while (count <= mid) { // until we reach mid
	            prev = curr;
	            
	            if(p1 < m && p2 < n){ // both arrays
	                if(nums1[p1] < nums2[p2]){
	                    curr = nums1[p1]; // visited
	                    p1++;
	                }else{
	                    curr = nums2[p2];
	                    p2++;
	                }
	            }else if(p1 < m){
	                curr = nums1[p1];
	                p1++;
	            }else if(p2 < n){
	                curr = nums2[p2];
	                p2++;
	            }
	            
	            count++;
	        }
	        
	        if (totalLen % 2 == 0) { 
	            return (prev + curr) / 2.0; // even
	        } else {
	            return curr; // odd
	        }
	    }
}
