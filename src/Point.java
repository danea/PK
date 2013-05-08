/**
 * Created with IntelliJ IDEA.
 * User: Christopher
 * Date: 03.05.13
 * Time: 15:24
 * To change this template use File | Settings | File Templates.
 */
public class Point {
    private double x;
    private double y;

    public Point(double x,double y) {
        this.setX(x);
        this.setY(y);
    }
	public Point(Point p) {
		this.setX(p.getX());
		this.setY(p.getY());
	}
    public Point () {
        this.setX(0);
        this.setY(0);
    }

    public double dist(Point p) {
        return Math.sqrt(
                (this.getX() - p.getX()) * (this.getX() - p.getX()) +
                (this.getY() - p.getY()) * (this.getY() - p.getY())
        );
    }

    public Point middle(Point p) {
        return new Point (
                Math.abs(this.getX() - p.getX()) / 2,
                Math.abs(this.getY() - p.getY()) / 2
        );
    }

    @Override
    public String toString() {
        return this.getX() + " / " + this.getY();
    }

    @Override
    public boolean equals(Object other) {
        if(other == this) {
            return true;
        }
        if(!(other instanceof Point) || other == null) {
            return false;
        }

        Point p = (Point) other;
        return (this.x == p.x && this.y == p.y);
    }


    /*GETTER/SETTER BLOCK*/
    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
}
