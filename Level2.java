package wh.game;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import java.io.File;
import java.io.IOException;

public class Level2 extends Level{

    public Enemy e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15, e16, e17, e18, e19, e20, e21;
    public Coin c1, c2, c3, c4, c5, c6;
    public Animal bear1, bear2, dog1, dog2, dog3, dog4, dog5, gDeer1, gDeer2, gDeer3, gDeer4;

    public Level2() {

        super.walls = new int[][]{{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,1,0,0,0,0,1,0,1,1,1,0,0,0,0,0,0,1,1,1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,0,0,0,0,0,0,0,0,0},
                {0,1,0,0,0,0,1,1,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,0,0,1,1,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,4,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,0,0,1,1,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,6,7,0,0,0,0,0,0,0,0,0,0,0,0,4,5,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,0,0,1,1,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,6,7,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,0,0,0,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,1,0,1,0,0,0,0,0,1,0,0,1,0,0,0,1,0,0,1,0,0,0,0,1,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0},
                {0,0,1,1,1,1,1,0,0,0,0,0,1,0,0,0,1,0,0,0,0,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,0,1,1,0,1,1,1,1,0,1,0,4,5,0,0,1,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,4,5,0,4,5,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,6,7,0,0,1,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,6,7,0,6,7,0,0,0,0,1,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,1,0,0,0,0,1,0,1,0,0,0,0,1,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,1,1,0,0,0,0,1,1,1,1,1,0,0,0,0,1,1,0,1,0,0,1,0,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,0,0,0,0,1,1,1,1,1,1,1,1,1},
                {0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
                {0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,6,7,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
                {0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
                {0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,6,7,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
                {0,0,0,0,0,0,1,0,0,0,0,0,1,1,1,1,1,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,0,0,0,0,1,1,1,1,1,1,1,1,1},
                {0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,1,0,0,0,0,1,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,4,5,0,0,0,1,0,0,0,1,0,0,0,0,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,0,1,1,1,1,1,1,0,1,1,0,0,0,0,1,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,6,7,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,1,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,4,5,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,1,0,0,0,4,5,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,6,7,0,0,0,0,0,0,0,0,0},
                {0,1,1,1,1,1,1,0,0,0,6,7,0,0,0,0,1,0,0,0,0,1,0,1,0,0,0,0,1,0,0,1,0,0,0,1,0,0,0,0,1,0,0,1,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0},
                {1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,1,1,0,1,0,0,1,0,1,1,0,1,1,1,0,1,1,1,1,0,1,1,0,1,1,1,0,0,0,0,1,0,0,0,0,0,0,0,0},
                {1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,1,0,0,0,0,0,0,4,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
                {1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,6,7,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
                {1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
                {1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
                {0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};

        try {
            level = ImageIO.read(new FileImageInputStream(new File("src/wh/game/resource/images/level2.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Creating enemies, coins, animals

        e1 = new Enemy(112,368,16,16);
        enemies.add(e1);
        e2 = new Enemy(144,336,16,16);
        enemies.add(e2);
        e3 = new Enemy(144,304,16,16);
        enemies.add(e3);
        e4 = new Enemy(112,240,16,16);
        enemies.add(e4);
        e5 = new Enemy(176,272,16,16);
        enemies.add(e5);
        e6 = new Enemy(56,64,16,16);
        enemies.add(e6);
        e7 = new Enemy(48,88,16,16);
        enemies.add(e7);
        e8 = new Enemy(479,80,16,16);
        enemies.add(e8);
        e9 = new Enemy(368,128,16,16);
        enemies.add(e9);
        e10 = new Enemy(624,104,16,16);
        enemies.add(e10);
        e11 = new Enemy(672,127,16,16);
        enemies.add(e11);
        e12 = new Enemy(536,208,16,16);
        enemies.add(e12);
        e13 = new Enemy(472,335,16,16);
        enemies.add(e13);
        e14 = new Enemy(512,288,16,16);
        enemies.add(e14);
        e15 = new Enemy(552,335,16,16);
        enemies.add(e15);
        e16 = new Enemy(592,288,16,16);
        enemies.add(e16);
        e17 = new Enemy(336,416,16,16);
        enemies.add(e17);
        e18 = new Enemy(496,512,16,16);
        enemies.add(e18);
        e19 = new Enemy(496,560,16,16);
        enemies.add(e19);
        e20 = new Enemy(576,559,16,16);
        enemies.add(e20);
        e21 = new Enemy(575,512,16,16);
        enemies.add(e21);

        c1 = new Coin(56,64,16,16);
        coins.add(c1);
        c2 = new Coin(536,104,16,16);
        coins.add(c2);
        c3 = new Coin(704,208,16,16);
        coins.add(c3);
        c4 = new Coin(532,312,16,16);
        coins.add(c4);
        c5 = new Coin(704,416,16,16);
        coins.add(c5);
        c6 = new Coin(536,536,16,16);
        coins.add(c6);

        bear1 = new Animal(48,576,16,16,"Bear");
        animals.add(bear1);
        bear2 = new Animal(880,390,16,16,"Bear");
        animals.add(bear2);
        dog1 = new Animal(99,106,16,16,"DogR");
        animals.add(dog1);
        dog2 = new Animal(240,360,16,16,"DogR");
        animals.add(dog2);
        dog3 = new Animal(418,172,16,16,"DogL");
        animals.add(dog3);
        dog4 = new Animal(656,426,16,16,"DogL");
        animals.add(dog4);
        dog5 = new Animal(725,583,16,16,"DogR");
        animals.add(dog5);
        gDeer1 = new Animal(55,245,16,16,"grazingDeerL");
        animals.add(gDeer1);
        gDeer2 = new Animal(214,140,16,16,"grazingDeerR");
        animals.add(gDeer2);
        gDeer3 = new Animal(867,247,16,16,"grazingDeerR");
        animals.add(gDeer3);
        gDeer4 = new Animal(877,116,16,16,"grazingDeerL");
        animals.add(gDeer4);
    }

    public void levelMove(){

        // Movement of enemies and bears

        this.e1.enemyHorizontalMove(112,176);
        this.e2.enemyHorizontalMove(112,160);
        this.e3.enemyVerticalMove(272,320);
        this.e4.enemyHorizontalMove(112,176);
        this.e5.enemyVerticalMove(272,352);
        this.e6.enemyVerticalMove(64,144);
        this.e7.enemyHorizontalMove(32,80);
        this.e8.enemyHorizontalMove(400,480);
        this.e9.enemyHorizontalMove(368,448);
        this.e10.enemyVerticalMove(80,128);
        this.e11.enemyVerticalMove(80,128);
        this.e12.enemyHorizontalMove(336,688);
        this.e13.enemyVerticalMove(288,336);
        this.e14.enemyVerticalMove(288,336);
        this.e15.enemyVerticalMove(288,336);
        this.e16.enemyVerticalMove(288,336);
        this.e17.enemyHorizontalMove(336,688);
        this.e18.enemyVerticalMove(512,544);
        this.e19.enemyHorizontalMove(496,560);
        this.e20.enemyVerticalMove(528,560);
        this.e21.enemyHorizontalMove(512,576);
        this.bear1.animalMove(48,112,0,0);
        this.bear2.animalMove(880,896,390,432);
    }

}
