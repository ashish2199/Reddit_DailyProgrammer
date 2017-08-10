package easy;

import java.util.Scanner;

/*
[2017-06-12] Challenge #319 [Easy] Condensing Sentences

Compression makes use of the fact that repeated structures are redundant, and it's more efficient to represent the pattern and the count or a reference to it. Siimilarly, we can condense a sentence by using the redundancy of overlapping letters from the end of one word and the start of the next. In this manner we can reduce the size of the sentence, even if we start to lose meaning.
For instance, the phrase "live verses" can be condensed to "liverses".
In this challenge you'll be asked to write a tool to condense sentences.

Challenge Input
Deep episodes of Deep Space Nine came on the television only after the news.
Digital alarm clocks scare area children.

Challenge Output
Deepisodes of Deep Space Nine came on the televisionly after the news.
Digitalarm clockscarea children.
 */
public class challenge_319 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inp = sc.nextLine();
        //String inp = "live verses";
        for (int i = 0; i < inp.length(); i++) {
            if (inp.charAt(i) == ' ') {
                int j = 1;
                int y = 0;
                while ((i - j) >= 0 && i + j + 1 < inp.length() && inp.charAt(i - j) != ' ') {
                    String s = inp.substring(i - j, i);
                    String t = inp.substring(i + 1, i + j + 1);
                    if (s.equals(t)) {
                        y = j;
                    }
                    ++j;
                }
                if (y > 0) {
                    inp = inp.substring(0, i) + inp.substring(i + y + 1);
                    i = -1;
                }
            }
        }
        System.out.println("" + inp);
    }
}
