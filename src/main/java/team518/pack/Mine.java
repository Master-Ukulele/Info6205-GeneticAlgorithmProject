package team518.pack;

public class Mine {
    private double xPosition;
    private double yPosition;
    private double radiation;
    //private double zPosition;
    //private double reserves; //Later, a constant related to radiation strength

    public double getxPosition() {
        return xPosition;
    }

    public void setxPosition(double xPosition) {
        this.xPosition = xPosition;
    }

    public double getyPosition() {
        return yPosition;
    }

    public void setyPosition(double yPosition) {
        this.yPosition = yPosition; }

    public double getRadiation () {
        return radiation;
    }

    public void setRadiation (double radiation) {
        this.radiation = radiation;
    }
}