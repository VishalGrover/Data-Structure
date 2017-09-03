package Array;

public class SubArrayWithGivenSum {
    public static void main(String[] args){
        int arr[] = {15, 2, 4, 8, 9, 5, 10, 23};
        int sum = 24;
        subArrWithSum(arr, sum);

        int arr2[] = {10, 2, -2, -20, 10};
        int sum2 = -10;
        subArrWithSum(arr2, sum2);
    }

    public static void subArrWithSum(int[] arr, int sum){
        int length = arr.length;
        for(int i = 0; i < length; i++){
            int j = i;
            int currSum = sum;
            while(j < length && currSum >= arr[j]){
                currSum -=  arr[j];
                if(currSum == 0){
                    System.out.println("The two positions are " + i + " and " + j);
                    return;
                }
                j++;
            }
        }
        System.out.println("There is no such subArray found"); // {1,2,3} sum = 4 should not be found
    }
}
