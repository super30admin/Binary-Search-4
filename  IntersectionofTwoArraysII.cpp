 #include <bits/stdc++.h>
class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
            int m = nums1.size();
            int n = nums2.size();
        cout<< m <<" "<< n << endl;

              
            if(m>n) return intersect(nums2,nums1);

            sort(nums1.begin(),nums1.end());
            sort(nums2.begin(),nums2.end());


            vector<int> v;

            int low = 0;
            int high = n-1;

            for(int i=0;i<m;i++){
                    int target = nums1[i];
                
                    int bsIdx = binarySearch(nums2,low,high,target);
                    if(bsIdx != -1){
                        v.push_back(target);
                        low = bsIdx+1;
                   
                    }
            }

            vector<int> result;
            for(int i=0;i<v.size();i++){
                result.push_back(v[i]);
           
            }

            return result;
    }



   int  binarySearch(vector<int> nums2,int low,int high,int target){
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums2[mid] == target){
                if( mid == low || nums2[mid] != nums2[mid-1]){
                    return mid;
                }else{
                    high = mid -1;

                }
            }else if(nums2[mid]>target){
                high = mid-1;

            }else{
                low = mid+1;
            }

        }
        return -1;
    }
};