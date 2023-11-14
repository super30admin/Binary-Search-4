#include<bits/stdc++.h>
using namespace std;

/*
Approach: Binary search + shrink left side: Iterating linearly thru smaller array, we search for the curr elem in other array using BS. We get the first occurence of the elem in currSearchWindow (st,end), then if the occurence is found, we could easily discard the elements to the left of this index(inclduing itself) because it wont contribute to the answer anymore.
Time: O(n1*log(n2))
Works on leetcode: Yes
*/

void printArr(vector<int> arr) {
    for(int a: arr) {
        cout<<a<<" ";
    }
    cout<<endl;
}

class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        if(nums1.size() > nums2.size()) {
            intersect(nums2, nums1);
        }
        int nl1=nums1.size();
        int nl2=nums2.size();
        sort(nums1.begin(), nums1.end());
        sort(nums2.begin(), nums2.end());
        vector<int> ans;

        // Nums1 is now smaller so we traverse it linearly and do BS on nums2
        // Set low and high for nums2
        int low=0, high=nl2-1;
        for(int n1: nums1) {
            int idx = binarySearchWithStl(nums2, low, high, n1);
            if(idx != -1) {
                ans.push_back(n1);
                low = idx+1;
            }
        }
        return ans;
    }

    int binarySearchWithoutStl(vector<int>& nums, int low, int high, int x) {
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(nums[mid] > x) {
                high = mid-1;
            }
            else if(nums[mid]<x) {
                low = mid+1;
            }
            else { 
                // When mid has val x then we need to get the leftmost occurence of the val
                // If this is the first elem in range or left side has different value then return
                // Else keep searching to the left
                if(mid == low) {
                    return low;
                }
                else {
                    high = mid;
                }
            }
        }
        return -1;
    }

    int binarySearchWithStl(vector<int>& nums, int low, int high, int x) {
        vector<int>::iterator ptr = lower_bound(nums.begin()+low, nums.begin()+high+1, x);
        if(ptr != nums.end() && *ptr == x) {
            return ptr - nums.begin();
        }
        return -1;
    }
};

int main() {
    vector<int> nums1{1,2};
    vector<int> nums2{1,1};
    Solution S;
    printArr(S.intersect(nums1, nums2));
}