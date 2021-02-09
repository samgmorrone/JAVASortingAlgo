public class Quicksort
{
   static int comparison = 0;
   public static int quicksort(int[ ] data, int first, int n)
   {
      int pivotIndex; // Array index for the pivot element
      int n1;         // Number of elements before the pivot element
      int n2;         // Number of elements after the pivot element
    
      if (n > 1)
      {
         // Partition the array, and set the pivot index.
         pivotIndex = partition(data, first, n);

         // Compute the sizes of the two pieces.
         n1 = pivotIndex - first;
         n2 = n - n1 - 1;
      
         // Recursive calls will now sort the two pieces.
         quicksort(data, first, n1);
         quicksort(data, pivotIndex + 1, n2);
      }
      return comparison;
   }

   private static int partition(int[ ] data, int first, int n)
   {
        int pivot = data[first]; // Choose the first element as the pivot
        int tooBigIndex = first + 1; // Index of element after pivot
        int tooSmallIndex = first + n -1; // Index of last element
  
        while (tooBigIndex <= tooSmallIndex) {
          // Search forward from left
          while (tooBigIndex <= tooSmallIndex && data[tooBigIndex] <= pivot)
            tooBigIndex++;

          // Search backward from right
          while (data[tooSmallIndex] > pivot)
            tooSmallIndex--;

  
          // Swap two elements in the list
          if (tooBigIndex < tooSmallIndex) {
            int temp = data[tooSmallIndex];
            data[tooSmallIndex] = data[tooBigIndex];
            data[tooBigIndex] = temp;
          }
          comparison++;
        }
  
        data[first] = data[tooSmallIndex];
        data[tooSmallIndex] = pivot;
        return tooSmallIndex;
   }
}