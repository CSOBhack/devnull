package cz.csob.hackathon.devnull;

public class Configurer {

	public static void config() {
		String host = "ninja.cesal.cz";
		String port = "80";
		String dbname = "hackathon";
		String username = "hackathon";
		String password = "Hacknow1";

		String addSettings = "useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&autoReconnect=true";
		String jdbcUrl = "jdbc:log4jdbc:mysql://" + host + ":" + port + "/" + dbname + "?" + addSettings;
		System.setProperty("spring.datasource.url", jdbcUrl);
		System.setProperty("spring.datasource.username", username);
		System.setProperty("spring.datasource.password", password);
		System.out.println("Database connection URL is " + System.getProperty("spring.datasource.url"));
		System.out.println("Database username is " + System.getProperty("spring.datasource.username"));
	}

}
