public class csvCleaner extends fileCleaner {
    // Extend fileCleaner so you can also remove ",,," lines
    public csvCleaner() {}

    public Boolean checkIfCommas(String line){
        System.out.println("Checking for commas: " + line);
        if (line.trim().startsWith(",,,")){
            System.out.println("Commas found!");
            return true;
        } else {
            return false;
        }
    }

    public Boolean checkIfComment(String line){
        System.out.println("Checking for comments.");
        if (line.trim().startsWith("#")){
            System.out.println("Comment found!");
            return true;
        } else {
            return false;
        }
    }
}
