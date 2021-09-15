import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/*
 * https://progcont.hu/progcont/100047/?pid=478
 */
public class RectanglesCirclesAndTriangles {

    @FunctionalInterface
    interface Collidable {
        boolean doesCollide(double x, double y);
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            List<Collidable> collidables = parseShapes(br);
            collideWithPoints(br, collidables);
        } catch (Exception e) {

        }
    }

    private static List<Collidable> parseShapes(BufferedReader br) throws IOException {
        List<Collidable> collidables = new ArrayList<>();
        String[] tokens;
        while (true) {
            tokens = br.readLine().split(" ");
            if (tokens[0].equals("*")) {
                return collidables;
            }
            collidables.add(shapeOf(tokens));
        }
    }

    private static Collidable shapeOf(String[] tokens) {
        switch (tokens[0].charAt(0)) {
            case 'r': return rectangleOf(
                    Double.parseDouble(tokens[1]),
                    Double.parseDouble(tokens[2]),
                    Double.parseDouble(tokens[3]),
                    Double.parseDouble(tokens[4]));
            case 't': return triangleOf(
                    Double.parseDouble(tokens[1]),
                    Double.parseDouble(tokens[2]),
                    Double.parseDouble(tokens[3]),
                    Double.parseDouble(tokens[4]),
                    Double.parseDouble(tokens[5]),
                    Double.parseDouble(tokens[6]));
            default: return circleOf(
                    Double.parseDouble(tokens[1]),
                    Double.parseDouble(tokens[2]),
                    Double.parseDouble(tokens[3]));
        }

    }

    private static Collidable rectangleOf(double topX, double topY, double bottomX, double bottomY) {
        return (x,y) -> topX < x && topY > y && bottomX > x && bottomY < y;
    }

    private static Collidable circleOf(double centerX, double centerY, double radius) {
        double radiusSq = radius * radius;
        return (x,y) -> {
            double dx = x - centerX;
            double dy = y - centerY;
            return dx * dx + dy * dy < radiusSq;
        };
    }

    private static Collidable triangleOf(double x0, double y0, double x1, double y1, double x2, double y2) {
        double y0y1 = y0 - y1;
        double x0x1 = x0 - x1;
        double y1y2 = y1 - y2;
        double x1x2 = x1 - x2;
        double y2y0 = y2 - y0;
        double x2x0 = x2 - x0;
        return (x,y) -> {
            double d1 = (x - x1) * y0y1 - x0x1 * (y - y1);
            double d2 = (x - x2) * y1y2 - x1x2 * (y - y2);
            double d3 = (x - x0) * y2y0 - x2x0 * (y - y0);
            return !(((d1 < 0) || (d2 < 0) || (d3 < 0)) && ((d1 > 0) || (d2 > 0) || (d3 > 0)));
        };
    }

    private static void collideWithPoints(BufferedReader br, List<Collidable> collidables) throws IOException {
        String[] tokens;
        tokens = br.readLine().split(" ");
        double lastX;
        double lastY;
        double x = Double.parseDouble(tokens[0]);
        double y = Double.parseDouble(tokens[1]);
        for (int pointIdx = 1;;pointIdx++) {
            lastX = x;
            lastY = y;
            tokens = br.readLine().split(" ");
            x = Double.parseDouble(tokens[0]);
            y = Double.parseDouble(tokens[1]);
            StringJoiner sj = new StringJoiner(System.lineSeparator());
            sj.setEmptyValue(String.format("Point " + pointIdx + " is not contained in any figure"));
            for (int figIdx = 0; figIdx < collidables.size(); figIdx++) {
                if (collidables.get(figIdx).doesCollide(lastX,lastY)) {
                    sj.add(String.format("Point %d is contained in figure %d", pointIdx, figIdx + 1));
                }
            }
            System.out.println(sj);
        }
    }
}
