package bot;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;

public class EndGame{
    private final Robot end_robot;
    private final Color end_expectedColor;
    private final Rectangle end_searchArea;

    public EndGame(Color expectedColor, Rectangle searchArea) throws AWTException {
        this.end_robot = new Robot();
        this.end_expectedColor = expectedColor;
        this.end_searchArea = searchArea;
    }

    public boolean searchForColor() {
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage screenImage = end_robot.createScreenCapture(screenRect);
        return searchForColorInRegion(screenImage, end_searchArea, end_expectedColor);
    }

    public void clickButton(int x, int y) {
        end_robot.delay(500);
        end_robot.mouseMove(x, y);
        end_robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        end_robot.delay(100); // Небольшая задержка для имитации реального действия
        end_robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
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