package AimsProject;

public class Aims {
	public static void main(String[] args) {
		
		Cart anOrder = new Cart();
		
	    DigitalVideoDisc dvd1 = new DigitalVideoDisc("The lion king", "Animation", "Roger Allers", 87, 19.95f);
	    anOrder.addDigitalVideoDisc(dvd1);
	    
	    DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
	    anOrder.addDigitalVideoDisc(dvd2);
	    
	    DigitalVideoDisc dvd3 = new DigitalVideoDisc("Alladin", "Animation", " Roger Allers", 18.99f);
	    anOrder.addDigitalVideoDisc(dvd3);
	    anOrder.addDigitalVideoDisc(dvd3);
		anOrder.removeDigitalVideoDisc(dvd3);
		System.out.println("Total Cost is:");
		System.out.println(anOrder.totalCost());
		anOrder.addDigitalVideoDisc(dvd2);
		anOrder.display();
	}
}
