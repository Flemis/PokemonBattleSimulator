/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Gabriel
 */
public class Skill {
    private int number;
    private String name;
    private int damage;
    private int pp;
    private int accuracy;
    private double critRate;

    private Skill(int number,String name, int damage, int pp, int accuracy, double critRate) {
        this.number = number;
        this.name = name;
        this.damage = damage;
        this.pp = pp;
        this.accuracy = accuracy;
        this.critRate = critRate;
    }
    
    public static Skill newSkill(String a){
        String str[] = a.split(",");
        int number = Integer.parseInt(str[0]);
        String name = str[1];
        int damage = Integer.parseInt(str[2]);
        int pp = Integer.parseInt(str[3]);
        int accuracy = Integer.parseInt(str[4]);
        double critRate = Double.parseDouble(str[5]);
        
        return new Skill(number,name,damage,pp,accuracy,critRate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public double getCritRate() {
        return critRate;
    }
    
    public void drawPP(){
       pp--; 
    }
    
    public boolean havePP(){
       if(getPp() > 0)
         return true;
       else
         return false;
    }

    public void setCritRate(double critRate) {
        this.critRate = critRate;
    }
    

    @Override
    public String toString() {
        return " name=" + name + ", damage=" + damage + ", pp=" + pp + ", accuracy=" + accuracy + ", critRate=" + critRate;
    }
    
    
    
}
