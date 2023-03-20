package br.org.sesisc.sim.backend.util;

public class MaskUtil {

    public static String formatName(String name) {
        String[] words = name.split("\\s+");
        
        String formated = ""; 
        
        for (String word : words) {
            formated += word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase() + " "; 
        }
        
        return formated.substring(0, formated.length() - 1); 
    }
}