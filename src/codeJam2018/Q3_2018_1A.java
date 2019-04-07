package codeJam2018;

import java.util.*;
import java.io.*;


//Edgy Baking(14, 29)
public class Q3_2018_1A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int numCase = 1; numCase <= T; numCase++) {

            int N = in.nextInt(), P = in.nextInt();
            double sum = 0, ans = 0, maxAdd = 0, minSide = 250;
            for(int i = 0; i < N; i++){
                int W = in.nextInt(), H = in.nextInt();
                sum += 2*(W+H);
                minSide = Math.min(minSide, Math.min(W,H));
                maxAdd += 2*Math.sqrt(W*W + H*H);
            }

            if(P < (sum + 2*minSide))
                ans = sum;
            else if(P <=  (sum + maxAdd))
                ans = P;
            else
                ans = sum+maxAdd;

            System.out.println("Case #" + numCase + ": " + ans);
        }
    }

}
