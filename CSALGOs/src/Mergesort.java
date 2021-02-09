public class Mergesort
{
   static int comparison = 0;
   public static int mergesort(int[ ] data, int first, int n)
   {
      int n1; // Size of the first half of the array
      int n2; // Size of the second half of the array

      if (n > 1)
      {
         // Compute sizes of the two halves
         n1 = n / 2;
         n2 = n - n1;

         mergesort(data, first, n1);      // Sort data[first] through data[first+n1-1]
         mergesort(data, first + n1, n2); // Sort data[first+n1] to the end

         // Merge the two sorted halves.
         comparison = comparison + merge(data, first, n1, n2);
      }
      return comparison;
   }

   private static int merge(int[ ] data, int first, int n1, int n2)
   {
      int[ ] temp = new int[n1+n2]; // Allocate the temporary array
      int copied = 0; // Number of elements copied from data to temp
      int copied1 = 0; // Number copied from the first half of data
      int copied2 = 0; // Number copied from the second half of data
      int i;           // Array index to copy from temp back into data
      int count = 0;

      // Merge elements, copying from two halves of data to the temporary array.
      while ((copied1 < n1) && (copied2 < n2))
      {
         if (data[first + copied1] < data[first + n1 + copied2]) {
            temp[copied++] = data[first + (copied1++)];
            count++; }
         else {
            temp[copied++] = data[first + n1 + (copied2++)];
            count++; }
      }

      // Copy any remaining entries in the left and right subarrays.
      while (copied1 < n1) {
         temp[copied++] = data[first + (copied1++)];
         count++; }
      while (copied2 < n2) {
         temp[copied++] = data[first + n1 + (copied2++)];
         count++; }

      // Copy from temp back to the data array.
      for (i = 0; i < n1+n2; i++)
         data[first + i] = temp[i];
    
      return count;
   }
}