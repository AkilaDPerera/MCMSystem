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
	
	public static boolean usernameValidation(String name){
		name = name.trim();
		if (name.matches("[A-Za-z]+") && name.length()<50){
			return true;
		}else{
			return false;
		}
	}

	public static boolean dobValidation(String dob){
		if (dob!=null){
			return true;
		}else{
			return false;
		}
	}
	
	
	public static boolean optionalNameValidation(String name){
		name = name.trim();
		if (name.matches("[A-Za-z ]*") && name.length()<50){
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
	
	public static boolean optionalPhoneValidation(String phone){
		phone = phone.trim();
		if (phone.matches("^0[0-9]{9}") || phone.matches("^\\+94[0-9]{9}") || phone.matches("[0-9]{9}") || phone.matches("")){
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
	
	public static boolean idValidation(String id){
		id = id.trim();
		if (id.matches("[0-9]+")){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean isTime(String time){
		time = time.trim();
		if (time.matches("[0-1][0-9]:[0-6][0-9]")||time.matches("2[0-3]:[0-5][0-9]")){
			return true;
		}else{
			return false;
		}
	}
	
	
//	public static void main(String [] args){
//		System.out.println(isTime("100:30"));
//	}

}
