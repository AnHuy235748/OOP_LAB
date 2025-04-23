package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Aims {

    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        setupStore();
        int choice;
        do {
            showMenu();
            choice = getUserChoice();

            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    viewCart();
                    break;
                case 0:
                    System.out.println("See you again");
                    break;
                default:
                    System.out.println("Invalid input!");
            }
        } while (choice != 0);

        scanner.close();
    }

    public static void setupStore() {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Sci-fi", "George Lucas", 121, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", "Guy Ritchie", 128, 18.99f);
        CompactDisc cd1 = new CompactDisc("The Golden", "Jazz", "Borcaleo", "Louis Samatha", 22.95f);
        Track t1 = new Track("Long way ahead", 196);
        Track t2 = new Track("Returner", 211);
        cd1.addTrack(t1); cd1.addTrack(t2);
        Book book1 = new Book("2013", "The face", 13.20f);
        book1.addAuthor("Shimmer Valve");


        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(cd1);
        store.addMedia(book1);
    }


    public static void showMenu() {
        System.out.println("\nAIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void viewStore() {
        store.printStore();
        int choice;
        do {
            storeMenu();
            choice = getUserChoice();
            switch (choice) {
                case 1:
                    System.out.print("Input the media's titles: ");
                    String title = scanner.nextLine();
                    Media media = store.findMediaByTitle(title);
                    if (media != null) {
                        System.out.println("Details:\n" + media.toString());
                        mediaDetailsMenu(media);
                    } else {
                        System.out.println("Media named '" + title + "' isn't found!");
                    }
                    break;
                case 2: 
                    System.out.print("Input the media's titles: ");
                    title = scanner.nextLine();
                    media = store.findMediaByTitle(title);
                    if (media != null) {
                        cart.addMedia(media);
                        System.out.println("Number of items: " + cart.getItemsOrdered().size());
                    } else {
                        System.out.println("Media named '" + title + "' isn't found!");
                    }
                    break;
                case 3: // Play media
                    System.out.print("Input the media's titles: ");
                    title = scanner.nextLine();
                    media = store.findMediaByTitle(title);
                    if (media != null) {
                        if (media instanceof Playable) {
                            ((Playable) media).play();
                        } else {
                            System.out.println("The media named ('" + media.getTitle() + "') isn't playable.");
                        }
                    } else {
                        System.out.println("Media named '" + title + "' isn't found!");
                    }
                    break;
                case 4: 
                    viewCart();
                    return;
                case 0: 
                    break;
                default:
                    System.out.println("Invalid input!");
            }
        } while (choice != 0);
    }

    public static void storeMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    public static void mediaDetailsMenu(Media media) {
        System.out.println("\nOptions for " + media.getTitle() + ":");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        if (media instanceof Playable) {
            System.out.println("2. Play");
        }
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1: ");

        int choice = getUserChoice();
        switch (choice) {
            case 1:
                cart.addMedia(media);
                break;
            case 2: 
                if (media instanceof Playable) {
                    ((Playable) media).play();
                } else {
                    System.out.println("Invalid input!");
                }
                break;
            case 0: 
                break;
            default:
                System.out.println("Invalid input!");
        }
    }

    public static void updateStore() {
        System.out.println("\nUpdate Store Options:");
        System.out.println("1. Add Media");
        System.out.println("2. Remove Media");
        System.out.println("0. Back");
        System.out.print("Please choose a number: 0-1-2: ");
        int choice = getUserChoice();

        if (choice == 1) {
            System.out.println("You can not do this yet!");
        } else if (choice == 2) {
            System.out.print("Input media's titles: ");
            String title = scanner.nextLine();
            Media mediaToRemove = store.findMediaByTitle(title);
            if (mediaToRemove != null) {
                store.removeMedia(mediaToRemove);
            } else {
                System.out.println("Not found!");
            }
        } else if (choice == 0) {
        } else {
            System.out.println("Invalid input!");
        }
    }

    public static void viewCart() {
        cart.print();
        int choice;
        do {
            cartMenu();
            choice = getUserChoice();
            switch (choice) {
                case 1:
                    filterCartMenu();
                    break;
                case 2:
                    sortCartMenu();
                    break;
                case 3:
                    System.out.print("Input media's titles: ");
                    String title = scanner.nextLine();
                    Media mediaToRemove = cart.searchByTitle(title);
                    if (mediaToRemove != null) {
                        cart.removeMedia(mediaToRemove);
                    } else {
                    }
                    cart.print();
                    break;
                case 4:
                    System.out.print("Input media's titles: ");
                    title = scanner.nextLine();
                    Media mediaToPlay = cart.searchByTitle(title);
                    if (mediaToPlay != null) {
                        if (mediaToPlay instanceof Playable) {
                            ((Playable) mediaToPlay).play();
                        } else {
                            System.out.println("The media ('" + mediaToPlay.getTitle() + "') isn't playable.");
                        }
                    } 
                    break;
                case 5:
                    System.out.println("Ordered successfully!");
                    cart.emptyCart();
                    return;
                case 0: 
                    break;
                default:
                    System.out.println("Invalid input!");
            }
        } while (choice != 0);
    }

    public static void cartMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }

    public static void filterCartMenu() {
        System.out.println("\nFilter Options:");
        System.out.println("1. Filter by ID");
        System.out.println("2. Filter by Title");
        System.out.println("0. Back");
        System.out.print("Choose option: ");
        int choice = getUserChoice();
        if (choice == 1) {
            System.out.print("Enter ID to filter: ");
            int id = getUserChoice();
            cart.searchByID(id);
        } else if (choice == 2) {
            System.out.print("Enter Title to filter: ");
            String title = scanner.nextLine();
            cart.searchAllByTitle(title);
        } else if (choice != 0) {
            System.out.println("Invalid choice.");
        }
    }

    public static void sortCartMenu() {
        System.out.println("\nSort Options:");
        System.out.println("1. Sort by Title then Cost");
        System.out.println("2. Sort by Cost then Title");
        System.out.println("0. Back");
        System.out.print("Choose option: ");
        int choice = getUserChoice();
        ArrayList<Media> items = cart.getItemsOrdered();
        if (choice == 1) {
            Collections.sort(items, Media.COMPARE_BY_TITLE_COST);
            System.out.println("Cart sorted by Title then Cost:");
        } else if (choice == 2) {
            Collections.sort(items, Media.COMPARE_BY_COST_TITLE);
            System.out.println("Cart sorted by Cost then Title:");
        } else if (choice == 0) {
            return;
        } else {
            System.out.println("Invalid input!");
            return; 
        }
        cart.print(); 
    }


    private static int getUserChoice() {
        int choice = -1;
        while (choice == -1) {
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine();
                choice = -1; 
                System.out.print("Please input again: "); 
            }
        }
        return choice;
    }
}