package Bank3;

public class PNB {
   String username;
   String address;
   String phone_number;
   String account_number;
   int atm_pin;
   double initial_amt;

   public PNB(String username, String address, String phone_number, String account_number, int atm_pin, double initial_amt) {
      this.username = username;
      this.address = address;
      this.phone_number = phone_number;
      this.account_number = account_number;
      this.atm_pin = atm_pin;
      this.initial_amt = initial_amt;
   }

   public String getUsername() {
      return this.username;
   }

   void add_amount(double cash, int user_atm_pin) {
      if (cash > 0.0) {
         if (user_atm_pin == this.atm_pin) {
            this.initial_amt += cash;
            System.out.println("Total Bank Amount is :: " + this.initial_amt);
            System.out.println("                                       ");
            System.out.println("===============================================");
         } else {
            System.out.println("ATM PIN IS WRONG... :(  ..try again...!");
            System.out.println("===================================================");
         }
      } else {
         System.out.println("Kindly add money greater than zero.. :( ");
         System.out.println("===================================================");
      }

   }

   void pay(double cash, int user_atm_pin) {
      if (cash <= this.initial_amt) {
         if (user_atm_pin == this.atm_pin) {
            this.initial_amt -= cash;
            System.out.println("Payment successfully total bank balance is  :: " + this.initial_amt);
            System.out.println("                                       ");
            System.out.println("===================================================");
         } else {
            System.out.println("ATM PIN IS WRONG... :(  ..try again...!");
            System.out.println("===================================================");
         }
      } else {
         System.out.println("Insufficient money in your bank a/c....  :( ");
         System.out.println("===================================================");
      }

   }

   void show_my_details(int user_atm_pin) {
      if (user_atm_pin == this.atm_pin) {
         System.out.println("username::" + this.username);
         System.out.println("address::" + this.address);
         System.out.println("phone number::" + this.phone_number);
         System.out.println("account number::" + this.account_number);
         System.out.println("ATM::" + this.atm_pin);
         System.out.println("                                       ");
         System.out.println("                                       ");
         System.out.println("===================================================");
      } else {
         System.out.println("ATM PIN IS WRONG... :(  ..try again...!");
         System.out.println("===================================================");
      }

   }

   void check_balance(int user_atm_pin) {
      if (user_atm_pin == this.atm_pin) {
         System.out.println(this.initial_amt);
         System.out.println("                                       ");
         System.out.println("                                       ");
         System.out.println("===================================================");
      } else {
         System.out.println("ATM PIN IS WRONG... :(  ..try again...!");
         System.out.println("===================================================");
      }

   }

   void updateATMPin(int otp, int user_input_otp, int new_atm_pin) {
      if (otp == user_input_otp) {
         this.atm_pin = new_atm_pin;
         System.out.println("ATM PIN has been successfully updated. The New ATM PIN is :" + this.atm_pin);
      } else {
         System.out.println("OTP is Wrong... :(  ");
      }

   }

   void updatePhone_number(int otp, int user_input_otp, String new_phone_number) {
      if (otp == user_input_otp) {
         this.phone_number = new_phone_number;
         System.out.println("PHONE NUMBER has been successfully updated. The New PHONE NUMBER is ;" + this.phone_number);
      } else {
         System.out.println("OTP is Wrong... :(  ");
      }

   }
}
