package com.practice.array;

public class BuyAndSellStocks {

    /*
    a = 7 1 5 3 6 4
    min = a[0]
    maxProfit = 0

    for(i=1 --> a.len-1)
    maxProfit =  Math.max(maxProfit,a[i]-min)

            -->max(0,(1-7)-> -6) = 0
            -->max(0,(5-1)-> 4) = 4
            -->max(4,(3-1)-> 2) = 4
            -->max(4,(6-1)-> 5) = 5
            -->max(5,(4-1)-> 5) = 5

    min = Math.min(min,a[i])

            -->min(7,1) = 1
            -->min(1,5) = 1
            -->min(1,3) = 1
            -->min(1,6) = 1
            -->min(1,4) = 1
    */

    public static void main(String[] args) {
        int[] a = {7 ,1 ,5 ,3 ,6 ,4};

        int maxProfit = 0;
        int min = a[0];

        for(int i=1;i<a.length;i++){
            maxProfit = Math.max(maxProfit,a[i]-min);
            min = Math.min(min,a[i]);
        }

        System.out.println("Max profit that can be earned is "+maxProfit);
    }

}
