import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int numCase = 1; numCase <= T; numCase++) {
			
			//O(nlogn) runtime
            int len = in.nextInt(), num = 0;
			String ans = "OK";
			List<Integer> evenL = new ArrayList<Integer>();
			List<Integer> oddL = new ArrayList<Integer>();
            for(int i = 0; i < len; i ++){
				num = in.nextInt();
				if(i%2==0)
					evenL.add(num);
				else
					oddL.add(num);
			}
			Collections.sort(evenL);
			Collections.sort(oddL);
			for(int i = 0; i < len/2 && ans.equals("OK"); i++){
				if(evenL.get(i) > oddL.get(i))
					ans = 2*i + "";
				if(i+1 < evenL.size() && oddL.get(i) > evenL.get(i+1)){
					ans = 2*i+1 + "";
				}
			}
			System.out.println("Case #" + numCase + ": " + ans);

        }
    }
}
