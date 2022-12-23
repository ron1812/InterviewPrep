package com.practice.company;

import java.util.*;
import java.util.stream.Collectors;

public class SmallestNegativeBal {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Alex Blake 2", "Blake Alex 2", "Casey Alex 5", "Blake Casey 7", "Alex Blake 4", "Alex Casey 4");
       // List<String> strings = Arrays.asList("Alex Blake 5", "Blake Alex 3", "Casey Alex 7", "Casey Alex 4", "Casey Alex 2");

        List<List<String>> collect = strings.stream().map(x -> Arrays.asList(x.split(" "))).collect(Collectors.toList());

        System.out.println(getSmallestNegativeBalance(collect));
        System.out.println(getSmallestNegativeBalanceV2(collect));
    }

    public static List<String> getSmallestNegativeBalance(List<List<String>> debts){

        Map<String,Integer> borrwMap = new HashMap<>();
        Map<String,Integer> lenderMap = new HashMap<>();

        for(List list :debts)
        {
            int amount = Integer.parseInt((String) list.get(2));
            borrwMap.put((String) list.get(0),( borrwMap.getOrDefault((String)list.get(0),0) - amount));
            lenderMap.put((String) list.get(1),( lenderMap.getOrDefault((String)list.get(1),0) + amount));
        }

        LinkedList<String> minNegList = new LinkedList<>();
        Integer minMoney = Integer.MAX_VALUE;
        for(Map.Entry<String, Integer> entry : borrwMap.entrySet())
        {
            Integer lenderMoney = lenderMap.getOrDefault(entry.getKey(),0);
            Integer borrowerMoney = borrwMap.getOrDefault(entry.getKey(),0);

            int i = borrowerMoney + lenderMoney;

            if(i < 0){
                if(i < minMoney){
                    minNegList.clear();
                    minNegList.add(entry.getKey());
                    minMoney = i;
                }else if(i == minMoney){
                    minNegList.add(entry.getKey());
                }
            }
        }

        Collections.sort(minNegList);

        return minNegList.isEmpty() ? Collections.singletonList("Nobody has a negative balance") : minNegList;
    }

    public static List<String> getSmallestNegativeBalanceV2(List<List<String>> debts){

        Map<String,Integer> borrwLendMap = new HashMap<>();

        for(List list :debts)
        {
            int amount = Integer.parseInt((String) list.get(2));

            borrwLendMap.put((String) list.get(0),( borrwLendMap.getOrDefault((String)list.get(0),0) - amount));
            borrwLendMap.put((String) list.get(1),( borrwLendMap.getOrDefault((String)list.get(1),0) + amount));
        }

        List<String> minNegList = new ArrayList<>();
        Integer minMoney = Integer.MAX_VALUE;
        for(Map.Entry<String, Integer> entry : borrwLendMap.entrySet())
        {
            Integer money = borrwLendMap.getOrDefault(entry.getKey(),0);

            if(money < 0){
                if(money < minMoney){

                    minNegList.clear();
                    minNegList.add(entry.getKey());
                    minMoney = money;
                }else if(money.equals(minMoney)){

                    minNegList.add(entry.getKey());
                }
            }
        }

        Collections.sort(minNegList);

        return minNegList.isEmpty() ? Collections.singletonList("Nobody has a negative balance") : minNegList;
    }
}
