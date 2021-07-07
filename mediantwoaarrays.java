
# Time complexity:O(klog(m))
# Space complexity: 0(1)
# Did code run successfully on leetcode: yes
# Any problem you faced: No


class Solution {
    public double findMedianSortedArrays(int[] x, int[] y) {
        int xLen = x.length, yLen = y.length;
        if(xLen > yLen) {
            // we want x to be the shorter one
            return findMedianSortedArrays(y, x);
        }
        int left = 0, right = xLen;
        int partitionX, partitionY, maxLeftX, minRightX, maxLeftY, minRightY;
        while(left <= right) {
            partitionX = (left + right) / 2;
            partitionY = (xLen + yLen + 1) / 2 - partitionX;

            if(partitionX == 0) {
                maxLeftX = Integer.MIN_VALUE;
            } else {
                maxLeftX = x[partitionX-1];
            }

            if(partitionX == xLen) {
                minRightX = Integer.MAX_VALUE;
            } else {
                minRightX = x[partitionX];
            }

            if(partitionY == 0) {
                maxLeftY = Integer.MIN_VALUE;
            } else {
                maxLeftY = y[partitionY-1];
            }

            if(partitionY == yLen) {
                minRightY = Integer.MAX_VALUE;
            } else {
                minRightY = y[partitionY];
            }

            if(maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if((xLen + yLen)%2 == 0) {
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2.0;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                right = partitionX - 1;
            } else {
                left = partitionX+1;
            }
        }
        return 0.0;
    }
}