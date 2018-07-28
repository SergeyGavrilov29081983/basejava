import java.io.File;

public class MainFile {

    public static void main(String[] args) {
        /*String filePath = ".\\.gitignore";

        File file = new File(filePath);
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }

        File dir = new File("C:\\Users\\Sergey\\basejava");
        System.out.println(dir.isDirectory());
        String[] list = dir.list();
        if (list != null) {
            for (String name : list) {
                System.out.println(name);
            }
        }

        try (FileInputStream fis = new FileInputStream(filePath)) {
            System.out.println(fis.read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        String path = "C:\\Users\\Sergey\\basejava";
        showProjectTree(new File(path));

    }

    private static void showProjectTree(File file) {
        if (!file.isDirectory()) {
            System.out.println(file.getName());
        }
        if (file.isDirectory()) {
            try {
                File[] files = file.listFiles();
                assert files != null;
                for (File file1 : files) {
                    showProjectTree(file1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
