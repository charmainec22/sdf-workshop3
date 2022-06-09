package vtp2022.day3.workshop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;

import javax.swing.plaf.basic.BasicComboBoxUI.ItemHandler;

public class Cart {
    private List<String> contents = new LinkedList<>();
    private String username;

    public Cart(String name){
        this.username = name;
    }

    public String getUsername() {
        return username;
    }

    public void add(String item){
        for(String inCart: contents)
            if(inCart.equals(item)){
                return;
            }
            contents.add(item);
    }

    public String delete(int index){
        if (index < contents.size())
            return contents.remove(index);
        return "nothing";
    }

    //dont need to try and catch as already throws IOException
    public void load(InputStream is) throws IOException {
        //raw file reading
        InputStreamReader isr = new InputStreamReader(is);
        //content line by line reading
        BufferedReader br = new BufferedReader(isr);
        String item;
        while((item = br.readLine()) != null)
            contents.add(item);
        br.close();
        isr.close();
    }

    //for loading is always input, reading of file always input
    //for saving is always output
    public void save(OutputStream os) throws IOException {
        OutputStreamWriter ows = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(ows);
        for (String item : contents)
            bw.write(item + "\n");
        
        ows.flush();
        bw.flush();
        ows.close();
        bw.close();
    }

    public List<String> getContents(){
        return contents;
    }

}
