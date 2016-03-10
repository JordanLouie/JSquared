/*======================================
  class MergeSortTester

  ALGORITHM:
  <INSERT YOUR DISTILLATION OF ALGO HERE>

  BIG-OH CLASSIFICATION OF ALGORITHM:
  <INSERT YOUR EXECUTION TIME CATEGORIZATION OF MERGESORT HERE>

  Mean execution times for dataset of size n:
  Batch size: <# of times each dataset size was run>
  n=1       time: 
  n=10      time: 
  n=100     time: 
  ...
  n=<huge>  time: 

  ANALYSIS:
  <INSERT YOUR RESULTS ANALYSIS HERE>
  ======================================*/

public class MergeSortTester {

    public static void populate ( int[] arr ) { 
	for ( int i = 0 ; i < arr.length ; i++ ) { 
	    arr[i] = ((int) ((Math.random()) * 100)); 
	} 
    } 

    /******************************
     * execution time analysis 
     * <INSERT YOUR DESCRIPTION HERE OF 
     *  YOUR APPARATUS FOR GENERATING EXECUTION 
     *  TIME DATA...>
     ******************************/
    public static void main( String[] args ) {
	int[] arr0 = {0}; 
	int[] arr1 = new int[10];
	long TStart = 0; 
	long TEnd = 0;
	long TPassed = 0; 
	long TAverage = 0;

	MergeSort.printArray(arr0);
	
	for (int i = 0 ; i < 100 ; i++) { 
	    populate(arr1); 
	    MergeSort.printArray(arr1);  
	    //add the thing to keep track of time and run a couple of hundred of thousands of times and yeah
	    TStart = System.currentTimeMillis(); 
	    System.out.println("Time Start: " + TStart);
	    MergeSort.printArray(MergeSort.sort(arr1));
	    TEnd = System.currentTimeMillis(); 
	    System.out.println("Time End: " + TEnd);
	    TPassed = TEnd - TStart; 
	    System.out.println (TPassed); 
	    TAverage += TPassed; 
	} 
	TAverage /= 100; 
	System.out.println(TAverage);
    }//end main

}//end class
