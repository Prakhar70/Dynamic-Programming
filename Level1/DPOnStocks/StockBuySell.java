package Level1.DPOnStocks;
class StockBuySell{
    public int stockBuySell(int[] arr, int n) {
        int maxProfit=0;
        int buyPrice = arr[0];
        for(int i =1;i<n;i++){
            int profit=arr[i]-buyPrice;
            if(profit>maxProfit){
                maxProfit=profit;
            }
            if(buyPrice<arr[i]){
                buyPrice=arr[i];
            }
        }
        return maxProfit;
       
    }
}