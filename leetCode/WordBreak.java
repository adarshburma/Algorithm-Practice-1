public class WordBreak2 {

    static String dictionary[] = {"mobile","samsung","sam","sung",
            "man","mango", "icecream","and",
            "go","i","love","ice","cream"};

    public static boolean containsDictionary(String word){
        for(int i = 0 ; i < dictionary.length; i++){
            if(dictionary[i].compareTo(word) == 0){
                return true;
            }
        }

        return false;
    }

    public static void wordBreak(String input){
        wordBreakUtil2(input, input.length(), "");
    }

    public static void wordBreakUtil(String input, int n, String result){
        for(int i = 0; i <= n; i++){

            String prefix = input.substring(0, i);

            if(containsDictionary(prefix)){
                if(i == n){
                    result += prefix;
                    System.out.println(result);
                    return;
                }

                wordBreakUtil(input.substring(i), n-i, result+prefix+ " ");
            }
        }
    }

    public static void main(String[] args){
        wordBreak("iloveicecreamandmango");
    }

    public static void wordBreakUtil2(String input, int n, String result){
        for(int i = 0 ; i < n ; i++){
            String prefix = input.substring(0,i);
            if(containsDictionary(prefix)){
                if(i == n){
                    result += prefix;
                    System.out.println(result);
                    return;
                }

                wordBreakUtil(input.substring(i), n-i, result+prefix+" ");
            }
        }
    }
}
