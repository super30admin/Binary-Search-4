//Partition & Binary Search
//Tc = O(log(n1)), if we make first array's length smaller, that is n1 is smaller. Else TC = O(log(min(n1,n2)))
//Sc =
//Approach3: Partition with Binaru Search: Use below formula to get partitionY.
//partY = n1+n2/2 - partX, can be used in even length combined array and odd length combined length. In odd length, it gives one less element on left side. 1,2,3,/4,5,6,7
//Do Binary search on parition:
//1.low at array1 0th index
//2.high at array1 nth index
//3.find mid, that will be partX
//4.find partY using formula on Array2
//5.If(X2>Y1), increase low pointer to partX + 1(or mid+1)
//6.If(X1>Y2), high = mid-1
//7.find minimum between Y1 and Y2. min(Y1,Y2)=median
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length; 
        int n2 = nums2.length;
        if(n1 > n2){ //keep the left smaller, if not smaller, flip arrays
            return findMedianSortedArrays(nums2, nums1);
        }
        int low = 0; 
        int high = n1;
        while(low <= high){
            int partX = low + (high-low)/2;
            int partY = (n1+n2)/2 - partX;
            double X1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];//get actual element
            double Y1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];
            double X2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            double Y2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];

            if(X1 <= Y2 && X2 <= Y1){
                //correct partition
                if((n1+n2)%2 == 0) {
                    //even
                    return (Math.min(Y1,Y2) + Math.max(X1,X2))/2;
                } else { 
                    //odd
                    return Math.min(Y1,Y2);
                }
            } else if(X1 > Y2){
                high = partX - 1;
            } else {
                low  = partX + 1;
            }
        }
        return 3.0; //return anything
    }
}

//Approach1: Combine 2 arrays into 1, sort them, find median. TC = O((m+n)log(m+n)) or O((n1+n2)log(n1+n2))
//Approach2: Two pointers: Use 2 pointers to merge arrays. TC = O(m+n) for traversal or O(n1+n2)