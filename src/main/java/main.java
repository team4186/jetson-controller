import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class main {
    public static void main(String[] args) {
        new main().run();
    }

    public void run() {
        NetworkTableInstance inst = NetworkTableInstance.getDefault();
        NetworkTable table = NetworkTableInstance.getDefault().getTable("Jetson");
        NetworkTableEntry view1 = table.getEntry("view1");
        NetworkTableEntry view2 = table.getEntry("view2");
        inst.startClientTeam(4186);
        inst.startDSClient();
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("interrupted");
                return;
            }
            boolean standard = view1.getBoolean(true);
            boolean intake = view2.getBoolean(false);
            if (standard) {
                System.out.println("Standard");
            } else {
                System.out.println("Intake");
            }
        }
    }
}