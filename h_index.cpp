//Time Complexity-O(logn)
//Space Complexity-O(1)
//Ran successfully on leetcode

class Solution {
public:
    int hIndex(vector<int>& citations) {
        if(citations.empty())
            return 0;
        int n=citations.size();
        int l=0,h=n-1;
        while (l<=h)
        {
            int mid=l+(h-l)/2;
            if(citations[mid]==n-mid)
                return n-mid;
            if(citations[mid]<n-mid)
                l=mid+1;
            else
                h=mid-1;
        }
        return n-l;
    }
};