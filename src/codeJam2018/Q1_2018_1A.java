package codeJam2018;

import java.util.*;
import java.io.*;

public class Q1_2018_1A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();  
  outer:for (int numCase = 1; numCase <= T; numCase++) {
            int R = in.nextInt(), C = in.nextInt(), H = in.nextInt(), V = in.nextInt();
			int numChips = 0, chipsEachRow = 0, sum = 0, chipsEachPiece = 0, hIdx = 0, 
					count = 0, total = (V+1)*(H+1), prevCol = -1;
			int[] horizontalCuts = new int[H+1];
			
			int[][] p = new int[R][C];
			String tmp;
			char input;
			//Prefix sum array of recording the total number of chips 
			//in the rectangle [(0,0), (i, 0), (0, j), (i, j)]
			//O(R*C) runtime
			for(int i = 0; i < R; i++){
			    tmp = in.next();
			    sum = 0;
				for(int j = 0; j < C; j++){
					input = tmp.charAt(j);
					if(input == '@')
						sum++;
					if(i - 1 >= 0) 
						p[i][j] += p[i - 1][j];
					p[i][j] += sum;
				}
			}
			numChips = p[R - 1][C - 1];
			
			//Conditions checking, O(1)
			if(numChips % ((H+1)*(V+1)) != 0){
				System.out.println("Case #" + numCase + ": " + "IMPOSSIBLE");
				continue outer;
			}
			if(numChips == 0){
				System.out.println("Case #" + numCase + ": " + "POSSIBLE");
				continue outer;
			}
			
			//Finding the right index to make horizontal cuts
			//O(R)
		    chipsEachRow = numChips / (H+1);
			chipsEachPiece = (numChips / (H+1))/(V+1);
			for(int i = 0; i < R; i++){
				if(p[i][C - 1] % chipsEachRow == 0 && p[i][C - 1] > 0)
					if(i == 0 || p[i - 1][C - 1] != p[i][C - 1]) 
						horizontalCuts[hIdx++] = i;
			}
			
			//Finding the right index to make vertical cuts
			//O(H*C) runtime
			for(int j = 0 ; j < C; j++) {
				count = 0;
				for(hIdx = 0; hIdx < horizontalCuts.length; hIdx++) {
					//The total number of chips since last qualified columns to current col, 
					//row[0] to current horizontal cut row
					int cur = p[horizontalCuts[hIdx]][j] - (prevCol == -1 ? 0 : p[horizontalCuts[hIdx]][prevCol]);
					
					if(hIdx == 0) 
						if(cur == chipsEachPiece)
							count++;
					else 
						if( cur == chipsEachPiece * (hIdx + 1)) 
							count++;					
				}
				if(count == H+1) {
					total -= count;
					prevCol = j;
				}
			}
			if(total == 0)
				System.out.println("Case #" + numCase + ": " + "POSSIBLE");
			else
				System.out.println("Case #" + numCase + ": " + "IMPOSSIBLE");
        }
    }
}
