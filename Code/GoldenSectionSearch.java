

public class GoldenSectionSearch {

    private double phi = (Math.sqrt(5) - 1) /2;
    
    private double f(double x) {
        return 0;
    }
    public double max(double a, double b, double epsilon) {
        double xR = a;
        double xL = b;
        while(Math.abs(xR-xL) > epsilon) {
            double d = (xR-xL) * this.phi;
            double x1 = xL + d;
            double x2 = xR - d;
            if(f(x2) > f(x1)) {
                xR = x1;
            } else {
                xL = x2;
            }
        }
        return xR;
    }
    
    public double min(double a, double b, double epsilon) {
        double xR = a;
        double xL = b;
        while(Math.abs(xR-xL) > epsilon) {
            double d = (xR-xL) * this.phi;
            double x1 = xL + d;
            double x2 = xR - d;
            if(f(x2) < f(x1)) {
                xR = x1;
            } else {
                xL = x2;
            }
        }
        return xR;
    }
}
