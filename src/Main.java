public class Main {

    public static void main(String[] args) {
        Triangle a = new Triangle(
                            new Point(),
                            new Point(8,7),
                            new Point(9,0)
                        );
        Triangle b = a;
        Triangle c = new Triangle(
                new Point(),
                new Point(8,7),
                new Point(9,0)
        );
        Triangle d = new Triangle(
                new Point(),
                new Point(8,7),
                new Point(9,1)
        );
        System.out.println("Area: " + a.area());
        System.out.println("Umfang: " + a.perimeter());
        System.out.println("equals(null): " + a.equals(null));
        System.out.println("equals(b=a): " + a.equals(b));
        System.out.println("equals(deepcopy): " + a.equals(c));
        System.out.println("equals(wrong): " + a.equals(d));
        System.out.println("Normale Ausgabe: " + a);
        System.out.println("Mittelpunkte Ausgame: " + a.midTriangle());
    }
}
