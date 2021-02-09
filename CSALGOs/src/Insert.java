public class Insert
{
static int comparison = 0;
   public static int insertionsort(int[ ] data, int first, int n)
   {
      int entry; // The element that is currently being inserted
      int j;
       
      for (int i = 1; i < n; i++)
      {
         entry = data[first+i];
         for (j = first+i; (j>first) && (data[j-1] > entry); j--)
         {
                data[j] = data[j-1];
                comparison++;
         }
         comparison++;
         data[j] = entry;
      }
      return comparison;
}
}

