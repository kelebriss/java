package WS6;

/** 
** Software Technology 152
** Class to hold various static sort methods.
*/
class Sorts
{
    // bubble sort
    public static void bubbleSort(int[] A) //bubble sort
    {
    	int i, pass=0, tmp;
    	boolean sorted;
    	do 
    	{
    		sorted =true;
    		for(i=0; i<(A.length-1-pass); i++) // comparing inside array elements
    		{
    			if(A[i]>A[i+1]) // checking front value and it is lager then swap
    			{
    				tmp = A[i]; //swap function array
    				A[i]= A[i+1];
    				A[i+1]=tmp;
    			}
    		}
    		pass++; // increasing the pass
    	}while(!sorted); // when array is sorted then quit the loop
    }//bubbleSort()

    // selection sort
    public static void selectionSort(int[] A) // selection sort
    {
    	int i,j,k, tmp;
    	
    	for(i=0; i<A.length; i++) //loop for pass
    	{
    		k = i; // duplicate the index number for comparing
    		for(j=i+1; j<A.length;j++) // loop for comparing the elements
    		{
    			if(A[j]<A[k]) // if selected element(k) is smaller than the element(j) then do this
    				k = j; // change the 
    		}
    		tmp = A[k];  //swap function.
    		A[k] = A[i];
    		A[i] = tmp;	
    	}
    }// selectionSort()

    // insertion sort
    public static void insertionSort(int[] A) // insertion sort
    {
    	int i,j, tmp;
    	
    	for(i=1; i<A.length;i++) 
    	{
    		j=i;
    		tmp = A[j];
    		while( (j>0)&& (A[j-1]> tmp)) 
    		{// comparing tmp element and A array and A is larger then tmp array changing the index
    			A[j] = A[j-1];// sorting function except i index element
    			j--;
    		}
    		A[j]=tmp; // insert the element
    	}
    }// insertionSort()

    // mergeSort - front-end for kick-starting the recursive algorithm
    public static void mergeSort(int[] A)
    {
    	mergeSortRecurse(A, 0, A.length-1);
    }//mergeSort()
    private static void mergeSortRecurse(int[] A, int leftIdx, int rightIdx)// merge sort
    {
    	int midIdx;
    	if(leftIdx < rightIdx) // validate the function
    	{
    	 midIdx = (leftIdx+rightIdx)/2; // calculate the middle Index number
    	
    	 mergeSortRecurse(A,leftIdx,midIdx); // split into two part,it is left side and recursive 
    	 mergeSortRecurse(A,midIdx+1, rightIdx); // split into two part,it is right side and recursive 
    	
       	 merge(A,leftIdx,midIdx,rightIdx); // when splitting is done then do merge function
    	}
    }//mergeSortRecurse()
    private static void merge(int[] A, int leftIdx, int midIdx, int rightIdx)
    {
    	int tmpArr[] = new int[rightIdx - leftIdx +1]; // allocate the proper size of array for to contain elements for temporary
    	int i,j,k;
    	
    	i = leftIdx;
    	j = midIdx+1;
    	k = 0; // temporary array's index number counter;
    	
    	while((i <= midIdx) && (j <= rightIdx)) // do the merging split elements
    	{
    		if(A[i] <= A[j]) // if left elements is smaller than mid elements then do this
    		{
    			tmpArr[k] = A[i]; // insert to temporary array
    			i++; // increase left index
    		}
    		else // other case do this
    		{
    			tmpArr[k] = A[j];// insert to temporary array
    			j++; // increase mid index
    		}
    		k++; // increase temporary array index
    	}
    	for(i = i; i<midIdx;i++) 
    	// may mid index is reached right index first 
    	//so rest of left to mid index elements insert into temporary array
    	{
    		tmpArr[k] = A[i]; // insert
    		k++;// increase temporary array index
    	}
    	for(j=j; j<rightIdx+1;j++)
        // may left index is reached mid index first 
        //so rest of mid to right index elements insert into temporary array
    	{
    		tmpArr[k] = A[j]; // insert
    		k++;// increase temporary array index
    	}
    	for(k = leftIdx; k<rightIdx+1; k++)
    	{
    		A[k] = tmpArr[k-leftIdx]; // replace the A array's elements with temporary array's elements
    	}
    }//merge()

    //***********quick sort is ws7 so will upload on ws7 practice**********//
/*
    // quickSort - front-end for kick-starting the recursive algorithm
    public static void quickSort(int[] A)
    {
    }//quickSort()
    private static void quickSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
    }//quickSortRecurse()
    private static int doPartitioning(int[] A, int leftIdx, int rightIdx, int pivotIdx)
    {
		return 0;	// TEMP - Replace this when you implement QuickSort
    }//doPartitioning

*/
}//end Sorts calss
