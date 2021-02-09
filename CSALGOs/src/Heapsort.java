public class Heapsort
{
   static int comparison = 0;
   public static int heapsort(int[ ] data, int n)
   {
      int unsorted; // Size of the unsorted part of the array
      int temp;     // Used during the swapping of two array locations

      makeHeap(data, n);

      unsorted = n;

      while (unsorted > 1)
      {
         unsorted--;

         // Swap the largest element (data[0]) with the final element of unsorted part
         temp = data[0];
         data[0] = data[unsorted];
         data[unsorted] = temp;
         comparison++;

         reheapifyDown(data, unsorted);
      }
      comparison++;
    
      return comparison;
   }

   private static void makeHeap(int[ ] data, int n)
   // Precondition: data is an array with at least n elements.
   // Postcondition: The elements of data have been rearranged so that the
   // complete binary tree represented by this array is a heap.
   {
      int i, k;
      for(i = 1; i < n; i++)
      {
          k = i; //The index of the new element
          int temp = data[k];
          int parent = (k-1)/2;
          while(k > 0 && temp > data[parent])
          {
            data[k] = data[parent];
            k = parent;
            parent = (k-1) /2;
          }
          data[k] = temp;
      }
   }

   private static void reheapifyDown(int[ ] data, int n)
   {
      int current;
      int bigChildIndex=0;
      boolean heapOkay;
    
      current = 0;
      heapOkay = false;
    
      while( (!heapOkay) && (!isLeaf(data, current) ) )// & current node is not a leaf
      {
          //sets bigchildindex to be the index of the larger child of the current node
          if(2*current +2 < n) {
              if(data[2*current +2] > data[2*current +1])
                 bigChildIndex = 2*current +2;
              else
                 bigChildIndex = 2*current +1;
          }
          else if(2*current +1 < n)
               bigChildIndex = 2*current +1;
   
          if(data[current] < data[bigChildIndex])
          {
              int temp = data[current];
              data[current] = data[bigChildIndex];
              data[bigChildIndex] = temp;
              current = bigChildIndex;
              comparison++;
          }
          else
            heapOkay = true;
      }
   }
   public static boolean isLeaf(int[] data, int index)
   {
       if((2*index+1 > data.length) && (2*index+1 > data.length))
        return true;
       else
        return false;
   }
}