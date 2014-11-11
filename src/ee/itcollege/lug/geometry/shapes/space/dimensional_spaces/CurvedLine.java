package ee.itcollege.lug.geometry.shapes.space.dimensional_spaces;

import ee.itcollege.lug.geometry.shapes.space.points.OneDimensionalPoint;
import ee.itcollege.lug.geometry.shapes.space.utility.curvature.CurvatureInformation;

public class CurvedLine extends OneDimensionalSpace {

    /**
     * Constructor method.
     *
     * @param length        Size of one dimensional space.
     * @param startingPoint The point where the one dimensional space start extending from.
     */
    public CurvedLine(int length, OneDimensionalPoint startingPoint, CurvatureInformation curveInfo) {
        super(length, startingPoint);
        curveInfo.apply(this);
    }

}
