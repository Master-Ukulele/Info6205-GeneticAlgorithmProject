package team518.pack;

public class Galaxy {
    private double xMax = 10;
    private double yMax = 10;
    private Mine mine; //Use a container later to storage more mines, e.g. Array, better with HashTable
    //private Blocker blocker; //Design blocker later and its container

    public void createMine () {
        this.mine = new Mine();
        mine.setxPosition(Math.random() * xMax); // 0 <= x < xMax
        mine.setyPosition(Math.random() * yMax);
    }

    public Mine getMine() {
        return mine;
    }

    public void setMine(Mine mine) {
        this.mine = mine;
    }

    public class Mine {
        private double xPosition;
        private double yPosition;
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
            this.yPosition = yPosition;
        }
    }
}
