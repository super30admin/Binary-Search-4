//TC: O(log(min(n,m))) since we consider the minimum array and arrive at the partition from there. 
//SC: O(1) since there is no extra space consumed

class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        
        int n = nums1.size();
        int m = nums2.size();
        
        if(n > m){
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int low = 0;
        int high = n; //not n-1, since partitions are being done. We index later on while considering the limits of the partition
        
        
        //partition based on the lengths of arrays 1 and 2 
        //partition x is the partitioning of the first array
        //partition y is the partitioning of the second array
        
        while(low <= high){
            
            int partx = low + (high - low)/2;  
            int party = (n+m)/2 - partx;    //will tell us where to partition in second array            
            
            double l1;
            if(partx == 0){
                //if partx reaches 0, then we can consider intmin to be l1 since any l2 value in party will be greter. This effectively tells us that all elements in array x are greater in value than half of the total elements of the combined arrays
                l1 = INT_MIN;
            } else{
                //pick the rightmost element of partition x
                l1 = nums1[partx - 1];
            }
            
            
            double l2;
            if(party == 0){
                l2 = INT_MIN;
            } else{
                l2 = nums2[party - 1];
            }
            
            double r1;
            if(partx == n){
                r1 = INT_MAX;
            } else{
                r1 = nums1[partx];
            }
            
            double r2;
            if(party == m){
                r2 = INT_MAX;
            } else{
                r2 = nums2[party];
            }
            
            
            //we know that l1 is less than r1 and l2 is less than r2. The key here is to check if l2<r1 and l1<r2 for our partitions of both arrays to be valid. 
            if(l1 <=r2 && l2 <= r1){
                //we get our answer
                
                if((n+m)%2 == 0){
                    return (max(l1, l2) + min(r1, r2))/2;
                } else{
                    return min(r1, r2);
                }
            } else if(l2 > r1){
                low = partx + 1;
            } else{
                high = partx - 1;
            }
            
            
            
        }
        
        return 0;
        
    }
};