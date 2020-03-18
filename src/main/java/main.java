import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class main {
    int state = 0;

    public static void main(String[] args) {
        new main().run();
    }

    public void run() {
        NetworkTableInstance inst = NetworkTableInstance.getDefault();
        NetworkTable table = NetworkTableInstance.getDefault().getTable("Jetson");
        NetworkTableEntry view1 = table.getEntry("view1");
        inst.startClientTeam(4186);
        inst.startDSClient();
        boolean view, previous;
        previous = true;
        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                System.out.println("Interrupted!");
                return;
            }

            view = view1.getBoolean(true);
            if (!view) toggle();
        }
    }

    public void toggle() {
        if(state == 0) {
            System.out.println("Viewing Intake!");
            state = 1;
        }
        else {
            System.out.println("Viewing Forwards");
            state = 0;
        }
        System.out.println("State Changed! " + state);
    }
}