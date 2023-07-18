package FlyFighting;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.List;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener {

    //读取英雄机的图片
    ImageIcon heroImage = new ImageIcon("image/hero.png");

    //定义一个集合来装所有的敌机
    ArrayList<Enemy> enemys = new ArrayList();

    //定义一个队列来装所有的子弹
    ArrayList<Bullet> bullets = new ArrayList();

    //定义一个集合来装爆炸的图片
    ArrayList<Bomb> bombs = new ArrayList();




    //英雄机的坐标
    int heroX = 300;
    int heroY = 400;
    private int number=0;//分数

    public GamePanel() {
        //创建10个敌人
        for(int i=0; i<10; i++){
            enemys.add(new Enemy());
        }
    }




    //鼠标移动时调用
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar()=='w')heroY-=10;
        if(e.getKeyChar()=='s')heroY+=10;
        if(e.getKeyChar()=='a')heroX-=10;
        if(e.getKeyChar()=='d')heroX+=10;

        if(heroX+heroImage.getIconWidth() > GameMain.width) {
            heroX = GameMain.width - heroImage.getIconWidth() - 20;
        }

        if(heroY+heroImage.getIconHeight() > GameMain.height) {
            heroY = GameMain.height - heroImage.getIconHeight() - 20;
        }



        repaint();//x发生变化后需要重新绘制


    }

    //碰撞方法
    public boolean isHit(Enemy e, Bullet b) {
        //指定一个区域
        Rectangle rect = new Rectangle(e.getX(), e.getY(), e.getWidth(), e.getHeight());

        //表示（x，y）坐标空间中的位置的点
        Point p = new Point(b.getX()+b.getWidth()/2, b.getY()+b.getHeight());

        return rect.contains(p);
    }




    //重写paint方法，做绘制图片使用
    public void paint(Graphics g) {
        super.paint(g);

        g.setFont(new Font("", Color.RED.getRed(), 30));
        g.drawString("得分"+number, 20, 30);

        //1.绘制英雄机
        g.drawImage(heroImage.getImage(), heroX, heroY, null);

        //2.绘制敌机
        for(int i=0; i<enemys.size(); i++) {
            Enemy enemy = enemys.get(i);
            enemy.drawImage(g);//重新绘制
        }

        //3.绘制子弹
        for(int i=0; i<bullets.size(); i++) {
            Bullet bullet = bullets.get(i);
            bullet.drawImage(g);
        }

        //4.绘制爆炸图片
        for(int i=0; i<bombs.size(); i++) {
            Bomb bomb = bombs.get(i);
            bomb.drawImage(g);
        }
    }

    /*
     * init这个方法做初始化方法使用
     * 创建一些组件（英雄机，子弹，敌人）
     * */

    public void init() {
        int flag = 0;
        while(true) {

            flag++;
            //每循环20次创建一个子弹
            if(flag % 15 == 0) {

                //创建一些子弹
                Bullet bullet = new Bullet(heroX+heroImage.getIconWidth()/2, heroY);

                //把子弹添加到集合中
                bullets.add(bullet);
            }

            //让敌机往下移动
            for(int i=0; i<enemys.size(); i++) {
                Enemy enemy = enemys.get(i);
                enemy.move();//改变敌机的y值

                //判断敌机的y值是否大于整个窗口的高度
                if(enemy.getY() > GameMain.height){
                    //删除敌机
                    enemys.remove(enemy);

                    //再添加一个新的敌机
                    enemys.add(new Enemy());

                }
            }

            //让子弹飞起来
            for(int i=0; i<bullets.size(); i++){
                Bullet tempBullet = bullets.get(i);
                tempBullet.move();
            }

            System.out.println("子弹数量："+bullets.size());

            //删除越界的子弹
            for(int i = 0; i<bullets.size(); i++) {
                Bullet bullet = bullets.get(i);
                if(bullet.getY() < 0) {
                    //y轴小于零说明越界了
                    bullets.remove(bullet);
                }
            }


            //处理子弹碰撞到敌机的效果
            for(int i=0; i<enemys.size(); i++) {
                Enemy enemy = enemys.get(i);//敌机

                for(int j=0; j<bullets.size(); j++) {
                    Bullet bullet = bullets.get(j);//得到子弹

                    if(isHit(enemy, bullet)){
                        //先删除敌机
                        enemys.remove(enemy);//先删除击中的敌机
                        enemys.add(new Enemy());//再添加一个新的敌机
                        bullets.remove(bullet);//删除子弹

                        //创建一个爆炸图片的对象
                        Bomb bomb = new Bomb(enemy.getX(), enemy.getY());
                        bombs.add(bomb);//添加到集合中
                        number+=10;//每次碰撞加10分
                    }
                }
            }

            //删除爆炸的图片
            for(int i=0; i<bombs.size(); i++) {
                Bomb bomb = bombs.get(i);
                bomb.move();
                if(bomb.getCount()>5) {
                    bombs.remove(bomb);
                }
            }



            try {
                Thread.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            }

            repaint();
        }


    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
