package com.ls.wechat.util;

import java.io.IOException;
import java.io.OutputStream;

public class StreamUtils {

    public static void writeToStream(OutputStream outputStream, String text) throws IOException {
        writeToStream(outputStream, text, "UTF-8");
    }

    public static void writeToStream(OutputStream outputStream, String text, String charset) throws IOException {
        outputStream.write(text.getBytes(charset));
    }
}
