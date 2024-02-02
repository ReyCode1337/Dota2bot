package bot;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;

public class AutoAccept{
    private final Robot robot;
    private final Color expectedColor;
    private final Rectangle searchArea;

    public AutoAccept(Color expectedColor, Rectangle searchArea) throws AWTException {
        this.robot = new Robot();
        this.expectedColor = expectedColor;
        this.searchArea = searchArea;
    }

    public boolean searchForColor() {
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage screenImage = robot.createScreenCapture(screenRect);
        return searchForColorInRegion(screenImage, searchArea, expectedColor);
    }

    public void clickButton(int x, int y) {
        robot.mouseMove(x, y);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(100); // Небольшая задержка для имитации реального действия
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
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