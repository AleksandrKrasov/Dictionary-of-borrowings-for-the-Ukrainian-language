/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ukrvocabulary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Саня
 */
public class Vocabulary implements Serializable{
    
    private ArrayList<String> vocabulary;

    public Vocabulary(String root) throws FileNotFoundException {
        vocabulary = new ArrayList<>();
        fillVocabulary(root);
    }
    
    private void fillVocabulary(String root) throws FileNotFoundException {
        Scanner scn = new Scanner(new File(root));
        while(scn.hasNextLine())
            vocabulary.add(scn.nextLine());
    }

    public ArrayList<String> getVocabulary() {
        return vocabulary;
    }

    public void setVocabulary(ArrayList<String> vocabulary) {
        this.vocabulary = vocabulary;
    }
    
    public void addWord(String word){
        vocabulary.add(word);
    }
    
    public void removeWord(int wordPosition){
        vocabulary.remove(wordPosition);
    }
    
    public void serData(){
        try(PrintWriter pw = new PrintWriter(new File("res/vocabulary.txt"));) {
            for(int i=0; i<vocabulary.size(); i++){
                pw.print(vocabulary.get(i));
                pw.println();
            }
        } catch (FileNotFoundException ex){
            Logger.getLogger(Vocabulary.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sortVocabulary(){
        Collections.sort(vocabulary);
    }
}
