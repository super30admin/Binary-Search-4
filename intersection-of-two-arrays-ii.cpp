/*
Time -
    If arrays are sorted: O(min(m,n)log(max(m,n)))
    If arrays not sorted: O(max(m,n)log(max(m,n)))
Space : O(1)
*/

class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        vector<int> intersection;
        if(!nums1.size() || !nums2.size()) return intersection;
        sort(nums1.begin(),nums1.end());
        sort(nums2.begin(),nums2.end());
        
        vector<int> small = nums1;
        vector<int> large = nums2;
        
        if(nums1.size()>nums2.size()) {
            small = nums2;
            large = nums1;
        }
        
        int i=0;
        while(i<small.size()){
            int cnt_small = 1;
            int ele = small[i];
            
            i++;
            while(i<small.size() && small[i] == ele){
                cnt_small++;
                i++;
            }
            
            int cnt = min(cnt_small,binarySearch(large,ele));
            
            while(cnt--){
                intersection.push_back(ele);
            }
        }        
        return intersection;
    }
    
    int binarySearch(vector<int>& nums, int n){
        int l = 0, h = nums.size()-1;
        
        while(l<=h){
            int m = l+(h-l)/2;
            if(nums[m] == n){
                int left = m-1,right = m+1,count = 1;
                while(left>=0 && nums[left] == n) {left--;count++;}
                while(right<nums.size() && nums[right] == n) {right++;count++;}
                return count;
            }else if(nums[m]<n){
                l = m+1;
            }else{
                h = m-1;
            }
        }
        
        return 0;
    }
};