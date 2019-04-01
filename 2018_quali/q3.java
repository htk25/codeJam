import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
		//Pass 5/5, noted that after a new line character, flush() will be called
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int numCase = 1; numCase <= T; numCase++) {
			
			int A = in.nextInt();
			int resI = -2, resJ = -2, i = 2, j = 2;
			Set<Integer> result = new HashSet();
			while(resI!=0&&resJ!=0){
				System.out.println(i+" "+j);
				resI = in.nextInt();
				resJ = in.nextInt();
				result.add(resI*1000+resJ);
				if(result.size()%9==0){
					j += 3;
				}
				if(resI == -1){
					System.out.println("Wrong!");
					break;
				}
			}
            

        }
    }
}
