/*

I referred this video to get this solution 
Median of Two Sorted Arrays Tushar Roy URL :
https://www.youtube.com/watch?v=LPFhl65R7ww 

Time Complexity: 0(log(m+n))
Did it run on leet code: Yes

Algorithm:

1. I have two markers placed one in longer array(X) and one in shorter array(Y).
2. We take 4 variables maxLeftX,minRightX,maxLeftY,minRightY which are equal to
partitionX-1,partitionX,partitionY-1,partitionY

3. Here we need to be careful oif sum of lengths of array is not even
because if its even then we need to return median of two elements in middle


*/


class Solution {
public:
    double findMedianSortedArrays(vector<int>& arr1, vector<int>& arr2) {
        
    int x= arr1.size();
    int y= arr2.size();
    
    if(x>y){
        return findMedianSortedArrays(arr2,arr1);
    }
    

    // doing binary search in array of lower length
    int low = 0,high=x;
    while(low<=high){
        // making the partitions
        int partitionX =(low+high)/2;
        int partitionY = (x+y+1)/2-partitionX;

        // Smaller array
        int maxLeftX = (partitionX==0)? INT_MIN:arr1[partitionX-1];
        int minRightX = (partitionX==x)? INT_MAX:arr1[partitionX];

        // Larger array
        int maxLeftY = (partitionY==0)? INT_MIN:arr2[partitionY-1];
        int minRightY = (partitionY==y)? INT_MAX:arr2[partitionY];

        if(maxLeftX<=minRightY && maxLeftY<=minRightX){
            // we have found the partition
            if((x+y)%2==0){
                return (double)(max(maxLeftX,maxLeftY) + min(minRightX,minRightY))/2;
            }
            return (double)max(maxLeftX,maxLeftY);
        }else if(maxLeftX>minRightY){
            high = partitionX-1;// too far on the right side, need to move left
        }else{
            low = partitionX+1;// too far on left side , need to move right
        }
    }

}

};