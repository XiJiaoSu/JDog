package cn.wocding.jdog.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;

public class HttpOutputStream extends ServletOutputStream {

	protected final ByteArrayOutputStream out = new ByteArrayOutputStream();

	@Override
	public void write(int b) throws IOException {
		out.write(b);
	}

	public ByteArrayOutputStream getOut() {
		return out;
	}
}
