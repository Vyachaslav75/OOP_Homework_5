package Units;

import java.util.ArrayList;
import java.util.Random;

public abstract class BaseHero implements BaseInterface{
    protected static int number;
    protected static Random r;
    public int health;
    protected int attack;
    protected int minDamage;
    protected int maxDamage;
    protected int armor;
    protected int speed;
    //protected int experience;
    protected final String NAME;
    protected int maxHP;
    //protected int x;
    //protected int y;
    protected Positions position;
    static {
        BaseHero.number = 0;
        BaseHero.r = new Random();
    }

    public BaseHero(int health, int attack, int minDamage, int maxDamage,
                    int armor, int speed, String name, int x, int y) {
        this.health = health;
        this.attack = attack;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.armor = armor;
        this.speed = speed;
        NAME = name;
        this.maxHP = health;
        //this.x = x;
        //this.y = y;
        position = new Positions(x, y);

    }

//    public BaseHero(int x, int y) {
//        this(1,1,1,1,1,3,
//                String.format("Hero_ #%d", ++BaseHero.number), x, y);
//    }

    public BaseHero(String name, int x, int y) {
        this(1,1,1,1,1,3,
                name, x ,y);
        //this.name = name;
    }
    @Override
    public String getInfo(){
        String outStr = String.format("\t%-3s\t⚔️ %-3d\t\uD83D\uDEE1 %-3d\t♥️%-3d%%\t☠️%-3d\t        " , 
        NAME,attack , armor,(int) health*100/maxHP,(int) (minDamage + maxDamage)/2);
        return outStr;
        //return String.format("Name: %s Hp: %d Type: %s",
        //        NAME, this.health, this.getClass().getSimpleName());
    }

    @Override
    public void step(ArrayList<BaseHero> team1, ArrayList<BaseHero> team2) {
        //System.out.println(this.getType());

    }
    public String getType(){return "";}

    public int getSpeed() {
        return this.speed;
    }
//    public double distance(int x1, int y1){
//        return Math.sqrt(Math.pow((x1-this.x), 2)+Math.pow((y1-this.y), 2));
//    }

//    public void healed(int hp){
//        this.health = hp + this.health > this.maxHP ? this.maxHP : hp + this.health;
//    }
    public void takeDamage(int damage){
        //damage = BaseHero.r.nextInt(this.minDamage, this.maxDamage);
//        if (damage < 0){
//            healed(damage);
//        }else if (this.health - damage > 0){
//            this.health -= damage;
//        }
        if (this.health - damage < 0){
            this.health = 0;
        }else {
            this.health -= damage;
        }

    }
    public void attackEnemy(BaseHero target){
        //int damage = BaseHero.r.nextInt(this.minDamage, this.maxDamage);
        int damage = (this.minDamage + this.maxDamage)/2;
        target.takeDamage(damage);
    }
    public Positions getPosition(){
        return position;
    }
    public String getName(){return "";}
}
