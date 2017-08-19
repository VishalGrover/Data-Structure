package Array;

public class MinElementInSortedNRotated {
    public static void main(String[] args){
        int[] arr = {5, 6, 1, 2, 3, 4};
        minElementInSortedNRotated(arr, 0, arr.length - 1);

        int[] arr1 = {1, 2, 3, 4};
        minElementInSortedNRotated(arr1, 0, arr1.length - 1);

        int[] arr2 = {2, 1};
        minElementInSortedNRotated(arr2, 0, arr2.length - 1);

    }
    public static void minElementInSortedNRotated(int[] arr, int left, int right){
        if(arr[left] > arr[right]){
            int mid = (left + right)/2;
            System.out.println("mid is " + mid);
            if (arr[left] > arr[mid]){
                minElementInSortedNRotated(arr, left, mid);
            }
            else {
                minElementInSortedNRotated(arr, mid + 1, right);
            }
        }
        else{
            System.out.println("Minimum element is " + arr[left]);
        }

    }
}
