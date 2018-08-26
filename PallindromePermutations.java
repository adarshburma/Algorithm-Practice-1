package org.practice.courses.courseapi;

public class PalindromePermutations {

    public boolean ispalindrome(String phrase){
        boolean foundOdd = false;
        int[] table = buildCharIndexArray(phrase);
        for(int i : table){
            System.out.println(i);
        }
        for(int num : table){
            if(num % 2 == 1){
                if(foundOdd){
                    return false;
                }

                foundOdd = true;
            }
        }

        return true;
    }

    public int getCharIndex(char c){

        int a_index = Character.getNumericValue('a');
        int z_index = Character.getNumericValue('z');
        int c_index = Character.getNumericValue(c);

        if(c_index >= a_index && c_index <= z_index){
            return c_index - a_index;
        }

        return -1;
    }

    public int[] buildCharIndexArray(String phrase){
        int a_index = Character.getNumericValue('a');
        int z_index = Character.getNumericValue('z');

        int[] phrase_arr = new int[z_index - a_index + 1];
        for(char c : phrase.toCharArray()){
            if(getCharIndex(c) != -1)
                phrase_arr[getCharIndex(c)]++;
        }

        return phrase_arr;
    }

    public boolean findIfPalindrome(String phrase){
        int a_index = Character.getNumericValue('a');
        int z_index = Character.getNumericValue('z');
        int[] table  = new int [z_index - a_index + 1];
        for(char c : phrase.toCharArray()){
            int c_index = Character.getNumericValue(c);
            if(c_index >= a_index && c_index <= z_index){
                int index = c_index - a_index;
                if(index != -1)
                    table[index]++;
            }
        }
        int count = 0;
        for(int num : table){
            if(num % 2 == 1){
                count++;
            }
        }

        return count <= 1;
    }

    public int createBitVector(String phrase){
        int bitVector = 0;
        for(char c : phrase.toCharArray()){
            int x = Character.getNumericValue(c);
            bitVector = toggle(bitVector, x);
        }
        return bitVector;
    }

    public int toggle(int bitVector, int index){
        if(index < 0)
            return bitVector;
        int mask = 1 << index;
        if((bitVector & mask) == 0){
            bitVector |= mask;
        } else{
            bitVector &= ~mask;
        }

        return bitVector;
    }

    public boolean isPalindrome(String phrase){
        int bitVector = createBitVector(phrase);
        return bitVector == 0 || checkExactlyOneBitSet(bitVector);
    }

    public boolean checkExactlyOneBitSet(int bitVector){
        return (bitVector & (bitVector - 1)) == 0;
    }

    public static void main(String args[]){
        PalindromePermutations palindromePermutations = new PalindromePermutations();
        System.out.println(palindromePermutations.isPaalindrome("aabbccdd"));
        System.out.println(palindromePermutations.isPaalindrome("aaabbbccdd"));

    }


    public int createBitVector2(String phrase){
        int bitVector = 0;
        for(char c : phrase.toCharArray()){
            int c_index = Character.getNumericValue(c);
            toggle2(bitVector,  c_index );
        }

        return bitVector;
    }

    public int toggle2(int bitVector, int index){
        if(index < 0){
            return bitVector;
        }
        int mask = (1 << index);
        if((bitVector & mask) == 0){
            bitVector |= mask;
        }else{
            bitVector &= ~mask;
        }
        return bitVector;
    }

    public boolean checkIfOneBitSet(int bitVector){
        return (bitVector & (bitVector -1)) == 0;
    }

    public boolean isPaalindrome(String phrase){
        int bitVector = createBitVector2(phrase);
        return bitVector == 0 && checkIfOneBitSet(bitVector);
    }
}
