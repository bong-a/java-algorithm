package string;

public class BmMatch {

    public static void main(String[] args) {
        String txt = "ABABCDEFGHA";
        String pat = "ABC";
        BmMatch match = new BmMatch();
        int rs = match.bmMatch(txt, pat);
        System.out.println(rs);
    }

    public int bmMatch(String txt, String pat) {
        int pt;
        int pp;
        int txtLen = txt.length();
        int patLen = pat.length();

        int[] skip = new int[Character.MAX_VALUE + 1];
        for (pt = 0; pt < Character.MAX_VALUE; pt++) {
            skip[pt] = patLen;
        }
        for (pt = 0; pt < patLen - 1; pt++) {
            skip[pat.charAt(pt)] = patLen - pt - 1;
        }
        System.out.println("pt : " + pt);
        while (pt < txtLen) {
            pp = patLen - 1;
            while (txt.charAt(pt) == pat.charAt(pp)) {
                System.out.println(txt.charAt(pt) + " >>");
                if (pp == 0) {
                    return pt;
                }
                pp--;
                pt--;
                System.out.println("pp : " + pp + ", pt : " + pt);
            }
            System.out.println("skip[] : " + skip[txt.charAt(pt)]);
            System.out.println("patLen - pp : " + (patLen - pp));
            pt += ((skip[txt.charAt(pt)] > patLen - pp) ? skip[txt.charAt(pt)] : patLen - pp);
            System.out.println("pt : " + pt);
        }
        return -1;
    }
}
