public class Person {
    private String name="张伟";
    private int HP=100;
    private int atk=5;

    public void useAtk(Person p){
        p.HP=p.HP-atk;
        System.out.println(name+"攻击了"+p.name+"HP-"+atk);
    }

    public void useItem(Item i){
        HP=HP+i.getHP();
        atk=atk+i.getAtk();
        System.out.println(name+"使用了"+i.getName());
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getHP() {
        return HP;
    }

    public int getAtk() {
        return atk;
    }
}
