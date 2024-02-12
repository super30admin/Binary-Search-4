class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        int n1 = nums1.size();
        int n2 = nums2.size();

        if (n1 > n2) {
            return intersect(nums2, nums1);
        }

        std::sort(nums1.begin(), nums1.end());
        std::sort(nums2.begin(), nums2.end());

        int p1 = 0;
        int p2 = 0;
        vector<int> result;
        int low = 0, high = n2 - 1;

        for (int i = 0; i < n1; i++) {
            int bsIdx = binarySearch(nums2, low, high, nums1[i]);
            if (bsIdx != -1) {
                result.push_back(nums1[i]);
                low = bsIdx + 1;
            }
        }

        return result;
    }

private:
    int binarySearch(vector<int>& arr, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                if (mid == low || arr[mid] > arr[mid - 1]) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
};