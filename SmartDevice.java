// src/main/SmartHomeSystem.java
import java.util.Scanner;

public class SmartHomeSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DeviceObserver observer = new DeviceObserver();

        while (true) {
            System.out.println("\n1. Create Device\n2. Set Thermostat\n3. Lock/Unlock Door\n4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (choice == 1) {
                System.out.print("Enter device type (light/thermostat/doorLock): ");
                String type = scanner.nextLine();
                SmartDevice device = DeviceFactory.createDevice(type);
                if (device != null) {
                    observer.addObserver((Observer) device);
                    System.out.println(type + " created successfully.");
                } else {
                    System.out.println("Invalid device type.");
                }

            } else if (choice == 2) {
                System.out.print("Set temperature: ");
                int temp = scanner.nextInt();
                scanner.nextLine();
                Thermostat thermostat = new Thermostat();
                observer.addObserver(thermostat);
                thermostat.setTemperature(temp);

            } else if (choice == 3) {
                System.out.print("Authorized (true/false): ");
                boolean authorized = scanner.nextBoolean();
                scanner.nextLine();
                DoorLockProxy doorLock = new DoorLockProxy(authorized);
                System.out.print("Lock or Unlock (lock/unlock): ");
                String action = scanner.nextLine();
                if (action.equals("lock")) {
                    doorLock.lock();
                } else {
                    doorLock.unlock();
                }

            } else if (choice == 4) {
                System.out.println("Exiting system.");
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }
}
