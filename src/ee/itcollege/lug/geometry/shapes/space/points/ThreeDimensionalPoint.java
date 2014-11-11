package ee.itcollege.lug.geometry.shapes.space.points;

import ee.itcollege.lug.geometry.shapes.space.abstract_classes.Coordinate;
import ee.itcollege.lug.geometry.shapes.space.abstract_classes.Point;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class ThreeDimensionalPoint extends Point {

    /**
     * Constructor method.
     * {@inheritDoc}
     *
     * @param coordinates
     */
    public ThreeDimensionalPoint(Coordinate[] coordinates) {
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
        //ToDo
        throw new NotImplementedException();
    }
}
