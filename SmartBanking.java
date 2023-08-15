import java.util.Scanner;


public class SmartBanking{
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        final String clear = "\033[H\033[2J";
        int option = 0;
        final String DASHBOARD = "Welcome to smart banking App";
        final String OPEN_ACCOUNT = "OPEN_ACCOUNT";
        final String DEPOSIT_MONEY = "DEPOSIT_MONEY";
        final String WITHDRAW_MONEY = "WITHDRAW_MONEY";
        final String TRANSFER_MONEY = "TRANSFER_MONEY";
        final String CHECK_BALANCE = "CHECK_ACCOUNT_BALANCE";
        final String DROP_ACCOUNT = "DROP_EXISTING_ACCOUNT";

        String screen = DASHBOARD;
        String[] ID = new String[0];
        String[] NAME = new String[0];
        double[] BALANCE = new double[0];
        
        do{
            System.out.println(clear);
            final String App_title = String.format("%s%s%s", "\033[34;1m",screen,"\033[0m");
            System.out.printf("%40s\n",App_title);

            switch(screen){
            
                case DASHBOARD:
            
                System.out.println("[1]. Open new Account\n[2]. Deposit money\n[3]. Withdraw money\n[4]. Transfer money\n[5]. Check account balance\n[6]. Drop existing Account\n[7]. Exit");
                System.out.print("\nEnter your option :");
                option = scanner.nextInt();
                scanner.nextLine();
                switch(option){
                    case 1: screen = OPEN_ACCOUNT;break;
                    case 2: screen = DEPOSIT_MONEY;break;
                    case 3: screen = WITHDRAW_MONEY;break;
                    case 4: screen = TRANSFER_MONEY;break;
                    case 5: screen = CHECK_BALANCE;break;
                    case 6: screen = DROP_ACCOUNT;break;
                    case 7: System.exit(0);break;
                }
                break;

                case OPEN_ACCOUNT:
           

                boolean valid = true;
                String id;
                String name ;
                double balance;
                
                do{
                    valid =true;
                    System.out.print("Enter account name: ");
                    name = scanner.nextLine().strip();
                    if(name.isBlank()){
                        System.out.println("\033[31mName can't be empty\033[0m");
                        valid =false;
                        continue;
                    }
                    for (int i = 0; i < name.length(); i++) {
                        if(!(Character.isLetter(name.charAt(i))) || Character.isSpaceChar(name.charAt(i))){
                            System.out.println("\033[31mInvalid Name\033[0m");
                            valid =false;
                            break;
                        }
                        
                    }
                }while(!valid);
                valid = true;
                do{
                    valid =true;
                    System.out.print("Enter Initial deposit: ");
                    balance = scanner.nextDouble();
                    scanner.nextLine();
                    if((balance<500)){
                        System.out.println("\033[31mMinimum Initial deposit is RS500.00 !\033[0m");
                        valid =false;
                        continue;
                    }
                   else valid = true;
                    
                  
                }while(!valid);
                String[] newname = new String[NAME.length+1];
                String[] newid = new String[ID.length+1];
                double[] newbalance = new double[BALANCE.length+1];
                for (int i = 0; i < newname.length-1; i++) {
                    newname[i] = NAME[i];
                    newid[i] = ID[i];
                    newbalance[i]= BALANCE[i];
                    System.out.println("dfwe");
                }
                newname[newname.length-1]= name;
                newid[newid.length-1] = "SDB-"+String.format("%05d",newname.length);
                newbalance[newbalance.length-1] = balance;
                NAME = newname;
                ID = newid;
                BALANCE = newbalance;
                System.out.println();
                System.out.print(NAME[NAME.length-1] +" : "+name+ " added sucessfully. Do you want to add new student (Y/n)? ");
                if (scanner.nextLine().strip().toUpperCase().equals("Y")) continue;
                screen = DASHBOARD;
                break;

            }
           

        }while(true);
        
    }
}