import java.util.*;

public class Bank3 {

    public static void main(String[] args){

        //setting the vars
        double dep =0, with = 0, amount = 0;
        int choice=0, counter = 0, prevchoice = 0;


        
        try(Scanner scan = new Scanner(System.in);){
            
            SecRun obj; //Object for Secret Run

            //get the amount in user account and then give a free line
            System.out.println("Hello,What is your balance? ");
            amount= scan.nextDouble();
            System.out.println();

            
            //Until the user wants to exit, keep looping this
            while(choice!=3){

                //Ask user what would they like to do
                System.out.println("what would you like to do today?\n1.)Deposit\n2.)Withdraw\n3.)Exit");
                choice = scan.nextInt();
                System.out.println();


                if(choice==1){    // make a deposit for the user            
                    System.out.println("How much would you like to deposit?");
                    dep = scan.nextInt();
                    obj = new SecRun(amount, dep, with);
                    amount = obj.deposit(amount, dep);
                }
                else if(choice==2){    // allow user to withdraw          
                    System.out.println("How much would you like to withdraw?");
                    with = scan.nextInt();
                    obj = new SecRun(amount, dep, with);
                    amount = obj.withdraw(amount, with);                
                }

                if(counter>=1 && (choice==1||choice==2)){ //if it is user second or more turn start applying charges
                    /*
                    *invoke a new constructor which remembers users previous choice and current choice based on this apply
                    *the charges. The current amount will be deducted based on the user deposit or withdrawal amount
                    */
                    obj = new SecRun(prevchoice, choice, amount, dep, with); 
                    amount = obj.checkCharges(prevchoice, choice, amount, dep, with);
                    
                }
                    
                if(choice!=3) // show the current balance until the user decides to exit
                    System.out.println("Your balance is " + Math.round(amount*100.00)/100.00+"\n");
                    
                prevchoice = choice; // change the previous choice after user has performed current operation. Useful to decide what charges user will incur.
                counter++; // raise the counter to see what turn is on, need not record it as it is only to check if the user has done more than one turn
            }

        }
        catch(Exception e){
            System.out.println("Error occured: "+e);
        }
        finally{
            System.out.println("Your final balance is " + Math.round(amount*100.00)/100.00+"\n"); // set the final account 
        }
    }
    
}

    

