import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fileCleaner {
    /**
     * Super (abstract) class which is base for our file cleaners
     * We will build this up so that our sub classes inherit these main classes
     *     - Including a base overridden toString & Override at least one in sub
     *     - Will overload a method too
     *
     * Expects a string (or list of strings) to clean
     * Returns the string(s) without the offending problems
     *
     * ^ Note not a file - but the List of strings themselves (or just a string)
     */

    public fileCleaner() {}

    protected Boolean checkIfBlankLine(String line) {
        if (line.trim().isBlank()) {
            return true;
        } else {
            return false;
        }
    }

    protected Boolean checkIfComment(String line) {
        if (line.trim().startsWith("//")) {
            return true;
        } else {
            return false;
        }
    }

}
