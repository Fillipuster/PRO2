package Opgave04;

import java.io.File;

public class DirectoryScanning {

    public static void listDir(String path) {
        scanDir(path, 0);
    }

    public static void scanDir(String path, int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("\t");
        }

        System.out.print("[DIR] " + path + "\n");
        File file = new File(path);
        String[] names = file.list();
        for (String name : names) {
            String newPath = path + "/" + name;
            if ((new File(newPath)).isDirectory()) {
                scanDir(newPath, depth + 1);
            }
        }
    }

    public static void main(String[] args) {
        listDir("C:\\M.E.S.S");
    }

}
