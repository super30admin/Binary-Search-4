// Time Complexity : log(n), n : number of citations
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


class Solution {
    public int hIndex(int[] citations) {
        //check for null or empty case
        if(citations == null || citations.length == 0) return 0;
        //do binary search
        int low = 0; 
        int high = citations.length-1;
        while(low <= high) {
            int mid = low + (high-low)/2;
            int diff = citations.length - mid;
            if(diff == citations[mid]) {
                return diff; 
            }
            else if(diff > citations[mid]) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
            
        }      
        return citations.length - low;
    }
}


/*
Eg :
Index : 0 1 2 3 4 
Cita  : 1 1 4 5 6
Diff  : 5 4 3 2 1

Ans : 3 
(when cita[mid] >= diff), return diff
diff = length - mid for a particular number
so we do Binary search, to check if cita[mid] == diff
if equal (cita[mid] == diff), so return diff

if cit[mid] > diff, we know ans is in left side (so change high)
if cit[mid] < diff, we know ans is in right side (so change low)
in case diff at cit[mid] is ans, thats when low crosses high, so we return 
length - low (to get citation at low position)

*/


///////////////////////////
// Time Complexity : log(n), n : number of citations
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


class Solution {
    public int hIndex(int[] citations) {
        //check for null or empty case
        if(citations.length == 0 || citations[citations.length-1] == 0) return 0;
        //do binary search (low<high)
        int low = 0; 
        int high = citations.length-1;
        while(low < high) {
            int mid = low + (high-low)/2;
            int diff = citations.length - mid;
            if(diff == citations[mid]) {
                return diff; 
            }
            else if(diff > citations[mid]) {
                low = mid+1;
            }
            else {
                //low < high, to check mid case, high = mid
                high = mid;
            }
            
        }      
        return citations.length - low;
    }
}


/*
Eg :
Index : 0 1 2 3 4 
Cita  : 1 1 4 5 6
Diff  : 5 4 3 2 1

Ans : 3 
(when cita[mid] >= diff), return diff
diff = length - mid for a particular number
so we do Binary search, to check if cita[mid] == diff
if equal (cita[mid] == diff), so return diff

if cit[mid] > diff, we know ans is in left side (including mid) (so change high)
if cit[mid] < diff, we know ans is in right side (so change low)
in case diff at cit[mid] is ans, thats when low = high (wont enter loop), so we return 
length - low

*/


///////////////////////////
// Time Complexity : O(n), n is number of citations
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :



class Solution {
    public int hIndex(int[] citations) {
        //check for null or empty case
        if(citations == null || citations.length == 0) return 0;
        //linear search for first occurance when 
        //diff <= citations[i]
        for(int i = 0; i < citations.length; i++) {
            int diff = citations.length - i; 
            if(diff <= citations[i]) {
                return diff;
            }
        } return 0;
    }
}


/*
Eg :
Index : 0 1 2 3 4 
Cita  : 1 1 4 5 6
Diff  : 5 4 3 2 1

Ans : 3 
Ans is when diff <= cit[i] 
Linear 
*/

