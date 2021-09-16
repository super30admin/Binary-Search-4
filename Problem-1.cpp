/*
Time Complexity = O(n+m)
Space Complexity = O(n)
where n1 is the number of elements in array nums1 and n2 is the number of elements in the array nums2.
*/
class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        int n1 = nums1.size();
        int n2 = nums2.size();
        int i;
        map<int,int> m;
        vector<int> ans;
        for(i=0;i<n1;i++){
            if(m.find(nums1[i])==m.end())
                m.insert({nums1[i],1});
            else
                m[nums1[i]]++;
        }
        for(i=0;i<n2;i++){
            if(m.find(nums2[i])!=m.end())
            {
                if(m[nums2[i]]!=0){
                    m[nums2[i]]--;
                    ans.push_back(nums2[i]);
                }
            }
        }
        return ans;
    }
};

/*
if array is not sorted already.
Time Complexity = O(nlogn + mlogm)
Space Complexity = O(1)

if array is already sorted.
Time Complexity = O(n + m)
Space Complexity = O(1)
where n1 is the number of elements in array nums1 and n2 is the number of elements in the array nums2.
*/
class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        int n1 = nums1.size();
        int n2 = nums2.size();
        int i;
        vector<int> ans;
        sort(nums1.begin(), nums1.end());
        sort(nums2.begin(), nums2.end());
        int p1 = 0, p2 = 0;
        while(p1<n1 && p2<n2){
            if(nums1[p1]==nums2[p2]){
                ans.push_back(nums1[p1]);
                p1++;
                p2++;
            }
            else if(nums1[p1]<nums2[p2])
                p1++;
            else
                p2++;
        }
        return ans;
    }
};

/*
Time Complexity = O(nlogm)
Space Complexity = O(1)
where n1 is the number of elements in array nums1 and n2 is the number of elements in the array nums2.
*/
class Solution {
public:
    int binarysearch(vector<int> nums, int target, int low, int high)
    {
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target){
                if(mid==low || nums[mid-1]<nums[mid])
                    return mid;
                high = mid-1;
            }
            if(nums[mid]<target)
                low = mid+1;
            else
                high = mid-1;
        }
        return -1;
    }
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        int n1 = nums1.size();
        int n2 = nums2.size();
        if(n1>n2)
            intersect(nums2, nums1);
        int i;
        vector<int> ans;
        sort(nums1.begin(), nums1.end());
        sort(nums2.begin(), nums2.end());
        int low = 0;
        int high = nums2.size()-1;
        for(i=0;i<n1;i++){
            int index = binarysearch(nums2, nums1[i],low ,high);
            if(index!=-1){
                ans.push_back(nums1[i]);
                low = index+1;
            }
        }
        return ans;
    }
};
