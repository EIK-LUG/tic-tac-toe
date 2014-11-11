package ee.itcollege.lug.geometry.shapes.space.abstract_classes;

/**
 * This class describes a point in space. For example (0, 0) or (0, 1, 2).
 */
public abstract class Point {

    public Coordinate[] coordinates;
    int numberOfCoordinates;

    /**
     * Constructor method.
     * {@inheritDoc}
     */
    public Point(Coordinate[] coordinates) {
        this.coordinates = coordinates;
        numberOfCoordinates = this.coordinates.length;
    }

    /**
     * Checks if points are of the same type.
     * Having the same amount of dimensions means they can be represented in the same space.
     *
     * {@inheritDoc}
     * @return If the two points are of the same type.
     */
    public boolean isOfSameType(Point otherPoint) {
        return (this.numberOfCoordinates == otherPoint.numberOfCoordinates);
    }

    /**
     * Calculates distance from other point.
     *
     * The other point has to be of the same type. For example distance cannot be calculate between
     * a two dimensional point and a Three dimensional point.
     *
     * {@inheritDoc}
     * @param otherPoint A point to calculate distance from.
     * @return  The distance between the two points.
     */
    abstract public double distanceFromOtherPoint(Point otherPoint);

}
