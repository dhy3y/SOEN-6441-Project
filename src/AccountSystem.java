import java.util.HashMap;

public class AccountSystem {

    HashMap<String, Boolean> rentDetails;

    public void addLease(String leaseID, boolean rentPaidOrNot) {
        rentDetails.put(leaseID, rentPaidOrNot);
    }

    public void changeRentStatus(String leaseID, boolean newStatus) {
        rentDetails.put(leaseID, newStatus);
    }

    public void getRentStatus(String leaseID) {
        if(rentDetails.get(leaseID)) {
            System.out.println("Paid");
        }
        else {
            System.out.println("Unpaid");
        }
    }
}
