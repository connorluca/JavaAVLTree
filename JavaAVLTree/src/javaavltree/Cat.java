/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaavltree;

/**
 *
 * @author conno
 */
public class Cat implements Comparable<Cat>{
    private String name;
    private String breed;
    private double wieghtKG;

    public Cat(String name, String breed, double wieghtKG) {
        this.name = name;
        this.breed = breed;
        this.wieghtKG = wieghtKG;
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public double getWieghtKG() {
        return wieghtKG;
    }

    public void setWieghtKG(double wieghtKG) {
        this.wieghtKG = wieghtKG;
    }

    @Override
    public int compareTo(Cat o) {
        if(this.wieghtKG<o.wieghtKG){
            return -1;
        }
        else if(this.wieghtKG >o.wieghtKG){
            return 1;
        }
        else{
            return 0;
        }
    }
    
}
