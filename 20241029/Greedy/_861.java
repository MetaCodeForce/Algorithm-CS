package leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _861 {
    public static void main(String[] args) {

        /*
            Input: bills = [5,5,5,10,20]
            Output: true

            Input: bills = [5,5,10,10,20]
            Output: false

            5,5,5,10,5,20,5,10,5,20
            true
        */

        int[] bills = {5,5,5,10,5,20,5,10,5,20};
        System.out.println(lemonadeChange(bills));
    }

    public static boolean lemonadeChange(int[] bills) {
        boolean result = false;
        List<Integer> inMyWallet = new ArrayList<>();

        for (int i = 0; i < bills.length; i++) {
            System.out.println("inMyWallet : " + inMyWallet);
            System.out.println("bills[i] : " + bills[i]);
            if (bills[i]==5) {
                inMyWallet.add(bills[i]);
            } else {
                int cnt = 1;
                while(bills[i] > 5) {
                    if(inMyWallet.isEmpty()){
                        return result;
                    }
                    if(cnt==1) {
                        inMyWallet.add(bills[i]);
                    }
                    if(bills[i]>inMyWallet.get(0)){
                        bills[i] = bills[i] - inMyWallet.get(0);
                        inMyWallet.remove(0);
                    } else {
                        if(inMyWallet.size()>1){
                            bills[i] = bills[i] - inMyWallet.get(1);
                            inMyWallet.remove(1);
                        } else {
                            return result;
                        }
                    }
                    cnt++;
                }
                Collections.sort(inMyWallet, Collections.reverseOrder());
                if(bills[i]!=5){
                    return result;
                }
            }
        }

        result = true;
        return result;
    }
}
