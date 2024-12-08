import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Time Complexity: O(n)
// Space Compexity: O(n)

public class problem1 {


    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> myList = new ArrayList(); // result list for common values

        Map<Integer,Integer> myMap = new HashMap();

        for(int i:nums1){ // map for nums1 items, how many times appear
            if(myMap.containsKey(i))
                myMap.put(i,myMap.get(i)+1);
            else
                myMap.put(i,1);
        }

        for(int i:nums2){ // this time look for num2 items
            if(myMap.containsKey(i)  && myMap.get(i)>1){ // if it is more than 1
                myMap.put(i,myMap.get(i)-1); // decrease frequency of it
                myList.add(i); // add common element to result list
            }else if(myMap.containsKey(i) && myMap.get(i)==1){
                myMap.remove(i); // I will not need as a common, once more as it appears only once
                myList.add(i); // add common element to result list
            }
        }

        // convert List to array as it is expected as int array
        int[] r = new int[myList.size()];
        for(int i=0;i<myList.size();i++){
            r[i]=myList.get(i);
        }
        return r;


    }
}
