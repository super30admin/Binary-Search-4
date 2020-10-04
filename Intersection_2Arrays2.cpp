// Time Complexity : O(k) where n is the max (n,m)
// Space Complexity : O(m) for the hashmap for vector 2
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning



class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        int n1 = nums1.size();
        int n2 = nums2.size();
        
        
        // sorting both the arrays
        sort(nums1.begin(), nums1.end());
        sort(nums2.begin(), nums2.end());
        map<int, int> mymap;
        vector<int> result ;
        
        // adding all the values in array 2 to a hashmap and their frequency
        for ( int i = 0; i < n2; i ++){
            
            if(mymap.find(nums2[i]) == mymap.end()){
                mymap.insert({nums2[i], 0});
            }
            mymap[nums2[i]] +=1;
            
        }
        
        // traversing on vector 2 and checkin in hashmap for existance in vector 1
        // and decreasig the frequency.
        for( int i = 0; i <n1; i++){
            
            if(mymap.find(nums1[i]) != mymap.end()){
                
                if(mymap[nums1[i]]!=0){
                    result.push_back(nums1[i]);
                    mymap[nums1[i]] -=1;
                }
            }
        }
     return result;
    }
};