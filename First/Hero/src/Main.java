import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner myscanner =new Scanner(System.in);
        System.out.println("欢迎来到竞技场");
        System.out.println("请输入你的英雄名字");
        String hName=myscanner.next();
        System.out.println("请输入英雄血量");
        int hHP=myscanner.nextInt();
        System.out.println("请输入英雄攻击力");
        int hAtk=myscanner.nextInt();
        System.out.println("请选择需要的技能：1 or 2");
        int n=myscanner.nextInt();
        Skill s1=new Skill("v我50",50,"让他V了50HP");
        Skill s2=new Skill("你是好人",100,"对他说你是好人");
        Item i1=new Item("大剑",10,75);
        Item i2=new Item("护符",200,20);
        Hero stu=new Hero("学生",250,30,s1);
        Hero goddess=new Hero("女神",200,25,s2);
        if (n==1){
            Hero player_1=new Hero(hName,hHP,hAtk,s1);
            System.out.println("请选择装备：1 or 2");
            int m=myscanner.nextInt();
            switch (m){
                case 1:player_1.useItem(i1);
                break;
                case 2:player_1.useItem(i2);
                break;
            }
            for (int i = 1;  ; i++) {
                if (player_1.getHP()<=0||stu.getHP()<=0)
                {
                    if(player_1.getHP()<=0){
                        System.out.println("lose");
                        return;
                    }
                    else {
                        System.out.println("win");
                        return;
                    }
                }
                System.out.println("round"+i);
                player_1.useAtk(stu);
                stu.useAtk(player_1);
                if (player_1.getFlag()==2)player_1.useSkill(s1,stu);
            }
        } else if (n==2) {
            Hero player_2=new Hero(hName,hHP,hAtk,s1);
            System.out.println("请选择装备：1 or 2");
            int m=myscanner.nextInt();
            switch (m){
                case 1:player_2.useItem(i1);
                break;
                case 2:player_2.useItem(i2);
                break;
            }
            for (int i = 1;  ; i++) {
                if (player_2.getHP()<=0||stu.getHP()<=0)
                {
                    if(player_2.getHP()<=0){
                        System.out.println("lose");
                    return;
                    }
                    else{
                        System.out.println("win");
                        return;
                    }
                }
                System.out.println("round"+i);
                player_2.useAtk(stu);
                stu.useAtk(player_2);
                if (player_2.getFlag()==2)player_2.useSkill(s1,stu);
            }
        }else {
            System.out.println("非所给选项");
            return;
        }
    }
}