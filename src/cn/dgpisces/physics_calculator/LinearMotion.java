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
        return ((Math.pow(terminalVelocity, 2) - Math.pow(initVelocity, 2)) / 2 * distance);
    }

    public static double equationUnknownDist(double acceleration, double initVelocity, double terminal) {
        return ((Math.pow(terminal, 2) - Math.pow(initVelocity, 2)) / (2 * acceleration));
    }

    public static double equationUnknownInit(double acceleration, double time, double terminal) {
        return (terminal - (acceleration * time));
    }

    public static double equationUnknownTime(double acceleration, double initVelocity, double terminal) {
        return ((terminal - initVelocity) / acceleration);
    }

    public static double equationUnknownTerminal(double acceleration, double initVelocity, double time) {
        return (initVelocity + (acceleration * time));
    }
}
