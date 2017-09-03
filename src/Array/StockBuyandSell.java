package Array;

import java.util.ArrayList;
import java.util.List;

public class StockBuyandSell {
    public static void main(String[] args){
        int[] arr = {100, 120, 130, 140, 60, 50, 40};
        buyandSellStock(arr);
    }

    public static void buyandSellStock(int[] arr){

        List<Invest> list = new ArrayList<>();
        int i = 0;
        int len = arr.length;
        while (i < len){

            while(i< len -1 && arr[i + 1] <= arr[i]){
                i++;
            }
            if(i == len -1){
                break;
            }
            Invest invest = new Invest();
            invest.buy = i;
            i++;

            while(i < len && arr[i] >= arr[i -1]){
                i++;
            }
            invest.sell = i - 1;

            list.add(invest);

        }

        list.forEach((Invest x)->{System.out.println("Best time to buy  is: " + x.buy + " and to sell is : " + x.sell);});
    }
}

class Invest{
    int buy, sell;
}