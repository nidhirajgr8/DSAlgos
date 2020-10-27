package DynamicProgramming;

public class countOfSubsetSum {

	/*****
	 * Check how many subsets possible whose sum is given
	 */
	
	//KNAPSACK with bottom up [iterative][tabular]
	public static void main(String[] args) {
		int arr[]= {2,3,5,6,8,10};
		int sum=10;
		System.out.println(
		isEqualSumPartitionPossible(arr, sum)
		);
	}
	
	public static int isEqualSumPartitionPossible(int[] arr, int sum) {
		
		if(arr.length==0) {return 0;}
		
		// create a array to fill True and False
		int[][] mat = new int[arr.length][sum+1];
		/********   Iterative BOTTOM UP            ************************/
		/***  Initializes first row and first column  **/
		//First column initialize ->all true
		for(int i=0;i<arr.length;i++) {
			mat[i][0]=1;
		}
		
		//For first row only that value will be true which is equal to sum at that column
		for(int j=0;j<=sum;j++) {
			if(arr[0]==j) {
				mat[0][j]=1;
			}
		}
		/***********************************************************/
		
		for (int i = 1; i < arr.length; i++) {
			for(int j=1;j<=sum;j++) {
				if(arr[i]>j) {
					mat[i][j]=mat[i-1][j];
				}else {
					mat[i][j]=mat[i-1][j] + mat[i-1][j-arr[i]];
				}
			}
		}
		return mat[arr.length-1][sum];
	}
	
}
