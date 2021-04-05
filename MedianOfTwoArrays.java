class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      
        int n = nums1.length;
        int m = nums2.length;
        
        if(n > m){
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int low = 0;
        int high = n;
        
        //Doing binary search on the shortest array
        //tring to dive the arrays in such a way that both the halves have equal number of elements
        while(low <= high){
            int partX = low + (high - low) /2;
            int partY = (n+m)/2 - partX;
            
            double l1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            double l2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            double r1 = partX == n ? Integer.MAX_VALUE : nums1[partX];
            double r2 = partY == m ? Integer.MAX_VALUE : nums2[partY];
            
            //checking the property that all elemnts on left half are less than all elemsnts on right half
            if(l1 <= r2 && l2 <= r1){
                // if so we are hadling odd and even length
                if((n+m) % 2 == 0){
                    return (Math.max(l1,l2) + Math.min(r1, r2)) / 2;
                }else{
                    return Math.min(r1,r2);
                }
            }//else moving the high and low pointers accordingly to achieve the property
            else if(l2 > r1){
                low = partX+1;
            }else{
                high = partX-1;
            }
        }
        
        return -1;
    }
}

// Time Complexity: O(log( min(m, n)))
// Space Complexity: O(1)

/*
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l =nums1.length + nums2.length;
        int[] arr = new int[l];
        System.arraycopy(nums1, 0, arr, 0, nums1.length);
        System.arraycopy(nums2, 0, arr, nums1.length, nums2.length);
        Arrays.sort(arr);
        if(arr.length % 2 == 0){
            float n1 = arr[arr.length/2];
            float n2 = arr[(arr.length/2 - 1)];
            return (float)((n1+n2)/2);            
        }
        else{
            return arr[(arr.length/2)];
        }
        
    }
}
*/