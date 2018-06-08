package framgia.com.text;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class TextInFile implements IText {
    private final File file;

    public TextInFile(File file) {
        this.file = file;
    }

    @Override
    public List<String> read() {
        try (Stream<String> stream = Files.lines(Paths.get(file.getPath()),  Charset.forName("UTF-8"))) {
            return stream.collect(toList());

        } catch (IOException ioe) {
            ioe.printStackTrace();
            throw new IllegalArgumentException("Can not read the file");
        }
    }
}
