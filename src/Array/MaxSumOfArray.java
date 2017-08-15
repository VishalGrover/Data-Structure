package Array;

public class MaxSumOfArray {
    public static void main(String[] args){
        int[] arr = {8,3,1,2};
        maxSum(arr);
    }

    public static void maxSum(int[] arr){
        int len = arr.length;

        int maxSum = 0;

        for(int i = 0; i < len; i++){

            int sum = 0;

            for(int j = 0; j < len; j++){
                int index = (i + j)%len;
                sum += index*arr[j];
            }

            if(sum > maxSum){
                maxSum = sum;
            }
        }


        System.out.println("sum is " + maxSum);
    }
}
