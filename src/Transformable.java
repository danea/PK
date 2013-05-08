/**
 * Created with IntelliJ IDEA.
 * User: Christopher
 * Date: 08.05.13
 * Time: 16:54
 * To change this template use File | Settings | File Templates.
 */
public interface Transformable {
	public Transformable rotate2(double alpha);
	public Transformable move2(double tx, double ty);
	public Transformable scale2(double sx, double sy);
}
