package string;

public class KmpMatch {
    public static void main(String[] args) {
        String txt = "ZABCABCABDXACCADEF";
        String pt = "ABCABD";
        KmpMatch match = new KmpMatch();
        int result = match.match(txt, pt);
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

    public int match(String txt, String pat) {
        int pt = 1;
        int pp = 0;

        int[] skip = new int[pat.length() + 1];

        skip[pt] = 0;
        while (pt != pat.length()) {
            if (pat.charAt(pt) == pat.charAt(pp)) {
                skip[++pt] = ++pp;
            } else if (pp == 0) {
                skip[++pt] = pp;
            } else {
                pp = skip[pp];
            }
        }
        for (int i : skip) {
            System.out.print(i + " ");
        }
        System.out.println();
        pt = pp = 0;
        while (pt != txt.length() && pp != pat.length()) {
            if (txt.charAt(pt) == pat.charAt(pp)) {
                pt++;
                pp++;
            } else if (pp == 0) {
                pt++;
            } else {
                System.out.println("pp=" + pp);
                pp = skip[pp];
            }
        }
        if (pp == pat.length()) {
            return pt - pp;
        }
        return -1;
    }
}
