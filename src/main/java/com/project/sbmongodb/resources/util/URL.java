package com.project.sbmongodb.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {

	/* URLDecoder serve para decodificar parametro
	 * de URL
	 *  
	 */
	public static String decodeURL(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
}
