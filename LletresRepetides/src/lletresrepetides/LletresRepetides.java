/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lletresrepetides;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author azorin
 */
public class LletresRepetides {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("introduce tu nombre");
        String readname = sc.next();

// FASE 1        
        char[] name = new char[readname.length()];

        for (int i = 0; i < readname.length(); i++) {
            name[i] = readname.charAt(i);
        }
        // una altre manera més curta
        char[] name2 = readname.toCharArray();

        for (int i = 0; i < readname.length(); i++) {
            int n=i+1;
            System.out.println(" Character  "+ n + "  :  " + name[i]);
            //System.out.println(name2[i]);
        }
    
// FASE 2
        List<Character> listChar = new ArrayList();
        
        for (char c : name) {
            listChar.add(c);
        }

        List<Character> listChar1 = new ArrayList();
        for (int i = 0; i < readname.length(); i++) {
            listChar1.add(i, readname.charAt(i));
        }
        
        LletresRepetides vocal = new LletresRepetides();
                
        listChar.stream().forEach((c) -> {
            if (Character.isDigit(c)) {
                System.out.println("Els noms de persones no contenen números:" + c);
 //               listChar.remove(c);
            }else if ( Character.isLetter((c)) && vocal.isVocal(c)){
                System.out.println("Es una vocal: " +c );
            }else{
                System.out.println("Es una consonant:  " + c);
            }           
        });
        
    // FASE 3
                       
        Map<String, Integer> repeatLetters = new HashMap<>();
      

        for (char c : name) {
            String caracter = Character.toString(c);
            if(!repeatLetters.containsKey(caracter)){
                repeatLetters.put(caracter, 1);
            }else{
                int repeatletter = repeatLetters.get(caracter);
                repeatLetters.replace(caracter, repeatletter, repeatletter+1);
            }
        }    
             
        repeatLetters.entrySet().stream().forEach((letter) -> {
            System.out.println("clave=" + letter.getKey() + ", valor=" + letter.getValue());
        });
       
    // FASE 4
        List<Character> listCharSurname = new ArrayList();
        System.out.println("introduce tu apellido:");
        String readsurname = sc.next();
        char[] surname = readsurname.toCharArray();
        for (char c : surname) {
            listCharSurname.add(c);
        }
        
        List<Character> listCharFullname = new ArrayList();
        
        listCharFullname.addAll(listChar);
        listCharFullname.add(' ');
        listCharFullname.addAll(listCharSurname);
        
        System.out.println(listCharFullname);
    }

    private boolean isVocal(char c) {
        char [] vocals = {'a', 'e', 'i', 'o', 'u'};
        for (char vocal : vocals) {
            if (Character.toLowerCase(c) == vocal){
                return true;
            }
        }
        return false;
    }

}
