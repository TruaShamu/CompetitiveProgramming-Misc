import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
@todo
    We have to find the number of ways to make N pairs.
    We can represent the array of available women as a bitmask integer.
    For instance, 15 == 1111 (in binary) == There are 4 women and they are all available.
    So, we can make a DP matrix DP[# available men][# available women (as a bitmask) ], and DP[N][ ((1<< N) -1 ] would be the answer.
    ((1 << N)-1 just means 111 if N=3 or 11111 if N=5, it means that all women are available)

    @todo Let's think about it.
          If there is only 1 man, then you can just loop through all the women with bit=1 , and dp[1][women bitmask] == 1 (1 way of pairing).
          If there is >1 man, then:
          For each man, loop though all women with bit=1
          DP[#men][#women as bitmask] == sum of (DP[men-1][bitmask with setting the woman's bit to 0]
          Hopefully this makes sense.
   */
public class matching2 {
    public static int N;
    public static int mod = (int) 1e9 + 7;
    public static boolean[][] comp = new boolean[21][21];
    public static long[][] dp = new long[21][1 << 21];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        //Bitmask initialize. i is the men, j is the subset.
        // (i.e when j==9 -> binary: 1001 -> 1st woman & 4th woman available)
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],-1);
        }

        //Read the compatibility matrix.
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                comp[i][j] = Integer.parseInt(st.nextToken()) == 1;
            }
        }
        //works

        //When all men are available, and all the women are available (women are saved in a bitmask).
        long answer = solve(N, (1 << N) - 1);


        System.out.println(answer);
    }


    //#available men, #available women
    public static long solve(int men, int women) {
        //System.out.println("MEN: "+men + " WOMEN: " + (Integer.toString(women, 2)));
        long curAns = 0;

        //Already have value
        if (dp[men - 1][women] != -1) {
            return dp[men - 1][women];
        }

        if (men == 1) {
            for (int j = 0; j < N; j++) {
                //Check if the jth women is left.
                if (((1 << j) & women) > 0) {
                    if (comp[men - 1][j]) {
                        //1 way to pair the last man with the woman if they're compatible.
                        dp[men - 1][women] = 1;
                        return 1;
                    } else {
                        dp[N - 1][women] = 0;
                        return 0;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            //If the ith woman is available.
            if (((1 << i) & women) > 0) {
                if (comp[men - 1][i]) {
                    //Recursively calculate the # ways, if the man is paired with this woman.
                    curAns += solve(men - 1, women - (1 << i));
                }
            }
        }
        //MOD IT.
        curAns %= mod;
        dp[men - 1][women] = curAns;
        return dp[men - 1][women];

    }
}
