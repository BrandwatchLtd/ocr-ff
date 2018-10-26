import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;

public class Main {
    public static void main(String[] args) {
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("/Users/jamess/brandwatch/tessdata");
        File directory = new File("/Users/jamess/Downloads");
        File[] files = directory.listFiles();
        for (File file : files) {
            try {
                String contentType = Files.probeContentType(FileSystems.getDefault().getPath(file.getAbsolutePath()));
                if (contentType != null && contentType.startsWith("image")) {
                    try {
                        String ocrResult = tesseract.doOCR(file);
                        System.out.println(ocrResult);
                    } catch (TesseractException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
