public class Hero extends Person{
    private Skill skill;
    private int flag=0;

    public void fight(Hero player, Hero b) {
        for (int i = 1;  ; i++) {
            if (player.getHP() <=0|| b.getHP() <=0)
            {
                if(player.getHP()<=0){
                    System.out.println("lose");
                    return;
                }
                else{
                    System.out.println("win");
                    return;
                }
            }
            System.out.println("[round"+i+"]");
            player.useAtk(b);
            if (player.getHP() <=0|| b.getHP() <=0)
            {
                if(player.getHP()<=0){
                    System.out.println("lose");
                    return;
                }
                else{
                    System.out.println("win");
                    return;
                }
            }
            b.useAtk(player);
            if (player.getHP() <=0|| b.getHP() <=0)
            {
                if(player.getHP()<=0){
                    System.out.println("lose");
                    return;
                }
                else{
                    System.out.println("win");
                    return;
                }
            }
            if (player.flag%3==0)player.useSkill(b);
            if (player.getHP() <=0|| b.getHP() <=0)
            {
                if(player.getHP()<=0){
                    System.out.println("lose");
                    return;
                }
                else{
                    System.out.println("win");
                    return;
                }
            }
            if (b.flag%3==0)b.useSkill(player);
        }
    }

    public int getFlag() {
        return flag;
    }

    @Override
    public void useAtk(Person p) {
        super.useAtk(p);
        flag++;
    }

    public Hero(String name, int HP, int atk,Skill skill) {
        this.skill = skill;
        setName(name);
        setHP(HP);
        setAtk(atk);
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Hero(String name, int HP, int atk) {
        setName(name);
        setHP(HP);
        setAtk(atk);
    }

    public void useSkill(Person p){
        p.setHP(p.getHP()-skill.getAtk());
        System.out.println(getName()+"对"+p.getName()+"使用了"+skill.getName()+" "+skill.getDescribe()+" "+p.getName()+"的HP-"+skill.getAtk());
    }
}
