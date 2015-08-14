/**
 * StreamReader.java
 * 
 * Copyright (c) 2015 Kenji Sasaki
 * Released under the MIT license.
 * https://github.com/npedotnet/npe-base/blob/master/LICENSE
 * 
 * This file is a part of npe-base.
 * https://github.com/npedotnet/npe-base
 *
 * For more details, see npe-base wiki.
 * https://github.com/npedotnet/npe-base/wiki
 * 
 */

package net.npe.io;

import java.io.IOException;
import java.io.InputStream;

public class StreamReader extends InputReader {
	
	public StreamReader(InputStream stream, ByteOrderReader endian) {
		super(endian);
		this.stream = stream;
	}
	
	@Override
	public int read() throws IOException {
		return stream.read();
	}
	
	@Override
	public void mark() {
		stream.mark(0);
	}
	
	@Override
	public void reset() throws IOException {
		stream.reset();
	}
	
	@Override
	public void skip(int numberOfBytes) throws IOException {
		stream.skip(numberOfBytes);
	}
	
	private InputStream stream;

}
