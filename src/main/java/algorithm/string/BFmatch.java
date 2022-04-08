package algorithm.string;

public class BFmatch {
    public static void main(String[] args) {
        String txt = "ABC이지스DEF";
        String pt = "이지스";
        BFmatch bFmatch = new BFmatch();
        int result = bFmatch.bfMatchLast(txt, pt);
        if (result == -1) {
            System.out.println("텍스트에 패턴이 없습니다.");
        } else {
            int len = 0;
            for (int i = 0; i < result; i++) {
                len += txt.substring(i, i + 1).getBytes().length;
            }
            len += pt.length();

            System.out.println((result + 1) + "번째 문자부터 일치합니다.");
            System.out.println("텍스트 : " + txt);
            System.out.printf(String.format("패턴 : %%%ds\n", len), pt);
        }
    }

    public int bfMatch(String txt, String pat) {
        int pt = 0;
        int pp = 0;
        while (pt != txt.length() && pp != pat.length()) {
            if (txt.charAt(pt) == pat.charAt(pp)) {
                pt++;
                pp++;
            } else {
                pt = pt - pp + 1;
                pp = 0;
            }
        }
        if (pp == pat.length()) {
            return pt - pp;
        }
        return -1;
    }

    public int bfMatchLast(String txt, String pat) {
        int pt = 0;
        int pp = 0;
        while (pt != txt.length() && pp != pat.length()) {
            if (txt.charAt(pt) == pat.charAt(pp)) {
                pt++;
                pp++;
            } else {
                pt = pt - pp + 1;
                pp = 0;
            }
        }
        if (pp == pat.length()) {
            return pt-1 ;
        }
        return -1;
    }
}
