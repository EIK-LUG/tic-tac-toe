package ee.itcollege.lug.geometry.shapes.space.abstract_classes;

/**
 * This class describes a single coordinate. For example the x coordinate.
 */
public abstract class Coordinate {

    protected static enum axisNames {X, Y, Z}
    protected axisNames axis;
    public double value;

    /**
     * Constructor method.
     */
    public Coordinate(axisNames axisName, double value) {
        this.axis = axisName;
        this.value = value;
    }

}
