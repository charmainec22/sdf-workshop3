package vtp2022.day3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

import vtp2022.day3.workshop.Cart;

public class Repository {
    private File repository;

    //take in directory and create a new file
    public Repository(String repo){
        this.repository = new File(repo);
    }

    public List<String> getShoppingCart(){
        List<String> carts = new LinkedList<>();
        for (String n : repository.list())
            carts.add(n.replace(".cart", ""));
        System.out.println(carts);
        return carts;
    }

    public void save(Cart cart){
        //form file name
        String cartName = cart.getUsername() + ".db";
        //form location to save file
        String saveLocation = repository.getPath() + File.separator + cartName;
        //pass file over
        File saveFile  = new File(saveLocation);
        OutputStream os = null;
        try{
            //if file does not exist then create new file
            if(!saveFile.exists())
            {
                System.out.println("create file");
                Path path = Paths.get(repository.getPath());
                Files.createDirectories(path);
                saveFile.createNewFile();
            }
                saveFile.createNewFile();
            os = new FileOutputStream(saveLocation);
            //call save method and pass in outputstream 
            cart.save(os);
            os.flush();
            os.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
    }

    public Cart load(String username){
        //filename
        String cartName = username + ".cart";
        //create new cart
        Cart cart = new Cart(username);
        //loop through files in repo
        for (File cartFile: repository.listFiles())
            if(cartFile.getName().equals(cartName)){
                try{
                    InputStream is = new FileInputStream(cartFile);
                    cart.load(is);
                    is.close();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        return cart;
    }

    public void saveUser(String username){
        String userName = "users.cart";
        //form location to save file
        String saveLocation = repository.getPath() + File.separator + userName;
        //pass file over
        File saveFile  = new File(saveLocation);
        OutputStream os = null;
        try{
            //if file does not exist then create new file
            if(!saveFile.exists())
            {
                System.out.println("create file");
                Path path = Paths.get(repository.getPath());
                Files.createDirectories(path);
                saveFile.createNewFile();
            }
                saveFile.createNewFile();
            os = new FileOutputStream(saveLocation);
            os.flush();
            os.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
    }

}
