package vtp2022.day3;

import java.io.Console;
import java.util.List;

import vtp2022.day3.workshop.Cart;

//class that holds all execution and switch statement
public class Session {
    public static final String LIST = "list";
    public static final String CARTS = "carts";
    public static final String ADD = "add";
    public static final String DELETE = "delete";
    public static final String LOAD = "load";
    public static final String USERS = "users";
    public static final String SAVE = "save";
    public static final String END = "end";
    public static final String LOGIN = "login";

    private Repository repository;
    private Cart curCart;
    
    public Session(Repository repo){
        this.repository = repo;
    }

    public void start(){
        Console cons = System.console();
        boolean stop = false;
        curCart = new Cart("anon");

        while(!stop){
            String input = cons.readLine(" > ");
            String[] terms = input.split(" ");
            switch(terms[0]){
                case CARTS:
                    System.out.println("List of shopping carts");
                    //list carts db files
                    //TODO
                break;

                case LIST:
                    System.out.printf("Items in %s's shopping cart \n", curCart.getUsername());
                    printList(curCart.getContents());
                    //TODO
                break;

                case ADD:
                    int before = curCart.getContents().size();
                    for (int i = 1; i < terms.length; i++)
                        curCart.add(terms[i]);
                    int addedCount = curCart.getContents().size() - before;
                    System.out.printf("Added %d item(s) to %s's cart \n", addedCount, curCart.getUsername());
                break;
                
                case DELETE:
                    int idx = Integer.parseInt(terms[1]);
                    String item = curCart.delete(idx);
                    System.out.printf("Removed %s from %s's cart", item, curCart.getUsername());
                break;

                case LOAD:
                    //curCart = reps
                    //TODO
                break;

                case SAVE:
                    //TODO
                break;

                case END:
                    stop = true;
                break;

                case LOGIN:
                    curCart = new Cart(terms[1]);
                break;

                case USERS:
                    //TODO repo need to have the getAllUsers method.
                break;

                default:
                    System.err.printf("Unknown input : %s \n", terms[0]);

            } 
            System.out.println("");  
        }
        System.out.println("Thank you for shopping with us.");
    }

    public void printList(List<String> list){
        if (list.size() <= 0){
            System.out.println("No record found!");
            return;
        }

        for ( int i = 0; i < list.size(); i++){
            System.out.printf("%d. %s \n", (i+1), list.get(1));
        }
    }
}
