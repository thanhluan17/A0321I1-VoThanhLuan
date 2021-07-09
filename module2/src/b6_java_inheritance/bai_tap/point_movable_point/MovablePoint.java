package b6_java_inheritance.bai_tap.point_movable_point;

public class MovablePoint extends Point {
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;

    public MovablePoint() {
    }

    public MovablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
        float[] array;
        array = new float[]{xSpeed, ySpeed};
        return array;
    }

    @Override
    public String toString() {
        return "MovablePoint{" + "x=" + getX() + ", y=" + getY() + ", xSpeed=" + xSpeed + ", ySpeed=" + ySpeed + '}';
    }

    public MovablePoint move() {
        super.setXY(getX() + xSpeed, getY() + xSpeed);
        return this;
    }
}
