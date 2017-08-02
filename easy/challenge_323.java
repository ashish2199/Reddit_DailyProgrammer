package easy;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author Ashish
 */
/*
[2017-07-10] Challenge #323 [Easy] 3SUM
If a given set of n real numbers contains three elements that sum to zero.

o(N^2) sollution using sorting and 2 sum problem:
2sum – given a sorted array, find 2 numbers that sum up to S. To solve this in O(N) time, 
we can keep two indices – one in the beginning (start) and the other in the end (end).

If the sum of the current two numbers is greater than S, we move the end pointer backward by one step. 
If the sum is smaller than S, we move the start pointer forward by one step.

When the two pointers meet each other, we know that no two numbers sum up to S. 
The reason we can make it O(N) is that the array is sorted and we don’t need to check all the combinations.
 */
public class challenge_323 {

    public static void main(String[] args) {
        String inp = "-1 -6 -3 -7 5 -8 2 -8 1";
        System.setIn(new ByteArrayInputStream(inp.getBytes()));
        Scanner sc = new Scanner(System.in);
        String[] str_nos = sc.nextLine().split(" ");
        int[] nos = new int[str_nos.length];
        for (int i = 0; i < str_nos.length; i++) {
            nos[i] = Integer.parseInt(str_nos[i]);
        }
        Arrays.sort(nos);
        HashSet<HashSet<Integer>> check_dup = new HashSet<HashSet<Integer>>();

        for (int i = 0; i < nos.length - 1; i++) {
            int sum = -nos[i];
            int begin = 0;
            int end = nos.length - 1;
            while (begin < end) {

                if ((nos[begin] + nos[end]) > sum) {
                    --end;
                } else if ((nos[begin] + nos[end]) < sum) {
                    ++begin;
                } else {
                    HashSet<Integer> hs = new HashSet<Integer>();
                    hs.add(nos[i]);
                    hs.add(nos[begin]);
                    hs.add(nos[end]);

                    if (check_dup.contains(hs)) {
                    
                    } else if (begin != end && end != i && begin != i) {
                        check_dup.add(hs);
                        System.out.println("" + nos[i] + " " + nos[begin] + " " + nos[end]);
                    }
                    ++begin;
                }
            }
        }
    }
}
