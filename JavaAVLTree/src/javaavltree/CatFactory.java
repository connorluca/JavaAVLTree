/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaavltree;

import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author conno
 */
public class CatFactory {
    private ArrayList<String> catNames;
    private ArrayList<String> catBreeds;
    //there are duplicates of cat breeds in list to reflect commonality of that breed
    /*
    This will read a list of cat names and cat breeds from a list to be used in the generation of new cats.
    */
    public CatFactory(){
        File catNamesFile = new File("catNames.txt");
        File catBreedsFile= new File("catBreeds.txt");
        try {
            Scanner fileReader = new Scanner(catNamesFile);
            while(fileReader.hasNextLine()){
                catNames.add(fileReader.next());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CatFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Scanner fileReader = new Scanner(catBreedsFile);
            while(fileReader.hasNextLine()){
                String temp = fileReader.nextLine();                
                catBreeds.add(temp.trim());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CatFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
    Selects a random cat breed name and weight and returns that cat object.
    */
    public Cat createRandomCat() {
        String name = catNames.get((int)(random()*(catNames.size()-1)));
        String breed = catBreeds.get((int)(random()*(catBreeds.size()-1)));
        double weight = random()*(10-1)+1;//cat weight should be tied to breed but I don't wanna gather the information or fomat the file for that.
        return new Cat(name,breed,weight);
    }
    
}
