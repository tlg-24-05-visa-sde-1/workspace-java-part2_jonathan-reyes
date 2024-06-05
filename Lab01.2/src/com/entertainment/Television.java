package com.entertainment;

import java.util.Objects;

/*Natural Order is defined by brand( sort key)*/

public class Television implements Comparable<Television>{
    //fields
    private String brand;
    private int volume;
    private final Tuner tuner = new Tuner();

    //constructor
    public Television() {
    }

    public Television(String brand, int volume) {
        setBrand(brand);
        setVolume(volume);
    }

    //business methods
    public int getCurrentChannel(){
        return tuner.getChannel();
    }

    public void changeChannel(int channel){
        tuner.setChannel(channel);
    }


    //accessor methods
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }



    //from intellij
    @Override
    public boolean equals(Object obj) {
        if (this == obj)  // checking if BOTH references are pointing to the same physical object
            return true;
        if (obj == null || getClass() != obj.getClass()) //check if passed obj is null OR this.class !=objects.class
            return false;

        //downcasting the object to television
        Television that = (Television) obj;

        return getVolume() == that.getVolume() &&               //checking the volumes (this.getVolume()==other.volume();
                Objects.equals(getBrand(), that.getBrand());    //null safe brand checking
    }

    //from intellij
    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getVolume());
    }


    /*public int hashCode(){
        System.out.println("hashCode() called");
        //this is a hashcode that will yield a hash collision
        //return getBrand().length()+getVolume();

        //this is a scientifically correct hash function. Minimizes hash collision.
        return Objects.hash(brand, volume);
    }*/

    /*@Override
    public boolean equals(Object obj){
        System.out.println("equals() called");
        boolean result = false;
        //Checking if obj passed in parenthesis is actually a television
        //if(obj instanceof Television){ //This is a IS_A Check ( remember salariedEmployee vs Executive check
                                            //executive is-a salariedEmp so it would pass)
         if(this.getClass() == obj.getClass()){  //Checking if we are the EXACT SAME TYPE, executive employee
                                                // passed to equals in salaried emp, this would not pass

            //MUST DOWNCAST obj of OBJECT class down to TELEVISION to work with it
            Television other = (Television)obj;

            //business equality is defined as brand, volume
           // result = this.getBrand().equals(other.getBrand()) && this.getVolume() == other.getVolume(); //throws nullpointerexception when null
            result = Objects.equals(this.getBrand(),other.getBrand()) &&
                    this.getVolume() == other.getVolume();         //is null safe, meaning that brands being objects if passed as null
                                                                    //wont throw the nullpointer exception. NOTE: volumes being primitives cant be null
        }

        return result;
    }*/


    @Override
    public int compareTo(Television o1) {
        return this.getBrand().compareTo(o1.getBrand());
    }

    @Override
    public String toString() {
        return String.format("%s [brand=%s, volume=%s, currentChannel= %s]",
                getClass().getSimpleName(), getBrand(), getVolume(), getCurrentChannel());

    }
}