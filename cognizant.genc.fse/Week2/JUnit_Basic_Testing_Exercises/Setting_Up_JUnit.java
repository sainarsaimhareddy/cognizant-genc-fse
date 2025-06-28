package JUnit_Basic_Testing_Exercises;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
class mainjava{
	public mainjava get_instance() {
		return new mainjava();
	}
	public int testaddition(int a,int b) {
		return a+b;
	}
	public Integer square(int input) {
		return input*input;
		// TODO Auto-generated method stub
//		return null;
	}
}
public class Setting_Up_JUnit {
   private mainjava object=new mainjava();
   @Test
   public void addition() {
	   int a=5,b=12;
	   assertEquals(17,object.testaddition(a, b),"good");
   }
   @Test
   public void checknull() {
	   assertNotNull(object.get_instance());
   }
   @ParameterizedTest
   @ValueSource(ints = {1, 2, 3, 4, 5})
   public void square(int input) {
       int expected = input * input; // Calculate expected value
       assertEquals(expected+1, object.square(input));
   }
   
  
}
