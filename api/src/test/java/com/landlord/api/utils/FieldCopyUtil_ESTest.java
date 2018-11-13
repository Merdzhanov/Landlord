/*
 * This file was automatically generated by EvoSuite
 * Tue Nov 13 12:08:53 GMT 2018
 */

package com.landlord.api.utils;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import com.landlord.utils.FieldCopyUtil;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class FieldCopyUtil_ESTest extends FieldCopyUtil_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      FieldCopyUtil.setFields("TYT>]o:", "");
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      FieldCopyUtil fieldCopyUtil0 = new FieldCopyUtil();
      FieldCopyUtil.setFields("TYT>]o:", fieldCopyUtil0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      // Undeclared exception!
      try { 
        FieldCopyUtil.setFields((Object) null, "");
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("com.landlord.utils.FieldCopyUtil", e);
      }
  }
}