public class MedianOfSortedArrays {
//https://leetcode.com/problems/median-of-two-sorted-arrays/

    public static void main(String[] args) {
int[] nums = {1,3};
int[] nums2 = {2,4};
        System.out.println(findMedianSortedArrays(nums,nums2));
    }

  //Binary Search Approach
  /*
  * take partition of the arrays in such way that you take that each partition when partitioned further should have equal number of elements
for even elements eg a1 has 4 elements and a2 has 6 partition 1
Odd elements a1=5 a2=6
for first parts of each array
para1 = 0+5/2 =2 para2 =m+n/2 -para1 = 11/2-2=3
we are ok if partition is not equal
1 5 9 10 15
2 11 12 13 14 16
par1 15
	2 11 13
par2 9 10 15
	 13 14 16
L1=5 r1=9 l2=12 r2=13
L1<=R2  L2<=R1
imaginary partition line drawn should have  splitted the arrays in sorted halves we know L1 R1 are in arr 1  L2 R2 in arr2  we know r1>l1
and r2>l2 we are not sure about L1 R2 L2 R1  Reason ?
picked 4 from 1  so pick 1 from 2 acc formula reason for selecting Integer Min and Integer Max
we have proper partitions
* if partitions are not proper check for L1 L2 R1 R2 elements and apply binary search to increment or decrement all 4 variables
Check even elements odd elements - odd elements then result lies min R1 R2, if elements are even (Max l1 l2 + min r1 r2)/2.0
if l1>r2 high = partx-1 else low = mid+1
*
* TC - O(lon(min(m,n))
* SC - O(1)
  * */

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1==null && nums2==null || nums1.length==0 && nums2.length==0) return 0.0;
        if(nums2.length< nums1.length) return findMedianSortedArrays(nums2,nums1);

        int low = 0;
        int high = nums1.length;
        while(low<=high){
            int partX = low+ (high-low )/2;
            int partY = (nums1.length+ nums2.length)/2 -partX;
            double l1 = partX==0?Integer.MIN_VALUE:nums1[partX-1];
            double l2 = partY==0?Integer.MIN_VALUE:nums2[partY-1];
            double r1 = partX== nums1.length?Integer.MAX_VALUE:nums1[partX];
            double r2 = partY== nums2.length?Integer.MAX_VALUE:nums2[partY];
            if(l1<=r2 && l2<=r1){
                if((nums1.length+ nums2.length)%2.0 ==0) return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;

                return Math.min(r1,r2);
            }
            else if (l1>r2) high = partX-1;
            else low = partX+1;
        }
        return 0.0;
    }



//Brute Force
    /*
    * Create an array of the 2 arrays sort it. If the newly formed array is odd then find middle element and
    * if it is even find 2 middle elements and then take their average
    * Time Complexity - O(m+n(logm+n))
    * SC = O(m+n) for array or list
    *
    * */
    /*
public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    if(nums1==null && nums2==null || nums1.length==0 && nums2.length==0) return 0.0;
    List<Integer> resultArray = new ArrayList<>();
    for (int i = 0; i < nums1.length; i++){
        resultArray.add(nums1[i]);
    }
    for (int i = 0; i < nums2.length; i++){
        resultArray.add(nums2[i]);
    }
    Collections.sort(resultArray);
    int mid =  (resultArray.size()/2);
    if(resultArray.size()%2!=0) return resultArray.get(mid);
    else return (resultArray.get(mid)+ resultArray.get(mid-1))/2.0;

    }*/
}
