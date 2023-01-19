/*
 * Copyright (c) Pisces Gao my copyright message. 2023-2023. All rights reserved.
 *
 */

package cn.dgpisces.physics_calculator;

import java.awt.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("-------------Physics Calculator-------------");
        System.out.println("Mechanics:"); //Electricity maybe add, pay attention to be edible in this part
        System.out.println("1. Linear Motion");
        System.out.println("2. 2D Motion");
        System.out.print("Please input the number: ");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        switch (input) {
            case 1:
                linearMotion(scanner);
                break;
            case 2:
                twoDMotion(scanner);
                break;
            default:
        }
    }

    public static void linearMotion(Scanner scanner) {
        while (true) {
            int nextLineJudge = 0;
            String distance;
            String acceleration;
            String time;
            String initVelocity;
            String terminalVelocity;
            boolean distStatus;
            boolean accStatus;
            boolean timeStatus;
            boolean initStatus;
            boolean terminalStatus;

            while (true) {
                try {
                    PhysicsCalculatorUtil.clearConsole(); //Clear Terminal
                } catch (AWTException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("-------------Linear Motion-------------");
                System.out.println("Please input the data you have (press enter directly if there's an unknown value)");
                if (nextLineJudge == 0) {
                    scanner.nextLine();
                }
                System.out.print("Distance: ");
                distance = scanner.nextLine();
                System.out.print("Acceleration: ");
                acceleration = scanner.nextLine();
                System.out.print("Time: ");
                time = scanner.nextLine();
                System.out.print("Initial(v0) Velocity: ");
                initVelocity = scanner.nextLine();
                System.out.print("Terminal(v) Velocity: ");
                terminalVelocity = scanner.nextLine();

        /*
        Process Null Data
         */
                ArrayList<Boolean> judgement = new ArrayList<>();
                if (distance.length() != 0) {
                    distStatus = true;
                } else {
                    distStatus = false;
                    judgement.add(false);
                }
                if (acceleration.length() != 0) {
                    accStatus = true;
                } else {
                    accStatus = false;
                    judgement.add(false);
                }
                if (time.length() != 0) {
                    timeStatus = true;
                } else {
                    timeStatus = false;
                    judgement.add(false);
                }
                if (initVelocity.length() != 0) {
                    initStatus = true;
                } else {
                    initStatus = false;
                    judgement.add(false);
                }
                if (terminalVelocity.length() != 0) {
                    terminalStatus = true;
                } else {
                    terminalStatus = false;
                    judgement.add(false);
                }

        /*
        Formula Logic Judgement
         */
                //Two Or More Invalid Data, Reenter the Data.
                int count = 0;
                for (int i = 0; i < judgement.size(); i++) {
                    if (!judgement.get(i)) {
                        count++;
                    }
                }
                if (count >= 3) {
                    System.out.println("Please input more information");
                    nextLineJudge++;
                    scanner.nextLine();
                } else if (count == 0) {
                    System.out.println("You've known the answer, please retry");
                    nextLineJudge++;
                    scanner.nextLine();
                } else {
                    break;
                }
            }
        /* Copy and Paste From Here.
        double distConvert = Double.parseDouble(distance);
        double accConvert  = Double.parseDouble(acceleration);
        double timeConvert = Double.parseDouble(time);
        double initConvert = Double.parseDouble(initVelocity);
        double terminalConvert = Double.parseDouble(terminalVelocity);
        */
            double result;
            double secResult;
            System.out.println("Your result:");
            if (!accStatus) {
                if (!distStatus) {
                    double timeConvert = Double.parseDouble(time);
                    double initConvert = Double.parseDouble(initVelocity);
                    double terminalConvert = Double.parseDouble(terminalVelocity);
                    result = LinearMotion.equationUnknownAccWithoutDist(timeConvert, initConvert, terminalConvert);
                    secResult = LinearMotion.equationUnknownDist(result, initConvert, terminalConvert);
                    System.out.println("Acceleration = " + result);
                    System.out.println("Distance = " + secResult);
                } else if (!initStatus) {
                    double distConvert = Double.parseDouble(distance);
                    double timeConvert = Double.parseDouble(time);
                    double terminalConvert = Double.parseDouble(terminalVelocity);
                    result = LinearMotion.equationUnknownAccWithoutInit(timeConvert, terminalConvert, distConvert);
                    secResult = LinearMotion.equationUnknownInit(result, timeConvert, terminalConvert);
                    System.out.println("Acceleration = " + result);
                    System.out.println("Initial Velocity = " + secResult);
                } else if (!timeStatus) {
                    double distConvert = Double.parseDouble(distance);
                    double initConvert = Double.parseDouble(initVelocity);
                    double terminalConvert = Double.parseDouble(terminalVelocity);
                    result = LinearMotion.equationUnknownAccWithoutTime(initConvert, terminalConvert, distConvert);
                    secResult = LinearMotion.equationUnknownTime(result, initConvert, terminalConvert);
                    System.out.println("Acceleration = " + result);
                    System.out.println("Time = " + secResult);
                } else {
                    double distConvert = Double.parseDouble(distance);
                    double initConvert = Double.parseDouble(initVelocity);
                    double terminalConvert = Double.parseDouble(terminalVelocity);
                    result = LinearMotion.equationUnknownAcc(distConvert, initConvert, terminalConvert);
                    System.out.println("Acceleration = " + result);
                }
            } else if (!distStatus) {
                if (!initStatus) {
                    double accConvert = Double.parseDouble(acceleration);
                    double timeConvert = Double.parseDouble(time);
                    double terminalConvert = Double.parseDouble(terminalVelocity);
                    result = LinearMotion.equationUnknownDistWithoutInit(accConvert, terminalConvert, terminalConvert);
                    secResult = LinearMotion.equationUnknownInit(accConvert, timeConvert, terminalConvert);
                    System.out.println("Distance = " + result);
                    System.out.println("Initial Velocity = " + secResult);
                } else if (!terminalStatus) {
                    double accConvert = Double.parseDouble(acceleration);
                    double timeConvert = Double.parseDouble(time);
                    double initConvert = Double.parseDouble(initVelocity);
                    result = LinearMotion.equationUnknownDistWithoutTerminal(accConvert, timeConvert, initConvert);
                    secResult = LinearMotion.equationUnknownTerminal(accConvert, initConvert, timeConvert);
                    System.out.println("Distance = " + result);
                    System.out.println("Terminal Velocity = " + secResult);
                } else if (!timeStatus) {
                    double accConvert = Double.parseDouble(acceleration);
                    double initConvert = Double.parseDouble(initVelocity);
                    double terminalConvert = Double.parseDouble(terminalVelocity);
                    result = LinearMotion.equationUnknownDistWithoutTime(accConvert, initConvert, terminalConvert);
                    secResult = LinearMotion.equationUnknownTime(accConvert, initConvert, terminalConvert);
                    System.out.println("Distance = " + result);
                    System.out.println("Time = " + secResult);
                } else {
                    double accConvert = Double.parseDouble(acceleration);
                    double initConvert = Double.parseDouble(initVelocity);
                    double terminalConvert = Double.parseDouble(terminalVelocity);
                    result = LinearMotion.equationUnknownDist(accConvert, initConvert, terminalConvert);
                    System.out.println("Distance = " + result);
                }
            } else if (!initStatus) {
                if (!terminalStatus) {
                    double distConvert = Double.parseDouble(distance);
                    double accConvert = Double.parseDouble(acceleration);
                    double timeConvert = Double.parseDouble(time);
                    result = LinearMotion.equationUnknownInitWithoutTer(accConvert, timeConvert, distConvert);
                    secResult = LinearMotion.equationUnknownTerminal(accConvert, result, timeConvert);
                    System.out.println("Initial Velocity = " + result);
                    System.out.println("Terminal Velocity = " + secResult);
                } else if (!timeStatus) {
                    double distConvert = Double.parseDouble(distance);
                    double accConvert = Double.parseDouble(acceleration);
                    double terminalConvert = Double.parseDouble(terminalVelocity);
                    result = LinearMotion.equationUnknownInitWithoutTime(accConvert, terminalConvert, distConvert);
                    secResult = LinearMotion.equationUnknownTime(accConvert, result, terminalConvert);
                    System.out.println("Initial Velocity = " + result);
                    System.out.println("Time = " + secResult);
                } else {
                    double accConvert = Double.parseDouble(acceleration);
                    double timeConvert = Double.parseDouble(time);
                    double terminalConvert = Double.parseDouble(terminalVelocity);
                    result = LinearMotion.equationUnknownInit(accConvert, timeConvert, terminalConvert);
                    System.out.println("Initial Velocity = " + result);
                }
            } else if (!timeStatus) {
                if (!terminalStatus) {
                    double distConvert = Double.parseDouble(distance);
                    double accConvert = Double.parseDouble(acceleration);
                    double initConvert = Double.parseDouble(initVelocity);
                    result = LinearMotion.equationUnknownTimeWithoutTer(accConvert, initConvert, distConvert);
                    secResult = LinearMotion.equationUnknownTerminal(accConvert, initConvert, result);
                    System.out.println("Time = " + result);
                    System.out.println("Terminal Velocity = " + secResult);
                } else {
                    double accConvert = Double.parseDouble(acceleration);
                    double initConvert = Double.parseDouble(initVelocity);
                    double terminalConvert = Double.parseDouble(terminalVelocity);
                    result = LinearMotion.equationUnknownTime(accConvert, initConvert, terminalConvert);
                    System.out.println("Time = " + result);
                }
            } else {
                double accConvert = Double.parseDouble(acceleration);
                double timeConvert = Double.parseDouble(time);
                double initConvert = Double.parseDouble(initVelocity);
                result = LinearMotion.equationUnknownTerminal(accConvert, initConvert, timeConvert);
                System.out.println("Terminal Velocity = " + result);
            }
            System.out.print("Do you want to calculate new?(Y/N): ");
            String check = scanner.next();
            if(check.equalsIgnoreCase("n")){
                break;
            }
        }
    }

    public static void twoDMotion(Scanner scanner) {
        int input;
        while (true) {
            try {
                PhysicsCalculatorUtil.clearConsole();
            } catch (AWTException e) {
                throw new RuntimeException(e);
            }
            System.out.println("-------------2D Motion-------------");
            System.out.println("1. Decomposed or composed vector");
            System.out.println("2. Calculation");
            System.out.print("Input: ");
            input = scanner.nextInt();
            if (input != 1 && input != 2) {
                System.out.println("Unknown Input, please retry!");
            } else {
                break;
            }
        }
            switch (input) {
                case 1:
                    composedAndDecomposedVector(scanner);
                    break;
                case 2:
                    break;
                default:
                    break;
            }
    }

    public static void composedAndDecomposedVector(Scanner scanner){
        int input;
        while(true) {
            try {
                PhysicsCalculatorUtil.clearConsole();
            } catch (AWTException e) {
                throw new RuntimeException(e);
            }
            System.out.println("-------------Composed or Decomposed Vector-------------");
            System.out.println("1. x y vector composes to single vector");
            System.out.println("2. single vector decomposes to x y vector");
            System.out.print("Input: ");
            input = scanner.nextInt();
            if (input != 1 && input != 2) {
                System.out.println("Unknown Input, please retry!");
            } else {
                break;
            }
        }
        switch (input){
            case 1:
                System.out.println("-------------1. x y vector composes to single vector-------------");
                System.out.print("x Direction: ");
                double xDirection = scanner.nextDouble();
                System.out.print("y Direction: ");
                double yDirection = scanner.nextDouble();
                double angleOutput = PhysicsCalculatorUtil.composedXYToSingle(xDirection,yDirection);
                System.out.println("Angle: " + angleOutput);
                break;
            case 2:
                System.out.println("-------------2. single vector decomposes to x y vector-------------");
                System.out.print("Angle: ");
                double angle = scanner.nextDouble();
                System.out.print("Combined Velocity/Acceleration: ");
                double combined = scanner.nextDouble();
                Map<String, Double> returnMap = PhysicsCalculatorUtil.decomposedToXYDirection(angle,combined);
                System.out.println("X Direction: " + returnMap.get("x"));
                System.out.println("Y Direction: " + returnMap.get("y"));
                break;
            default:
                break;
        }
    }
}