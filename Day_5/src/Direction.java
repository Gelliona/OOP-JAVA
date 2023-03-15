public enum Direction {

    TOP, RIGHT, BOTTOM, LEFT;

    public String dir;

       public static Direction fromString(String dir) {
        
        if (dir != null) {
            Direction[] values = values();
            for (Direction value : values()) {
                if (dir.equalsIgnoreCase(value.name())) {
                    return value;
                }
            }
        }
        throw new IllegalArgumentException("Нет такого значения направления");
    }
}


