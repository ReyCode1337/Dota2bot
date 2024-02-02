package bot;

import bot.functionbot.*;

import java.awt.*;

public class DotaBot {

    public void setStart() throws AWTException {

        int SearchGame = 0;
        int AcceptGame = 1;
        int PeekHero = 1;
        int FeedOnMid = 1;
        int EndGame = 1;
        int h = 0;
        int k0 = 0;

        while (k0 < 1) {

            while (SearchGame < 1) {

                try {
                    Color expectedColor = new Color(255, 255, 255); // Измените на ожидаемый цвет кнопки
                    Rectangle searchArea = new Rectangle(1643, 1000, 313, 45); // Измените на область кнопки
                    StartGame startBot = new StartGame(expectedColor, searchArea);

                    if (startBot.searchForColor()) {
                        int x = (int) searchArea.getCenterX();
                        int y = (int) searchArea.getCenterY();
                        startBot.clickButton(x, y);
                        System.out.println("Игра ищется!");
                        SearchGame++;
                        AcceptGame = 0;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            while (AcceptGame < 1) {
                try {
                    Color expectedColor = new Color(255, 255, 255); // Измените на ожидаемый цвет кнопки
                    Rectangle searchArea = new Rectangle(946, 512, 313, 60); // Измените на область кнопки
                    AutoAccept AAbot = new AutoAccept(expectedColor, searchArea);

                    if (AAbot.searchForColor()) {
                        int x = (int) searchArea.getCenterX();
                        int y = (int) searchArea.getCenterY();
                        AAbot.clickButton(x, y);
                        System.out.println("Игра принята!");
                        AcceptGame++;
                        PeekHero = 0;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            while (PeekHero < 1) {
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
                        FeedOnMid = 0;
                        PeekHero++;
                        System.out.println("Пизделово на поляне пошло!");

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            while (FeedOnMid < 1) {
                try {
                    AutoAttack bot3 = new AutoAttack();
                    bot3.clickKey(133, 945);
                    EndGame = 0;

                } catch (AWTException e) {
                    throw new RuntimeException(e);
                }
            }

            while (EndGame < 1) {
                try {
                    Color expectedColor = new Color(161, 241, 172); // Измените на ожидаемый цвет кнопки
                    Rectangle searchArea = new Rectangle(900, 890, 250, 35); // Измените на область кнопки
                    EndGame EndBot = new EndGame(expectedColor, searchArea);

                    if (EndBot.searchForColor()) {
                        int x = (int) searchArea.getCenterX();
                        int y = (int) searchArea.getCenterY();
                        EndBot.clickButton(x, y);
                        System.out.println("Игра закончена!");
                        h++;
                        System.out.println(h);
                        SearchGame = 0;
                        EndGame++;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        }
    }
}





