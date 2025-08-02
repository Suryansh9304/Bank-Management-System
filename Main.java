package Bank3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
   public Main() {
   }

   public static void main(String[] args) {
      ArrayList<PNB> accountHolders = new ArrayList();
      Scanner sc = new Scanner(System.in);
      Random random = new Random();

      while(true) {
         while(true) {
            System.out.println("hi if you want to add a new account holder click 0 or \nif you want to add money click 1 or \nif you want pay money click 2 or \nif you want to show your details click 3 or \nif you want to check your balance click 4 \nEnter 5 for update ATM pin \nEnter 6 for update Phone Number \nenter 7 for exit");
            int num = sc.nextInt();
            PNB selectedAccount;
            int otp;
            int userInputOtp;
            int newPhoneNumber;
            double payAmtValue;
            switch (num) {
               case 0:
                  sc.nextLine();
                  System.out.println("Enter username:");
                  String username = sc.nextLine();
                  System.out.println("Enter address:");
                  String address = sc.nextLine();
                  System.out.println("Enter phone number:");
                  String phoneNumber = sc.nextLine();
                  System.out.println("Enter account number:");
                  String accountNumber = sc.next();
                  System.out.println("Enter ATM pin:");
                  int atmPin = sc.nextInt();
                  System.out.println("Enter initial amount:");
                  double initialAmt = sc.nextDouble();
                  PNB newAccountHolder = new PNB(username, address, phoneNumber, accountNumber, atmPin, initialAmt);
                  accountHolders.add(newAccountHolder);
                  break;
               case 1:
                  selectedAccount = selectAccount(sc, accountHolders);
                  if (selectedAccount != null) {
                     System.out.println("Enter Your ATM Pin");
                     otp = sc.nextInt();
                     System.out.println("Enter Amount");
                     payAmtValue = sc.nextDouble();
                     selectedAccount.add_amount(payAmtValue, otp);
                  }
                  break;
               case 2:
                  selectedAccount = selectAccount(sc, accountHolders);
                  if (selectedAccount != null) {
                     System.out.println("Enter ATM Pin");
                     otp = sc.nextInt();
                     System.out.println("Enter pay Amount");
                     payAmtValue = sc.nextDouble();
                     selectedAccount.pay(payAmtValue, otp);
                  }
                  break;
               case 3:
                  selectedAccount = selectAccount(sc, accountHolders);
                  if (selectedAccount != null) {
                     System.out.println("Enter Your ATM Pin");
                     otp = sc.nextInt();
                     System.out.println("This is your bank details::");
                     selectedAccount.show_my_details(otp);
                  }
                  break;
               case 4:
                  selectedAccount = selectAccount(sc, accountHolders);
                  if (selectedAccount != null) {
                     System.out.println("Enter Your ATM Pin");
                     otp = sc.nextInt();
                     System.out.println("Your check balance amount is ::");
                     selectedAccount.check_balance(otp);
                  }
                  break;
               case 5:
                  selectedAccount = selectAccount(sc, accountHolders);
                  if (selectedAccount != null) {
                     otp = random.nextInt(9000) + 1000;
                     System.out.println("Enter OTP " + otp + " for update Your Pin");
                     userInputOtp = sc.nextInt();
                     System.out.println("Enter New ATM Pin");
                     newPhoneNumber = sc.nextInt();
                     selectedAccount.updateATMPin(otp, userInputOtp, newPhoneNumber);
                  }
                  break;
               case 6:
                  selectedAccount = selectAccount(sc, accountHolders);
                  if (selectedAccount != null) {
                     otp = random.nextInt(9000) + 1000;
                     System.out.println("Enter OTP " + otp + " for update Your PHONE NUMBER");
                     userInputOtp = sc.nextInt();
                     System.out.println("Enter New PHONE NUMBER");
                     newPhoneNumber = sc.nextInt();
                     selectedAccount.updatePhone_number(otp, userInputOtp, String.valueOf(newPhoneNumber));
                  }
                  break;
               case 7:
                  System.out.println("Exit");
                  sc.close();
                  System.exit(0);
                  break;
               default:
                  System.out.println("Something error occurred...");
            }
         }
      }
   }

   private static PNB selectAccount(Scanner sc, ArrayList<PNB> accountHolders) {
      if (accountHolders.isEmpty()) {
         System.out.println("No account holders available.");
         return null;
      } else {
         System.out.println("Select an account holder:");

         int index;
         for(index = 0; index < accountHolders.size(); ++index) {
            System.out.println("" + index + ": " + ((PNB)accountHolders.get(index)).getUsername());
         }

         index = sc.nextInt();
         if (index >= 0 && index < accountHolders.size()) {
            return (PNB)accountHolders.get(index);
         } else {
            System.out.println("Invalid selection.");
            return null;
         }
      }
   }
}
