package codeJam2018;

import java.util.*;
import java.io.*;

//Mysterious Road Signs (10,20), current solution only passed the visible set
public class Q2_2018_1B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int numCase = 1; numCase <= T; numCase++) {
            int S = in.nextInt(), max = 1, count = 0;
            int[][] signs = new int[S][2];

            Map<String, Integer> map = new HashMap();
            for(int i = 0; i < S; i++){
                int D = in.nextInt(), A = in.nextInt(), B = in.nextInt();
                signs[i][0] = D + A;
                signs[i][1] = D - B;
            }


      outer:for(int i = S; i > 0; i--){
                int j = 0;
                while(j + i <= S){
                    if(checkSeq(j, j + i, signs)){
                        max = i;
                        break outer;
                    }
                    j++;
                }
            }
            int i = max, j = 0;
            while(j + i <= S){
                if(checkSeq(j, j + i, signs))
                    count++;
                j++;
            }
//            for (Map.Entry<String, Integer> entry : map.entrySet()) {
//                if(entry.getValue() == max)
//                    count++;
//            }

            System.out.println("Case #" + numCase + ": " + max + " "+count);
        }
    }

    public static boolean checkSeq(int left, int right, int[][] signs){
        List<Integer> toEast = new ArrayList();
        List<Integer> toWest = new ArrayList();

        int eIdx = left, wIdx = left, A = signs[left][0], B = -10000000;

        while(eIdx < right && ( signs[eIdx][0] == A || signs[eIdx][1] == B ) ){
            if(eIdx + 1 < right && signs[eIdx + 1][0] != A && B == -10000000)
                B = signs[eIdx + 1][1];
            eIdx++;
        }

        A = -10000000; B = signs[wIdx][1];
        while(wIdx < right && ( signs[wIdx][0] == A || signs[wIdx][1] == B ) ){
            if(wIdx + 1 < right && signs[wIdx + 1][1] != B && A == -10000000)
                A = signs[wIdx + 1][0];
            wIdx++;
        }

        return eIdx == right || wIdx == right;
    }

}
