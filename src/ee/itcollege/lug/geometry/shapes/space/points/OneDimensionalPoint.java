package ee.itcollege.lug.geometry.shapes.space.points;

import ee.itcollege.lug.geometry.shapes.space.abstract_classes.Coordinate;
import ee.itcollege.lug.geometry.shapes.space.abstract_classes.Point;

public class OneDimensionalPoint extends Point {

    /**
     * Constructor method.
     * {@inheritDoc}
     */
    public OneDimensionalPoint(Coordinate[] coordinates) {
        super(coordinates);
    }

    /**
     * Constructor method.
     * Overloads constructor, allows creating a instance from a single coordinate.
     */
    public OneDimensionalPoint(Coordinate coordinate) {
        super(new Coordinate[]{coordinate});
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
            return Math.abs(this.coordinates[0].value - otherPoint.coordinates[0].value);
        } else {
            throw new ClassCastException("Points must be of same type!" + this.getClass());
        }
    }


}
