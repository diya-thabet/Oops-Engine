package org.dhia.util;

public class Time {
    public static float timeStarted= System.nanoTime();

    public static float getTime(){
        return (float) (( System.nanoTime() - timeStarted)*1E-9);
    }

    public static void main(String[] args){
        Time time = new Time();
        System.out.println("nihaha");
        System.out.println(timeStarted);
        System.out.println(getTime());
        System.out.println(timeStarted -  System.nanoTime());
    }
}
