import java.util.*;
import java.io.*;

public class NFA<T extends Comparable> {
    HashMap<String, HashMap<String,ArrayList<String>>> table = new HashMap<String, HashMap<String,ArrayList<String>>>();
    ArrayList<String> access = new ArrayList<>();
    ArrayList<String> pre = new ArrayList<>();
    String ch;
    int i, j;
    
    public NFA() {}

    public void addState(String key) {
        table.put(key, new HashMap<String, ArrayList<String>>());
    }

    public void newTransition(String q1, String symbol, String q2 ) {
        if(table.get(q1).get(symbol) == null)
            table.get(q1).put(symbol, new ArrayList<>());

        table.get(q1).get(symbol).add(q2);
    }
    
    public ArrayList strProccessing(String str, String start) {
        pre = new ArrayList<String>();
        pre.add(start);
        if(str == ""){
            access.addAll(table.get(pre.get(0)).get("lmd"));
        }
        else {
            for(i = 0; i < str.length();i++) {
                ch = String.valueOf(str.charAt(i)) ;
                access = new ArrayList<String>();
                System.out.println("Processing lmd");
                for(int a = 0; a < pre.size();a++) {
                    access.add(pre.get(a));
                    access.addAll(table.get(pre.get(a)).get("lmd"));    
                }
                System.out.println("Processing " + str.charAt(i));
                pre= access;
                access = new ArrayList<String>();
                for(j = 0; j < pre.size();j++) {
                    if(table.get(pre.get(j)).containsKey(ch)) {
                        access.addAll(table.get(pre.get(j)).get(ch));
                        break;
                    }
                    else
                        access.clear();
                }
                pre = access;
                access = new ArrayList<String>();
                System.out.println("Processing lmd");
                for(int a = 0; a < pre.size();a++){
                    access.add(pre.get(a));
                    access.addAll(table.get(pre.get(a)).get("lmd"));  
                }
                pre = access;
                System.out.println("access");
                System.out.println(access);
            }
            if (access.size()>1)
                return access;
            else {
                System.out.println("Processing lmd");
                pre = access;
                access = new ArrayList<>();
                if(pre.size() > 0){
                    System.out.println(access);
                    for(int k = 0; k < pre.size();k++)
                        access.addAll(table.get(pre.get(k)).get("lmd"));
                }
            } 
        } return access;
    }       
}