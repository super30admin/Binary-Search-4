class Sample{
    /****************PROBLEM-1*****************/
    //TC:0(N+M)
//SC:0(Min(m,n))
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            if(nums1==null || nums2==null || nums1.length==0 || nums2.length==0){
                return new int[]{};
            }
            int n=nums1.length,m=nums2.length;
            List<Integer> result=new ArrayList<>();
            HashMap<Integer,Integer> seen=new HashMap<>();
            if(m>n){
                intersect(nums2,nums1);
            }
            for(int i=0;i<n;i++){
                seen.put(nums1[i],seen.getOrDefault(nums1[i],0)+1);
            }
            for(int i=0;i<m;i++){
                if(seen.containsKey(nums2[i])){
                    int value=seen.get(nums2[i]);
                    result.add(nums2[i]);
                    if(value-1==0){
                        seen.remove(nums2[i]);
                    }else{
                        seen.put(nums2[i],value-1);
                    }
                }
            }
            int[] answer=new int[result.size()];
            for(int i=0;i<answer.length;i++){
                answer[i]=result.get(i);
            }
            return answer;
        }
    }


    //TC:0(NlogN)+0(MlogM)
//SC:0(min(n,m))
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            if(nums1==null || nums2==null || nums1.length==0 || nums2.length==0){
                return new int[]{};
            }
            int n=nums1.length,m=nums2.length;
            List<Integer> result=new ArrayList<>();
            Arrays.sort(nums1);
            Arrays.sort(nums2);

            int ptr1=0,ptr2=0;
            while(ptr1<n && ptr2<m){
                if(nums1[ptr1]==nums2[ptr2]){
                    result.add(nums1[ptr1]);
                    ptr1++;
                    ptr2++;
                }else if(nums1[ptr1]<nums2[ptr2]){
                    ptr1++;
                }else{
                    ptr2++;
                }
            }

            int[] answer=new int[result.size()];
            for(int i=0;i<answer.length;i++){
                answer[i]=result.get(i);
            }
            return answer;
        }
    }

    //TC:0(NlogN)+0(MlogM)
//SC:0(1)
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            if(nums1==null || nums2==null || nums1.length==0 || nums2.length==0){
                return new int[]{};
            }
            int n=nums1.length,m=nums2.length;
            List<Integer> result=new ArrayList<>();
            Arrays.sort(nums1);
            Arrays.sort(nums2);

            if(n>m){
                intersect(nums2,nums1);
            }
            int low=0;
            for(int i=0;i<n;i++){
                int bSearch=binarySearch(nums2,nums1[i],low,m-1);
                if(bSearch!=-1){
                    result.add(nums1[i]);
                    low=bSearch+1;
                }
            }

            int[] answer=new int[result.size()];
            for(int i=0;i<answer.length;i++){
                answer[i]=result.get(i);
            }
            return answer;
        }

        private int binarySearch(int[] nums,int target,int low,int high){
            while(low<=high){
                int mid=low+(high-low)/2;
                if(nums[mid]==target){
                    if(mid==low || nums[mid-1]!=target){
                        return mid;
                    }
                    high=mid-1;
                }else if(nums[mid]>target){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }
            return -1;
        }
    }

    /***************************PROBLEM2**********************/
    //tc:0(m+n)
//sc:0(m+n)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {

            int n=nums1.length,m=nums2.length;
            int ptr1=n-1,ptr2=m-1,pos=m+n-1;
            int[] result=new int[m+n];
            while(ptr1>=0 && ptr2>=0){
                if(nums1[ptr1]>=nums2[ptr2]){
                    result[pos--]=nums1[ptr1--];
                }else{
                    result[pos--]=nums2[ptr2--];
                }
            }
            while(ptr1>=0){
                result[pos--]=nums1[ptr1--];
            }
            while(ptr2>=0){
                result[pos--]=nums2[ptr2--];
            }
            int mid=result.length/2;
            if(result.length%2==0){
                return (double) (result[mid]+result[mid-1])/2;
            }else{
                return (double) result[mid];
            }
        }
    }

    //tc:0(logm) m=size of smaller array
//sc:0(1)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if(nums1==null && nums2==null){
                return 0.0;
            }
            int m=nums1.length,n=nums2.length;
            if(m>n){
                return findMedianSortedArrays(nums2,nums1);
            }
            int low=0,high=m;
            while(low<=high){
                int partX=low+(high-low)/2;
                int partY=((m+n)/2)-partX;
                double l1= partX==0 ? Integer.MIN_VALUE : nums1[partX-1];
                double r1= partX==m ? Integer.MAX_VALUE : nums1[partX];
                double l2= partY==0 ? Integer.MIN_VALUE : nums2[partY-1];
                double r2= partY==n ? Integer.MAX_VALUE : nums2[partY];
                if(l1<=r2 && l2<=r1){
                    if((m+n)%2!=0){
                        return Math.min(r1,r2);
                    }else{
                        return (Math.max(l1,l2)+Math.min(r1,r2))/2;
                    }
                }
                else if(l1>r2){
                    high=partX-1;
                }
                else if(l2>r1){
                    low=partX+1;
                }
            }
            return 0.0;
        }
    }

}