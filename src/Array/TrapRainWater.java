package Array;

/*The main thing here is we will look at each of the block and calculate how much water can be filled in it.
*   |
*   |__|   (2,0,1
*   So the formula is : water stored in each block = Min(leftHeight,rightHeight) - blockHeight
*/
public class TrapRainWater {
    public static void main(String[] args){
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        maxRainWater(arr);
    }

    public static void maxRainWater(int[] arr){
        int len = arr.length;
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        int water = 0;
        left[0] = arr[0];
        right[len - 1] = arr[len -1];
        for (int i = 1;i < len; i++){
            left[i] = Math.max(left[i - 1], arr[i]);
        }

        for (int i = len -2;i > -1; i--){
            right[i] = Math.max(right[i + 1], arr[i]);
        }

        for(int i = 0; i < len; i++){
            water += Math.min(left[i], right[i]) -arr[i];
        }

        System.out.println("Total water stored " + water);
    }
}
