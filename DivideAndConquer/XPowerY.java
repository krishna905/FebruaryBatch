package DivideAndConquer;

public class XPowerY {
    private float calculateXPowerY(float X, int Y) {
        if(Y == 0) {
            return 1;
        }
        else {
            float xPowerYBy2 = calculateXPowerY(X, Y / 2);
            if(Y % 2 == 0) {
                return (xPowerYBy2 * xPowerYBy2);
            }
            else {
                return (X * xPowerYBy2 * xPowerYBy2);
            }
        }
    }

    public static void main(String[] args) {
        XPowerY xPowerY = new XPowerY();

        float X = 1.5f;
        int Y = 3;
        double result;

        if(Y >= 0) {
            result = xPowerY.calculateXPowerY(X, Y);
        }
        else {
            result = xPowerY.calculateXPowerY(X, -Y);
            result = 1 / result;
        }

        System.out.println("Result: " + result);
    }
}
