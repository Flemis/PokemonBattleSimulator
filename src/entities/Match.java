
package entities;

import java.util.Scanner;


public class Match {
    public int rounds;
    public boolean over;
    Rules rl;
    Trainer A;
    
    public Match() {
        this.rounds = 0;
    }
    
    public void roundAdd(){
        rounds++;
    }
    
    public void setOver(boolean x){
        over = x;
    }
    
    public boolean Listarops(Trainer A){
        if(!(A.isHaveMain())){
           A.escolherPkm();
        }
        
        Scanner sr = new Scanner(System.in);
        int i;
        System.out.println("|-------------------------------|");
        System.out.println(A.getName() + "     " + A.mainPkm.getName() + "    " + A.mainPkm.getHP());
        System.out.println("                                |");
        System.out.println("| 1-Atacar                      |");
        System.out.println("| 2-Trocar PKM                  |");
        System.out.println("| 3-Verificar pokemon           |"); 
        System.out.println("|------------------------------|");
        
        i = sr.nextInt();
    
        switch(i){
            case 1:
              return true;
            case 2:
              A.trocarPkm();
              break;
            case 3:
                System.out.println(A.mainPkm.informarStatus());
              break;  
            default:
              break;  
      }
        return Listarops(A);
    }
    
    public Trainer cadastrarTrainers(int n){
       Scanner sr = new Scanner(System.in);
        System.out.println("-----------------");
       System.out.println("nome do treinador: ");
        System.out.println("----------------- \n");
       String name = sr.nextLine();
       return A = new Trainer(name,n);
    }
    
    public void Ismatch(){
        rl = new Rules();
        Scanner n = new Scanner(System.in);
        System.out.println("----------");
        System.out.println("Digite o número de pkmns para cada treinador");
        System.out.println("----------\n");
        int op = n.nextInt();
        Trainer A = cadastrarTrainers(op);
        Trainer B = cadastrarTrainers(op);
        
        do{
         Listarops(A);
         Listarops(B);
         rl.battleCalc(A, B);         
       } while(!(rl.testWin(A, B)));
    } 
}
