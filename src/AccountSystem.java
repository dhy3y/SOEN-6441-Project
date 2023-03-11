import java.util.HashMap;

public class AccountSystem {

    HashMap<String, Boolean> rentDetails;

    public void rentStatus(String leaseID) {
        if(rentDetails.get(leaseID)) {
            System.out.println("Paid");
        }
        else {
            System.out.println("Unpaid");
        }
    }
}
