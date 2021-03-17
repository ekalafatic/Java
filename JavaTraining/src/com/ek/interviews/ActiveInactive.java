package com.ek.interviews;

import java.util.ArrayList;
import java.util.Arrays;

public class ActiveInactive {
    public static int[] cellCompete(int[] cells, int days){
        int[] newCells = {0,0,0,0,0,0,0,0};
        int cellsLength = cells.length;


        for(int day = 0; day < days; day++ ){
            System.out.println("DAY "+ day);

            for(int j = 0; j < cellsLength; j++ ){

                // start
                if(j==0){
                    // If the neighbours aren't equal, active the cell
                    if(cells[j+1] == 1){
                        newCells[j] = 1;
                    } else {
                        newCells[j] = 0;
                    }
                    System.out.println("J = 0: "+ j);
                } else
                    // end
                    if(j==cellsLength-1){
                        System.out.println("J = cells.length-1: "+ j);

                        // If the neighbours aren't equal, active the cell
                        if(cells[j-1] == 1){
                            newCells[j] = 1;
                        } else {
                            newCells[j] = 0;
                        }
                    } else
                        if(cells[j-1] == cells[j+1]) {
                            System.out.println("cells[j-1] == cells[j+1]: "+ j);
                            System.out.println("cells[j-1] Y cells[j+1]: "+ cells[j-1] + " " + cells[j+1]);
                            newCells[j] = 0;
                        }else{
                            System.out.println("cells[j-1] != cells[j+1]: "+ j);
                            System.out.println("cells[j-1] Y cells[j+1]: "+ cells[j-1] + " " + cells[j+1]);
                            newCells[j] = 1;
                        }
            }

            System.out.println("Newcells modificado");
            for (int i = 0; i< newCells.length; i++){
                System.out.print(newCells[i] + " ");
            }
            System.out.println();

            // cells updated
            cells = newCells.clone();

            System.out.println("cells modificado");
            for (int i = 0; i< cells.length; i++){
                System.out.print(cells[i] + " ");
            }
            System.out.println();
        }

        return newCells;
    }

    public static void main(String[] args) {
        int[] newCells2 = {0,0,0,0,0,0,0,0};

        // Test 1
//        int[] cells = {1,0,0,0,0,1,0,0};
//        int days = 1;

        // Test 2
        int[] cells = {1,1,1,0,1,1,1,1};
        int days = 2;

        newCells2 = cellCompete(cells,  days);

        for (int i = 0; i< newCells2.length; i++){
            System.out.print(newCells2[i] + " ");
        }
    }



}
