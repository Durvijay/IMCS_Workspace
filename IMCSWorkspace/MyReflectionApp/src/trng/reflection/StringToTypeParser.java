package trng.reflection;

import java.util.HashMap;
import java.util.Map;


public class StringToTypeParser {

	  /** Primitive type name -> class map. */
	  private static final Map<String, Class<?>> PRIMITIVE_NAME_TYPE_MAP = new HashMap<String, Class<?>>();

	  /** Setup the primitives map. */
	  static {
	    PRIMITIVE_NAME_TYPE_MAP.put("boolean", Boolean.TYPE);
	    PRIMITIVE_NAME_TYPE_MAP.put("Boolean", Boolean.TYPE);
	    PRIMITIVE_NAME_TYPE_MAP.put("byte", Byte.TYPE);
	    PRIMITIVE_NAME_TYPE_MAP.put("Byte", Byte.TYPE);
	    PRIMITIVE_NAME_TYPE_MAP.put("char", Character.TYPE);
	    PRIMITIVE_NAME_TYPE_MAP.put("Charecter", Character.TYPE);
	    PRIMITIVE_NAME_TYPE_MAP.put("short", Short.TYPE);
	    PRIMITIVE_NAME_TYPE_MAP.put("Short", Short.TYPE);
	    PRIMITIVE_NAME_TYPE_MAP.put("int", Integer.TYPE);
	    PRIMITIVE_NAME_TYPE_MAP.put("Integer", Integer.TYPE);
	    PRIMITIVE_NAME_TYPE_MAP.put("long", Long.TYPE);
	    PRIMITIVE_NAME_TYPE_MAP.put("Long", Long.TYPE);
	    PRIMITIVE_NAME_TYPE_MAP.put("float", Float.TYPE);
	    PRIMITIVE_NAME_TYPE_MAP.put("Float", Float.TYPE);
	    PRIMITIVE_NAME_TYPE_MAP.put("double", Double.TYPE);
	    PRIMITIVE_NAME_TYPE_MAP.put("Double", Double.TYPE);
	    PRIMITIVE_NAME_TYPE_MAP.put("String", String.class);
	  }
	
	public static Object toObject( Class<?> clazz, String value ) { 
	    if( Boolean.class.isAssignableFrom( clazz ) ) return Boolean.parseBoolean( value );
	    if( Byte.class.isAssignableFrom( clazz ) ) return Byte.parseByte( value );
	    if( Short.class.isAssignableFrom( clazz ) ) return Short.parseShort( value );
	    if( Integer.class.isAssignableFrom( clazz ) ) return Integer.parseInt( value );
	    if( Long.class.isAssignableFrom( clazz ) ) return Long.parseLong( value );
	    if( Float.class.isAssignableFrom( clazz ) ) return Float.parseFloat( value );
	    if( Double.class.isAssignableFrom( clazz ) ) return Double.parseDouble( value );
	    
	    return value;
	}
	
	public static Class<?> toType( String typeString ) {
		return PRIMITIVE_NAME_TYPE_MAP.get(typeString);
	}
}
