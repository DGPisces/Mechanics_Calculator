package cn.dgpisces.physics_calculator;

import java.awt.*;
import java.util.ArrayList;
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
                break;
            default:
        }
    }

    public static double linearMotion(Scanner scanner){
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
            if(nextLineJudge==0) {
                scanner.nextLine();
            }
            System.out.print("Distance: ");
            distance = scanner.nextLine();
            System.out.print("Acceleration: ");
            acceleration = scanner.nextLine();
            System.out.print("Time: ");
            time = scanner.nextLine();
            System.out.print("Initial Velocity: ");
            initVelocity = scanner.nextLine();
            System.out.print("Terminal Velocity: ");
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
                timeStatus =false;
                judgement.add(false);
            }
            if (initVelocity.length() != 0) {
                initStatus =true;
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
        if(!accStatus){
            if(!distStatus){
                double timeConvert = Double.parseDouble(time);
                double initConvert = Double.parseDouble(initVelocity);
                double terminalConvert = Double.parseDouble(terminalVelocity);
                result = LinearMotion.equationUnknownAccWithoutDist(timeConvert,initConvert, terminalConvert);
                secResult = LinearMotion.equationUnknownDist(result, initConvert,terminalConvert);
            }
            else if (!initStatus){
                double distConvert = Double.parseDouble(distance);
                double timeConvert = Double.parseDouble(time);
                double terminalConvert = Double.parseDouble(terminalVelocity);
                result = 0; //Unfinished Start From Here!
            }
            else if (!timeStatus){

            }
            else{
                double distConvert = Double.parseDouble(distance);
                double timeConvert = Double.parseDouble(time);
                double initConvert = Double.parseDouble(initVelocity);
                double terminalConvert = Double.parseDouble(terminalVelocity);
                result = LinearMotion.equationUnknownAcc(distConvert, initConvert,terminalConvert);
            }
        }
        else if (!distStatus) {
            if(!initStatus){

            }
            else if(!terminalStatus){

            } else if (!timeStatus) {

            }
            else {
                double accConvert  = Double.parseDouble(acceleration);
                double timeConvert = Double.parseDouble(time);
                double initConvert = Double.parseDouble(initVelocity);
                double terminalConvert = Double.parseDouble(terminalVelocity);
                result = LinearMotion.equationUnknownDist(accConvert, initConvert,terminalConvert);
            }
        }
        else if (!initStatus) {
            if(!terminalStatus){

            } else if (!timeStatus) {

            }else {
                double distConvert = Double.parseDouble(distance);
                double accConvert  = Double.parseDouble(acceleration);
                double timeConvert = Double.parseDouble(time);
                double terminalConvert = Double.parseDouble(terminalVelocity);
                result = LinearMotion.equationUnknownInit(accConvert,timeConvert,terminalConvert);
            }
        }
        else if(!timeStatus){
            if (!terminalStatus){

            }
            else{
                double distConvert = Double.parseDouble(distance);
                double accConvert  = Double.parseDouble(acceleration);
                double initConvert = Double.parseDouble(initVelocity);
                double terminalConvert = Double.parseDouble(terminalVelocity);
                result = LinearMotion.equationUnknownTime(accConvert,initConvert,terminalConvert);
            }
        }
        else{
            double distConvert = Double.parseDouble(distance);
            double accConvert  = Double.parseDouble(acceleration);
            double timeConvert = Double.parseDouble(time);
            double initConvert = Double.parseDouble(initVelocity);
            result = LinearMotion.equationUnknownTerminal(accConvert,initConvert,timeConvert);
        }
        return 1;

    }
}