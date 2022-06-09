package vtp2022.day3.workshop;

import vtp2022.day3.Repository;
import vtp2022.day3.Session;

/**
 * Hello world!
 *
 */
public class App 
{
    
    private static String defaultDb = "db";
    public static void main( String[] args )
    {
        //print out first argument db name used to create the directory
        if(args.length > 0)
            if(args[0] != null){
                System.out.println( args[0] );
                App.defaultDb = args[0];
            }
        System.out.println( defaultDb );
        //split to two classes
        Repository repo = new Repository(defaultDb);
        //class -> loop of taking in commands 
        Session session = new Session(repo);
        session.start();
    }
}
