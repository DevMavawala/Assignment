// src/main/DeviceFactory.java
class DeviceFactory {
    public static SmartDevice createDevice(String type) {
        switch (type) {
            case "light":
                return new Light();
            case "thermostat":
                return new Thermostat();
            case "doorLock":
                return new DoorLock();
            default:
                return null;
        }
    }
}
