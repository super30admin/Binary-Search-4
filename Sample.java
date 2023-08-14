//Problem 1: Intersection of 2 arrays
// Time Complexity : O(min(m,n)* log(max(m,n)))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach
//Sort both the arrays, for each element in min elements array -> Binary search in max elements array
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        if(m>n) return intersect(nums2, nums1);
        List<Integer> res=new ArrayList<>();

        //hashmap solution O(m+n) SC: (min(m,n))
        // HashMap<Integer,Integer> map=new HashMap<>();
        // for(int i: nums1){
        //     map.put(i, map.getOrDefault(i,0)+1);
        // }
        // for(int num: nums2){
        //     if(map.containsKey(num)){
        //         res.add(num);
        //         map.put(num,map.get(num)-1);
        //         map.remove(num,0);
        //     }
        // }

        //binary search TC: O(max(m,n) + mlogm + nlogn) SC: O(1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1=0,p2=0;
        while(p1<m && p2<n){
            if(nums1[p1]==nums2[p2]){
                res.add(nums1[p1]);
                p1++; p2++;
            }
            else if(nums1[p1]<nums2[p2]) p1++;
            else
                p2++;
        }

        //O(mlogn) -> Best solution
        // Arrays.sort(nums1);
        // Arrays.sort(nums2);
        // int low=0,high=n-1;
        // for(int i=0;i<m;i++){
        //     int bsIndex=binarysearch(nums2, low, high, nums1[i]);

        //     if(bsIndex !=-1){
        //         res.add((nums1[i]));
        //         low=bsIndex+1;
        //     }
        // }

        int[] result=new int[res.size()];
        for(int i=0;i<res.size();i++)
            result[i]=res.get(i);
        
        return result;
         
    }

    private int binarysearch(int[] arr, int low, int high, int target){
        while(low<=high){
            int mid= low+(high-low)/2;

            if(arr[mid]==target){
                if(mid==low || arr[mid]>arr[mid-1])
                    return mid;
                else{
                    high=mid-1;
                }
            }
            else if(arr[mid]>target){
                high=mid-1;
            }
            else
                low=mid+1;
        }
        return -1;
    }
}



//Problem 2: Median of 2 sorted arrays
// Time Complexity : O(log math.min(m,n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//form partitions of first and second array such that, each element in first partition is less than each in second
//now check conditions of even elements or odd and find median accordingly

//Approach; create a partition such as all left elements < all right elements, 
// now if n1+n2 is odd, return min of r1,r2 else return average of max(l1,l2),min (r1,r2)
class Solution {
    //TC: O(log math.min(m,n)) SC: O(1)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        if(n1>n2) return findMedianSortedArrays(nums2,nums1);

        int low=0, high=n1; //it is partition, so 0->n1

        while(low<=high){
            int partx=low+(high-low)/2;
            int party=(n1+n2)/2 - partx; //formula
            double l1= partx==0 ? Integer.MIN_VALUE : nums1[partx-1]; //first array left
            double l2= party==0 ? Integer.MIN_VALUE : nums2[party-1]; //second array left

            double r1= partx==n1 ? Integer.MAX_VALUE : nums1[partx]; //first array right
            double r2= party==n2 ? Integer.MAX_VALUE : nums2[party]; //second array right

            if(l1<=r2 && l2<=r1){ //correct partition found
                if((n1+n2)%2!=0) //odd array length
                    return Math.min(r1,r2);
                else
                    return (Math.min(r1,r2)+Math.max(l1,l2))/2; //even array length
            }
            else if(l2>r1) 
                low=partx+1;
            else 
                high=partx-1;
        }
        return 0.0;
    }
}
