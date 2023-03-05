package OOP.homework.heroes;

public class Point2D {
    protected int x;
    protected int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double getDistance(Point2D pointB) {
        return Math.sqrt(Math.pow(this.x - pointB.x, 2) + Math.pow(this.y - pointB.y, 2));
    }
}