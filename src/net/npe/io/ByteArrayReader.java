/**
 * ByteArrayReader.java
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

public class ByteArrayReader extends InputReader {
	
	/**
	 * constructor
	 * @param buffer byte array buffer
	 * @param offset offset in buffer
	 * @param endian default ByteOrderReader (LittleEndian or BigEndian)
	 */
	public ByteArrayReader(byte [] buffer, int offset, ByteOrderReader endian) {
		super(endian);
		this.buffer = buffer;
		position = offset;
		mark();
	}
	
	@Override
	public int read() {
		return buffer[position++] & 0xFF;
	}
	
	@Override
	public void mark() {
		marker = position;
	}
	
	@Override
	public void reset() {
		position = marker;
	}
	
	@Override
	public void skip(int numberOfBytes) {
		position += numberOfBytes;
	}
	
	private byte [] buffer;
	private int position;
	private int marker;
	
}
