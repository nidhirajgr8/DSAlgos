package DynamicProgramming;

public class knapsack_0_1 {
	
	
	/*******
	 *            SUBSET SUM
	 */
	
	/*
	 * DP 2 version
	 * 1. Top Down [Memoization /Recursive]
	 * 2. Bottom up [Iterative] 
	 * 
	 */
	
	/** 1)  If there exists a subset whose sum is W -- Return Yes or No [ True/Flse]
	 *  2)  If there exists a subset of weight & value, return combination which gives maximum profit
	 */
	
	/**
	 * 
	 * His idea of applying the Dynamic Programming is as follows:

	1)Find the recursion in the problem.
	2)Top-down: store the answer for each subproblem in a table to avoid having to recompute them.
	3)Bottom-up: Find the right order to evaluate the results so that partial results are available when needed.
	 */
	
	
	
	////    1 )
	
	public static void main(String[] args) {
		
		int arr[] = {2,3,5,8};
		int sum=8;
		
		System.out.println(subsetsum(arr,sum));
	
		
	}

	private static boolean subsetsum(int[] arr, int sum) {
		
		if(arr.length<1) {return false;}
		// 
		//				  j		0   1   2	3   4	5	6   7   8---->sum=8
		//				i
		//	2				0   T   F   T   F   F	F   F   F   F
		//	3				1   T   F   T   T	F	T	F	F	F
		//	5				2   T	F	T	T	F	T	F	T	T
		//	8				3   T	F	T	T	F	T	F	T	T
		//	 				:  
		//   			num
		//   			sets
		//
		//     3 conditions:
		//			 a[i] = j   then mark it as T  or 1  ex: a[1] = 2 = j or a[2]=j=5
		//			 a[i-1][j]= T or 1  if condition 1 doesn't satisfy then just keep previous upper cell below.
		//			 when a[i-1] = F or 0 , then a[i-1][j-a[i] = 1   Ex: a[2][5] ... here its previous upper cell is F , so 2nd condition fails.
		//															so, a[i-1] -> a[1] & a[j-a[i] = a [5-a[2]] -> a[5- 
		//			 
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
		// fill the rest of the cell [Iteration -Bottom up]
		for(int i=1;i<arr.length;i++) {
			for(int j=1;j<=sum;j++) {
				
				if(mat[i-1][j]) {
					mat[i][j]=true;
				}else {
					if(j>=arr[i]) {
						mat[i][j]=mat[i-1][j-arr[i]];
					}
				}
			}
		}
		
		
		return mat[arr.length-1][sum];
		
		//outcome
		/*
				[true, false, true, false, false, false, false, false, false]
				[true, false, true, true,  false, true,  false, false, false]
				[true, false, true, true,  false, true,  false, true,  true ]
				[true, false, true, true,  false, true,  false, true,  true ]
		*/			
	}
	
	

}
