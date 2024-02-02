package bot;

import java.awt.*;

public class DotaBot {
    public void setStart() throws AWTException {
        int k1 = 0;
        int k2 = 1;
        int k3 = 1;
        int k4 = 1;
        int k5 = 1;
        int h = 0;
        int k0 = 0;
        while (k0 < 1) {
            while (k1 < 1) {

                try {
                    Color expectedColor = new Color(255, 255, 255); // Измените на ожидаемый цвет кнопки
                    Rectangle searchArea = new Rectangle(1643, 1000, 313, 45); // Измените на область кнопки
                    Startgame startBot = new Startgame(expectedColor, searchArea);

                    if (startBot.searchForColor()) {
                        int x = (int) searchArea.getCenterX();
                        int y = (int) searchArea.getCenterY();
                        startBot.clickButton(x, y);
                        System.out.println("Игра ищется!");
                        k1++;
                        k2 = 0;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            while (k2 < 1) {
                try {
                    Color expectedColor = new Color(255, 255, 255); // Измените на ожидаемый цвет кнопки
                    Rectangle searchArea = new Rectangle(946, 512, 313, 60); // Измените на область кнопки
                    AutoAccept AAbot = new AutoAccept(expectedColor, searchArea);

                    if (AAbot.searchForColor()) {
                        int x = (int) searchArea.getCenterX();
                        int y = (int) searchArea.getCenterY();
                        AAbot.clickButton(x, y);
                        System.out.println("Игра принята!");
                        k2++;
                        k4 = 0;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            while (k4 < 1) {
                try {
                    Color expectedColor = new Color(255, 255, 255); // Измените на ожидаемый цвет кнопки
                    Rectangle searchArea = new Rectangle(1673, 840, 84, 60); // Измените на область кнопки
                    PeekHero peekbot = new PeekHero(expectedColor, searchArea);

                    if (peekbot.searchForColor()) {
                        int x = (int) searchArea.getCenterX();
                        int y = (int) searchArea.getCenterY();
                        peekbot.clickButton(x, y);
                        peekbot.gg();
                        System.out.println("Герой пикнут!");
                        k5 = 0;
                        k4++;

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                while (k0 < 1) {


                    while (k5 < 1) {
                        try {
                            AutoAttack bot3 = new AutoAttack();
                            System.out.println("Пизделово на поляне пошло!");
                            bot3.clickKey(133, 945);
                            h++;
                            System.out.println(h);
                            k3 = 0;

                        } catch (AWTException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    while (k3 < 1) {
                        try {
                            Color expectedColor = new Color(161, 241, 172); // Измените на ожидаемый цвет кнопки
                            Rectangle searchArea = new Rectangle(900, 890, 250, 35); // Измените на область кнопки
                            EndGame EndBot = new EndGame(expectedColor, searchArea);

                            if (EndBot.searchForColor()) {
                                int x = (int) searchArea.getCenterX();
                                int y = (int) searchArea.getCenterY();
                                EndBot.clickButton(x, y);
                                System.out.println("Игра закончена!");
                                k1 = 0;
                                k3++;

                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        }
    }
}