package bot;

import java.awt.*;
import java.awt.event.KeyEvent;

public class AutoAttack{
    int keyEvent = KeyEvent.VK_A;
    private final Robot AArobot;

    public AutoAttack() throws AWTException {
        this.AArobot = new Robot();
    }

    public void clickKey(int x, int y) {
        AArobot.mouseMove(x, y);
        AArobot.delay(10000);
        AArobot.keyPress(keyEvent);
        AArobot.delay(100);
        AArobot.keyRelease(keyEvent);
    }

    }
