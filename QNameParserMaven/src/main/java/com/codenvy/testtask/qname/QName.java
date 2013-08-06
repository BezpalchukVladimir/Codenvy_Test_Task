package com.codenvy.testtask.qname;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Codenvy. Test task
 * 
 * QName Parser
 * 
 * @author Vladimir Bezpalchuk
 * 
 * @version 1.0 03 Aug 2013.
 */

public class QName {

	/**
     * Regular expressions partly for full name  
     */ 
	private static final Pattern NAME_PATTERN = Pattern
			.compile("(([^ /:\\[\\]*'\"|](?:[^/:\\[\\]*'\"|]*[^ /:\\[\\]*'\"|])?):)?"
					  + "([^ /:\\[\\]*'\"|](?:[^/:\\[\\]*'\"|]*[^ /:\\[\\]*'\"|])?)");
	
	/**
     * Regular expressions for prefix names  
     */ 
	private static final String PREFIX_REGEX = "[_:A-Za-z][-._:A-Za-z0-9]*";

	private final String prefix;
	private final String localName;

	/**
	 * Creates a new QName instance with the given prefix and localName
	 * 
	 * @param prefix 	   Prefix part of full name
	 * @param localName    Local name part of full name
	 * @throws IllegalNameException 
	 */
	public QName(String prefix, String localName) throws IllegalNameException {
		// an empty localName not valid 
		if (localName == null || localName.length() == 0) {
			throw new IllegalNameException("empty localName");
		}
		this.prefix = prefix;
		this.localName = localName;
	}

	/**
	 * Parse the string name and get QName instance
	 * 
	 * @param name - input string
	 * @return instance of QName
	 * @throws IllegalNameException
	 */
	public static QName parse(String name) throws IllegalNameException {
		if (name == null || name.length() == 0) {
			throw new IllegalNameException("empty name");
		}

		String prefixParam = null;
		String localNameParam = null;

		Matcher matcher = NAME_PATTERN.matcher(name);
		if (matcher.matches()) {
			// check for prefix (group 1)
			if (matcher.group(1) != null) {
				// prefix specified
				prefixParam = matcher.group(2);
				// check if the prefix is a valid XML prefix
				if (!(prefixParam.matches(PREFIX_REGEX))) {
					// illegal syntax for prefix
					throw new IllegalNameException("'" + name
							+ "' is not a valid name: illegal prefix");
				}
			} else {
				// no prefix specified
				prefixParam = "";
			}

			// group 3 is localName
			localNameParam = matcher.group(3);
			if (localNameParam.matches("\\.+")) {				
				throw new IllegalNameException("'" + name
						+ "' is not a valid name");
			}

		} else {
			// illegal syntax for name
			throw new IllegalNameException("'" + name + "' is not a valid name");
		}

		return new QName(prefixParam, localNameParam);
	}

	/**
	 * Returns full form of QName as '[prefix:]localName'
	 * 
	 * @return string of QName
	 */
	public String getAsString() {
		if (prefix.equals("")) {
			return getLocalName();
		} else {
			return getPrefix() + ":" + getLocalName();
		}
	}

	/**
	 * Method that returns local name part of full name.
	 * 
	 * @return Local name part of full name
	 */
	public String getLocalName() {
		return localName;
	}

	/**
	 * Method that returns the prefix.
	 * 
	 * @return Prefix of the full name
	 */
	public String getPrefix() {
		return prefix;
	}

}
