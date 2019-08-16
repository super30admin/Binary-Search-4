package binarysearch2;

//did not understand why the name of question is intersections. if we r just finding common element from both array and its order does not matter
//Approach 1 using two pointer 
//first sort both array and using two pointers compare and if got same value then put it in list

//Approach 2 using Hashmap without sorting just store first array into hashmap key as value of element and  value as occurance count starting with 1.
//and find second array element's into first array if found then put into output list and remove count of element from hashmap.


//apprach 1 
//tc :(n+m)log n
//sc:o(n)

//solution using hashmap with o(m+n) time complexity and space complexity o(n)

//follow-up question answers:
/*What if elements of nums2 are stored on disk, and the memory is
limited such that you cannot load all elements into the memory at
once?

If only nums2 cannot fit in memory, put all elements of nums1 into a HashMap, read chunks of array that fit into the memory, and record the intersections.

If both nums1 and nums2 are so huge that neither fit into the memory, sort them individually (external sort), then read 2 elements from each array at a time in memory, record intersections.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class IntersectionOfArray {
	    public int[] intersect(int[] nums1, int[] nums2) {
	       Arrays.sort(nums1);
	        Arrays.sort(nums2);
	        int pnt1 = 0;
	        int pnt2 = 0;
	        ArrayList<Integer> myList = new ArrayList<Integer>();
	        while((pnt1 < nums1.length) &&(pnt2< nums2.length)){
	            if(nums1[pnt1]<nums2[pnt2]){
	                pnt1++;
	            }
	            else{
	                if(nums1[pnt1]>nums2[pnt2]){
	                    pnt2++;
	                }
	                else{
	                    myList.add(nums1[pnt1]);
	                    pnt1++;
	                    pnt2++;
	                }
	            }
	        }
	        int[] res = new int[myList.size()];
	        for(int i = 0; i<res.length; i++){
	            res[i] = (Integer)myList.get(i);
	        }
	        return res;
	    }

   
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//solution using hashmap with o(n) time complexity and space complexity o(n)
	
	/*public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hm= new HashMap<>();
        HashMap<Integer,Integer> result = new HashMap<>();
        int resultLength=0,i=0;
        
        for(int n1: nums1){
            if(hm.containsKey(n1)){
                hm.put(n1,hm.get(n1)+1);
            }
            else 
                hm.put(n1,1);
        }
        
        for(int n2: nums2){
            if(hm.containsKey(n2)){ //this is a result candidate
                resultLength++; //for result array length
                if(!result.containsKey(n2)){result.put(n2,0);} // insert in result for first time
                result.put(n2,result.get(n2)+1);
                
                int freq = (int) hm.get(n2); //to manage the result candidate in hm
                hm.put(n2,freq-1);
                if(freq-1==0){hm.remove(n2);}
            }
        }
        
        int[] resultArray = new int[resultLength];
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            int temp =0;
            while(temp<(int)entry.getValue()){
                resultArray[i++] = entry.getKey();
                temp++;
            }
        }    
        return resultArray;
        }*/

}
