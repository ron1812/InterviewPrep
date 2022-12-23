package com.practice.problems;

public class Count1s {

    /*
    The symbol & denotes the bitwise AND operator. It evaluates the binary value of given numbers. The binary result of these numbers will be returned to us in base 10.

    When the & operator starts its operation, it will evaluate the value of characters in both numbers starting from the left.

    Let's look at an example to help you understand better:

    System.out.println(10 & 12);
    // returns 8
    Let's break it down.

    The binary value of 10 is 1010

    The binary value of 12 is 1100

    Here is something you should have in mind before we start the operation:

    1 and 0 => 0
    0 and 1 => 0
    1 and 1 => 1
    0 and 0 => 0
    So let's carry out the operation.

    The first character for 10 is 1 and the first character for 12 is also 1 so:

    1 and 1 = 1.

    We move on to the second characters – 0 for 10 and 1 for 12:

    1 and 0 = 0.

    For the third characters – 1 for 10 and 0 for 12:

    1 and 0 = 0.

    For the fourth characters – 0 for 10 and 0 for 12:

    0 and 0 = 0.

    Now let's combine all the returned characters. We would have 1000.

    The binary value 1000 in base 10 is 8 and that is why our operation returned 8.
     */
    public static void main(String[] args) {
        System.out.println(('C' - 'A') +1);
        //System.out.println(hammingWeight(00000000000000000000000000001011));
    }

    public static int hammingWeight(int n) {

        int count = 0;

        while(n != 0){

            n = n & (n-1);
            count++;
        }
        return count;
    }
}
