package ee.itcollege.lug.geometry.shapes.space.interfaces;

import ee.itcollege.lug.geometry.exceptions.ShapeNotInSpaceException;
import ee.itcollege.lug.geometry.shapes.abstract_classes.GeometricalShape;
import ee.itcollege.lug.geometry.shapes.space.abstract_classes.Point;

public interface Space {

    /**
     * For checking if a location is in this space.
     *
     * @param location A location.
     * @return Is this location in this space.
     */
    public boolean isInThisSpace(Point location);

    /**
     * For checking if this location is currently not occupied.
     *
     * @param location A location.
     * @return Is this location free in this space.
     */
    public boolean isLocationFree(Point location);

    /**
     * Place shape in this space in the specified location.
     *
     * @param shape A shape to be places inside this space.
     * @param location A location in this space.
     */
    public void putIn(GeometricalShape shape, Point location);

    /**
     * Remove a Geometrical Space from this space.
     *
     * @param shape A shape that is located in this space.
     */
    public GeometricalShape removeFrom(GeometricalShape shape) throws ShapeNotInSpaceException;

    /**
     * For checking if any more free locations in this Space.
     *
     * @return If this Space has any free locations left.
     */
    public boolean hasFreeLocation();
}