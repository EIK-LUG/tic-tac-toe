package ee.itcollege.lug.geometry.shapes.space.points;

import ee.itcollege.lug.geometry.shapes.space.abstract_classes.Coordinate;
import ee.itcollege.lug.geometry.shapes.space.abstract_classes.Point;

public class TwoDimensionalPoint extends Point {

    /**
     * Constructor method.
     * {@inheritDoc}
     *
     * @param coordinates
     */
    public TwoDimensionalPoint(Coordinate[] coordinates) {
        super(coordinates);
    }

    /**
     * Calculates distance from other point.
     * <p/>
     * The other point has to be of the same type. For example distance cannot be calculate between
     * a two dimensional point and a Three dimensional point.
     * <p/>
     * {@inheritDoc}
     *
     * @param otherPoint A point to calculate distance from.
     * @return The distance between the two points.
     */
    @Override
    public double distanceFromOtherPoint(Point otherPoint) {
        if (this.isOfSameType(otherPoint)) {
            return Math.sqrt(Math.pow(this.coordinates[0].value, 2) + Math.pow(this.coordinates[0].value, 2));
        } else {
            throw new ClassCastException("Points must be of same type!" + this.getClass());
        }

    }
}
