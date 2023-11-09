public class Ponto2DUtil {
    public static float distance(Ponto2D P1, Ponto2D P2) {
        int x1 = P1.getX();
        int y1 = P1.getY();
        int x2 = P2.getX();
        int y2 = P2.getY();
        return (float) Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

    public static float distance(Ponto2D P) {
        return distance(P, new Ponto2D());
    }

    public static int quadrant(Ponto2D P) {
        int x = P.getX();
        int y = P.getY();

        if (x == 0 || y == 0) {
            return 0;
        } else if (x > 0 && y > 0) {
            return 1;
        } else if (x < 0 && y > 0) {
            return 2;
        } else if (x < 0 && y < 0) {
            return 3;
        } else {
            return 4;
        }
    }
}
