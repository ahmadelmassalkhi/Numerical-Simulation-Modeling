

public class IntegralApproximation {

    
    private double f(double x) {
        return 0;
    }

    public double left(double a, double b, int n) {
        if(n == 1) return (b-a) * f(a);
        double h = (b-a) / n;
        double x = a;
        double sum = 0;
        while(x < b) {
            sum += h * f(x);
            x += h;
        }
        return sum;
    }

    public double right(double a, double b, int n) {
        if(n == 1) return (b-a) * f(b);
        double h = (b-a) / n;
        double x = a+h;
        double sum = 0;
        while(x <= b) {
            sum += h * f(x);
            x += h;
        }
        return sum;
    }

    public double min(double a, double b) {
        return (a < b) ? a : b;
    }
    public double min(double a, double b, int n) {
        if(n == 1) return (b-a) * min(f(a), f(b));
        double h = (b-a) / n;
        double x = a;
        double sum = 0;
        while(x < b) {
            sum += h * min(f(x), f(x+h));
            x += h;
        }
        return sum;
    }

    public double max(double a, double b) {
        return (a > b) ? a : b;
    }
    public double max(double a, double b, int n) {
        if(n == 1) return (b-a) * max(f(a), f(b));
        double h = (b-a) / n;
        double x = a;
        double sum = 0;
        while(x < b) {
            sum += h * max(f(x), f(x+h));
            x += h;
        }
        return sum;
    }

    public double midpoint(double a, double b) {
        return (a+b)/2.0;
    }
    public double midpoint(double a, double b, int n) {
        if(n == 1) return (b-a) * f(midpoint(a, b));
        double h = (b-a) / n;
        double x = a;
        double sum = 0;
        while(x < b) {
            sum += h * f(midpoint(x, x+h));
            x += h;
        }
        return sum;
    }

    public double trapezoid(double a, double b, int n) {
        if(n == 1) return (b-a) * (f(a) + f(b)) / 2;
        double h = (b-a) / n;
        double x = a;
        double sum = 0;
        while(x < b) {
            sum += h * (f(x) + f(x+h)) / 2;
            x += h;
        }
        return sum;
    }

    public double random(double start, double end) {
        return (end - start) * Math.random() + start;
    }
    public double MonteCarloBasic(double a, double b, double ymin, double ymax, int n) {
        int Ninside = 0;
        int i = 0;
        while(i<n) {
            double randomX = random(a, b);
            double randomY = random(ymin, ymax);
            if(randomY<f(randomX) && randomY>=0) Ninside++;                
            if(randomY>f(randomX) && randomY<=0) Ninside++;
            i++;
        }
        return (Ninside / (double)n) * (b-a) * (ymax - ymin);
    }

    public double MonteCarloEnhanced(double a, double b, double ymin, double ymax, int n) {
        int i = 0;
        double sum = 0;
        while(i<n) {
            double randomX = random(a, b);
            sum += f(randomX);
            i++;
        }
        return (b-a) * sum / n;
    }

}