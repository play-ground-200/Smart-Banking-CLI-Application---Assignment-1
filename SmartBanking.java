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
                    valid2 =true;
                    System.out.print("\nEnter Account ID : ");
                    IDcheck = scanner.nextLine();
                    if(IDcheck.isBlank()){
                        System.out.println(("\033[31mAccount ID can't be empty !\033[0m"));
                        valid2 = false;
                        continue;
                    }
                    if(IDcheck.length()<9){
                        System.out.println(("\033[31mInvaid ID!\033[0m"));
                        valid2 = false;
                        continue;
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
                            valid2 = false;
                        }
                        
                    }

                }while(!valid2);
                System.out.printf("\nName : %S", NAME[index]);
                System.out.printf("\nCurrent A.C balance : RS.%1$,.2f", BALANCE[index]);
                System.out.printf("\nAvailable A.C balance : RS.%1$,.2f", (BALANCE[index]-500.00));
                System.out.print("\nDo you want to continue (Y/n)? ");
                if (scanner.nextLine().strip().toUpperCase().equals("Y")) continue;
                screen = DASHBOARD;
                break;

                case DEPOSIT_MONEY:

                 valid2 = true;
                 int index2 =0;
                 loop:
                do{
                     valid2 =true;
                    System.out.print("Enter Account ID : ");
                    IDcheck = scanner.nextLine();
                    if(IDcheck.isBlank()){
                        System.out.println(("\033[31mAccount ID can't be empty !\033[0m"));
                        valid2 = false;
                        continue;
                    }
                    if(IDcheck.length()<9){
                        System.out.println(("\033[31mInvaid ID!\033[0m"));
                        valid2 = false;
                        continue;
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
                            index2 = i;
                            break loop;
                        }
                        if(i==ID.length-1){
                            System.out.println(("\033[31mAccount ID doesn't exist !\033[0m"));
                            valid2 = false;
                        }
                        
                    }


                }while(!valid2);   
                
                System.out.printf("\nCurrent A.C balance : RS.%1$,.2f", BALANCE[index2]);
                 valid = true;
                do{
                    valid =true;
                    System.out.print("\nEnter deposit amount: ");
                    balance = scanner.nextDouble();
                    scanner.nextLine();
                    if((balance<500)){
                        System.out.println("\033[31mMinimum Initial deposit is RS500.00 !\033[0m");
                        valid =false;
                        continue;
                    }
                   else valid = true;
                    
                  
                }while(!valid);

                BALANCE[index2] = BALANCE[index2]+balance;
                System.out.printf("\nNew A.C balance : RS.%1$,.2f", (BALANCE[index2]));
                System.out.println();
                System.out.print("Do you want to Coninue (Y/n)? ");
                if (scanner.nextLine().strip().toUpperCase().equals("Y")) continue;
                screen = DASHBOARD;
                break;

                case WITHDRAW_MONEY:

                 valid2 = true;
                 int index3 =0;
                 loop:
                do{
                     valid2 =true;
                    System.out.print("Enter Account ID : ");
                    IDcheck = scanner.nextLine();
                    if(IDcheck.isBlank()){
                        System.out.println(("\033[31mAccount ID can't be empty !\033[0m"));
                        valid2 = false;
                        continue;
                    }
                    if(IDcheck.length()<9){
                        System.out.println(("\033[31mInvaid ID!\033[0m"));
                        valid2 = false;
                        continue;
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
                            index3 = i;
                            break loop;
                        }
                        if(i==ID.length-1){
                            System.out.println(("\033[31mAccount ID doesn't exist !\033[0m"));
                            valid2 = false;
                        }
                        
                    }


                }while(!valid2);   
                
                System.out.printf("\nCurrent A.C balance : RS.%1$,.2f", BALANCE[index3]);
                 valid = true;
                do{
                    valid =true;
                    System.out.print("\nEnter deposit amount: ");
                    balance = scanner.nextDouble();
                    scanner.nextLine();
                    if((balance<100)){
                        System.out.println("\033[31mMinimum Initial deposit is RS500.00 !\033[0m");
                        valid =false;
                        continue;
                    }
                    if(((BALANCE[index3]-balance)<500)){
                        System.out.println("\033[31mInsuficient Balance !\033[0m\n");
                        System.out.printf("\033[31mAvailable Balance is : RS.%1$,.2f!\033[0m\n",BALANCE[index3]-500);
                        
                        valid =false;
                        continue;
                    }
                   else valid = true;
                    
                  
                }while(!valid);

                BALANCE[index3] = BALANCE[index3]-balance;
                System.out.printf("\nNew A.C balance : RS.%1$,.2f", (BALANCE[index3]));
                System.out.println();
                System.out.print("Do you want to Coninue (Y/n)? ");
                if (scanner.nextLine().strip().toUpperCase().equals("Y")) continue;
                screen = DASHBOARD;
                break;

                case TRANSFER_MONEY:

                valid2 = true;
                index3 =0;
                String IDfromcheck;
                String IDtocheck;
                 loop:
                do{
                     valid2 =true;
                    System.out.print("Enter from Account ID : ");
                    IDfromcheck = scanner.nextLine();
                    if(IDfromcheck.isBlank()){
                        System.out.println(("\033[31mAccount ID can't be empty !\033[0m"));
                        valid2 = false;
                        continue;
                    }
                    if(IDfromcheck.length()<9){
                        System.out.println(("\033[31mInvaid ID!\033[0m"));
                        valid2 = false;
                        continue;
                    }
                    if(!IDfromcheck.substring(0, 4).equals("SDB-") || IDfromcheck.length() != 9){
                        System.out.println("\033[31mInvalid Account ID !\033[0m");
                        valid2 = false;
                        continue;
                    }
                    for (int i = 4; i < IDfromcheck.length(); i++) {
                        if(!Character.isDigit(IDfromcheck.charAt(i))){
                            System.out.println("\033[31mInvalid Account ID !\033[0m");
                            valid2 =false;
                            continue;
                        }
                        
                    }
                    for (int i = 0; i < ID.length; i++) {
                        if(IDfromcheck.equals(ID[i])){
                            index3 = i;
                            break loop;
                        }
                        if(i==ID.length-1){
                            System.out.println(("\033[31mAccount ID doesn't exist !\033[0m"));
                            valid2 = false;
                        }
                        
                    }


                }while(!valid2);  
                 valid2 = true;
                int index4 =0;
                loop:
                do{
                     valid2 =true;
                    System.out.print("Enter to Account ID : ");
                    IDtocheck = scanner.nextLine();
                    if(IDtocheck.isBlank()){
                        System.out.println(("\033[31mAccount ID can't be empty !\033[0m"));
                        valid2 = false;
                        continue;
                    }
                    if(IDtocheck.length()<9){
                        System.out.println(("\033[31mInvaid ID!\033[0m"));
                        valid2 = false;
                        continue;
                    }
                    if(!IDtocheck.substring(0, 4).equals("SDB-") || IDtocheck.length() != 9){
                        System.out.println("\033[31mInvalid Account ID !\033[0m");
                        valid2 = false;
                        continue;
                    }
                    for (int i = 4; i < IDtocheck.length(); i++) {
                        if(!Character.isDigit(IDtocheck.charAt(i))){
                            System.out.println("\033[31mInvalid Account ID !\033[0m");
                            valid2 =false;
                            continue;
                        }
                        
                    }
                    for (int i = 0; i < ID.length; i++) {
                        if(IDtocheck.equals(ID[i])){
                            index4 = i;
                            break loop;
                        }
                        if(i==ID.length-1){
                            System.out.println(("\033[31mAccount ID doesn't exist !\033[0m"));
                            valid2 = false;
                        }
                        
                    }


                }while(!valid2); 
                
                System.out.printf("\nFrom account balance : RS.%1$,.2f", BALANCE[index3]);
                System.out.printf("\nTo acount balance : RS.%1$,.2f", BALANCE[index4]);
                 valid = true;
                do{
                    valid =true;
                    System.out.print("\nEnter transfer amount: ");
                    balance = scanner.nextDouble();
                    scanner.nextLine();
                    if((balance<100)){
                        System.out.println("\033[31mMinimum transfer amount is RS100.00 !\033[0m");
                        valid =false;
                        continue;
                    }
                    if(((BALANCE[index3]-(balance*1.02))<500)){
                        System.out.println("\033[31mInsuficient Balance !\033[0m\n");
                        System.out.printf("\033[31mAvailable Balance is : RS.%1$,.2f!\033[0m\n",BALANCE[index3]-500);
                        
                        valid =false;
                        continue;
                    }
                   else valid = true;
                    
                  
                }while(!valid);

                BALANCE[index3] = BALANCE[index3]-(balance*1.02);
                
                BALANCE[index4] = BALANCE[index4]+balance;
                System.out.printf("\nFrom account balance : RS.%1$,.2f", (BALANCE[index3]));
                System.out.printf("\nTo account balance : RS.%1$,.2f", (BALANCE[index4]));
                System.out.println();
                System.out.print("Do you want to Coninue (Y/n)? ");
                if (scanner.nextLine().strip().toUpperCase().equals("Y")) continue;
                screen = DASHBOARD;
                break;

                case DROP_ACCOUNT:

                valid2 = true;
                 index3 =0;
                 loop:
                do{
                     valid2 =true;
                    System.out.print("Enter Account ID : ");
                    IDcheck = scanner.nextLine();
                    if(IDcheck.isBlank()){
                        System.out.println(("\033[31mAccount ID can't be empty !\033[0m"));
                        valid2 = false;
                        continue;
                    }
                    if(IDcheck.length()<9){
                        System.out.println(("\033[31mInvaid ID!\033[0m"));
                        valid2 = false;
                        continue;
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
                            index3 = i;
                            break loop;
                        }
                        if(i==ID.length-1){
                            System.out.println(("\033[31mAccount ID doesn't exist !\033[0m"));
                            valid2 = false;
                        }
                        
                    }


                }while(!valid2);   

                newid = new String[ID.length-1];
                newname = new String[NAME.length-1];
                newbalance = new double[BALANCE.length-1];
                boolean found =false;
                for (int i = 0; i < newid.length-1; i++) {
                   if (ID[i].equals(IDcheck)){
                       newid[i]=ID[i+1];
                       newname[i] = NAME[i+1];
                       newbalance[i] = BALANCE[i+1];
                       found=true;
                   }
                   else if(found) {
                       newid[i]=ID[i+1];
                       newname[i] = NAME[i+1];
                       newbalance[i] = BALANCE[i+1];
                   }
   
                   else {
                       newid[i]=ID[i];
                       newname[i] = NAME[i];
                       newbalance[i] = BALANCE[i];
                   }
                   
                }
                ID =newid;
                NAME = newname;
                BALANCE = newbalance;
                System.out.print( " remove sucessfully. Do you want to remove another Account (Y/n)? ");
                if (scanner.nextLine().strip().toUpperCase().equals("Y")) continue;
                screen = DASHBOARD;
                break;



                default:
                System.exit(0);
            }

            
           

        }while(true);
        
    }
}