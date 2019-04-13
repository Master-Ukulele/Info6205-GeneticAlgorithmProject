package team518.pack;

import java.util.Random;

public class NewTest {

    private static String crossOverV2 (String gene1, String gene2) {
        //String res="";
        char[] r = new char[46];
        char[] g1 = gene1.toCharArray();
        char[] g2 = gene2.toCharArray();

        double d = Math.random() * 23;
        int start = (int) d;
        for (int i = start; i < start + 23; i++) {
            r[i] = g1[i];
        }

        if (start == 0) {
            char[] ttEnd = gene2.substring(23,46).toCharArray();
            shuffle_char(ttEnd);
            for (int i = 23; i < 46; i++) {
                r[i] = ttEnd[i - 23];
            }
        } else if (start == 22) {
            char[] ttStart = gene2.substring(0,23).toCharArray();
//            shuffle_char(ttStart);
            for (int i = 0; i < 23; i++) {
                r[i] = ttStart[i];
            }
        } else {
            char[] ttStart = gene2.substring(0,start).toCharArray();
            char[] ttEnd = gene2.substring(start + 23,46).toCharArray();
            shuffle_char(ttStart);
            shuffle_char(ttEnd);
            for (int i = 0; i < start; i++) {
                r[i] = ttStart[i];
            }
            for (int i = start + 23; i < 46; i++) {
                r[i] = ttEnd[i - start - 23];
            }
        }
        String x = new String (r);
        return x;
    }

    public static void shuffle_char (char[] c) {
        Random random = new Random();
        int n = c.length;
        for(int i=0;i<n;i++){
            int r = random.nextInt (n-1);
            char tmp = c[r];
            c[r] = c[i];
            c[i] = tmp;
        }
    }

    public static void main(String[] arg) {
        String s1 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRST";
        //String s3 = "0000000000000000000000000000000000000000000000";

        String s2 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRST";

        String result = crossOverV2(s1,s2);
        System.out.println(result.length());
        System.out.print(result);
    }
}
