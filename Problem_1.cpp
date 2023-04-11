350. Intersection of Two Arrays II


Time Complexity: O(nlogn+mlogm)

Space Complexity: O(logn+logm)


vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
    sort(begin(nums1), end(nums1));
    sort(begin(nums2), end(nums2));
    int i = 0, j = 0, k = 0;
    while (i < nums1.size() && j < nums2.size()) {
        if (nums1[i] < nums2[j]) {
            ++i;
        } else if (nums1[i] > nums2[j]) {
            ++j;
        } else {
            nums1[k++] = nums1[i++];
            ++j;
        }
    }
    return vector<int>(begin(nums1), begin(nums1) + k);
}
