import java.util.HashMap;

public class AccountSystem {

    public static HashMap<String, Boolean> rentDetails;

    public static void addLease(String leaseID, boolean rentPaidOrNot) {
        rentDetails.put(leaseID, rentPaidOrNot);
    }

    public static void changeRentStatus(String leaseID, boolean newStatus) {
        rentDetails.put(leaseID, newStatus);
    }

    public static void getRentStatus(String leaseID) {
        if(rentDetails.get(leaseID)) {
            System.out.println("Paid");
        }
        else {
            System.out.println("Unpaid");
        }
    }
}
