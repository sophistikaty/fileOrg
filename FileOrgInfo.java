import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.attribute.FileTime;

public class FileOrgInfo {

    private Path fileName;
    private boolean isDirectory;
    private boolean isHidden;
    private FileTime lastModifiedTime;
    private Path path;

    FileOrgInfo(Path filePath){
        setFileName(filePath);
        setIsDirectory(filePath);
        setIsHidden(filePath);
        setLastModifiedTime(filePath);
        setPath(filePath);
    }

    public void printFileInfo () {
        System.out.printf("%n%s %s %s ", fileName, getFileType(), lastModifiedTime);
    }

    public Path getFileName(){
        return fileName;
    }

    public String getFileType(){
       String fileType;

        if (isDirectory){
            fileType = "Directory";
        }
        else {
            fileType = "File";
        }

        if (isHidden){
            fileType = fileType + " (hidden)";
        }
        return fileType;
    }

    public FileTime getLastModifiedTime(){
        return lastModifiedTime;
    }

    public Path getPath(){
        return path;
    }

    public void setFileName(Path filePath){
        fileName = filePath.getFileName();
    }

    public void setIsDirectory(Path filePath){
        isDirectory = Files.isDirectory(filePath);
    }

    public void setIsHidden(Path filePath){
        try {
            isHidden = Files.isHidden(filePath);
        }
            catch (IOException e){
            System.err.printf("%nException: %s%n", e);
        }
    }

    public void setLastModifiedTime(Path filePath){
        try {
            lastModifiedTime = Files.getLastModifiedTime (filePath);
        }
        catch (IOException e){
            System.err.printf("%nException: %s%n", e);
        }
    }

    public void setPath(Path filePath){
        path = filePath;
    }
}