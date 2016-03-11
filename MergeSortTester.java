/*======================================
  class MergeSortTester

  ALGORITHM:
To test this, I basically wrote two functions: one that would populate the array with random numbers and another to print how much time it takes for each complete sort and the average of all sorts for an array of size n. Each is tested 100 times and the average of those 100 are shown below.

  BIG-OH CLASSIFICATION OF ALGORITHM: O(nlogn)

  Mean execution times for dataset of size n:
  Batch size: 1-100,000 (in factors of 10) (using millis)
  n=1       time: 0 
  n=10      time: 1
  n=100     time: 12
  n=1000    time: 102
  n=10000   time: 1156
  n=100000  time: 10259

  ANALYSIS: As expected, the sort times do start to take quite a jump as the number gets larger and larger. Based on the times gathered, I think it's a solid sample size to show that the growth isn't exactly exponential but more leaning towards n(logn).
  
  ======================================*/

public class MergeSortTester {

    public static void populate ( int[] arr ) { 
	for ( int i = 0 ; i < arr.length ; i++ ) { 
	    arr[i] = ((int) ((Math.random()) * 100)); 
	} 
    } 

    public static void hundredTester ( int [] arr ) { 	
	long TStart = 0; 
	long TEnd = 0; 
	long TPassed = 0; 
	long TAverage = 0;
	for (int i = 0 ; i < 100 ; i++) { 
	    populate(arr); 
	    MergeSort.printArray(arr); 
	    //add the thing to keep track of time and run a couple of hundred of thousands of times and yeah
	    TStart = System.currentTimeMillis(); 
	    System.out.println("Time Start: " + TStart);
	    MergeSort.printArray(MergeSort.sort(arr));
	    TEnd = System.currentTimeMillis(); 
	    System.out.println("Time End: " + TEnd);
	    TPassed = TEnd - TStart; 
	    System.out.println ("Time Passed: " + TPassed); 
	    TAverage += TPassed; 
	} 
	TAverage /= 100; 
	System.out.println("Average for n(" + arr.length + "): " + TAverage);
    }

    public static void main( String[] args ) {
	int[] arr0 = new int[1]; 
	int[] arr1 = new int[10];
	int[] arr2 = new int[100]; 
	int[] arr3 = new int[1000];
	int[] arr4 = new int[10000];
	int[] arr5 = new int[100000];
	//hundredTester (arr0);
	//hundredTester (arr1);
	//hundredTester (arr2);
	//hundredTester (arr3);
	//hundredTester (arr4);
	hundredTester (arr5);
    }//end main

}//end class
