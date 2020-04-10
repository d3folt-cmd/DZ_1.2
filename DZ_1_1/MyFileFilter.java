package dz;

import java.io.File;
import java.io.FileFilter;

public class MyFileFilter implements FileFilter {
    private String type;

    public MyFileFilter(String type) {
        this.type = type;
    }

    private boolean check(String ext) { {
            if (type.equals(ext)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean accept(File pathname) {
        int index = pathname.getName().lastIndexOf(".");
        if (index == -1) {
            return false;
        }
        String ext = pathname.getName().substring(index + 1);
        return check(ext);
    }
}
