package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import java.io.IOException;

/* loaded from: classes2.dex */
public class DefaultIndenter extends DefaultPrettyPrinter.NopIndenter {
    public static final DefaultIndenter SYSTEM_LINEFEED_INSTANCE;
    public static final String SYS_LF;
    private final int charsPerLevel;
    private final String eol;
    private final char[] indents;

    static {
        String str;
        try {
            str = System.getProperty("line.separator");
        } catch (Throwable unused) {
            str = "\n";
        }
        SYS_LF = str;
        SYSTEM_LINEFEED_INSTANCE = new DefaultIndenter("  ", str);
    }

    public DefaultIndenter(String str, String str2) {
        this.charsPerLevel = str.length();
        this.indents = new char[str.length() * 16];
        int i2 = 0;
        for (int i3 = 0; i3 < 16; i3++) {
            str.getChars(0, str.length(), this.indents, i2);
            i2 += str.length();
        }
        this.eol = str2;
    }

    @Override // com.fasterxml.jackson.core.util.DefaultPrettyPrinter.NopIndenter, com.fasterxml.jackson.core.util.DefaultPrettyPrinter.Indenter
    public boolean isInline() {
        return false;
    }

    @Override // com.fasterxml.jackson.core.util.DefaultPrettyPrinter.NopIndenter, com.fasterxml.jackson.core.util.DefaultPrettyPrinter.Indenter
    public void writeIndentation(JsonGenerator jsonGenerator, int i2) throws IOException {
        jsonGenerator.writeRaw(this.eol);
        if (i2 <= 0) {
            return;
        }
        int i3 = i2 * this.charsPerLevel;
        while (true) {
            char[] cArr = this.indents;
            if (i3 > cArr.length) {
                jsonGenerator.writeRaw(cArr, 0, cArr.length);
                i3 -= this.indents.length;
            } else {
                jsonGenerator.writeRaw(cArr, 0, i3);
                return;
            }
        }
    }
}
