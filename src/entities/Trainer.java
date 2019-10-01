
package entities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Trainer {
    private String Name;
    List<Pokemon> pokemons = new ArrayList<>();
    Pokemon mainPkm;
    private boolean haveMain;
    private List<String> txtNames = new ArrayList<>();
    
    public int getSize(){
        return txtNames.size();
    }
    
     public void loadNames(){
        String names = "C:\\Users\\Gabriel\\Documents\\NetBeansProjects\\PokemonBattleSimulator\\data\\pokemons.txt";
       
       try (BufferedReader br = new BufferedReader(new FileReader(names))){
         String line = br.readLine();
         while(line != null){
           txtNames.add(line);
           line = br.readLine();
         }
         System.out.println("leitura realizada com sucesso");
       }catch(IOException e){
           System.out.println(e.getMessage()); 
       }
    }
    
    public void gerarPokemons(int n,List lista){
      Pokemon pkm;
      while (pokemons.size() < n){
         pkm = new Pokemon(lista);
         pokemons.add(pkm);
       }
    };

    public String getName() {
        return Name;
    }

    public boolean isHaveMain() {
        return haveMain;
    }
    
    
    public void listarPkms(){
           System.out.println("-------------");  
       for(Pokemon pkm:pokemons){
           System.out.println(pokemons.lastIndexOf(pkm) + 1 + " " + pkm);
           System.out.println("-------------");
       }
    }
    
    public boolean havePkmn(){
        if(pokemons.size() >= 1){
            return true;
        }
        else
            System.out.println(getName() + " não tem mais pokemons!");
            return false;
    }
    
    public void escolherPkm(){
       Scanner sc = new Scanner(System.in);
        System.out.println(getName() + "\n");
       listarPkms();
        System.out.println("\ndigite o numero do pokemon desejado: ");
        int rsp = sc.nextInt() - 1;
        mainPkm = pokemons.get(rsp);
        pokemons.remove(rsp);
        haveMain = true;
    };
    
    public void escolherAtk(){
       Scanner sc = new Scanner(System.in);
       int resp;
       mainPkm.informarAtaques();
        System.out.println("\nEscolha o ataque");
        resp = sc.nextInt() - 1;
    }
    
    
    public void trocarPkm(){
      Scanner sc = new Scanner(System.in);
       listarPkms();
        System.out.println("\ndigite o numero do pokemon desejado: ");
        int rsp = sc.nextInt() - 1;
        mainPkm = pokemons.get(rsp);
    };
    

    public void criarLog(){
       String path =  "C:\\Users\\Gabriel\\Documents\\NetBeansProjects\\PokemonBattleSimulator\\data\\TrainerLog.txt";
       
       try (BufferedWriter bw = new BufferedWriter(new FileWriter(path,false))){
            bw.write("Name: " + Name + "\n");
               for(Pokemon ataque:pokemons){ 
                bw.write(ataque.toString());
                bw.write("\n");
                bw.newLine();
            }
            System.out.println(getName() + " { Sucess");
            bw.close();
        } 
       catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public Pokemon getMain(Trainer A){
        return A.mainPkm;
    }
    
        public Trainer(String Name,int n) {
        this.Name = Name;
        loadNames();
          gerarPokemons(n,txtNames);
          haveMain = false;
          criarLog();
        }
    }
    
