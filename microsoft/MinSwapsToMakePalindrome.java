/* https://leetcode.com/discuss/interview-question/351783/ */    

 /*
    * Idea to construct palindrome:
    * 1. For any palindrome ith char should be equal len-i-1
    *
    * Algo:
    * 1. loop through first half of word.
    * 2. Find right char position which is identical to left char starting from the last.
    * 3. Swap right char with its next adj char until char is placed at len-left-1
    * 4. Capture count of each swap.
    * 5. Ultimately we construct palindrome after swapping
    *
    * */

    // time O(len(s)^2)
    // space O(len(s))

    public static int minAdjSwaps(char[] strc) {
        int n = strc.length;
        int count = 0;
        //loop through first half of word.
        for(int left = 0 ; left < n/2; left++) {
            int right= n-1;
            // Find right char position which is identical to left char starting from the last.
            while(left <= right) {
                if(strc[left] == strc[right]) {
                    break;
                }
                right--;
            }
            // If there is no matching right char return -1 palindrome is not possible
            if(left == right) {
                return -1;
            }

            //Swap right char with its next adj char until char is placed at len(s)-left-1
            for(int j = right ; j < n-left-1 ; j++) {
                swap(strc, j, j+1);
                //Capture count of each swap.
                count++;
            }
        }
        return count;
    }

    public static int minAdjSwaps(String str) {
        // "ntiin" - in this example 't' has no identical char from left to right our algorithm stops at t
        // we will need to run our algorithm from right to left as well so we reverse and run.
        return Math.max(minAdjSwaps(str.toCharArray()), minAdjSwaps(reverse(str.toCharArray())));
    }

    // swap i,j
    public static void swap (char[] str, int i, int j) {
        char t  = str[i];
        str[i] = str[j];
        str[j] = t;
    }

    // reverse string
    public static char[] reverse(char[] str) {
        int st = 0;
        int end = str.length - 1;
        while (st <= end) {
            swap(str, st, end);
            st++;
            end--;
        }
        return str;
    }
