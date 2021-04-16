import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import javax.sound.midi.SysexMessage;

public class project2 {
  static boolean valid(HashMap<String, String> wordlist , String selected)
  {
    String respond=wordlist.get(selected);
    if(respond==null)
      return false;
    else
      return true;
  }
  public static void main(String[] args) {
    int biggestword=0;
    HashMap<String, String> wordlist = new HashMap<String, String>();
    try {
      File myObj = new File("words_alpha.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        biggestword=data.length();
        wordlist.put(data, data);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    System.out.println("enter encrypted message:");
    Scanner input = new Scanner(System.in);
    String encrypt=input.nextLine();
    encrypt=encrypt.toLowerCase();
    String selected = "";
    for(int i=0;i<encrypt.length();i++)
    {
      if(encrypt.length()-i>=biggestword)
      {
        for(int j=biggestword+i;j>i;j--)
        {
          
          selected=encrypt.substring(i,j+1);
          if(valid(wordlist, selected))
          {
            System.out.println(selected);
            i=j;
            break;        
          }
        }
      }
      else
        {
          for(int j=encrypt.length()-1;j>i;j--)
          {
          selected=encrypt.substring(i,j+1);
          if(valid(wordlist, selected))
            {
              System.out.println(selected);
              i=j;
              break;        
            }
          }
        }
    }

  }
}