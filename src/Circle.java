/**
 * Created with IntelliJ IDEA.
 * User: Christopher
 * Date: 08.05.13
 * Time: 16:46
 * To change this template use File | Settings | File Templates.
 */
public class Circle implements Shape, Scaleable, Moveable, Rotate, Transformable{
	private Point p;

	@Override
	public void move(double tx, double ty) {
		p.setX(p.getX() + tx);
		p.setY(p.getY() + ty);
	}

	@Override
	public void rotate(double alpha) {
		//useless
	}

	@Override
	public void scale(double sx, double sy) {
		p.setX(p.getX() * sx);
		p.setY(p.getY() * sy);
		r = r * (Math.abs(sx+sy) / 2);
	}

	private double r;
	public Circle(Point p, double r) {
		this.p = new Point(p);
		this.r = r;
	}


	@Override
	public double perimeter() {
		return 2 * Math.PI * r;
	}

	@Override
	public double area() {
		return Math.PI * r * r;
	}

	@Override
	public Transformable rotate2(double alpha) {
		Circle ret = new Circle(this.p,this.r);
		ret.rotate(alpha);
		return ret;
	}

	@Override
	public Transformable move2(double tx, double ty) {
		Circle ret = new Circle(this.p,this.r);
		ret.move(tx,ty);
		return ret;
	}

	@Override
	public Transformable scale2(double sx, double sy) {
		Circle ret = new Circle(this.p,this.r);
		ret.scale(sx,sy);
		return ret;
	}
}
