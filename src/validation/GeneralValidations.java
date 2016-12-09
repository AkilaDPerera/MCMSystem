package validation;

public class GeneralValidations {
	
	public static boolean nameValidation(String name){
		name = name.trim();
		if (name.matches("[A-Za-z ]+") && name.length()<50){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean addressValidation(String address){
		address = address.trim();
		if (address.matches("[0-9A-Za-z ,/.]+") && address.length()<255){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean phoneValidation(String phone){
		phone = phone.trim();
		if (phone.matches("^0[0-9]{9}") || phone.matches("^\\+94[0-9]{9}") || phone.matches("[0-9]{9}")){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean emailValidation(String email){
		email = email.trim();
		if (email.matches("[A-Za-z0-9.]+@{1}[A-Za-z0-9.]+\\.[a-z]+")){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean salaryValidation(String salary){
		salary = salary.trim();
		if (salary.matches("[0-9]+\\.[0-9]{2}") || salary.matches("[0-9]+")){
			return true;
		}else{
			return false;
		}
	}
	
	
	public static void main(String [] args){
		System.out.println(salaryValidation(""));
	}

}
