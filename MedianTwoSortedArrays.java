//Problem 92: Median of Two Sorted Arrays
//TC:O(log(m+n)), where it will be min of m,n
//SC:O(1)

/*
  Bruteforce: TC:(O(m+n)+O(mnlog(mn))) | SC:O(m+n) Merge all elements to a list, sort the list and return the median according to array size which is even or odd

  Optimized: 1) Using Two pointers :  //TC:O(m+n) || SC(O(m+n)) 
             Merge two list in ascending order and return the median according to array size which is even or odd
             2) Using Binary Search : TC:O(log(m+n)), where it will be min of m,n | SC:O(1)
             //consider nums1 as smaller size array by default, because BS will be on smaller array
             Use the concept of partitioning, basically make left partition element smaller than the right partition elements

             Consider eg: 1)Arr1: 1,5,9,10,15
                            Arr2: 2,11,12,13,14,16
                          2)Arr1: 0,7,8,10,11
                            Arr2: 2,3,4,5,6,12,13  
                          Find partX = start+(end-start)/2 //similar to mid element but here end will be at arr1 length
                               partY = (n1+n2)/2-partX

                           Compare l1 with r2 and l2 with r1.
                           If both l1 and l2 are smaller than r2 and r1 respectively, just return the median according to array size which is even or odd.
                           If l1 is greater than r2 that means l1(array1 idx) has to be moved on left side, which means end = partX-1;
                           If l2 is greater than r1 that means l2(array2 idx) hast to be moved on left side which menas array 1 start=partX+1

             

*/

class Solution92 {
    
    //Using Binary Search
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //TC:O(log(m+n)), Where it will be min of m,n
        //SC:O(1)
        int n1=nums1.length;
        int n2=nums2.length;
        //consider nums1 as smaller size array by default, because BS will be on smaller array
        //if n2 is smaller, then reverse, means keep nums1 as smaller array;
        if(n1>n2) return findMedianSortedArrays(nums2,nums1);
        
        int start= 0;
        int end  = n1;
        
        while(start<=end){
            
            int partX = start+(end-start)/2;
            int partY = (n1+n2)/2 - partX;
            //if partx is at 0, then l1 should be min element
            double l1 = partX==0 ? Integer.MIN_VALUE : nums1[partX-1];
            double r1 = partX==n1 ? Integer.MAX_VALUE:nums1[partX];
            
            //if partY is at last idx, then r2 should be max element
            double l2 = partY==0 ? Integer.MIN_VALUE : nums2[partY-1];
            double r2 = partY==n2 ? Integer.MAX_VALUE:nums2[partY];
            
            //all elements at left side are smaller than the elements at right side
            //means correct partition found
            if(l1<=r2 && l2<=r1){
                
                if((n1+n2)%2==0){//even elements
                    return (Math.max(l1,l2)+Math.min(r1,r2))/2;
                }
                //odd element
                return Math.min(r1,r2);    
                
            }else if(l1>r2){
                end = partX-1;//move high pointer because lower elementt will be at left side
            }else{//l2>r1
                start = partX+1;
            }
            
        }
        
        return -1;//returning anything
        
    }
    
    /*Using Two pointers

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
     
        //TC:O(m+n) || SC(O(m+n))
        if((nums1==null || nums1.length==0) && (nums2==null || nums2.length==0)) return 0.0;
        
        int p1=0;
        int p2=0;
        
        int[] res = new int[nums1.length+nums2.length];
        int i=0;
        while(p1<nums1.length && p2<nums2.length){
            
            if(nums1[p1]<=nums2[p2]){
                res[i] = nums1[p1++]; 
            }else{
                res[i] = nums2[p2++];
            }
            
            i++;
        }
        
        while(p1<nums1.length){
           res[i++] = nums1[p1++]; 
        }
        
        while(p2<nums2.length){
           res[i++] = nums2[p2++]; 
        }
        
        int mid = (res.length-1)/2;
        
        if(res.length%2==0){//even
            return (res[mid]+res[mid+1])/2.0;
        }
        //odd
        return res[mid];
    }*/
}