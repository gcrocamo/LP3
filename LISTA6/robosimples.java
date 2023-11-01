package tempo;

public class RoboSimples {
    private String roboName;
    private int currentX, currentY;
    private String currentDirection;
    private static RoboSimples[] roboList = new RoboSimples[0];

    public RoboSimples(String name, int x, int y, String direction) {
        validateRobo(name, x, y, direction);
        roboName = name;
        currentX = x;
        currentY = y;
        currentDirection = direction;
        roboList = addToList();
    }

    public RoboSimples(String name) {
        this(name, 0, 0, "N");
    }

    public RoboSimples() {
        this("Wally");
    }

    private RoboSimples[] addToList() {
        int count = 0;

        for (int i = 0; i < roboList.length; i++) {
            count++;
        }

        RoboSimples[] list = new RoboSimples[count + 1];
        for (int i = 0; i < count; i++) {
            list[i] = roboList[i];
        }

        list[count] = this;

        return list;
    }

    private boolean isPositionOccupied(int x, int y) {
        for (RoboSimples robo : roboList) {
            if ((robo.currentX == x) && (robo.currentY == y)) {
                System.out.printf("Unable to move robo %s: Position (%d, %d) already occupied by robo %s!!!\n", this.roboName, x, y, robo.roboName);
                return true;
            }
        }
        return false;
    }

    private boolean validateRobo(String name, int x, int y, String newDirection) {
        if (validateName(name) && !isPositionOccupied(x, y) && validateDirection(newDirection))
            return true;
        return false;
    }

    private boolean validateName(String name) {
        if (name == null || name.isEmpty() || name.isBlank())
            throw new IllegalArgumentException("Invalid name");
        return true;
    }

    private boolean validateDirection(String direction) {
        switch (direction) {
            case "N":
            case "NL":
            case "L":
            case "SL":
            case "S":
            case "SO":
            case "O":
            case "NO":
                return true;

            default:
                throw new IllegalArgumentException("Invalid direction");
        }
    }

    public void move() {
        this.move(1);
    }

    public void move(int steps) {
        switch (currentDirection) {
            case "N":
                if (!isPositionOccupied(currentX, currentY + steps))
                    currentY += steps;
                break;

            case "L":
                if (!isPositionOccupied(currentX + steps, currentY))
                    currentX += steps;
                break;

            case "S":
                if (!isPositionOccupied(currentX, currentY - steps))
                    currentY -= steps;
                break;

            case "O":
                if (!isPositionOccupied(currentX - steps, currentY))
                    currentX -= steps;
                break;

            case "NL":
                if (!isPositionOccupied(currentX + steps, currentY + steps)) {
                    currentY += steps;
                    currentX += steps;
                }
                break;

            case "NO":
                if (!isPositionOccupied(currentX - steps, currentY + steps)) {
                    currentY += steps;
                    currentX -= steps;
                }
                break;

            case "SL":
                if (!isPositionOccupied(currentX + steps, currentY - steps)) {
                    currentY -= steps;
                    currentX += steps;
                }
                break;

            case "SO":
                if (!isPositionOccupied(currentX - steps, currentY - steps)) {
                    currentY -= steps;
                    currentX -= steps;
                }
                break;
        }
    }

    public void changeDirection(String newDirection) {
        currentDirection = newDirection;
    }

    public String toString() {
        String str = "\nRobo Name: " + roboName + "\n";
        str = str + "Robo Position: (" + currentX + ", " + currentY + ")\n";
        str = str + "Robo Direction: " + currentDirection;

        return str;
    }
}
