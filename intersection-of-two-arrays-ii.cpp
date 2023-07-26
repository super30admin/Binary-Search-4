// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

#include <iostream>
#include <vector>
#include <algorithm> // for sort

std::vector<int> intersect(std::vector<int>& nums1, std::vector<int>& nums2) {
    if (nums1.empty() || nums2.empty()) return {};

    std::sort(nums1.begin(), nums1.end());
    std::sort(nums2.begin(), nums2.end());

    std::vector<int> result;
    int index = 0;

    for (int i = 0; i < nums1.size(); i++) {
        int loc = binarySearch(nums2, index, nums1[i]);

        if (loc < nums2.size() && nums2[loc] == nums1[i]) {
            result.push_back(nums1[i]);
            index = loc + 1;
        }
    }

    return result;
}

int binarySearch(std::vector<int>& nums, int index, int target) {
    int left = index, right = nums.size() - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        if (nums[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    return left;
}