package c230906;

public class App {

   public static void main(String[] args) {
      
      Player player= new Player("민규",100,20);
      Monster monster= new Monster("원준", 80,15);
      
      boolean isGame = true;
      
      System.out.println("싸워라");
      System.out.println(player.getName()+"(체력: "+player.getHealth()+")"
      +monster.getName()+"(체력 : "+monster.getHealth()+")");
      
      while (isGame) 
      {
         STATE playerSelect =player.selectAction();
         
         switch (playerSelect) {
         case ATTACK:
            
            //플레이어
            System.out.println(player.getName()+"이"+monster.getName()+"에게"
             +player.attack()+"만큼의 데미지를 먹임");
            monster.takeDamage(player.attack());
            
            //뒤지지 않았으면
            if(!monster.isAlive()) {
                System.out.println(monster.getName()+"처치!!");
                isGame=false;
            }
            else {
               System.out.println(monster.getName()+"(체력 : "+monster.getHealth()+")");
            }
            //몬스터
            System.out.println(monster.getName()+"이"+player.getName()+"에게"
                   +monster.attack()+"만큼의 데미지를 먹임");
            player.takeDamage(monster.attack());
            if(!player.isAlive()) {
                System.out.println(player.getName()+"처치!!");
                isGame=false;
            }
            else {
               System.out.println(player.getName()+"(체력 : "+player.getHealth()+")");
            }
            break;
         case USE_ITEM:
            player.useItem();break;
         case RUN:
            System.out.println(player.getName()+"튀튀튀~~~");
            isGame=false;
         default:
            System.out.println("잘못된 선택이였음./.....");
            break;
         }
      }
      System.out.println("게임 종료");
   }
}