package zadaniaDomowe.zad5;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CezarOutputStream extends FilterOutputStream {
    private final int shift;

    public CezarOutputStream(OutputStream out, int shift) {
        super(out);
        this.shift = shift;
    }

    @Override
    public void write(int b) throws IOException {
        out.write(encode((char) b));
    }

    private int encode(char c) {
        if (c >= 'A' && c <= 'Z') {
            return 'A' + (c - 'A' + shift) % 26;
        }
        if (c >= 'a' && c <= 'z') {
            return 'a' + (c - 'a' + shift) % 26;
        }
        return c;
    }
}
