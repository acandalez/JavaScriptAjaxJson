package modelo.persistencia.querys;

public class SQL {
	
	public static final String  GETLISTDEPARTMENTS = "SELECT * FROM DEPARTMENTS";
	public static final String GETLISTEMPLOYEES = "SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID LIKE (SELECT DEPARTMENT_ID FROM DEPARTMENTS WHERE DEPARTMENT_NAME LIKE ";

}
