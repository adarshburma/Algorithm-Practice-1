public int coinChange(int[] coins, int amount, int index,
                          HashMap<String, Integer> memo){
        if(amount == 0){
            return 1;
        }
        
        if(index >= coins.length){
            return 0;
        }
        
        String key = amount + " - " + index;
        
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        int ways = 0;
        int amountWithCoin = 0;
        while(amountWithCoin <= amount){
            int remaining = amount - amountWithCoin;
            ways += coinChange(coins, remaining, index+1, memo);
            amountWithCoin += coins[index];
        }
        memo.put(key, ways);
        return ways;
    }
