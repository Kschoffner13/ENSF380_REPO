package edu.ucalgary.oop;

import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BibReader {

    //Each attribute (such as title, year, and author) will be on a line by itself.
    private String title;
    private String author;
    private String bookTitle;
    private String year;
    private File file;

    private HashMap<String, String> attributes = new HashMap<String, String>();
    private String contents;

    private final Pattern year_pat = Pattern.compile("^\\s*year\\s*=\\s*\\{\\s*(\\d{4})", Pattern.CASE_INSENSITIVE);
    private final Pattern title_pat = Pattern.compile("^\\s*title\\s*=\\s*\\{\\s*(.*)\\}", Pattern.CASE_INSENSITIVE);
    private final Pattern author_pat = Pattern.compile("^\\s*author\\s*=\\s*\\{\\s*(.*)\\}", Pattern.CASE_INSENSITIVE);


    // for getting the title and such, check each line for a space or "="

    //constructor
    public BibReader(File file){
        this.file = file;
    }

    //getters

    public String getContents(){
        return this.contents;
    }
    public String getTitle(){
        return this.title;
    }
    public String getAuthor(){
        return this.author;
    }
    public String getBookTitle() {
        return this.bookTitle;
    }
    public String getYear(){
        return this.year;
    }

    public String getAttribute(String value){
        String key = value.toLowerCase();
        if(this.attributes.containsKey(key)){
            return this.attributes.get(key);
        }
        return "";
    }

    // setters


    public void setContents(String contents) {
        this.contents = contents;
    }

    // others
    public Boolean readFile() throws IOException {
        BufferedReader in = null;


        try{
            in = new BufferedReader(new FileReader(this.file));
            String line = in.readLine();
            this.contents = line + "\n";
            line = in.readLine();
            while(line != null){
                this.contents += line + "\n";
                line = in.readLine();
            }

        } catch( Exception e){
            return false;
        }

        try{
            in.close();
        }catch(Exception e){}

        return true;
    }

    public boolean parseContents(){
        // make a regex for title, author, and

        String [] lines = this.contents.split("\n");

        Matcher year_match = this.year_pat.matcher("year");
        Matcher title_match = this.title_pat.matcher("title");

        for(int i = 0; i < lines.length; i++){
            if(this.year != null && year_match.find()){

            }
        }

        return false;
    }
}
