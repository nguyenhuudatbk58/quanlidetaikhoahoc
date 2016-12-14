package quanlidetaikhoahoc;

public interface ApplicationProperty {

	// Database
	public static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/quanlidetaikhoahoc?characterEncoding=UTF-8";
	public static final String DB_USERNAME = "root";
	public static final String DB_PASSWORD = "aiemdat";

	// hibernate

	public static final String HB_DIALECT = "org.hibernate.dialect.MySQL5InnoDBDialect";
	public static final String HB_SHOW_SQL = "true";
	public static final String HB_CONNECTION_CHARSET = "utf-8";
	public static final String HB_CONNECTION_CHARACTER_ENCODING = "utf-8";
	public static final String HB_CONNECTION_USE_UNICODE = "true";
	public static final String HB_FORMAT_SQL = "true";
	public static final String HB_USE_SQL_COMMENT = "true";
	public static final String HB_PACKAGE_TO_SCAN = "quanlidetaikhoahoc.domain";
}
