import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.FileVisitor;
import java.nio.file.FileVisitResult;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

public class FileOrg {
    public static void main(String[] args) throws IOException {

        Path start = Paths.get("/Users/sophistikaty/Downloads/");
        Files.walkFileTree(start, new FileVisitor<Path>() {
//            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                    throws IOException
            {
                System.out.println("visited file");
                System.out.println(file);
//                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }

//            @Override
            public FileVisitResult visitFileFailed(Path file, IOException e)
                    throws IOException
            {
                System.out.println("failed file visit");
                System.out.println(file);
//                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }
//            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException e)
                    throws IOException
            {
                if (e == null) {
                    System.out.println("visited directory");
                    System.out.println(dir);
//                    Files.delete(dir);
                    return FileVisitResult.CONTINUE;
                } else {
                    // directory iteration failed
                    throw e;
                }
            }
//            @Override
            public FileVisitResult preVisitDirectory(Path dir, IOException e)
                    throws IOException
            {
                if (e == null) {
                    System.out.println("about to visit directory");
                    System.out.println(dir);
//                    Files.delete(dir);
                    return FileVisitResult.CONTINUE;
                } else {
                    // directory iteration failed
                    throw e;
                }
            }
        });

//        Scanner input = new Scanner(System.in);
//
//        System.out.println("Enter path to scan");
//
//        // create Path object based on user input
//        Path path = Paths.get(input.nextLine());
//        FileVisitor visitor = FileVisitor(path);
//
//        if (Files.exists(path)) {
//            Files.walkFileTree(path, visitor);
//            // display file (or directory) information
//            System.out.printf("%n%s exists%n", path.getFileName());
//            System.out.printf("%s a directory%n",
//                    Files.isDirectory(path) ? "Is" : "Is not");
//            System.out.printf("%s an absolute path%n",
//                    path.isAbsolute() ? "Is" : "Is not");
//            System.out.printf("Last modified: %s%n",
//                    Files.getLastModifiedTime(path));
//            System.out.printf("Size: %s%n", Files.size(path));
//            System.out.printf("Path: %s%n", path);
//            System.out.printf("Absolute path: %s%n", path.toAbsolutePath());
//
//            if (Files.isDirectory(path)) // output directory listing
//            {
//                System.out.printf("%nDirectory contents:%n");
//
//                // object for iterating through a directory's contents
//                DirectoryStream<Path> directoryStream =
//                        Files.newDirectoryStream(path);
//
//                for (Path p : directoryStream)
//                    System.out.println(p);
//            }
//        }
//        else {
//            System.out.printf("%s does not exist%n", path);
//        }
    }

//    public static void myVisitor(){
//
//    }
}