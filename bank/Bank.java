import java.util.*;


/*
WAP a program for a banking application where bank charges certain amount on 
deposit and withdrawal
Deposition followed by Deposition=> 0.20% of the amount deposited
Withdrawal followed by withdrawal=> 0.25% of the amount withdrawn

Deposition followed by withdrawal=> 0.40% of the amount deposited
Withdrawal followed by deposition=> 0.50% of the amount deposited*/


public class Bank {
   
    public static void main(String[] args){

        double DEPADEP = 0.002, WITHAWITH = 0.0025, DEPAWITH = 0.004, WITHADEP = 0.005;
        
        double dep =0, with = 0, amount = 0;
    
        int choice=0, counter = 0, prevchoice = 0;

        Scanner scan = new Scanner(System.in);

        System.out.println("Hello,What is your balance? ");
        amount= scan.nextDouble();
        System.out.println();

        while(choice!=3){

            System.out.println("what would you like to do today?\n1.)Deposit\n2.)Withdraw");
            choice = scan.nextInt();
            System.out.println();

            if(choice==1){                
                System.out.println("How much would you like to deposit?");
                dep = scan.nextInt();
                amount = amount + dep;                
            }
            else if(choice==2){               
                System.out.println("How much would you like to withdraw?");
                with = scan.nextInt();
                amount = amount - with;                
            }

            if(counter>=1 && (choice==1||choice==2)){
                
                if(prevchoice ==1 && choice==1){
                    double charge = DEPADEP*dep;
                    amount = amount - charge;
                    System.out.println("charge for deposition followed by Deposition is "+charge+" @ "+DEPADEP*100+"%\n");                    
                }
                else if(prevchoice ==1 && choice== 2){
                    double charge = DEPAWITH*dep;
                    amount = amount - charge;
                    System.out.println("charge for deposition followed by withdrawal is "+charge+" @ "+DEPAWITH*100+"%\n");
                }
                else  if(prevchoice == 2 && choice== 2){
                    double charge = WITHAWITH*dep;
                    amount = amount - charge;
                    System.out.println("charge for withdrawal followed by withdrawal is "+charge+" @ "+WITHAWITH*100+"%\n");
                }
                else if(prevchoice == 2 && choice== 1){
                    double charge = WITHADEP*dep;                
                    amount = amount - charge;
                    System.out.println("charge for withdrawal followed by deposition is "+charge+" @ "+WITHADEP*100+"%\n");
                }
            }
                
            if(choice!=3)
                System.out.println("Your balance is " + Math.round(amount*100.00)/100.00+"\n");
                
            prevchoice = choice;
            counter++;
        }

        System.out.println("Your final balance is " + Math.round(amount*100.00)/100.00+"\n");
    }
}
