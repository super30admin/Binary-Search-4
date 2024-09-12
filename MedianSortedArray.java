// Time Complexity : O(log(m + n)
// Space Complexity : O(m + n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :
// Difficult to predict.

// Your code here along with comments explaining your approach
class Solution {
    public double findMedianSortedArrays(int[] n1, int[] n2) {
           int i=0,j=0,c=0;
        int l1=n1.length;
        int l2=n2.length;
        int a[]=new int[n1.length+n2.length];
        while(i<n1.length || j<n2.length)
        {
            if(i<l1 && j<l2 && n1[i]<n2[j])
            {
                a[c++]=n1[i++];
            }
            else if(i<l1 && j<l2 && n2[j]<=n1[i])
            {
                a[c++]=n2[j++];
            }
            
            else if(j<l2)
            {
               a[c++]=n2[j++]; 
            }
            else
            {
                    a[c++]=n1[i++];
            }
            
        }
        
        double ans=0;
        if(c%2==0)
        {
            System.out.println(a[(c/2)-1]);
            ans=(double)(a[(c/2)-1]+a[(c/2)])/2;
        }
        else
            ans=a[(c/2)];
        
        return ans;
        
    }
}