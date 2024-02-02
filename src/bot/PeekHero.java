package bot;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class PeekHero{
    int keyEvents = KeyEvent.VK_P;
    private final Robot peek_robot;
    private final Color peek_expectedColor;
    private final Rectangle peek_searchArea;

    public PeekHero(Color expectedColor, Rectangle searchArea) throws AWTException {
        this.peek_robot = new Robot();
        this.peek_expectedColor = expectedColor;
        this.peek_searchArea = searchArea;
    }

    public boolean searchForColor() {
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage screenImage = peek_robot.createScreenCapture(screenRect);
        return searchForColorInRegion(screenImage, peek_searchArea, peek_expectedColor);
    }

    public void clickButton(int x, int y) {
        peek_robot.delay(1500);
        peek_robot.mouseMove(x, y);
        peek_robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        peek_robot.delay(100); // Небольшая задержка для имитации реального действия
        peek_robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        peek_robot.delay(1500);
        peek_robot.mouseMove(1204, 759);
        peek_robot.delay(100);
        peek_robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
        peek_robot.delay(100); // Небольшая задержка для имитации реального действия
        peek_robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
    }
    public void gg(){
        peek_robot.delay(30000);
        peek_robot.delay(30000);
        peek_robot.delay(30000);
        peek_robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
        peek_robot.delay(100);
        peek_robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
        peek_robot.keyPress(keyEvents);
        peek_robot.delay(100);
        peek_robot.keyRelease(keyEvents);
    }

    private boolean searchForColorInRegion(BufferedImage image, Rectangle area, Color targetColor) {
        for (int i = (int)area.getX(); i < area.getX() + area.getWidth(); i++) {
            for (int j = (int)area.getY(); j < area.getY() + area.getHeight(); j++) {
                if (new Color(image.getRGB(i, j)).equals(targetColor)) {
                    return true;
                }
            }
        }
        return false;
    }
}