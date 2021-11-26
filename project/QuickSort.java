import java.util.ArrayList;

public class QuickSort {
  public static void quickSort(int[] list, ArrayList<String> a, ArrayList<Integer> b) {
    a.add("pivote");
    b.add(0);
    quickSort(list, 0, list.length - 1,a,b);
  }

  private static void quickSort(int[] list, int first, int last, ArrayList<String> a, ArrayList<Integer> b) {
    if (last > first) {
      int pivotIndex = partition(list, first, last,a,b);
      a.add("pivot");
      b.add(pivotIndex);
      quickSort(list, first, pivotIndex - 1,a,b);
      quickSort(list, pivotIndex + 1, last,a,b);
    }
  }

  /** Partition the array list[first..last] */
  private static int partition(int[] list, int first, int last, ArrayList<String> a, ArrayList<Integer> b) {
    int pivot = list[first]; // Choose the first element as the pivot
    int low = first + 1; // Index for forward search
    a.add("low");
    b.add(low);
    int high = last; // Index for backward search
    a.add("high");
    b.add(high);

    while (high > low) {
      // Search forward from left
      while (low <= high && list[low] <= pivot){
        low++;
        a.add("low");
        b.add(low);
      }

      // Search backward from right
      while (low <= high && list[high] > pivot){
        high--;
        a.add("high");
        b.add(high);
      }

      // Swap two elements in the list
      if (high > low) {
        int temp = list[high];
        list[high] = list[low];
        list[low] = temp;
        a.add("c_low_high");
        b.add(-1);
      }
    }

    while (high > first && list[high] >= pivot){
      high--;
      a.add("high");
      b.add(high);
    }

    // Swap pivot with list[high]
    if (pivot > list[high]) {
      list[first] = list[high];
      list[high] = pivot;
      a.add("c_pivot");
      b.add(-2);
      return high;
    }
    else {
      return first;
    }
  }

  /** A test method */
  public static void main(String[] args) {
    ArrayList<String> claves = new ArrayList<>();
    ArrayList<Integer> valores = new ArrayList<>();
  
    int[] list = {13, 2, 5, 5, 8, 1, 4, 2, 3, 6};
    quickSort(list,claves,valores);
    for (int i = 0; i < list.length; i++)
      System.out.print(list[i] + " ");
      
    System.out.print("\n");
      
    String[] claves1 = new String[4];
    claves1 = claves.toArray(claves1);
    Integer[] valores1 = new Integer[4]; 
    valores1 = valores.toArray(valores1);
    
    for(int i=0;i<claves1.length;i++){
      System.out.print(claves1[i] + " ");
    }
    
    System.out.print("\n");
    
    for(int i=0;i<valores1.length;i++){
      System.out.print(valores1[i] + " ");
    }
    
  }
}
