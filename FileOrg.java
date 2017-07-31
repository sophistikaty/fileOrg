import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.FileVisitResult;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

public class FileOrg {

    private int fileCount;
    private int directoryCount;

    FileOrg(){
        ScanFromPath();
    }

    public void ScanFromPath(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter path to scan");
        Path start = Paths.get(input.nextLine());

        CollectDirectoryInfo(start);
    }

    public void CollectDirectoryInfo(Path start){
        try{
            Files.walkFileTree(start, new SimpleFileVisitor<java.nio.file.Path>() {
                @Override
                public FileVisitResult visitFile(Path filePath, BasicFileAttributes attrs)
                        throws IOException
                {
                    FileOrgInfo fileToOrg = new FileOrgInfo(filePath);
                    fileCount++;
                    fileToOrg.printFileInfo();
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path filePath, IOException e)
                        throws IOException
                {
                    System.out.println("failed file visit");
                    System.out.println(filePath);
                    return FileVisitResult.CONTINUE;
                }
                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException e)
                        throws IOException
                {
                    if (e == null) {
                        FileOrgInfo fileToOrg = new FileOrgInfo(dir);
                        directoryCount++;
                        fileToOrg.printFileInfo();
                        return FileVisitResult.CONTINUE;
                    } else {
                        throw e;
                    }
                }
            });
        }
        catch (IOException e){
            System.err.printf("%nException: %s%n", e);
        }
        System.out.printf("Directory Count: %s%n", directoryCount);
        System.out.printf("File Count: %s%n", fileCount);

    }
}