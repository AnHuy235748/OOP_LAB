package src;

public class Cart {
	
	private int qtyOrdered = 0;
	
	public static final int MAX_NUMBER_ORDERED = 3;
	private DigitalVideoDisc itemOrdered[] =
			new DigitalVideoDisc[MAX_NUMBER_ORDERED];
	
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBER_ORDERED) {
            itemOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added.");
        } else {
            System.out.println("The cart is almost full.");
        }
    }
    
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean found = false;
        
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemOrdered[i].equals(disc)) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemOrdered[j] = itemOrdered[j + 1];
                }
                itemOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                found = true;
                System.out.println("The disc has been removed.");
                break;
            }
        }
        // If the disc was not found
        if (!found) {
            System.out.println("The disc is not in the cart.");
        }
    }
    
    public double totalCost() {
        double total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemOrdered[i].getCost();
        }
        return total;
    }
}
