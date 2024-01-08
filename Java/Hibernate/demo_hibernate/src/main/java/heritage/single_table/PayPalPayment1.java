package heritage.single_table;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class PayPalPayment1 extends Payment1 {
    private String accountNumber;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "PayPalPayment1{" +
                "accountNumber='" + accountNumber + '\'' +
                "} " + super.toString();
    }
}
