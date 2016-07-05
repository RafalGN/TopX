/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core.model.comparator;

import core.model.Review;
import java.util.Comparator;

/**
 *
 * @author Rogerio
 */
public class ReviewImportanceComparator implements Comparator<Review>{

    @Override
    public int compare(Review o1, Review o2) {
        if (o1.getImportancia() < o2.getImportancia()) {
            return -1;
        }
        if (o1.getImportancia() > o2.getImportancia()) {
            return 1;
        }
        return 0;
    }
}
