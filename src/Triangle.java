/**
 * Created with IntelliJ IDEA.
 * User: Christopher
 * Date: 03.05.13
 * Time: 15:43
 * To change this template use File | Settings | File Templates.
 */
public class Triangle {
    private Point a, b, c;

    public Triangle (Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double perimeter () {
        return a.dist(b) +
               b.dist(c) +
               c.dist(a);
    }
    public Triangle midTriangle() {
        return new Triangle(
                b.middle(a),
                b.middle(c),
                c.middle(a)
        );
    }
    public double area () {
        //the formula: http://upload.wikimedia.org/math/f/e/5/fe56529cdaaaa9bb2f71c1ad8a1a454f.png
        //http://www.mathopenref.com/coordtrianglearea.html
        return Math.abs(
                (a.getX()-c.getX()) * (b.getY()-a.getY())-
                (a.getX()-b.getX()) * (c.getY()-a.getY())
        )*0.5;
    }

    @Override
    public String toString () {
        return "[ \n\t" + a + ", \n\t" + b + ", \n\t" + c + " \n]";
    }
    @Override
    public boolean equals(Object other) {
        if(other == this) {
            return true;
        }
        if(!(other instanceof Triangle) || other == null) {
            return false;
        }

        Triangle t = (Triangle) other;
        return (t.a.equals(this.a) &&
                t.b.equals(this.b) &&
                t.c.equals(this.c)
        );
    }
}
