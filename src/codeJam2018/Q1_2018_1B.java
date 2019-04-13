package codeJam2018;

import java.util.*;
import java.io.*;

//Rounding Error(5, 9, 11), first two visible, last one hidden
//Passed all
public class Q1_2018_1B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int numCase = 1; numCase <= T; numCase++) {
            int N = in.nextInt(), L = in.nextInt(), nVoted, ans = 0, idx = 0, sum = 0, num;
            double percentPP = 100.0/N;
            List<Integer> votes = new ArrayList();
            for(int i = 0; i < L; i++){
                num = in.nextInt();
                votes.add(num);
                sum += num;
            }
            nVoted = N - sum;

            if(100 % N == 0){
                //There won't be any decimals, thus, no need for any strategy
                ans = 100;
            }
            else if(percentPP - 100/N >= 0.5){
                //if the decimal of each vote is greater than 0.5, just make a programming language for every person not
                //voted yet and add up those voted.
                ans += Math.round(percentPP)*(nVoted);
                for(int vote : votes){
                    ans += Math.round(percentPP*vote);
                }
            }
            else{
                //
                Collections.sort(votes, (num1, num2) ->  Double.compare(num2*percentPP - (int)(num2*percentPP),
                        num1*percentPP - (int)(num1*percentPP) ));

                while(nVoted > 0 && idx < votes.size()){
                    num = votes.get(idx);
                    if( Double.compare(num*percentPP - (int)(num*percentPP), 0.5) >= 0){
                        ans += Math.round(percentPP*num);
                        idx++;
                    }
                    else{
                        nVoted--;
                        votes.set(idx, votes.get(idx)+1);
                    }
                }
                while(idx < votes.size()){
                    ans += Math.round(percentPP*votes.get(idx++));
                }
                if(nVoted > 0){
                    int leastReq = (int)Math.ceil(0.5/(percentPP - (int)percentPP));
                    ans += (nVoted/leastReq)* Math.round(leastReq*percentPP);
                    ans += (nVoted%leastReq)* Math.round(percentPP);

                }
            }
            System.out.println("Case #" + numCase + ": " + ans);
        }
    }

}
