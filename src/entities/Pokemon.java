
package entities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Pokemon {
    private String name;
    private int level;
    private int atk,def,spd,spAtk,HP;
    private Conditions cd;
    private List<Skill> ataques = new ArrayList<>();
    

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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
        return "Pokemon{" + "name=" + name + ", level=" + level + ", atk=" + atk + ", def=" + def + ", spd=" + spd + ", spdAtk=" + spAtk + ", HP=" + HP + ", cd=" + cd + ", ataques=" + ataques + '}';
    }
     
    
    
    public void geraAtaques(){
        String Skills = "";
        Skill ataque;
        
        try (BufferedReader br = new BufferedReader(new FileReader(Skills))){
            String line = br.readLine();
            while (ataques.size() <= 4){
                ataque = Skill.newSkill(line);
                ataques.add(ataque);
                line = br.readLine();
            }
            System.out.println("Ataques gerados com sucesso! ");
            br.close();
        }
        catch(IOException e){
            System.out.println(e);
        }
    };
    
    public String informarStatus(){
        return ("Atk: " + atk + " Defesa: " + def + " Speed: " + spd + " Spk Atk: : " + spAtk);
    }
    public void gerarLog(){
       String path =  "";
       
       try (BufferedWriter bw = new BufferedWriter(new FileWriter(path,false))){
            bw.write("Pokemon: " + getName() + " Level: " + getLevel() + "\n");
            bw.write(informarStatus() + "\n");
               for(Skill ataque:ataques){ 
                bw.write(ataque.toString());
                bw.newLine();
            }
            System.out.println("Sucess");
            bw.close();
        } 
       catch(IOException e){
            e.printStackTrace();
        }
    }
    
    private void gerarLevel(){
       Random rand = new Random();
       
       level = rand.nextInt(99);
    }
    
     public Pokemon(String name) {
        gerarLevel();
        gerarStatus();
        geraAtaques();
        this.name = name;
        gerarLog();
    }
}
