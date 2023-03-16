
/**
 * Delta College - CST 283 - Klingler & Gaddis Text
 * This program shows how to use breadth first search based on a queue to do a
 * directory search.
 */
import java.io.File;
import java.util.*;

public class DirSearch 
{
    public static void main(String[] args) 
    {
        String initDir = new String("/Users/teklingl/");
        String filePath = search(initDir, "DirSearch.java");

        if (filePath == null) 
            System.out.println("Not found");
        else 
            System.out.println(filePath);
    }

    /**
     * This method searches a given directory and all its subdirectories looking
     * for specified file or subdirectory.
     *
     * @param initDir : the initial directory to search.
     * @param searchFileName : the name of the file or subdirectory to search
     * for.
     * @return the full path name of the searched for file or directory.
     */
    static String search(String initDir, String searchFileName) 
    {
        StringQueue directoriesToSearch = new StringQueue(5000);
        directoriesToSearch.enqueue(initDir);

        while (!directoriesToSearch.isEmpty()) 
        {
            // Get next directory to search
            File currDir = new File(directoriesToSearch.dequeue());
            System.out.println(currDir);

            // Get contents of current directory
            String[] dirContents = currDir.list();

            // Directory contents will be null if there is
            // a problem listing the directory contents
            if (dirContents != null) 
            {
                // Do the directory contents contain the desired file?
                if (Arrays.asList(dirContents).contains(searchFileName))
                {
                    System.out.println("\nFOUND:");
                    return currDir.getAbsolutePath();
                }

                // Desired file not in current directory
                // Add all the children of this directory to the queue
                // of directories to be searched
                File[] childDirectories = currDir.listFiles();
                for (File aFile : childDirectories) 
                    if (aFile.isDirectory()) 
                        directoriesToSearch.enqueue(aFile.toString());
            }
        }
        // No more directories left to search, so not found
        return null;
    }
}
