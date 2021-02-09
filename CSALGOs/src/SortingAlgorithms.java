
//Sam Morrone CS3
import java.util.Random;
public class SortingAlgorithms
{
    public static void main(String[] args)
    {
        //PART 1
        int [] data = new int[100];
        Random generator = new Random();
        String BLANKS = "       ";
      
        for(int i = 1; i <=5; i++)
        {
            for(int j = 0; j <100; j++)
               data[j] = generator.nextInt(100);   
            System.out.println("Before: ");
            for(int j = 0; j <100; j++)
                System.out.print(data[j] + " ");
            System.out.println();
            sort(i, data, data.length);          
            System.out.print("After ");
            nameOfSort(i);
            for(int j = 0; j <100; j++)
                System.out.print(data[j] + " ");
            System.out.println("\n");
        }  
          
           
        //part 2
        
        int totalComparisons = 0;
        System.out.println("\n----------------------------------------------------------------------------------------------");
        System.out.printf("%-6s%15s%16s%12s%12s%11s%8s", "N","selectionSort","insertionSort","mergeSort","quickSort","heapSort","NlogN");
        System.out.println("\n----------------------------------------------------------------------------------------------");
      
     
        for(int N = 1000; N <= 10000; N= N + 1000)
        {
            System.out.print("\n\n" + N + BLANKS);
            for(int i = 1; i <=6; i++) {
            data = new int[N];
            generator = new Random();
            //Generates array of size N of random integers
            for(int j = 0; j < N; j++)
            {
                data[j] = generator.nextInt(N);
            }
             
            System.out.print(sort(i, data, data.length) + BLANKS);  
            if(N == 1000)
                System.out.print(" ");
           }
        }
      
        System.out.println("\n----------------------------------------------------------------------------------------------");
    }
  
    public static int sort(int i, int[] data, int n)
    {
        int numOfComparisons= 0;
        switch(i)
        {
            case 1:
                numOfComparisons = Select.selectionsort(data, 0, n);
                break;
            case 2:
                numOfComparisons = Insert.insertionsort(data, 0, n);
                break;
            case 3:
                numOfComparisons = Mergesort.mergesort(data, 0, n);
                break;
            case 4:
                numOfComparisons = Quicksort.quicksort(data, 0, n);
                break;
            case 5:
                numOfComparisons = Heapsort.heapsort(data, n);
                break;
            case 6:
                numOfComparisons = NlogN.calculate(n);
        }
        return numOfComparisons;
    }
  
    public static void nameOfSort(int i)
    {
        switch(i)
        {
            case 1:
                System.out.println("Selection Sort:");
                break;
            case 2:
                System.out.println("Insertion Sort:");
                break;
            case 3:
                System.out.println("Merge Sort:");
                break;
            case 4:
                System.out.println("Quick Sort:");
                break;
            case 5:
                System.out.println("Heap Sort:");
                break;
        }
    }
}