package ee.itcollege.lug.geometry.shapes.space.utility.curvature;

import ee.itcollege.lug.geometry.shapes.space.dimensional_spaces.OneDimensionalSpace;
import ee.itcollege.lug.geometry.shapes.space.dimensional_spaces.ThreeDimensionalSpace;
import ee.itcollege.lug.geometry.shapes.space.dimensional_spaces.TwoDimensionalSpace;
import ee.itcollege.lug.geometry.shapes.space.interfaces.Space;

/**
 * This class deals with applying curvature information to different Space objects.
 * Lets just say that the Constructor actually handles the representation of this information.
 */
public class CurvatureInformation {

    /**
     * Apply curvature information to a Space object.
     */
    public void apply(Space space) {
        if (space.getClass() == OneDimensionalSpace.class) {
            applyOneDimensional((OneDimensionalSpace)space);
        } else if (space.getClass() == TwoDimensionalSpace.class) {
            applyTwoDimensional((TwoDimensionalSpace)space);
        } else {
            applyThreeDimensional((ThreeDimensionalSpace)space);
        }
    }

    /**
     * Remove curvature information from a Space object.
     */
    public void remove(Space space) {
        if (space.getClass() == OneDimensionalSpace.class) {
            removeFromOneDimensional((OneDimensionalSpace)space);
        } else if (space.getClass() == TwoDimensionalSpace.class) {
            removeFromTwoDimensional((TwoDimensionalSpace)space);
        } else {
            removeFromThreeDimensional((ThreeDimensionalSpace)space);
        }
    }

    private void applyOneDimensional(OneDimensionalSpace space) {}

    private void applyTwoDimensional(TwoDimensionalSpace space) {}

    private void applyThreeDimensional(ThreeDimensionalSpace space) {}

    private void removeFromOneDimensional(OneDimensionalSpace space) {}

    private void removeFromTwoDimensional(TwoDimensionalSpace space) {}

    private void removeFromThreeDimensional(ThreeDimensionalSpace space) {}
}
