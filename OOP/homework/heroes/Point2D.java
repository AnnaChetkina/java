package OOP.homework.heroes;

public class Point2D {
    protected int x;
    protected int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double getDistance(Point2D target) {
        return Math.sqrt(Math.pow(this.x - target.x, 2) + Math.pow(this.y - target.y, 2));
    }

//    protected boolean isRight(Point2D enemyPoint) {
//        return this.point2D.x > enemyPoint.x;
//    }
//    protected boolean isUp(Point2D enemyPoint) {
//        return this.point2D.y < enemyPoint.y;
//    }
//    protected boolean isDown(Point2D enemyPoint) {
//        return this.point2D.y > enemyPoint.y;
//    }

    protected Point2D chooseWay(Point2D enemyPoint){
        return new Point2D(x - enemyPoint.x, y - enemyPoint.y);
    }
}