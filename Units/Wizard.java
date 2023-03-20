package Units;
public class Wizard extends BaseHero {
    private int mana;
    private int maxMana;
    public Wizard(String name, int x, int y){
        super(30, 17, -5, -5, 12, 9, name, x, y);
        this.maxMana = 1;
        this.mana = maxMana;
    }

  //  public String getInfo(){
  //      return String.format("%s Mana: %d", super.getInfo(), this.mana);
  //  }

    public String getType(){return "Колдун";}
    public String getName(){return "Колдун";}

}
