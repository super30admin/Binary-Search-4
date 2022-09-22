//TC : O(log(n)). -- n is smaller array length
//SC : O(1)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length; int n2 = nums2.length;
        if(nums1.length ==0 && nums2.length==0) return 0.0;
        if(n1>n2) return findMedianSortedArrays(nums2,nums1);
        
        int low = 0, high = n1;
        
        while(low<=high){
            int partX = low + (high-low)/2;
            int partY = ((n1+n2)/2) - partX;
            double l1 = partX==0 ? Integer.MIN_VALUE : nums1[partX-1];
            double r1 = partX==n1 ? Integer.MAX_VALUE : nums1[partX];
            double l2 = partY==0 ? Integer.MIN_VALUE : nums2[partY-1];
            double r2 = partY==n2 ? Integer.MAX_VALUE : nums2[partY];
            
            if(l1 <= r2 && l2 <= r1){
                if((n1+n2) % 2 ==0){
                    return (Math.max(l1,l2) + Math.min(r1,r2)) / 2;
                }else{
                    return Math.min(r1,r2);
                }
            }else if(l2>r1){
                low = partX+1;
            }else{
                high = partX-1;
            }
        }
        return 0.0;
    }

    //2 pointers  TC : O(m+n)
    /*public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        int p1 = 0,p2=0;
        int n1 = nums1.length-1;
        int n2 = nums2.length-1;
        while(p1 <= n1 && p2 <= n2){
            if(nums1[p1] <= nums2[p2]){
                list.add(nums1[p1]);
                p1++;
            }
            else{
                list.add(nums2[p2]);
                p2++;
            }
        }
        
        while(p1<=n1){
            list.add(nums1[p1]);
            p1++;
        }
        
        while(p2<=n2){
            list.add(nums2[p2]);
            p2++;
        }
        int n = list.size();
        if(n%2 != 0){
            return list.get(n/2) * 1.0;
        }else{
            int mid = n/2-1;
            return (list.get(mid)+list.get(mid+1) *1.0)/2;
        }
    }*/
}
