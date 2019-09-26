
package entities;


 public class Rules{
    public boolean testWin(Trainer A,Trainer B){
      int a=0,b=0;
      if(A.mainPkm.isFallen())
         if(A.havePkmn()){
           System.out.println(A.mainPkm.getName() + " caiu em batalha!\n");
           A.escolherPkm();
      }
      else{
        a++;
      }
      if(B.mainPkm.isFallen())
         if(B.havePkmn()){
          B.escolherPkm();
      }
       else{
         b++; 
      }
      
      if(a != 0 || b != 0){
       if(a != 0)      
            System.out.println("Treinador : " + B.getName() + " ganhou ");
       if(b != 0)
            System.out.println("Treinador : " + A.getName() + " ganhou ");
       return true;
      }
      else{
        return false;
      }
    }
    
    static void battleCalc(Trainer A,Trainer B){
         if(A.mainPkm.getSpd() <= B.mainPkm.getSpd()){
         System.out.println("**********************");
         System.out.println(B.getName());
         A.mainPkm.getDamage(B.mainPkm.selecionarAtk().getDamage() + B.mainPkm.getAtk());
         System.out.println("-----------------------");
         System.out.println(B.getName());
         B.mainPkm.getDamage(A.mainPkm.selecionarAtk().getDamage() + A.mainPkm.getAtk());
         }
         else{
         System.out.println("************************");
         System.out.println(A.getName());    
         B.mainPkm.getDamage(A.mainPkm.selecionarAtk().getDamage() + A.mainPkm.getAtk());
         System.out.println("------------------------");
         System.out.println(B.getName());
         A.mainPkm.getDamage(B.mainPkm.selecionarAtk().getDamage() + B.mainPkm.getAtk());
         }
         System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
         System.out.println(A.mainPkm.getName() + " recebeu " + B.mainPkm.getDpsAtk() + " pts de dano x\n");
         System.out.println(B.mainPkm.getName() + " recebeu " + A.mainPkm.getDpsAtk() + " pts de dano x\n");
         System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    }
    
    static void criticalHitCalc(){};
    static void evadeCalc(){};    

    
}
