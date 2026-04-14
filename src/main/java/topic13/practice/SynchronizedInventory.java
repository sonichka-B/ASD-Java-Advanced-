package topic13.practice;

public class SynchronizedInventory implements Inventory{
    private int inventory;
    public SynchronizedInventory(int inventory) {
        this.inventory = inventory;
    }
    private final Object lock = new Object();

    @Override
    public boolean reserve(int amount) {
        synchronized (lock){
            if(inventory>=amount){
                inventory -= amount;
                return true;
            }
        }
        return false;
    }

    @Override
    public int available() {
        synchronized (lock){
            return inventory;
        }
    }
}
