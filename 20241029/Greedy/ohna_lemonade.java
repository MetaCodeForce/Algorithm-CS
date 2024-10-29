

class Solution {
    public boolean lemonadeChange(int[] bills) {
       int five =0; //오딸라
       int ten =0;  //십딸라
    //    int twenty =0; 는 필요가없군ㅋ

       for(int bill : bills){
            if(bill==5){
                five++;
            }else if(bill==10){
                if(five==0){
                    return false;
                }
                five--; //거슬러준다...
                ten++; //돈받았다.. 
            }else if(bill==20){
                //5+10 이나 5+5+5로 주면되겠다..
                if(five >0 && ten>0){
                    five--;
                    ten--;
                    // twenty++;
                }else if( five >=3){
                    five-=3;
                }else{ //못준다..
                    return false;
                }
            }
       }
       return true; 
    }
}


/* 
Queue<Integer> qCharge = new LinkedList<>();

int price =5;
int cusNum=bills.length; //5

while(cusNum!=0){
    for(int i=0;i<cusNum;i++){
        if(bills[i]==5){
            qCharge.offer(bills[i]);
        }else{//5아니면 잔돈
            int charge = bills[i]-5; //10-5, 20-5
            while(charge=0){
                if(qCharge.contains(price)){
                    qCharge.remove(price);
                }
            }
        }
    }
    cusNum--;
}

}*/