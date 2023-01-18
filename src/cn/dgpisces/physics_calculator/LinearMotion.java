package cn.dgpisces.physics_calculator;

public class LinearMotion {
    private LinearMotion() {
    }

    public static double equationUnknownAcc(double distance, double initVelocity, double terminalVelocity) {
        return (Math.pow(terminalVelocity, 2) - Math.pow(initVelocity, 2)) / (2 * distance);
    }

    public static double equationUnknownAccWithoutDist(double time, double initVelocity, double terminalVelocity) {
        return ((terminalVelocity - initVelocity) / time);
    }

    public static double equationUnknownAccWithoutInit(double time, double terminalVelocity, double distance) {
        return (2 * (terminalVelocity * time - distance) / Math.pow(time, 2));
    }

    public static double equationUnknownAccWithoutTime(double initVelocity, double terminalVelocity, double distance) {
        return ((Math.pow(terminalVelocity, 2) - Math.pow(initVelocity, 2)) / (2 * distance));
    }

    public static double equationUnknownDist(double acceleration, double initVelocity, double terminal) {
        return ((Math.pow(terminal, 2) - Math.pow(initVelocity, 2)) / (2 * acceleration));
    }
    public static double equationUnknownDistWithoutInit(double acceleration, double terminal, double time){
        return ((terminal*time)-(0.5*acceleration* Math.pow(time,2)));
    }
    public static double equationUnknownDistWithoutTerminal(double acceleration, double time, double initVelocity){
        return ((initVelocity*time)+(0.5*acceleration*Math.pow(time,2)));
    }
    public static double equationUnknownDistWithoutTime(double acceleration, double initVelocity, double terminal){
        return ((Math.pow(terminal, 2) - Math.pow(initVelocity, 2)) / 2 * acceleration);
    }
    public static double equationUnknownInit(double acceleration, double time, double terminal) {
        return (terminal - (acceleration * time));
    }
    public static double equationUnknownInitWithoutTer(double acceleration, double time, double distance){
        return ((distance-(0.5*acceleration*Math.pow(time, 2)))/time);
    }
    public static double equationUnknownInitWithoutTime(double acceleration, double terminal, double distance){
        return (Math.sqrt(Math.pow(terminal,2)-(2*acceleration*distance)));
    }
    public static double equationUnknownTimeWithoutTer(double acceleration, double initVelocity, double distance){
        return (Math.sqrt(Math.pow(initVelocity,2)+(2*acceleration*distance)));
    }
    public static double equationUnknownTime(double acceleration, double initVelocity, double terminal) {
        return ((terminal - initVelocity) / acceleration);
    }
    public static double equationUnknownTerminal(double acceleration, double initVelocity, double time) {
        return (initVelocity + (acceleration * time));
    }
}
