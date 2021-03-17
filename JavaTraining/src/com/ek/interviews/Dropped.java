package com.ek.interviews;

import java.util.ArrayList;
import java.util.List;

/*
Coding Amazon Problem

Se ingresa una lista de request
> A los 3 request el siguiente debe ser Dropped
> A los 20 rquest, el siguiente debe ser Dropped
> Si hay un dropped por 20 request y el valor del request es mayor a 10, debe ser Dropped
 */

public class Dropped {
    static int droppedRequests(int num, List<Integer> requestTime) {
        System.out.println("num (number of request: " + num);
        System.out.println("requestTime" + requestTime);
        int count = 0;
        int count20 = 0;
        int count1020 = 0;
        int nDropped = 0;


        for (int i = 0; i< requestTime.size(); i++){
            if(i < requestTime.size() -1){
                if(requestTime.get(i).equals(requestTime.get(i+1))){
                    count++;
                } else {
                    count = 0;
                }
            }
            if( count == 3){
                nDropped++;
            }
            count20++;
            if(count20 == 20){
                nDropped++;
            }

            if(requestTime.get(i).equals(10)){
                count1020++;
            }
            if(count1020 == 20){
                nDropped++;
            }
        }

        return nDropped;
    }

    public static void main(String[] args){

        // TEST 1
//        List<Integer> requestTime = new ArrayList<>(List.of(1,1,1,1,2));
//        int nDropped2 = 0;
//        int num = 5;

        //test2
        List<Integer> requestTime = new ArrayList<>(List.of(1,1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,11,11,11,11));
        int nDropped2 = 0;
        int num = 21;

        nDropped2 = droppedRequests(num, requestTime);

        System.out.println(nDropped2);

    }
}
