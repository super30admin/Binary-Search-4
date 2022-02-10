/**
 * Time complexity:
 * Hash Map solution: O(m+n)
 * Binary Search solution: O(nlogm) where m is the bigger array
 */

/**
 * Spce complexity:
 * Hash map solution: O(min(m, n))
 * Binary Search solution: O(1) 
 */

/**
 * Approach(Hash Map):
 * We are creating a frequency map of the smaller array. Then we iterate over the bigger array. 
 * If we have any element of bigger array in the hashmap with frequency greater than zero
 * we add it to our result, decrease the frequency and erase the element if the frequency is zero.
 */

/**
 * Approach(Binary Search):
 * To perform binary search first we have to sort both the arrays as it is the basic requirement 
 * of binary search. Then we iterate over the smaller array and look for each element in the bigger
 * array using binary search. Now, we have to take care of the duplicate condition too. So, we have to check
 * that the previous element of the mid element should not be equal to the element at mid. If it is equal,
 * then we have to reduce the search space to the left. We also have to chekc that our mid should not be 
 * equal to -1. If it is not  equal to -1 then we can add the element of the smaller array to the target.
 */

//The code ran perfectly on leetcode.





class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        //if(nums1.size()== 0 || nums2.size() == 0) return {};
        vector<int> result;
        sort(nums1.begin(), nums2.end());
        sort(nums2.begin(), nums2.end());
        int low = 0, high = nums2.size()-1;
        for(int i =0; i<nums1.size(); i++){
            int target = nums1[i];
            int bIndex = bS(nums2, low, nums2.size()-1, target);
            if(bIndex != -1){
                result.push_back(target);
                low = bIndex + 1;
            }
        }
        return result;
    }
        
    private:
    int bS(vector<int> arr, int low, int high, int target){ 
        while(low<=high){
            int mid = low + (high - low)/2;
            if(arr[mid] == target){
                if(mid == low || arr[mid] != arr[mid-1]){
                    
                    return mid;
                } else {
                    high = mid -1;
                }
            } else if (arr[mid]>target){
                    high = mid-1;
                } else {
                    low = mid +1;
                }
        }
        return -1;
    }
};