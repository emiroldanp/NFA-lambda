import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import javax.sound.midi.Receiver;

/**
 * @author Emiliano Roldan
 * @author Alan Mendoza
 * 
 * Java program that reads from a file the elements that define an NDFA – λ and that
 *indicates if a string is accepted by the automata.
 */

public class Main {
    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {
        NFA<String> nfa = new NFA<String>();
        String str;

        Scanner sc = new Scanner(System.in);
        System.out.println("File's name: ");
        String filesName = sc.nextLine() + ".txt";
        String initial = null;
        ArrayList<String> alphabet = new ArrayList<String>();
        ArrayList<String> access = new ArrayList<String>();
        ArrayList<String> last = new ArrayList<String>();
        sc.close();

        try { 
            File file = new File (filesName);
            if (file.exists())
                System.out.println("File exists");
            else   
                System.out.println("File doesn't exists");  
            alphabet.add("lmd"); 
            Scanner in = new Scanner(file);
            int number=1;
            while(in.hasNextLine()) {
                String line = in.nextLine();
                Scanner limit = new Scanner(line);
                switch (number) {
                    case 1:
                        limit.useDelimiter("\\s*,|=>\\s*");
                        while(limit.hasNext()) {
                            String x = limit.next();
                            nfa.addState(x);
                            nfa.newTransition(x, "lmd", x);
                        }
                    break;

                    case 2:
                        limit.useDelimiter("\\s*,|=>\\s*");
                        while(limit.hasNext())
                            alphabet.add(limit.next());
                    break;

                    case 3:
                        limit.useDelimiter("\\s*,|=>\\s*");
                        while(limit.hasNext()) 
                            initial= limit.next();
                    break;

                    case 4:
                        limit.useDelimiter("\\s*,|=>\\s*");
                        while(limit.hasNext())
                            last.add(limit.next());
                    break;
                    
                    default:
                        ArrayList<String> stringArray = new ArrayList<String>();
                        int i=0;
                        limit.useDelimiter("\\s*,|=>\\s*");
                        while(limit.hasNext()){
                            stringArray.add(limit.next());
                            i++;
                        }
                        for(int j = 2; j<stringArray.size();j++) {
                            String sA =stringArray.get(j);
                            if((stringArray.get(1).contains("lmd")) && stringArray.get(0).contains(sA)){}
                            else
                                nfa.newTransition(stringArray.get(0),stringArray.get(1),stringArray.get(j));
                        }
                    break;  
                    } limit.close();
                number++;
            }
            in.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
            Scanner scan = new Scanner(System.in);
            System.out.println("Write the string: ");
            str = scan.nextLine();

            access = nfa.extended(str, initial);
            boolean accepted = false;

            for( int i = 0 ; i<access.size() && !accepted ;i++){
                if(last.contains(access.get(i))){
                    accepted=true;   
                }  
            }
            if (accepted) {
                System.out.println("The String: "+str+" is accepted by the language");
                
            } else {
                System.out.println("The String: "+str+" is not accepted by the language");
            }
            scan.close();
    }
}