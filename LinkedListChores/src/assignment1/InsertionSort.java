package assignment1;

public class InsertionSort {
    public void insertionSort(int [] nums) {
        int n = nums.length;
        for (int i = 1; i < n; ++i) {
            int pivot = nums[i];
            int j = i - 1;

            while (j >= 0 && nums[j] > pivot) {
                nums[j + 1] = nums[j];
                j = j - 1;
            }
            nums[j + 1] = pivot;
        }
    }
    public static void main(String[] args){
        int[] arr = {3,5,1,9,12,15};
        InsertionSort obj = new InsertionSort();
        obj.insertionSort(arr);
        System.out.print("sorted array: ");
        for(int num: arr){
            System.out.print(num+"\t");

        }
    }
}
