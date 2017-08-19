package Array;

import java.util.Arrays;
import java.util.ArrayList;

/*
The main aim here is to find the pythagorean triplet in an array of integers.
Method 1 :  Use brute force approach where we ran three loops  and check x*2 = y*2 + z*2
Method 2 : Its a three step process
            a. make square of each element  O(n)
            b. sort the array O(nlogN)
            c. use meet in the middle algorithm to find a given two element a,b in array with sum c (which is last element in array)
 */
public class PythaGoreanTriplet {
    public static void main(String[] args){
        int[] arr = {10,4,6,12,5,9,13};
        PythaGoreanTripletMethod1(arr);
        PythaGoreanTripletMethod2(arr);
    }

    public static boolean PythaGoreanTripletMethod1(int[] arr){
        int len = arr.length;

        for(int i = 0; i < len - 2; i++){
            for(int j = i + 1; j < len - 1; j++){
                for(int k = j + 1; k < len; k++){
                    int x = arr[i]*arr[i];
                    int y = arr[j]*arr[j];
                    int z = arr[k]*arr[k];
                    if((x + y) == z){
                        System.out.println(arr[i] + ", " + arr[j] + ", " + arr[k]);
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static boolean PythaGoreanTripletMethod2(int[] arr){
        int len = arr.length;

        for(int i = 0; i < len; i++){
            arr[i] = arr[i]*arr[i];
        }
        Arrays.sort(arr);

        for (int i = len - 1; i >0; i--){
            int finalSum = arr[i];
            System.out.println(finalSum);

            int l = 0, r = i - 1;
            while(l < r){
                if((arr[l] + arr[r]) == finalSum){
                    System.out.println(arr[l] + ", " + arr[r] + ", " + finalSum);
                    return  true;
                }

                if((arr[l] + arr[r]) < finalSum){
                    l++;
                }
                else{
                    r--;
                }
            }
        }


        return false;
    }
}
