package cn.javgo.javgo.design.decorator;

import java.io.*;

/**
 * Desc：IO 示例
 *
 * @author javgo
 * @date 2024-08-11
 */
public class IODemo {

    public static void main(String[] args) throws IOException {
        InputStream in = new FileInputStream("/user/javgo/test.txt");
        InputStream bin = new BufferedInputStream(in);

        byte[] data = new byte[128];
        while (bin.read(data) != -1) {
            // do something
        }
    }
}
