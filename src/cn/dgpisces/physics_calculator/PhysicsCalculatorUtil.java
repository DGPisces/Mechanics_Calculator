package cn.dgpisces.physics_calculator;

import java.awt.*;
import java.awt.event.KeyEvent;

public class PhysicsCalculatorUtil {
    private PhysicsCalculatorUtil(){
        System.out.println("Dangerous Action in Util Class!!!");
    }
    /**
     * Only Use This In IDEA Terminal
     */
    public static void clearConsole() throws AWTException {
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_CONTROL);             // 按下Ctrl键
        r.keyPress(KeyEvent.VK_R);                    // 按下R键
        r.keyRelease(KeyEvent.VK_R);                  // 释放R键
        r.keyRelease(KeyEvent.VK_CONTROL);            // 释放Ctrl键
        r.delay(100);
    }

    /**
     * Use This In Windows Terminal
     */
    public static void clearConsoleInWindowsTerminal(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
