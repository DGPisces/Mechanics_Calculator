package cn.dgpisces.physics_calculator;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class PhysicsCalculatorUtil {
    private PhysicsCalculatorUtil() {
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
    public static void clearConsoleInWindowsTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static Map<String, Double> decomposedToXYDirection(double angle, double combined){
        Map<String, Double> map = new HashMap<>();
        double angleInRadians = Math.toRadians(angle);
        double xDirection = (combined*Math.cos(angleInRadians));
        double yDirection = (combined*Math.sin(angleInRadians));
        map.put("x",xDirection);
        map.put("y",yDirection);
        return map;
    }
    public static double composedXYToSingle(double xDirection, double yDirection){
        double angleInRadians = (Math.atan2(yDirection,xDirection));
        return Math.toDegrees(angleInRadians);
    }

}
