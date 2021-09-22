import java.awt.*;
import java.util.*;

public class Handler {
    private Point3d[] points;

    public static final int WIDTH = 600, X_DROP = 120, Y_DROP = 120, X_START = 300, Y_START = 50;

    public Handler(int width, int height, int num){
        points = new Point3d[num];
        for (int i = 0; i < num; i++){
            points[i] = new Point3d(0,0,0, (9 * Math.PI / num) * i);
        }
    }

    public void tick(){
        for (Point3d point : points){
            point.setT(point.getT() + (.11));
            point.setX(- Math.sin(point.getT()));
            point.setY(Math.cos(point.getT() / 12));
            point.setZ(Math.cos(point.getT()));
        }
    }


    public void render(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, 1920, 1080);
        g.setColor(Color.WHITE);
        g.drawRect(X_START, Y_START, WIDTH, WIDTH);
        g.drawLine(X_START, Y_START + WIDTH, X_START - X_DROP, Y_START + Y_DROP + WIDTH);
        g.drawLine(X_START + WIDTH, Y_START + WIDTH, X_START + WIDTH - X_DROP, Y_START + Y_DROP + WIDTH);


        for (Point3d point : points){
            g.setColor(Color.LIGHT_GRAY);
            int x = (int) ((point.getX() + 1) / 2 * WIDTH) + (X_START);
            int y = (int) ((point.getY() + 1) / 2 * WIDTH) + (Y_START);

            double z =  (point.getZ() + 1) / 2;

            x -= (z * (X_DROP + 10));
            y += z * (Y_DROP - 20);
            g.fillOval(x, y,  (int) (10 * z) + 10, (int) (10 * z) + 10);
        }

        g.setColor(Color.WHITE);
        g.drawRect(X_START - X_DROP, Y_START + Y_DROP, WIDTH, WIDTH);
        g.drawLine(X_START, Y_START, X_START - X_DROP, Y_START + Y_DROP);
        g.drawLine(X_START + WIDTH, Y_START, X_START + WIDTH - X_DROP, Y_START + Y_DROP);



    }
}