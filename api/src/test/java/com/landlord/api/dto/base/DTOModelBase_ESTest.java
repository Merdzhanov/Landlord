/*
 * This file was automatically generated by EvoSuite
 * Tue Nov 13 12:12:35 GMT 2018
 */

package com.landlord.api.dto.base;

import org.junit.Test;
import static org.junit.Assert.*;
import com.landlord.dto.base.DTOModelBase;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class DTOModelBase_ESTest extends DTOModelBase_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      DTOModelBase dTOModelBase0 = new DTOModelBase();
      assertEquals(0, dTOModelBase0.id);
  }
}
