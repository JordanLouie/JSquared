/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  ======================================*/

public class MergeSort {

   /******************************************************
     * int[] merge(int[],int[]) 
     * Merges two input arrays
     * Precond:  Input arrays are sorted in ascending order
     * Postcond: Input arrays unchanged, and 
     * output array sorted in ascending order.
     ******************************************************/
    private static int[] merge( int[] a, int[] b ) {
        int[] shorter, longer, merged;
        merged = new int[a.length+b.length];

        if (a.length > b.length) {
            shorter = b;
            longer = a;
        } else {
            shorter = a;
            longer = b;
        }

        int shorterIndex = 0;
        int longerIndex = 0;
        while (shorterIndex < shorter.length && longerIndex < longer.length) {
            if (shorter[shorterIndex] < longer[longerIndex]) {
                merged[shorterIndex+longerIndex] = shorter[shorterIndex];
                shorterIndex++;
            } else {
                merged[shorterIndex+longerIndex] = longer[longerIndex];
                longerIndex++;
            }
        }

        if (longerIndex != longer.length) {
            for (; longerIndex < longer.length; longerIndex++) {
                merged[shorterIndex+longerIndex] = longer[longerIndex];
            }
        } else if (shorterIndex != shorter.length) {
            for (; shorterIndex < shorter.length; shorterIndex++) {
                merged[shorterIndex+longerIndex] = shorter[shorterIndex];
            }
        }
        return merged;
    }//end merge()


    /******************************************************
     * int[] sort(int[]) 
     * Sorts input array using mergesort algorithm
     * Returns sorted version of input array (ascending)
     ******************************************************/
    public static int[] sort( int[] arr ) 
    {
	int length = arr.length;
        if (length <= 1) {
            return arr;
        }
        int shorter = length/2;
        int longer = length/2;

        if (length % 2 == 1) {
            longer++;
        }
        int[] first = new int[shorter];
        int[] second = new int[longer];
        int i = 0;
        int arrIndex = 0;

        while (i < shorter) {
            first[i] = arr[arrIndex];
            i++;
            arrIndex++;
        }
        i = 0;
        while (i < longer) {
            second[i] = arr[arrIndex];
            i++;
            arrIndex++;
        }

        return merge(sort(first), sort(second));
    }//end sort()



    //-------------------HELPERS-------------------------
    //tester function for exploring how arrays are passed
    //usage: print array, mess(array), print array. Whaddayasee?
    public static void mess( int[] a ) {
	for( int i = 0 ; i<a.length; i++ )
	    a[i] = 0;
    }

    //helper method for displaying an array
    public static void printArray( int[] a ) {
	System.out.print("[");
	for( int i : a )
	    System.out.print( i + ",");
	System.out.println("]");
    }
    //---------------------------------------------------


    //main method for testing
    public static void main( String [] args ) {

	int[] arr0 = {0};
	int[] arr1 = {1};
	int[] arr2 = {1,2};
	int[] arr3 = {3,4};
	int[] arr4 = {1,2,3,4};
	int[] arr5 = {4,3,2,1};
	int[] arr6 = {9,42,17,63,0,512,23};
	int[] arr7 = {9,42,17,63,0,9,512,23,9};

	System.out.println("\nTesting mess-with-array method...");
	printArray( arr3 );
	mess(arr3);
	printArray( arr3 );

	System.out.println("\nMerging arr1 and arr0: ");
	printArray( merge(arr1,arr0) );

	System.out.println("\nMerging arr4 and arr6: ");
	printArray( merge(sort(arr4),sort(arr6)) );

	System.out.println("\nSorting arr4-7...");
	printArray( sort( arr4 ) );
	printArray( sort( arr5 ) );
	printArray( sort( arr6 ) );
	printArray( sort( arr7 ) );

    }//end main()

}//end class MergeSort
