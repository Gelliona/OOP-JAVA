public interface Robot {
    public void move(int step);
    public void changeDirection(Direction direction);

    public long getId();

    public Point getPoint();


}
