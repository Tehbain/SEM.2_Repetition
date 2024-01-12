import java.io.File;

public class ScanDirectory {
    public static void main(String[] args) {
        String path = "\\Users\\lhass\\IdeaProjects\\SEM.2_Repetition";
        scanDir(path);
    }


    public static void scanDir(String path) {
        File file = new File(path);

        String[] print = file.list();

        for (int i = 0; i < print.length; i++) {
            File current = new File(path + "\\" + print[i]);


            if (current.isDirectory()) {
                int lvl = 0;
                for (char c : (path + "\\" + print[i]).toCharArray()) {
                    if (c == '\\') lvl++;
                }
                System.out.print("(LEVEL) " + lvl + ": ");
                System.out.println(current);
                System.out.println();
                scanDir(path + "\\" + print[i]);
            }
        }
    }
}
