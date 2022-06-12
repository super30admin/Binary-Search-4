TIME = O(max(m,n))
SPACE = O(min(m,n))
    
class Solution {
public:
    unordered_map<int,int> m;
    vector<int> result;
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        if(nums2.size() < nums1.size()) return intersect(nums2,nums1);
        addToHash(nums1);
        findIntersection(nums2);
        return result;
    }
    
    void addToHash(vector<int> v){
        for(int i=0;i<v.size();i++){
            m[v[i]]++;
        }
    }
    
    void findIntersection(vector<int> x){
        for(int i=0;i<x.size();i++){
            if(m[x[i]]>0){
                result.push_back(x[i]);
                m[x[i]]--;
            }
        }
    }
};

Follow up : arrays are sorted 
Use 2 pointers - one pointer on each array 

Move the pointer on smaller array by comparing
TC = O(max(m,n)), SC = O(1)
    
BINARY SEARCH SOLUTION:
TC = O(mlogN)
SC = O(1)
m = size of smaller array
n = size of larger array

BS1 - Iterate on the smaller array and perform BS on the bigger array 

class Solution {
public:
    vector<int> result;
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        int size1 = nums1.size();
        int size2 = nums2.size();
        if(size2<size1) return intersect(nums2,nums1);
        int left = 0;
        int right = nums2.size()-1;
        for(int i=0;i<nums1.size();i++){
            if(binarySearch(nums2,left,right,nums1[i])){
                result.push_back(nums1[i]);
                left++;
            }
        }
        return result;
    }
    
    bool binarySearch(vector<int> v, int low, int high, int target){
        int left = low;
        int right = high;
        while(left<right){
            int mid = left + (right-left)/2;
            if(v[mid]>=target)
                right = mid;
            else
                left = mid + 1;
        }
        return v[left]==target ? true : false;
    }
};

