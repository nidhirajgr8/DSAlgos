package DynamicProgramming;

public class EqualSumPartition {
	/*******
	 * 
	 * Find IS IT POSSIBLE TO HAVE EQUAL SUM PARTITION IN GIVEN ARRAY?
	 */
	public static void main(String[] args) {
		int arr[]= {1,5,11,15};
		System.out.println(
		isEqualSumPartitionPossible(arr)
		);
	}
	
	public static boolean isEqualSumPartitionPossible(int[] arr) {
		
		int sum=0;
		if(arr.length==0) {return false;}
		
		for (int i = 0; i < arr.length; i++) {
			sum+=arr[i];
		}
		if(sum%2!=0) {
			return false;
		}
		sum=sum/2;
		// create a array to fill True and False
		boolean[][] mat = new boolean[arr.length][sum+1];
		/********   Iterative BOTTOM UP            ************************/
		/***  Initializes first row and first column  **/
		//First column initialize ->all true
		for(int i=0;i<arr.length;i++) {
			mat[i][0]=true;
		}
		
		//For first row only that value will be true which is equal to sum at that column
		for(int j=0;j<=sum;j++) {
			if(arr[0]==j) {
				mat[0][j]=true;
			}
		}
		/***********************************************************/
		
		for (int i = 1; i < arr.length; i++) {
			for(int j=1;j<=sum;j++) {
				//if the upper cell has T, bring it in current cell
				if(mat[i-1][j]) {
					mat[i][j]=mat[i-1][j];
				}else {
					//only if j value is more than arr[i] value
					if(j>=arr[i]) {
						mat[i][j]=mat[i-1][j-arr[i]];
					}
				}
			}
		}
		return mat[arr.length-1][sum];
	}

}
