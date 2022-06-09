package vtp2022.day3.workshop;

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
    }
}
