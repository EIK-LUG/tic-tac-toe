package ee.itcollege.lug.geometry.shapes.space;

import ee.itcollege.lug.geometry.shapes.space.abstract_classes.Coordinate;
import ee.itcollege.lug.geometry.shapes.space.abstract_classes.Point;
import ee.itcollege.lug.geometry.shapes.space.points.OneDimensionalPoint;
import ee.itcollege.lug.geometry.shapes.space.points.ThreeDimensionalPoint;
import ee.itcollege.lug.geometry.shapes.space.points.TwoDimensionalPoint;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * This class is a wrapper class for Point objects.
 */
public class Location extends Point {

    Point representation;

    /**
     * Constructor method.
     * {@inheritDoc}
     *
     * @param coordinates
     */
    public Location(Coordinate[] coordinates) {
        super(coordinates);

        if (coordinates.length == 1) {
            this.representation = new OneDimensionalPoint(coordinates);
        } else if (coordinates.length == 2) {
            this.representation = new TwoDimensionalPoint(coordinates);
        } else if (coordinates.length == 3) {
            this.representation = new ThreeDimensionalPoint(coordinates);
        } else {
            throw new NotImplementedException();
        }
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
        return 0;
    }
}
