import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int numCase = 1; numCase <= T; numCase++) {
            int D = in.nextInt();
            String P = in.next();


            int numC = 0, numS = 0, count = 0, totalDamage = 0;
            String ans = "IMPOSSIBLE";
            for(int i = 0; i < P.length(); i++){//Counting how many C
                if(P.charAt(i) == 'C')
                    numC++;
                else
                    numS++;
            }
            if(!(numS > D)) {//If more number of 'S' than D, return impossible
                int[] counter = new int[numC];
                numC = 0;
                for(int i = 0; i < P.length(); i++){
                    if(P.charAt(i) == 'C') {
                        numC++;
                    }
                    else {
                        if(numC > 0) {
                            counter[numC - 1]++;
                        }
                        totalDamage += 1<<numC;//Calculating total Damage
                    }
                }
                //Greedy process to minimize damage with 1 swap at a time
                //The 'S' with the most 'C' before it contribute the most damage, thus, always swap the last S first.
                while(totalDamage > D && numC > 0){

                    if(counter[numC - 1] > 0) {
                        totalDamage -= 1<<(numC - 1);
                        counter[numC - 1]--;
                        if(numC - 2 >= 0){
                            counter[numC - 2]++;
                        }
                        count++;
                    }
                    else{
                        numC--;
                    }

                }
                ans = count+"";
            }
            System.out.println("Case #" + numCase + ": " + ans);

        }
    }
}
