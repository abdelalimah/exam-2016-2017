package util;

import java.util.Vector;

public class Helper {
	
	public static <T> T[] convertArrayToVector(Vector<T> vector) {
		return (T[]) vector.toArray();
	};

}
