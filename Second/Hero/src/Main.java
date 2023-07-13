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
        System.out.println("请选择需要的技能：\n1.v我50\n2.你是好人\n3.吔屎啦你\n4.咸鱼突刺");
        int n=myscanner.nextInt();
        Skill s1=new Skill("v我50",50,"说我是学生让他V了50HP");
        Skill s2=new Skill("你是好人",100,"对他说你是好人");
        Skill s3=new Skill("吔屎啦你",75,"对他说吔屎啦你");
        Skill s4=new Skill("咸鱼突刺",35,"说咸鱼也是有梦想的并发动了突刺");
        Item i1=new Item("大剑",30,50);
        Item i2=new Item("护符",100,20);
        Item i3=new Item("添购",200,30);
        Item i4=new Item("ddl",-50,60);
        Hero stu=new Hero("学生",300,30,s1);
        Hero goddess=new Hero("女神",200,25,s2);
        Hero player=new Hero(hName,hHP,hAtk);
        switch (n) {
            case 1:player.setSkill(s1);
            break;
            case 2:player.setSkill(s2);
            break;
            case 3:player.setSkill(s3);
            break;
            case 4:player.setSkill(s4);
            break;
            default:
                System.out.println("非正常选项");
        }
        System.out.println("请选择装备：\n1.大剑\n2.护符");
        int m=myscanner.nextInt();
        switch (m){
            case 1:player.useItem(i1);
            break;
            case 2:player.useItem(i2);
            break;
            default:
                System.out.println("非正常选项");
        }
        System.out.println("请选择场次：1 or 2");
        int t=myscanner.nextInt();
        switch (t){
            case 1:
                stu.useItem(i4);
                player.fight(player,stu);
                break;
            case 2:
                goddess.useItem(i3);
                player.fight(player,goddess);
                break;
        }
    }
}