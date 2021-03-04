package mql.java.exam.util;

import java.util.Vector;

public class Helper {
	
	public static <T> T[] convertVectorToArray(Vector<T> vector) {
		return (T[])vector.toArray();
	}
}
