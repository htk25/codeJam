package codeJam2018;

import java.util.*;
import java.io.*;

//passed both visible and hidden test sets
//Bit Party(11, 21)

public class Q2_2018_1A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int numCase = 1; numCase <= T; numCase++) {
            int R = in.nextInt(), B = in.nextInt(), C = in.nextInt();
            int M,S,P;
            long t, left = 1, right = Long.MAX_VALUE, sum1 = 0;
            //Creating a list of cashiers
            //O(C)
            List<Cashier> l = new ArrayList();
            for(int i = 0; i < C; i++){
                M = in.nextInt();
                S = in.nextInt();
                P = in.nextInt();
                l.add(new Cashier(M,S,P));
            }
            //Binary search through all possible time to find the min time that can fulfill the request
            while (left < right) {
                t = left + (right - left) / 2L;
                sum1 = 0;

                for (Cashier c : l) {
                    c.calItem(t);
                }
                Collections.sort(l, (o1, o2) -> o2.totalItems - o1.totalItems);
                for (int i = 0; i < R; i++) {
                    sum1 += l.get(i).totalItems;
                    //System.out.println("items"+i+": "+l.get(i).totalItems);
                }
                //System.out.println(left+", "+ right+ ", "+sum1+", "+B+", T: "+t);

                if (sum1 < B)
                    left = t+1;
                else
                    right = t;
            }
            System.out.println("Case #" + numCase + ": " + left);
        }
    }

    static class Cashier{
        int M, S, P, totalItems;
        public Cashier(int m, int s, int p){
            M = m;
            S = s;
            P = p;
            totalItems = 0;
        }

        // Create local long var for long operations(P.S. this approach doesn't work b/c long operations take too much
        // time...)
        //
        public void calItem(long time){
            totalItems = (int)Math.max(0, Math.min(M, Math.floor((time - P)/S) ));
        }
    }

}
