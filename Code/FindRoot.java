


public class FindRoot {

    private double f(double x) {
        return 0;
    }

    public double bisection_method(double a, double b, double epsilon) {
        if (f(a) * f(b) > 0) throw new IllegalArgumentException("There doesn't exist a root f(x)=0 where x inside [a,b]");
        if(f(a) == 0) return a;
        if(f(b) == 0) return b;

        // find root
        double xL = a;
        double xR = b;
        double mid = (xR + xL) / 2;;
        while(Math.abs(xL - xR) > epsilon) {
            mid = (xR + xL) / 2;
            if(f(xL) * f(mid) < 0) xR = mid;
            else xL = mid;
        }
        return mid;
    }
}