/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class MedianOfString {
	public static void main (String[] args) {
		System.out.println("GfG!");
		int[] arr = {24,12,31,10};
		getMedianOfArray(arr);
	}
	
	public static void getMedianOfArray(int[] arr){
	    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
	   
	    PriorityQueue<Integer> maxLambdaHeap = new PriorityQueue<Integer>(arr.length, 
	    (Integer a, Integer b) -> {return b.compareTo(a);});
	    double[] median = new double[arr.length];
	    for(int i =1; i< arr.length; i++){
	        int number = arr[i];
	        //addElement in min or max heap 
	        //balance the two heaps
	        //Print the median
	        addNumber(number, maxLambdaHeap, minHeap);
	        rebalance(maxLambdaHeap, minHeap);
	        median[i] = getMedian(maxLambdaHeap, minHeap);
	    }
	    
	    for(int m = 0; m <median.length; m++){
	        System.out.println(median[m]);
	    }
	}
	
	public static void addNumber(int number, PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap){
	    if(maxHeap.isEmpty() || number < maxHeap.peek()){
	        maxHeap.add(number);
	    }
	    else{
	        minHeap.add(number);
	    }
	}
	
	public static void rebalance(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap){
	    int maxHeapSize = maxHeap.size();
	    int minHeapSize = minHeap.size();
	    if((maxHeapSize > minHeapSize) && ((maxHeapSize - minHeapSize) == 2)){
	        int maxElement = maxHeap.poll();
	        minHeap.add(maxElement);
	    }
	    else if((maxHeapSize < minHeapSize) && ((minHeapSize - maxHeapSize) == 2)){
	        int minElement = minHeap.poll();
	        maxHeap.add(minElement);
	    }
	}
	
	public static int getMedian(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap){
	    if(maxHeap.size() > minHeap.size()){
	        return maxHeap.peek();
	    }
	    else if (minHeap.size() > maxHeap.size()){
	        return minHeap.peek();
	    }
	    else{
	        return (minHeap.peek() + maxHeap.peek())/2;
	    }
	}
}
