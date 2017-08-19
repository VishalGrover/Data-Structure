package Array;
/*
In this problem there is an array we need to find out the maximum sum of the elements such that no two elements are adjacents
Input : arr[] = {5, 5, 10, 100, 10, 5}
Output : 110 (Using arr locations : 1,3,5)

Link : http://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/

The best way to think about this problem in for each element we have two options either to include it or exclude it.
Theorem : We need to maintaing Inclusive and Exclusive sum for each element in the array. Inclusive means including that element n vice versa.
case 1 : Include it : While iteration over each element if we decide that this element need to be included then we need to make sure that its previous
element should be excluded. i.e. : sumExclusive(n-1) + a[n]
case 2 : Exclude it : If we have decided that this element need to be excluded then we need to get the max of inclusive and exclusive for last element
i.e. : max(sumExclusive(n -1), sumInclusive(n -1))
 */

public class MaxSumInNonAdjacent {
    public static void main(String[] args){
        int[] arr = {5,5,10,100,10,5};
        maxSumInNonAdjacent(arr);
    }

    public static void maxSumInNonAdjacent(int[] arr){
        int len = arr.length;
        int inclusiveSum = arr[0];
        int exclusiveSum = 0;

        for (int i =1; i < len; i++){
            int sumIncludingThis = exclusiveSum + arr[i]; //need to store the value in some variable 
            exclusiveSum = Math.max(inclusiveSum, exclusiveSum);
            inclusiveSum = sumIncludingThis;
        }

        System.out.println("Maximu sum is : " + Math.max(inclusiveSum, exclusiveSum));
    }
}
