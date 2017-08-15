package Stack;
import java.util.Stack;

/* There are two main thing in this algo is that
1. you need to take care till the bars are increasing.
2. You need to store the index not the value in hist array
Now the algo work like this,
* 1. If the bar are increasing, keep adding the index in stack.
* 2. If array empty or bar start decreasing, then pop element from stack and area= hist[pop](i - s.peek() - 1), whch multiply bar area from this point to last.
* 3. compare area with maxArea
*
*
*/

public class MaxAreaHistogram {
    public static void main(String[] args){
        int[] hist = {6,2,5,4,5,1,6};
        maxAreaInhist(hist);
    }

    public static void maxAreaInhist(int[] hist){
        int maxArea = 0;
        int area = 0;
        int length = hist.length;
        int i = 0;
        Stack<Integer> s = new Stack<>();
        while(i < length){

            if(s.empty() || hist[s.peek()] <= hist[i]){
                s.push(i);
                i++;
            }
            else{
                int upperElem = s.peek();
                s.pop();
                area = hist[upperElem]*(s.empty() ? i : (i -s.peek() - 1));

                if(area > maxArea){
                    maxArea = area;
                }
            }
        }

        while(s.empty() == false){
            int upperElem = s.peek();
            s.pop();
            area = hist[upperElem]*(s.empty() ? i : (i -s.peek() - 1));

            if(area > maxArea){
                maxArea = area;
            }
        }

        System.out.println(maxArea);

    }
}
