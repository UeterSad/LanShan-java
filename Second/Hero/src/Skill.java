public class Skill {
    private String name;
    private int atk;
    private String describe;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }


    public Skill(String name, int atk, String describe) {
        this.name = name;
        this.atk = atk;
        this.describe = describe;
    }
}
