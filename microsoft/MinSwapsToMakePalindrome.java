/* https://leetcode.com/discuss/interview-question/351783/ */    

public static int minAdjSwaps(char[] strc) {
        int n = strc.length;
        int count = 0;
        for(int left = 0 ; left < n/2; left++) {
            int right= n-1;
            while(left <= right) {
                if(strc[left] == strc[right]) {
                    break;
                }
                right--;
            }
            if(left == right) {
                return -1;
            }
            for(int j = right ; j < n-left-1 ; j++) {
                swap(strc, j, j+1);
                count++;
            }
        }
        return count;
    }
    public static int minAdjSwaps(String str) {
        return Math.max(minAdjSwaps(str.toCharArray()), minAdjSwaps(reverse(str.toCharArray())));
    }
    public static void swap (char[] str, int i, int j) {
        char t  = str[i];
        str[i] = str[j];
        str[j] = t;
    }
    public static char[] reverse(char[] str) {
        int st = 0;
        int end = str.length-1;
        while(st <= end) {
            swap(str, st, end);
            st++;
            end--;
        }
        return str;
    }
