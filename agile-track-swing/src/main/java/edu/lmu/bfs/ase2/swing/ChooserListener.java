package edu.lmu.bfs.ase2.swing;
/**
 * Classes that implement interface ChooserListener can be told of the
 * selection made by the user of a DeptChooser or a CourseChooser.
 * The interface has just one method.
 * @Author X9
 * @Date: 10/10/2010
 */

public interface ChooserListener
{
    /**
     * Accepts the object corresponding to the user's selection
     * @param  o    the object corresponding to the user's selection
     */
    void tell(Object o);
}
