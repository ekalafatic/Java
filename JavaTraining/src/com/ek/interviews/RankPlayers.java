package com.ek.interviews;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Coding Amazon Problem
Se brinda un arreglo de puntajes (scores) con puntajes de jugadores.
Se debe puntuar a cada jugador según salgan primeros, segundos, etc.
Se brinda un cuttOffRank para limitar la cantidad de posiciones.
Se debe devolver la cantidad de jugadores que haya para determinada posición en adelante.

Ej: (100,50,50,25)
 */
public class RankPlayers {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    static int numPlayers(int cutOffRank, int num, ArrayList<Integer> scores) {
        int nPlayers = 0;

        if(scores.isEmpty() || cutOffRank == 0 || num == 0){
            return nPlayers;
        }

        ArrayList<Integer> rank = new ArrayList<Integer>();

        System.out.println("num -> cantidad de jugadores: " + num);
        System.out.println("cutOffRank -> corte de posiciones: " + cutOffRank);
        System.out.println("scores -> puntajes: " + scores);

        // Se ordena de forma descendiente la lista de scores
        Collections.sort(scores, Collections.reverseOrder());

        int score = 1;

        for (int i = 0; i<scores.size(); i++) {
            if(i == 0){
                rank.add(score);
            } else
                // Si el siguiente score es igual al anterior, tienen el mismo rank
            if(scores.get(i-1) == scores.get(i)){
                rank.add(rank.get(i-1));
            }else{
                score++;
                rank.add(score);
            }
        }

        for (int i = 0; i<rank.size(); i++){
            if(rank.get(i) <= cutOffRank){
                nPlayers++;
            }
        }

        System.out.println("Rank: " + rank);

        return nPlayers;

    }

    public static void main(String[] args) {
        // TEST 1
        ArrayList<Integer> scores = new ArrayList<Integer>(List.of(100,50,50,25));
        int cutOffRank = 2;
        int num = 5;
        int nPlayers;


        // TEST 2
//        ArrayList<Integer> scores = new ArrayList<Integer>();
//        int cutOffRank = 4;
//        int num = 5;
//        int nPlayers;

        // TEST 2
//        ArrayList<Integer> scores = new ArrayList<Integer>(List.of(100,50,50,25));
//        int cutOffRank = 5;
//        int num = 0;
//        int nPlayers;

        nPlayers = numPlayers(cutOffRank, num, scores);

        System.out.println("nPlayers " + nPlayers);


    }


}
