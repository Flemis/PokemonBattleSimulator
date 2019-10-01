
package entities;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Pokemon {
    private String name;
    private int level;
    private int atk,def,spd,spAtk,HP,DpsAtk;
    private Conditions cd = Conditions.STAND;
    private List<Skill> ataques = new ArrayList<>();
    
    

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getHP() {
        return HP;
    }
    
    public int getAtk(){
        return atk;
    }

    public int getSpd() {
        return spd;
    }
    
    
    public void setLevel(int level) {
        this.level = level;
    }
    
    public void getDamage(int x){
       if(HP - x >= 0)
       HP -= x;
       else
       HP = 0;
    }
    
    public boolean isFallen(){
       if (getHP() <= 0)
         return true;
       else
          return false;
    }
    
    public void setDps(Skill s){
        this.DpsAtk = s.getDamage() + getAtk();
    }

    public int getDpsAtk() {
        return DpsAtk;
    }
 
    public void gerarStatus(){
      HP = level * 45;
      atk = level * 15;
      def = level * 10;
      spAtk = level * 25;
      spd = level * 10;
      
        System.out.println("Status gerados com sucesso!");
    };

    @Override
    public String toString() {
        return " name= " + name + ", level=" + level;
    }
    
     public int geraRandom(List lista) {
       Random a = new Random();
       int op = a.nextInt(lista.size());
       return op;
    }
     
    
     
    public void geraNome(List lista){
       int x = geraRandom(lista);
       name = lista.get(x).toString();
       lista.remove(x);
    }
    
    public List loadSkills(){
        List<String> txtSkills = new ArrayList<>();
        String names = "C:\\Users\\Gabriel\\Documents\\NetBeansProjects\\PokemonBattleSimulator\\data\\Skills.txt";
       
       try (BufferedReader br = new BufferedReader(new FileReader(names))){
         String line = br.readLine();
         while(line != null){
           txtSkills.add(line);
           line = br.readLine();
         }
         System.out.println("leitura realizada com sucesso");
         return txtSkills;
       }catch(IOException e){
           System.out.println(e.getMessage());
           return null;
       }
    }
    
   
    
    public void geraAtaques(List list){
        Skill ataque;
        int op;
            while (ataques.size() <= 3){
                op = geraRandom(list);
                ataque = Skill.newSkill(list.get(op).toString());
                ataques.add(ataque);
                list.remove(op);
       
            }
            System.out.println("--------------------------");
            System.out.println("Ataques gerados com sucesso! ");
    }

    
    public String informarStatus(){
        return ("Atk: " + atk + " Defesa: " + def + " Speed: " + spd + " Spk Atk: : " + spAtk + " HP: " + HP);
    }
    
    public void informarAtaques(){
        for(Skill skill:ataques){
            System.out.println("\n--------------");
            System.out.println(ataques.lastIndexOf(skill) + 1 + " " +skill);
        }
        System.out.println("-------------------");
    }
    
    public Skill selecionarAtk(){
        int resp;
        Scanner sr = new Scanner(System.in);
        do{
        System.out.println(getName() + "     " + getHP());
        informarAtaques();
        System.out.println("Selecione um atk: ");
        resp = sr.nextInt() - 1;
        if (ataques.get(resp).havePP())
            break;  
        else{
            System.out.println("PP's desse movimento acabou!");
        }
        }while(true);
        setDps(ataques.get(resp));
        ataques.get(resp).drawPP();
        return ataques.get(resp);
    }
    
 
    public void gerarLog(){
       String path =  "C:\\Users\\Gabriel\\Documents\\NetBeansProjects\\PokemonBattleSimulator\\data\\pkmLog.txt";
       
       try (BufferedWriter bw = new BufferedWriter(new FileWriter(path,false))){
            bw.write("Pokemon: " + getName() + " Level: " + getLevel() + "\n");
            bw.write(informarStatus() + "\n");
               for(Skill ataque:ataques){ 
                bw.write(ataque.toString());
                bw.newLine();
            }
            System.out.println("-----------");    
            System.out.println("Sucess");
            bw.close();
        } 
       catch(IOException e){
            e.printStackTrace();
        }
    }
    
    private void gerarLevel(){
       Random rand = new Random();
       level = rand.nextInt(101);
       if(level == 0)
         gerarLevel();
    }
    
     public Pokemon(List lista) {
        gerarLevel();
        gerarStatus();
        geraAtaques(loadSkills());
        geraNome(lista);
        gerarLog();
    }
}
