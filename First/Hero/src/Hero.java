public class Hero extends Person{
    private Skill skill;
    private int flag=0;

    public int getFlag() {
        return flag;
    }

    @Override
    public void useAtk(Person p) {
        super.useAtk(p);
        flag++;
    }

    public Hero(String name, int HP, int atk, Skill skill) {
        this.skill = skill;
        setName(name);
        setHP(HP);
        setAtk(atk);
    }

    public void useSkill(Skill s, Person p){
        p.setHP(p.getHP()-s.getAtk());
        System.out.println(getName()+"对"+p.getName()+"使用了"+s.getName()+" "+s.getDescribe()+" "+p.getName()+"的HP-"+s.getAtk());
    }
}
