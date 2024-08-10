package cn.javgo.javgo.design.decorator;

import java.io.IOException;

/**
 * Desc：输入流接口
 *
 * @author javgo
 * @date 2024-08-11
 */
public abstract class MyInputStream {

    // 默认实现
    public int read(byte b[]) throws IOException {
        return read(b, 0, b.length);
    }

    public int read(byte b[], int off, int len) throws IOException {
        // 实现略
        return 0;
    }

    public long skip(long n) throws IOException {
        // 实现略
        return 0;
    }

    public int available() throws IOException {
        return 0;
    }

    public void close() throws IOException {}

    public synchronized void mark(int readlimit) {}

    public synchronized void reset() throws IOException {
        throw new IOException("mark/reset not supported");
    }

    public boolean markSupported() {
        return false;
    }
}
