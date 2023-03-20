package Units;
public class Robber extends BaseHero {


    public Robber(String name, int x, int y) {
        super(10, 8, 2, 4, 3, 6, name, x, y);;
    }

    public String getInfo(){
        return String.format("%s ", super.getInfo());
    }

    public String getType(){return "Разбойник";}
    public String getName(){return "Разбойник";}
}
