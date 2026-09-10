package testing;

import jakarta.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
		
		Persistence.createEntityManagerFactory("jpa_hibernate_exericise2"); //MariaDB
//		Persistence.createEntityManagerFactory("MSSQL"); //MSSQL
		
	}
}
