public class SecRun {
/*
WAP a program for a banking application where bank charges certain amount on 
deposit and withdrawal
Deposition followed by Deposition=> 0.20% of the amount deposited
Withdrawal followed by withdrawal=> 0.25% of the amount withdrawn
Deposition followed by withdrawal=> 0.40% of the amount deposited
Withdrawal followed by deposition=> 0.50% of the amount deposited*/

private double DEPADEP = 0.002, WITHAWITH = 0.0025, DEPAWITH = 0.004, WITHADEP = 0.005;
private double amount, with, dep, charge = 0;
private int prevchoice,choice;

public SecRun(double amount, double dep, double with){
    this.amount = amount;
    this.dep = dep;
    this.with = with;
} // cosntructor used for deposits and withdrawals


public SecRun(int prevchoice, int choice, double amount, double dep, double with){
    this.prevchoice = prevchoice;
    this.choice = choice;
    this.amount = amount;
    this.dep = dep;
    this.with = with;

} //constructor user to check for extra charges

     //CHARGE FOR choice AFTER prevchoice
// Method that checks how much extra charge has to be incured to user and deducts it from the amount user has
public double checkCharges(int prevchoice, int choice, double amount, double dep, double with){
    if(prevchoice ==1 && choice==1){ //charge for dep after dep
        charge = DEPADEP*dep;
        amount = amount - charge;
        System.out.println("charge for deposition followed by deposition is "+charge+" @ "+DEPADEP*100+"%\n");
        System.out.println("Total amount deposited " + (dep-charge) +"\n");
        
    }
    else if(prevchoice == 2 && choice == 1){ //charge for dep after withdrawal
        charge = DEPAWITH*dep;
        amount = amount - charge;
        System.out.println("charge for deposition followed by withdrawal is "+charge+" @ "+DEPAWITH*100+"%\n");
        System.out.println("Total amount deposited " + (dep-charge) +"\n");
    }
    else  if(prevchoice == 2 && choice == 2){ //charge for withdrawal after withdrawal 
        charge = WITHAWITH*with;
        amount = amount - charge;
        System.out.println("charge for withdrawal followed by withdrawal is "+charge+" @ "+WITHAWITH*100+"%\n");
        System.out.println("Total amount withdrawn " + (with) +"\n");
    }
    else if(prevchoice == 1 && choice== 2){ //charge for withdrawal after deposit
        charge = WITHADEP*dep;                
        amount = amount - charge;
        System.out.println("charge for withdrawal followed by deposition is "+charge+" @ "+WITHADEP*100+"%\n");
        System.out.println("Total amount withdrawn " + (with) +"\n");
    }
    return (amount*100)/100.00;
    
    }

// Method to deposit cash to the amount user has, ONLY FOR THE FIRST RUN
public double deposit(double amount, double dep){    
    return amount + dep; 
}

// Method to withdraw cash to the amount user has, ONLY FOR THE FIRST RUN
public double withdraw(double amount, double with){
    return amount - with;
}


}
