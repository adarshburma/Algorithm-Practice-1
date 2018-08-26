public class Coinage {

   int minCoins(int total){
        int coin_count = 0;
        while(total > 0){
            if(total >= 5){
                coin_count = coin_count + (total/5);
                total = total%5;           
            }else if(total >= 3){
                coin_count = coin_count + (total/3);
                total = total%3;
            }else if(total >= 1){
                coin_count = coin_count + (total/1);
                total = total%1;
            }
        }
        
        return coin_count;
        
    }
    
      int min_coins(int coins, int total){
        
        if(total == 0) return 0;
        
        if(total > 5){
            coins =  1 + min_coins(coins, total - 5);
        }else if(total > 3){
            coins = 1 + min_coins(coins, total - 3);
        }else if(total > 1){
            coins = 1 + min_coins(coins, total - 1);
        }
        	
        return coins;
        
    }
    
    
    int change_combinations(int amount, int[] coins){
        int[] combinations = new int[amount+1];
        combinations[0] = 1;
        for(int coin : coins){
            for(int i=1 ; i<combinations.length; i++){
                if(i >= coin){
                     combinations[i] += combinations[i-coin];
                }
            }
        }
        return combinations[amount];
    }
    
    public static void main(String args[]) {
        
        MyClass my = new MyClass();
        int coins[] = {1,3,5};
        System.out.println(my.change_combinations(12, coins));
        System.out.println(my.min_coins(coins,coins.length,9));
    }
}
