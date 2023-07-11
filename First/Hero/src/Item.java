public class Item {
    private String name;
    private int HP;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    private int atk;

    public Item(String name, int HP, int atk) {
        this.name = name;
        this.HP = HP;
        this.atk = atk;
    }
}
