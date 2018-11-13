/*
 * This file was automatically generated by EvoSuite
 * Tue Nov 13 12:10:51 GMT 2018
 */

package com.landlord.api.utils;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import com.landlord.dto.UserDTO;
import com.landlord.models.User;
import com.landlord.models.base.UserType;
import com.landlord.utils.UserMapperImpl;
import java.util.List;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class UserMapperImpl_ESTest extends UserMapperImpl_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      UserMapperImpl userMapperImpl0 = new UserMapperImpl();
      UserType userType0 = UserType.LANDLORD;
      User user0 = mock(User.class, new ViolatedAssumptionAnswer());
      doReturn("EO6`$cs4g.y").when(user0).getFirstName();
      doReturn(0).when(user0).getId();
      doReturn("[s@M=uf").when(user0).getLastName();
      doReturn(920.6761F).when(user0).getRating();
      doReturn("EO6`$cs4g.y").when(user0).getUserName();
      doReturn(userType0).when(user0).getUserType();
      UserDTO userDTO0 = userMapperImpl0.map(user0);
      User user1 = userMapperImpl0.map(userDTO0);
      assertEquals(920.6761F, user1.getRating(), 0.01F);
      assertEquals(0, user1.id);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      UserMapperImpl userMapperImpl0 = new UserMapperImpl();
      UserType userType0 = UserType.LANDLORD;
      User user0 = mock(User.class, new ViolatedAssumptionAnswer());
      doReturn("W[Yz /$Q1>AhK").when(user0).getFirstName();
      doReturn(1).when(user0).getId();
      doReturn("com.landlord.utils.UserMapperImpl").when(user0).getLastName();
      doReturn(0.0F).when(user0).getRating();
      doReturn("com.landlord.utils.UserMapperImpl").when(user0).getUserName();
      doReturn(userType0).when(user0).getUserType();
      UserDTO userDTO0 = userMapperImpl0.map(user0);
      User user1 = userMapperImpl0.map(userDTO0);
      assertEquals(0.0F, user1.getRating(), 0.01F);
      assertEquals(1, user1.id);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      UserMapperImpl userMapperImpl0 = new UserMapperImpl();
      UserType userType0 = UserType.LANDLORD;
      User user0 = mock(User.class, new ViolatedAssumptionAnswer());
      doReturn("Wz+r}Uv[").when(user0).getFirstName();
      doReturn((-272)).when(user0).getId();
      doReturn("Wz+r}Uv[").when(user0).getLastName();
      doReturn((float)(-272)).when(user0).getRating();
      doReturn("").when(user0).getUserName();
      doReturn(userType0).when(user0).getUserType();
      UserDTO userDTO0 = userMapperImpl0.map(user0);
      User user1 = userMapperImpl0.map(userDTO0);
      assertEquals((-272.0F), user1.getRating(), 0.01F);
      assertEquals((-272), user1.id);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      UserMapperImpl userMapperImpl0 = new UserMapperImpl();
      // Undeclared exception!
      try { 
        userMapperImpl0.map((User) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("com.landlord.utils.UserMapperImpl", e);
      }
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      UserMapperImpl userMapperImpl0 = new UserMapperImpl();
      // Undeclared exception!
      try { 
        userMapperImpl0.map((UserDTO) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("com.landlord.utils.UserMapperImpl", e);
      }
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      UserMapperImpl userMapperImpl0 = new UserMapperImpl();
      // Undeclared exception!
      try { 
        userMapperImpl0.mapMany((List<User>) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("com.landlord.utils.UserMapperImpl", e);
      }
  }

  @Test(timeout = 4000)
  public void test6()  throws Throwable  {
      UserMapperImpl userMapperImpl0 = new UserMapperImpl();
      // Undeclared exception!
      try { 
        userMapperImpl0.mapManyToModel((List<UserDTO>) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("com.landlord.utils.UserMapperImpl", e);
      }
  }
}
