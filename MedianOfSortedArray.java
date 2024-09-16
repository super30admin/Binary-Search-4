//Time Complexity:O(log n) n is lengthof shorter array
//Space Complexity:O(1)
/*Approach 
-Taking partitions , we have to apply binary search to the smaller array to know the position of
correct place to partition
-correct partition will be at a place where left of 1 is less than right of 2 and left of  2 should
be less than right of 1
-we will move our low and high if conditions above fail, accordingly
-based on parttition of smaller array we will find partition in larger array
-if our overall length is even then to find median we have to add max of left and min of right(since they 
will be neighbours if the array is whole array) and take out their mean.
-if our overall length is odd we need to take max on our left partition.
*/
public class MedianOfSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int n1 = nums1.length; int n2 = nums2.length;
        if(n1>n2) return findMedianSortedArrays(nums2,nums1);
        int low = 0; int high = n1;
        while(low <= high){
            int partX = low+(high-low)/2;
            int partY = (n1+n2+1)/2 - partX;
            double l1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX-1];
            double l2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY-1];
            double r1 = partX == n1 ?Integer.MAX_VALUE : nums1[partX];
            double r2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];
            if(l2> r1){low = partX+1;}
            else if(l1 > r2){high = partX -1;}
            else{
                if((n1+n2) % 2 ==0){
                    return (Math.max(l1,l2)+Math.min(r1,r2))/2;
                }
                else{
                    return Math.max(l1,l2);
                }
            }
        }
        
        return -1;
    }
public static void main(String args[]){
    MedianOfSortedArray obj = new MedianOfSortedArray();
    System.out.println(obj.findMedianSortedArrays(new int[]{1,5,8}, new int[]{3,4,6}));
}
}