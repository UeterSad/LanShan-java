public abstract class Person {
    private String name="张伟";
    private int HP=100;
    private int atk=5;
    public void fight(Person player,Person b){
        for (int i = 1;  ; i++) {
            if (player.HP<=0||b.HP<=0)
            {
                if(player.HP<=0){
                    System.out.println("lose");
                    return;
                }
                else{
                    System.out.println("win");
                    return;
                }
            }
            System.out.println("round"+i);
            player.useAtk(b);
            if (player.HP<=0||b.HP<=0)
            {
                if(player.HP<=0){
                    System.out.println("lose");
                    return;
                }
                else{
                    System.out.println("win");
                    return;
                }
            }
            b.useAtk(player);
        }
    }

    public void useAtk(Person p){
        p.HP=p.HP-atk;
        System.out.println(name+"攻击了"+p.name+" HP-"+atk);
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
