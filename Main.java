import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import javax.sound.midi.Receiver;

public class Main {
    public static void main(String[] args) {
        NFA<String> nfa = new NFA<>();
        int index = 0;
        String str;
        Object value;
        boolean visible;

        Scanner sc = new Scanner(System.in);
        System.out.println("File's name: ");
        String filesName = sc.nextLine() + ".txt";
        File file = new File (filesName);
        System.out.println(file.exists());
        String initial = null;
        ArrayList<String> alphabet = new ArrayList<String>();
        ArrayList<String> access = new ArrayList<String>();
        ArrayList<String> language = new ArrayList<String>();
        ArrayList<String> last = new ArrayList<String>();

        alphabet.add("lmd");
        try {    
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
                        ArrayList <String> stringArray = new ArrayList<String>();
                        int i=0;
                        limit.useDelimiter("\\s*,|=>\\s*");
                        while(limit.hasNext()){
                            stringArray.add(limit.next());
                        i++;
                        }
                        for(int j = 2; j<stringArray.size();j++) {
                            String s =stringArray.get(j);
                            if((stringArray.get(1).contains("lmd")) && stringArray.get(0).contains(s)){}
                            else
                                nfa.newTransition(stringArray.get(0),stringArray.get(1),stringArray.get(j));
                        }
                    break;  
                    }
                number++;
            }
            in.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Write the string: ");
            str = scanner.nextLine();

            access = nfa.stringProcessing(str, initial);
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

            System.out.println("Do you want to write another string: ");
            System.out.println("Y/N");
            String continuar = scanner.nextLine().toLowerCase();

        }while(continuar.contentEquals("y"));
    }
}