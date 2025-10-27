
import java.util.ArrayList;

class Account {
    String accountNumber;
    String accountHolderName;
    double balance;
    ArrayList<String> transactions = new ArrayList<>();

    Account(String accNo, String name, double bal) {
        accountNumber = accNo;
        accountHolderName = name;
        balance = bal;
    }

    void deposit(double amount) {
        balance = balance + amount;
        transactions.add("Deposited ₹" + amount);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance = balance - amount;
            transactions.add("Withdrawn ₹" + amount);
        } else {
            System.out.println("❌ Insufficient Balance!");
        }
    }

    void showBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    void showTransactions() {
        System.out.println("\nTransaction History for " + accountHolderName + ":");
        for (String t : transactions) {
            System.out.println(t);
        }
    }
}

class SavingsAccount extends Account {
    SavingsAccount(String accNo, String name, double bal) {
        super(accNo, name, bal);
    }

    @Override
    void withdraw(double amount) {
        if (balance - amount >= 1000) {
            balance = balance - amount;
            transactions.add("Withdrawn (Savings) ₹" + amount);
        } else {
            System.out.println("⚠️ Cannot withdraw! Minimum balance ₹1000 required.");
        }
    }
}

class CurrentAccount extends Account {
    CurrentAccount(String accNo, String name, double bal) {
        super(accNo, name, bal);
    }

    @Override
    void withdraw(double amount) {
        if (balance - amount >= -5000) {
            balance = balance - amount;
            transactions.add("Withdrawn (Current) ₹" + amount);
        } else {
            System.out.println("⚠️ Overdraft limit exceeded!");
        }
    }
}

public class BankSimulation {
    public static void main(String[] args) {
        SavingsAccount s1 = new SavingsAccount("SB101", "Rahul Sharma", 7000);
        s1.deposit(2000);
        s1.withdraw(3000);
        s1.showBalance();
        s1.showTransactions();

        System.out.println("\n----------------------------------");

        CurrentAccount c1 = new CurrentAccount("CA202", "Priya Patil", 5000);
        c1.deposit(1500);
        c1.withdraw(8000);
        c1.showBalance();
        c1.showTransactions();
    }
}
