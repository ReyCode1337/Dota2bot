package bot.functionbot;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;

public class StartGame {

    private final Robot start_robot;
    private final Color start_expectedColor;
    private final Rectangle start_searchArea;

    public StartGame(Color expectedColor, Rectangle searchArea) throws AWTException {
        this.start_robot = new Robot();
        this.start_expectedColor = expectedColor;
        this.start_searchArea = searchArea;
    }

    public boolean searchForColor() {
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage screenImage = start_robot.createScreenCapture(screenRect);
        return searchForColorInRegion(screenImage, start_searchArea, start_expectedColor);
    }

    public void clickButton(int x, int y) {
        start_robot.delay(3500);
        start_robot.mouseMove(x, y);
        start_robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        start_robot.delay(100); // Небольшая задержка для имитации реального действия
        start_robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        start_robot.delay(500);
        start_robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        start_robot.delay(100); // Небольшая задержка для имитации реального действия
        start_robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
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