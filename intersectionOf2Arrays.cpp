/*
Intuition: 
If the array is sorted, we can use 2 pointer solution & binary search to find if an element exists in another array.
#####################################################################
Solution: 2 Pointer solution. Assuming the array is sorted.
Time Complexity : O(m+n) where m = size of array 1, n= size of array 2
Space Complexity : O(1)
#####################################################################
Solution: Binary Search. Assuming the array is sorted.
Time Complexity : O(m log n ) where m = size of array 1, n= size of array 2
Space Complexity : O(1)
#####################################################################
*/
class Solution {
public:
    vector<int> result;
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        if ( nums1.size()== 0 and nums2.size()==0) return result;
        sort( nums1.begin(), nums1.end());
        sort( nums2.begin(), nums2.end());
        int pointerOne = 0;
        int pointertwo = 0;
        while ( pointerOne <= nums1.size()-1 and pointertwo <= nums2.size()-1 ){
        
            if ( nums1[pointerOne] == nums2[pointertwo]){
                result.push_back(nums1[pointerOne]);
                pointerOne++;
                pointertwo++;
            }
            else if(nums1[pointerOne] < nums2[pointertwo]){
                pointerOne++;
            }
            else if(nums1[pointerOne] > nums2[pointertwo]){
                pointertwo++;
            }
        }
        return result;
    }
};

class Solution {
public:
    vector<int> result;
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        sort(nums1.begin(), nums1.end());
        sort(nums2.begin(), nums2.end());
        int n1 = nums1.size();
        int n2 = nums2.size();
        //Making n1 greater
        if ( n1 < n2){
            return intersect(nums2, nums1);
        }
        
        int low = 0;
        int high = n1-1;
        
        for ( int i =0; i < n2; i++){
            int bsIndex = binarySearch(low, high, nums1, nums2[i]);
                if ( bsIndex != -1){
                    result.push_back(nums2[i]);
                    low = bsIndex + 1;
                }
        }
        return result;
        
    }
    int binarySearch(int low, int high, vector<int> nums, int target){
    
        while (low <= high){
            
            int mid = low + (high- low)/2;
            
            if ( target == nums[mid]){
                if (mid == low or nums[mid-1]!= nums[mid]) {
                    return mid;
                }
            }
            if ( target > nums[mid]) low = mid +1;
            else high = mid -1;
        }
        return -1;
    }
};