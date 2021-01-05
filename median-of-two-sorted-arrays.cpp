//Time - O(min(m,n)log(max(m,n)))
//Space - O(1)

class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        if(nums1.size() == 0 && nums2.size()==0) return 0;
        int n1 = nums1.size(), n2 = nums2.size();
        if(n1>n2){
            return findMedianSortedArrays(nums2,nums1);
        }    
        
        int low = 0, high = n1;
        
        while(low<=high){
            int partX = low + (high-low)/2;
            int partY = (n1+n2)/2 - partX;
            int l1 = partX-1 >=0 ? nums1[partX-1] : INT_MIN;
            int l2 = partY-1 >=0 ? nums2[partY-1] : INT_MIN;
            int r1 = partX < n1 ? nums1[partX] : INT_MAX;
            int r2 = partY < n2 ? nums2[partY] : INT_MAX;
            
            if(l1<=r2 && l2<=r1){
                
                if((n1+n2)%2 == 1) return min(r1,r2);
                else{
                    return (double)(max(l1,l2) + min(r1,r2))/2;
                }
                
            }else if(l1>r2){
                high = partX-1;
            }else if(l2>r1){
                low = partX+1;
            }
            
        }
        
        return 0;
        
    }
};