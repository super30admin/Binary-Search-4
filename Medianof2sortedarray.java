package codes;

public class Medianof2sortedarray {

	public static void main(String[] args) {
		System.out.println("to find the median of two sorted array");
		
		
//		int arr1 []= {1,3,5,11,15};
//		int arr2 []= {3,4,13,17,18};
		
		int arr1 []= {1};
		int arr2 []= {1};
		
		
//		System.out.println(median(arr1, arr2,0,arr1.length-1, 0, arr2.length-1));
		System.out.println(findmedian(arr1,arr2));
		
	}
	
	
	
	public static  double median(int [] a,int [] b,int start_a, int end_a,int start_b, int end_b) {
		/**
		 * works for arrays of equal lengths
		 */
		if(((end_a-start_a)==1 )&&((end_b-start_b)==1) ) {
			return (1.0*(Math.max(a[start_a],b[start_a])+Math.min(a[end_a],b[end_b])))/2;
		}
		int m1_index=(start_a+end_a)/2;
		int m2_index=(start_b+end_b)/2;
		
		int m2=b[m2_index];
		int m1=a[m1_index];
		
		if(m1==m2) {
			return m2;
		}
		
		if(m1<m2) {
			start_a=m1_index;
			end_b=m2_index;
		}
		if(m2<m1) {
			start_b=m2_index;
			end_a=m1_index;
		}
		
		return median(a, b, start_a, end_a, start_b, end_b);
		
		
		
	}
	
	
	public static double findmedian(int a [], int b []) {
		
//		if(a.length==1 && b.length==1) {
//			return ((double)(a[0]+b[0]))/2;
//		}
//		
//		if(((a.length)==2 )&&((b.length==2)))  {
//			return (1.0*(Math.max(a[0],b[0])+Math.min(a[1],b[1])))/2;
//		}
//		
		if(a.length>b.length) {
			return findmedian(b, a);
			
		}
		
		int x=a.length;
		int y=b.length;
		
		
//		these 2 values belong to x partition of array
		
		int low=0;   
		int high=x;
		
		
		while(low<=high) {
			int partitionX=(low+high)/2;
			int partitionY=(x+y+1)/2-partitionX;
			
			
			int maxLeftX=(partitionX==0)? Integer.MIN_VALUE:a[partitionX-1];
			int minRightX=(partitionX==x)? Integer.MAX_VALUE:a[partitionX];
			
			
			int maxLeftY=(partitionY==0)?Integer.MIN_VALUE:b[partitionY-1];
			int minRightY=(partitionY==y)?Integer.MAX_VALUE:b[partitionY];
			
			
			
			if(maxLeftX<=minRightY && maxLeftY<=minRightX) {
				
				
				if(((x+y)%2)==0){
					return ((double)Math.max(maxLeftX, maxLeftY)+Math.min(minRightX, minRightY))/2;
					
				}else {
					return ((double)Math.max(maxLeftX, maxLeftY));
				}
			
			}	else if(maxLeftX>minRightY) {
				high=partitionX-1;
			}
			else {
				low=partitionX+1;
			}
			
			
		}
		return 0.0;
	}
	
	
}
