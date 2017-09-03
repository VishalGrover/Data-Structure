package Array;

import java.util.ArrayDeque;
import java.util.Deque;

public class JumpingNumber {
    public static void main(String[] args){
        printJumpingNumber(30);
    }

    public static void printJumpingNumber(int num){

        for(int i =1 ; i < 9; i++){
            Deque<Integer> queue = new ArrayDeque<>();
            queue.add(i);

            while(!queue.isEmpty()){
                int x = queue.peek();
                queue.pop();

                if(x < num){
                    System.out.println(x);

                    int last_dig = x%10;

                    if(last_dig == 0){
                        queue.add(x*10 + 1);
                    }
                    else if(last_dig == 9){
                        queue.add(x*10 + 8);
                    }
                    else{
                        queue.add(x*10 + last_dig -1);
                        queue.add(x*10 + last_dig +1);
                    }
                }
            }
        }
    }
}
