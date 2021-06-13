package utility;

import java.io.File;

import javax.swing.filechooser.FileFilter;

// Only accepts jpg, jpeg and png (gif doesn't count >.>)
public class ImageFileFilter extends FileFilter {

    private static final String[] ACCEPTED_EXTENSIONS = { "jpg", "jpeg", "png" };

    @Override
    public boolean accept(File f) {
        String extension = getFileExtensionFromName(f.getName());

        for (String acceptedExtension : ACCEPTED_EXTENSIONS) {
            if (extension.equals(acceptedExtension)) {
                return true;
            }
        }
        
        return false;
    }

    @Override
    public String getDescription() {
        return null;
    }

    private String getFileExtensionFromName(String name) {
        String extension = "";

        int i = name.lastIndexOf('.');
        if (i > 0) {
            extension = name.substring(i + 1);
        }
        return extension;
    }
}
