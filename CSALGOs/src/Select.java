public class Select
{
   static int comparison = 0;
   public static int selectionsort(int[ ] data, int first, int n)
   {
      int i, j; // Loop control variables
      int big; // Index of largest value in data[first]...data[first+i]
      int temp; // Used during the swapping of two array values
      for (i = n-1; i > 0; i--)
      {
         // Calculate big as the index of the largest value in data[first]...data[first+i]:
         big = first;
         for (j = first+1; j <= first+i; j++)
         {
            comparison++;
            if (data[big] < data[j])
               big = j;
         }
    
         // swap data[first+i] with data[big]:
         temp = data[first+i];
         data[first+i] = data[big];
         data[big] = temp;
      }
      return comparison;
   }  
}

