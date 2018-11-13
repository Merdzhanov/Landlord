/*
 * This file was automatically generated by EvoSuite
 * Tue Nov 13 12:16:00 GMT 2018
 */

package com.landlord.api;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import com.landlord.ApiApplication;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.hibernate.boot.registry.selector.spi.StrategySelectionException;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class ApiApplication_ESTest extends ApiApplication_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      ApiApplication apiApplication0 = new ApiApplication();
      // Undeclared exception!
      try { 
        apiApplication0.sessionFactory();
        fail("Expecting exception: StrategySelectionException");
      
      } catch(StrategySelectionException e) {
         //
         // Default-resolver threw exception
         //
         verifyException("org.hibernate.boot.registry.selector.internal.StrategySelectorImpl", e);
      }
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      String[] stringArray0 = new String[0];
      // Undeclared exception!
      try { 
        ApiApplication.main(stringArray0);
        fail("Expecting exception: NoClassDefFoundError");
      
      } catch(NoClassDefFoundError e) {
         //
         // Could not initialize class org.springframework.boot.SpringApplication
         //
         verifyException("com.landlord.ApiApplication", e);
      }
  }
}
