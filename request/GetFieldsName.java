package request;
import java.lang.reflect.*;
import java.util.Arrays;

public class GetFieldsName {
	
	
	public static void main(String args[]){

	Class<Request> req= Request.class;
	Field[] fields = req.getFields();
	Field field = null;
	for (Field oneField : fields) {
	// get public field name

	try {
	field = req.getField(oneField.getName());
	String fieldname = field.getName();

	System.out.println(fieldname);
	} catch (NoSuchFieldException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	} 
	}
	
	}
	
}


