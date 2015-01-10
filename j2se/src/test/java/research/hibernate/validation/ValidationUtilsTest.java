package research.hibernate.validation;

import java.util.Date;

import junit.framework.Assert;
import junit.framework.TestCase;
import research.hibernate.validation.extend.ExtendEntity;
import research.hibernate.validation.simple.SimpleEntity;

public class ValidationUtilsTest extends TestCase{

  public void validateSimpleEntity() {
	  SimpleEntity se = new SimpleEntity();
	  se.setDate(new Date());
	  se.setEmail("123");
	  se.setName("123");
	  se.setPassword("123");
	  se.setValid(false);
	  ValidationResult result = ValidationUtils.validateEntity(se);
	  System.out.println("--------------------------");
	  System.out.println(result);
	  Assert.assertTrue(result.isHasErrors());
  }
  
  public void validateSimpleProperty() {
	  SimpleEntity se = new SimpleEntity();
	  ValidationResult result = ValidationUtils.validateProperty(se,"name");
	  System.out.println("--------------------------");
	  System.out.println(result);
	  Assert.assertTrue(result.isHasErrors());
  }
  
  public void validateExtendEntity() {
	  ExtendEntity ee = new ExtendEntity();
	  ee.setPassword("212");
	  ValidationResult result = ValidationUtils.validateEntity(ee);
	  System.out.println("--------------------------");
	  System.out.println(result);
	  Assert.assertTrue(result.isHasErrors());
  }
}
