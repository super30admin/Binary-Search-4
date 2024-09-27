//H-index
// Time Complexity : 0(logn)
// Space Complexity :0(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public int hIndex(int[] citations) {
       int low=0;
        int high= citations.length-1;
        int len= citations.length;
        while(low<=high)
        {
            int mid= low+(high-low)/2;
            int trial_Hindex=len-mid;
            if(trial_Hindex==citations[mid])
            {
                return trial_Hindex;
            }
            else if(trial_Hindex>citations[mid])
                low=mid+1;
            else
                high=mid-1;
            
        }
        return len-low;
    }
}

//Median of two sorted arrays
// Time Complexity : 0(logn)
// Space Complexity :0(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
         // 1) initialize sizes n1 and n2
        // 2) check which array is smaller
        // 3) do binary search on smaller array
        // 4) calculate parititions
        // 5) check l1 <= r2 && l2 <= r1 then voila
        // 5.1) check if odd or even and return accordingly
        // 6) check which side ot move on
        int n1=nums1.length;
        int n2=nums2.length;
        if(n1>n2)
            return findMedianSortedArrays(nums2,nums1);
        
        int low=0;
        int high=nums1.length;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            
            int partX= mid;
            int partY= (n1+n2+1)/2-partX;
            
            double L1=partX==0 ? Integer.MIN_VALUE :nums1[partX-1];
            double R1= partX==n1 ? Integer.MAX_VALUE :nums1[partX];
        
            double L2= partY==0 ? Integer.MIN_VALUE: nums2[partY-1];
            double R2= partY==n2 ? Integer.MAX_VALUE: nums2[partY];
            
            if(L1<=R2 && L2<=R1)
            {
                if((n1+n2)%2==0)
                {
                    return (Math.max(L1,L2)+Math.min(R1,R2))/2;
                }
                else
                {
                    return Math.max(L1,L2);
                }
            }else if(L2>R1)
            {
                low=mid+1;
            }
            else{
                high=mid-1;
            }
             
            }
            return -1;
    }
}


//Intersection of two Arrays
// Time Complexity : 0(nlogn)
// Space Complexity :0(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

 public int[] intersect(int[] nums1, int[] nums2) {
         Arrays.sort(nums1);
        Arrays.sort(nums2);
        int pnt1 = 0;
        int pnt2 = 0;
        ArrayList<Integer> myList = new ArrayList<Integer>();
        while((pnt1 < nums1.length) &&(pnt2< nums2.length)){
            if(nums1[pnt1]<nums2[pnt2]){
                pnt1++;
            }
            else{
                if(nums1[pnt1]>nums2[pnt2]){
                    pnt2++;
                }
                else{
                    myList.add(nums1[pnt1]);
                    pnt1++;
                    pnt2++;
                }
            }
        }
        int[] res = new int[myList.size()];
        for(int i = 0; i<res.length; i++){
            res[i] = (Integer)myList.get(i);
        }
        return res;
    }
}
