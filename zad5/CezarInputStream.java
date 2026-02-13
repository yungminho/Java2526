package zadaniaDomowe.zad5;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CezarInputStream extends FilterInputStream {
    private final int shift;

    public CezarInputStream(InputStream in, int shift) {
        super(in);
        this.shift = shift;
    }

    @Override
    public int read() throws IOException {
        int b = in.read();
        if (b == -1) return -1;
        return decode((char) b);
    }

    private int decode(char c) {
        if (c >= 'A'&& c <= 'Z') {
            return 'A' + (c - 'A' - shift + 26) % 26;
        } else if (c >= 'a'&& c <= 'z') {
            return 'a' + (c - 'a' - shift + 26) % 26;
        }
        return c;
    }
}
