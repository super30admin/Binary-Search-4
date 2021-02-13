//time complexity:O(logn)
//space complexity:O(1)
//executed on leetcode: yes
//approach:using binary search
//any issues faced? yes, the language of ques is confusing

class Solution {
public:
    int hIndex(vector<int>& citations) {
        int l=0;
        int r=citations.size()-1;
        int n=citations.size();
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(citations[mid]==n-mid)
                return n-mid;
            else if(citations[mid]<n-mid)
                l=mid+1;
            else
                r=mid-1;
                
        }
        return n-l;
    }
};