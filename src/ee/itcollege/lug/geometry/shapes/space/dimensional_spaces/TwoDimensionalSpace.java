package ee.itcollege.lug.geometry.shapes.space.dimensional_spaces;

import ee.itcollege.lug.geometry.exceptions.ShapeNotInSpaceException;
import ee.itcollege.lug.geometry.shapes.abstract_classes.GeometricalShape;
import ee.itcollege.lug.geometry.shapes.space.abstract_classes.Point;
import ee.itcollege.lug.geometry.shapes.space.interfaces.Space;
import ee.itcollege.lug.geometry.shapes.space.points.TwoDimensionalPoint;

import java.util.ArrayList;

public class TwoDimensionalSpace implements Space {

    private ArrayList<TwoDimensionalPoint> representation;

    /**
     *  Constructor method.
     */
    public TwoDimensionalSpace(ArrayList<TwoDimensionalPoint> twoDimensionalPoints) {
        int length = twoDimensionalPoints.size();
    }

    /**
     * For checking if a location is in this space.
     *
     * @param location A location.
     * @return Is this location in this space.
     */
    @Override
    public boolean isInThisSpace(Point location) {
        return false;
    }

    /**
     * For checking if this location is currently not occupied.
     *
     * @param location A location.
     * @return Is this location free in this space.
     */
    @Override
    public boolean isLocationFree(Point location) {
        return false;
    }

    /**
     * Place shape in this space in the specified location.
     *
     * @param shape    A shape to be places inside this space.
     * @param location A location in this space.
     */
    @Override
    public void putIn(GeometricalShape shape, Point location) {

    }

    /**
     * Remove a Geometrical Space from this space.
     *
     * @param shape A shape that is located in this space.
     */
    @Override
    public GeometricalShape removeFrom(GeometricalShape shape) throws ShapeNotInSpaceException {
        return null;
    }

    /**
     * For checking if any more free locations in this Space.
     *
     * @return If this Space has any free locations left.
     */
    @Override
    public boolean hasFreeLocation() {
        return false;
    }
}
