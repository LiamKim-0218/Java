package c230905;

import java.util.ArrayList;
import java.util.List;

public class Player {
   
   private List<Item> inventory;
   private int defense;
   private int attack;
   public Player(int defense, int attack) {
      inventory=new ArrayList<>();
      this.defense=defense;
      this.attack=attack;
   }
   public void AddItem(Item item) {
      inventory.add(item);
   }
   public void listInventory() {
      System.out.println("인벤토리 아이템 목록 : ");
      for(Item item : inventory) {
         System.out.println(item.getName()+"(장착 여부 : "+(item.isEquipped()?"장착":"탈착"+")"));
      }
   }
   public void equipItem(int index) {
      //내가 장착하려는 인덱스가 0이상, 인벤토기 크기보다 작으면
      if(index>=0 && index<inventory.size()) {
         
         Item item = inventory.get(index);
         
         //장착되어 있지 않다면?
         if(!item.isEquipped()) {
            item.equip();//장착!
            
            defense+=item.getDefense();
            attack+=item.getAttack();
            
            System.out.println("방어력이 " + defense + "증가함");
            System.out.println("공격력이 " + attack + "증가함");
         }
         else {
            System.out.println(item.getName()+"은 이미 장착~");
         }
      }
      else {
         System.out.println("벗어남");
      }
   }
   public void unequipItem(int index) {
      if(index>=0 && index<inventory.size()) {
         Item item = inventory.get(index);
         if(!item.isEquipped()) {
            item.unequip();
         }
         else {
            System.out.println(item.getName()+"은 이미 장착~");
         }
      }
      else {
         System.out.println("벗어남");
      }
   }
}