// Hashmap approach
// Time Complexity : O(m+n)
// Space Complexity : O(m) where m is the smaller of the two arrays
// Did this code successfully run on Leetcode : Yes 

//Binary search approach 
// Time Complexity : O(m log n) where m is the smaller array and n is the longer array 
// Space Complexity : O (1)

// Approach 1: hashmap 

// Keep a count of numbers in the smaller array and go over the big array to see which elements are in the hashset
// Add them to the result array and return 

class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        if(nums1.size() == 0 || nums2.size()==0) return vector<int> ();

        unordered_map<int,int> countMap;
        vector<int> result;

        if(nums2.size()<nums1.size())
            return intersect(nums2, nums1);

        for(int n: nums1)
            countMap[n]++;

        for(int n: nums2){
            if(countMap.find(n) != countMap.end() && countMap[n]>0){
                result.push_back(n);
                countMap[n]--;
            } 
        }
        return result;
    }
};

// -----------------------------------------------------------------

// Approach 2: Binary Search 

// Look for each number from the smaller array in the bigger array - if present, add it to the result 



class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        if(nums1.size() == 0 || nums2.size()==0)
            return vector<int>();

        vector<int> result;
        int m = nums1.size();
        int n = nums2.size();
        if(m > n)
            return intersect(nums2, nums1);
        
        // smaller array : nums1
        // bigger array : nums2

        // sorting both the arrays
        sort(nums1.begin(), nums1.end());
        sort(nums2.begin(), nums2.end());

        // start the binary search from the next index to avoid returning the same number that was already seen
        int startIndex = 0; 

        for(int num : nums1){
            int bsResult = binarySearch(nums2, startIndex, n-1, num);
            // BS returns -1 if the element was not found
            if(bsResult != -1) {
                result.push_back(nums2[bsResult]);
                startIndex = bsResult+1;
            }
        }
        return result;
    }

private:
    int binarySearch(vector<int> nums, int low, int high, int target){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target) {
                //need to make sure its the left most occurance 
                // it is the left most occurance if its at the beginning of the window 
                // or the left element is not the target 
                // Ex: [4,4,5]
                if(mid == low || nums[mid-1] != target)
                    return mid;
                else
                    high = mid-1;
            }
            else if(nums[mid] < target)
                low = mid+1;
            else
                high = mid-1;
            }            
        return -1;
    }
};