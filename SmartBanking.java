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
                    if((balance<5000)){
                        System.out.println("\033[31mMinimum Initial deposit is RS5000.00 !\033[0m");
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
                System.out.print(ID[ID.length-1] +" : "+name+ " added sucessfully. Do you want to Create new Account (Y/n)? ");
                if (scanner.nextLine().strip().toUpperCase().equals("Y")) continue;
                screen = DASHBOARD;
                break;

                case CHECK_BALANCE:

                boolean valid2 = true;
                String IDcheck;
                int index =0;
                loop:
                do{
                    valid =true;
                    System.out.print("Enter Account ID : ");
                    IDcheck = scanner.nextLine();
                    if(IDcheck.isBlank()){
                        System.out.println(("\033[31mAccount ID can't be empty !\033[0m"));
                    }
                    if(!IDcheck.substring(0, 4).equals("SDB-") || IDcheck.length() != 9){
                        System.out.println("\033[31mInvalid Account ID !\033[0m");
                        valid2 = false;
                        continue;
                    }
                    for (int i = 4; i < IDcheck.length(); i++) {
                        if(!Character.isDigit(IDcheck.charAt(i))){
                            System.out.println("\033[31mInvalid Account ID !\033[0m");
                            valid2 =false;
                            continue;
                        }
                        
                    }
                    for (int i = 0; i < ID.length; i++) {
                        if(IDcheck.equals(ID[i])){
                            index = i;
                            break loop;
                        }
                        if(i==ID.length-1){
                            System.out.println(("\033[31mAccount ID doesn't exist !\033[0m"));
                        }
                        
                    }

                }while(!valid2);
                System.out.printf("\nName : %S", NAME[index]);
                System.out.printf("\nCurrent A.C balance : RS.%1$,.2f", BALANCE[index]);
                System.out.printf("\nAvailable A.C balance : RS.%1$,.2f", (BALANCE[index]-500.00));



                default:
                System.exit(0);
            }

            
           

        }while(true);
        
    }
}