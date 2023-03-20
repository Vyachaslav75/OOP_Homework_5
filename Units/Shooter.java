package Units;

import java.util.ArrayList;

public abstract class Shooter extends BaseHero {
    protected int arrows;
    public Shooter(int health, int attack, int minDamage, int maxDamage,
                   int armor, int speed, String name, int x, int y, int arrows) {
        super(health, attack, minDamage, maxDamage, armor, speed, name, x, y);
        this.arrows = arrows;
    }
    @Override
    public void step(ArrayList<BaseHero> enemy, ArrayList<BaseHero> friends) {

        if (this.arrows > 0 && this.health > 0){
            //System.out.println("Могу стрелять! я "+ this.getType());
            double dist = 20;
            BaseHero hero;
            int indx = 0;
            for (int i = 0; i < enemy.size(); i++) {
                //System.out.println(enemy.size());
                hero = enemy.get(i);
                //System.out.println(hero.getType());
                if (hero.health > 0 && dist > this.position.distance(hero.position.x, hero.position.y)){
                    dist = this.position.distance(hero.position.x, hero.position.y);
                    indx = i;
                }
            }
            hero = enemy.get(indx);
            //System.out.println("Цель: " + hero.getType());
            if (hero.health > 0){
                this.attackEnemy(hero);
                this.arrows--;
            }
        }
        //System.out.println("Остаось стрел" + String.valueOf(this.arrows));
        for (BaseHero hero : friends){
            if (hero.getType().equals("Крестьянин")){
                this.arrows++;
                break;
            }//else{
          //      this.arrows--;
          //  }
        }
        //System.out.println("Остаось стрел" + String.valueOf(this.arrows));
    }
}
