
//Technique1 : Add to HashMap
//Time Complexity = O(m+n) Traversing the first array to add in HashMap and check the values in second array that exists or not in HashMap
//Space Complexity = O(1) we are not using any extra space here

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        //if(n1>n2) return intersect(int[] nums2, int[] nums1);
        
        // Array.sort(nums1);
        // Array.sort(nums2);
        if(n1>n2) return intersect(nums2, nums1);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        for(int i=0; i<n1; i++){         
                 map.put(nums1[i], map.getOrDefault(nums1[i], 0) +1);  // add frequency to the HashMap
        }
        
        for(int j=0; j < n2; j++){
            if(map.containsKey(nums2[j])){
                if(map.get(nums2[j]) >0){
                    result.add(nums2[j]); 
                map.put(nums2[j], map.get(nums2[j])-1); // update frequency to the HashMap
        }
                }
                
                
            }
        }
        int [] arrayResult = new int[result.size()];
        for(int k=0; k<result.size(); k++){
            arrayResult[k] = result.get(k);
        }
        return arrayResult;
    }

}


//Technique2 : Two Pointers
//Time Complexity = O(max(m,n)) Traversing the first array  and Second Array, atleast we will traverse fully one Array, thats max(arr1,arr2)
//Space Complexity = O(1) we are not using any extra space here

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        //if(n2>n1) return intersect(nums2, nums1);
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        

        List<Integer> result = new ArrayList<>();
        
        int pointer1 = 0;
        int pointer2 = 0;
        while(pointer1 < n1 && pointer2 < n2){
            if(nums1[pointer1] == nums2[pointer2]){
                result.add(nums1[pointer1]);
                 pointer1++;
                 pointer2++;
                
            }
            else if(nums1[pointer1] < nums2[pointer2]){
                pointer1++;
            }
            else{
                pointer2++;
            }
            
        }
   
        System.out.println(result);
        
        int [] arrayResult = new int[result.size()];
        for(int k=0; k<result.size(); k++){
            arrayResult[k] = result.get(k);
        }
        return arrayResult;
    }

}

//Technique3 : Binary Search
//Time Complexity = O(mlogn) Traversing the smallest array  and apply Binary Search on another Big array
//Space Complexity = O(1) we are not using any extra space here

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        if (n2 > n1) return intersect(nums2, nums1);

        List < Integer > result = new ArrayList <> ();

        int low = 0;
        
        for (int i = 0; i < n1; i++) {

            int high = n2 - 1;

            while (low <= high) {

                int mid = low + (high - low) / 2;
                 
                
                if (nums2[mid] == nums1[i]) {


                    if (low < mid && nums2[mid] == nums2[mid - 1]) {
                        high = mid - 1;
                    } else {
                        result.add(nums2[mid]);
                        low = mid + 1;
                        break;
                    }
                } else if (nums2[mid] > nums1[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } // while

        } //for


        System.out.println(result);
        int[] arrayResult = new int[result.size()];
        for (int k = 0; k < result.size(); k++) {
            arrayResult[k] = result.get(k);
        }
        return arrayResult;

    }
}
