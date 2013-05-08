/**
 * Created with IntelliJ IDEA.
 * User: Christopher
 * Date: 03.05.13
 * Time: 15:43
 * To change this template use File | Settings | File Templates.
 */
public class Triangle implements Scaleable, Moveable, Rotate, Shape, Transformable{
    private Point a, b, c;

    public Triangle (Point a, Point b, Point c) {
        this.a = new Point(a);
        this.b = new Point(b);
        this.c = new Point(c);
    }
	@Override
	public void scale(double sx, double sy) {
		a.setX(a.getX() * sx);
		b.setX(b.getX() * sx);
		c.setX(c.getX() * sx);

		a.setY(a.getY() * sy);
		b.setY(b.getY() * sy);
		c.setY(c.getY() * sy);
	}
	@Override
	public void move(double tx, double ty){
		a.setX(a.getX() + tx);
		b.setX(b.getX() + tx);
		c.setX(c.getX() + tx);

		a.setY(a.getY() + ty);
		b.setY(b.getY() + ty);
		c.setY(c.getY() + ty);
	}
	@Override
	public void rotate(double alpha) {
		a.setX(Math.cos(alpha) * a.getX() - Math.sin(alpha) * a.getY());
		a.setY(Math.sin(alpha) * a.getY() + Math.cos(alpha) * a.getX());
		b.setX(Math.cos(alpha) * b.getX() - Math.sin(alpha) * b.getY());
		b.setY(Math.sin(alpha) * b.getY() + Math.cos(alpha) * b.getX());
		c.setX(Math.cos(alpha) * c.getX() - Math.sin(alpha) * c.getY());
		c.setY(Math.sin(alpha) * c.getY() + Math.cos(alpha) * c.getX());
	}
	@Override
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
	@Override
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

	@Override
	public Transformable rotate2(double alpha) {
		Triangle ret = new Triangle(this.a,this.b,this.c);
		ret.rotate(alpha);
		return ret;
	}

	@Override
	public Transformable move2(double tx, double ty) {
		Triangle ret = new Triangle(this.a,this.b,this.c);
		ret.move(tx, ty);
		return ret;
	}

	@Override
	public Transformable scale2(double sx, double sy) {
		Triangle ret = new Triangle(this.a,this.b,this.c);
		ret.scale(sx, sy);
		return ret;
	}
}
