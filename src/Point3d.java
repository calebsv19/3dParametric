public class Point3d {
    private double x, y, z, t;

    public Point3d(){
        this(0,0,0, 0);
    }

    public Point3d(int x, int y, int z, double t){
        this.x = 1.0 * x;
        this.y = 1.0 * y;
        this.z = 1.0 * z;
        this.t = t;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public double getZ(){
        return z;
    }

    public double getT(){
        return t;
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    public void setZ(double z){
        this.z = z;
    }

    public void setT(double t){
        this.t = t;
    }
}
