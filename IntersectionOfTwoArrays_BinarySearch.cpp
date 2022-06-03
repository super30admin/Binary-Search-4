// Time Complexity : Sorting :- O(m*log n) + O(n*log n)
//                   Intersection :- O(m*log n)
//                   Total :- O(m*log n) + O(n*log n) + O(m*log n)
// Space Complexity : O(1)
//      Where m, n : Length of arrays.
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english
/* Sort both arrays. Iterate over smaller array and perform binary search on second array to find the current element in second array.
 * Binary search returns the first occurance of element. Maintain a window to restrict binary search using low pointer. 
 * When element is found adjust low pointer.
 */
class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        
        if (nums1.size() == 0 | nums2.size() == 0)
            return {};
        
        if (nums1.size() > nums2.size())
            intersect(nums2, nums1);
        
      
        vector<int> results;
        
        sort(nums1.begin(), nums1.end());
        sort(nums2.begin(), nums2.end());
        int low = 0;
        int high = nums2.size() - 1;
        
        for (auto& ele : nums1)
        {
            int bIndex = binarySearch(ele, low, high, nums2);
            
            if (bIndex != -1)
            {
                results.push_back(ele);
                low = bIndex + 1;
            }
        }
        
        return results;
    }
    
    int binarySearch(int& ele, int low, int high, vector<int>& nums2)
    {
        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            
            if (nums2[mid] == ele)
            {
                if (mid == low || nums2[mid - 1] < ele)
                {
                    return mid;
                }
                
                high = mid - 1;
            }
            else
            {
                if (ele < nums2[mid])
                {
                    high = mid - 1;
                }
                else
                {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
};