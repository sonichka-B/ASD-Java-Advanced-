package topic13.practice;

public class UnsafeInventory implements Inventory{
    private int inventory;
    public UnsafeInventory(int inventory) {
        this.inventory = inventory;
    }

    @Override
    public boolean reserve(int amount) {
        if(inventory >=amount ) {
            try {
                Thread.sleep(1);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            inventory -= amount;
            return true;
        }
        return false;
    }

    @Override
    public int available() {
        return inventory;
    }
}
