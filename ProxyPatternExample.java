// src/structural/ProxyPatternExample.java
interface DoorLockSystem {
    void lock();
    void unlock();
}

class RealDoorLock implements DoorLockSystem {
    public void lock() {
        System.out.println("Door is locked.");
    }

    public void unlock() {
        System.out.println("Door is unlocked.");
    }
}

class DoorLockProxy implements DoorLockSystem {
    private RealDoorLock realDoorLock = new RealDoorLock();
    private boolean isAuthorized;

    public DoorLockProxy(boolean isAuthorized) {
        this.isAuthorized = isAuthorized;
    }

    public void lock() {
        if (isAuthorized) {
            realDoorLock.lock();
        } else {
            System.out.println("Unauthorized access. Cannot lock the door.");
        }
    }

    public void unlock() {
        if (isAuthorized) {
            realDoorLock.unlock();
        } else {
            System.out.println("Unauthorized access. Cannot unlock the door.");
        }
    }
}
