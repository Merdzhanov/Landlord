/*
 * This file was automatically generated by EvoSuite
 * Tue Nov 13 12:11:46 GMT 2018
 */

package com.landlord.api.dto;

import com.landlord.dto.ChatMessageDTO;
import com.landlord.dto.EstateDTO;
import com.landlord.dto.UserDTO;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class EstateDTO_ESTest extends EstateDTO_ESTest_scaffolding {

    @Mock
    private EstateDTO_ESTest_scaffolding javaUtilDate;

//    mock(Class.forName("java.util.Date",false, EstateDTO_ESTest_scaffolding.class.getClassLoader()));

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      EstateDTO estateDTO0 = new EstateDTO();
      EstateDTO estateDTO1 = new EstateDTO((String) null, estateDTO0.image, "", (BigDecimal) null, (BigDecimal) null, (Date) null);
      estateDTO0.setMessageList(estateDTO1.messageList);
      assertEquals(0, estateDTO1.getId());
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      EstateDTO estateDTO0 = new EstateDTO();
      EstateDTO estateDTO1 = new EstateDTO("S6fm", estateDTO0.image, "Ze", (BigDecimal) null, (BigDecimal) null, (Date) null);
      estateDTO0.setUsers(estateDTO1.users);
      assertEquals("Ze", estateDTO1.getAddress());
  }

//  @Test(timeout = 4000)
//  public void test02()  throws Throwable  {
//      BigDecimal bigDecimal0 = new BigDecimal((-1863L));
//      Date date0 = mock(Date.class, new ViolatedAssumptionAnswer());
//      EstateDTO estateDTO0 = new EstateDTO((String) null, (byte[]) null, (String) null, bigDecimal0, bigDecimal0, date0);
//      Date date1 = mock(Date.class, new ViolatedAssumptionAnswer());
//      estateDTO0.setDueDate(date1);
//      assertEquals(0, estateDTO0.id);
//  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      byte[] byteArray0 = new byte[1];
      BigDecimal bigDecimal0 = new BigDecimal((long) (byte)17);
      EstateDTO estateDTO0 = new EstateDTO("", byteArray0, "", bigDecimal0, bigDecimal0, (Date) null);
      estateDTO0.setDescription("ey&m-sJsk->Ib");
      assertEquals("ey&m-sJsk->Ib", estateDTO0.getDescription());
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      EstateDTO estateDTO0 = new EstateDTO();
      byte[] byteArray0 = new byte[7];
      estateDTO0.setImage(byteArray0);
      assertNull(estateDTO0.getImageUrl());
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      BigDecimal bigDecimal0 = new BigDecimal((-1863L));
      Date date0 = new Date();
      EstateDTO estateDTO0 = new EstateDTO((String) null, (byte[]) null, (String) null, bigDecimal0, bigDecimal0, date0);
      List<UserDTO> list0 = estateDTO0.getUsers();
      assertEquals(0, list0.size());
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      EstateDTO estateDTO0 = new EstateDTO();
      BigDecimal bigDecimal0 = new BigDecimal(0.0);
      estateDTO0.setOwedAmount(bigDecimal0);
      BigDecimal bigDecimal1 = estateDTO0.getOwedAmount();
      assertEquals((byte)0, bigDecimal1.byteValue());
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      byte[] byteArray0 = new byte[7];
      BigDecimal bigDecimal0 = new BigDecimal((double) (byte)55);
      EstateDTO estateDTO0 = new EstateDTO((String) null, byteArray0, (String) null, bigDecimal0, bigDecimal0, (Date) null);
      BigDecimal bigDecimal1 = estateDTO0.getOwedAmount();
      assertSame(bigDecimal0, bigDecimal1);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      BigDecimal bigDecimal0 = new BigDecimal((-1863L));
      Date date0 = new Date();
      EstateDTO estateDTO0 = new EstateDTO((String) null, (byte[]) null, (String) null, bigDecimal0, bigDecimal0, date0);
      BigDecimal bigDecimal1 = estateDTO0.getOwedAmount();
      assertSame(bigDecimal0, bigDecimal1);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      byte[] byteArray0 = new byte[9];
      BigDecimal bigDecimal0 = new BigDecimal((long) (byte) (-1));
      EstateDTO estateDTO0 = new EstateDTO("64", byteArray0, "com.landlord.dto.base.DTOModelBase", bigDecimal0, bigDecimal0, (Date) null);
      estateDTO0.name = "com.landlord.dto.base.DTOModelBase";
      String string0 = estateDTO0.getName();
      assertEquals("com.landlord.dto.base.DTOModelBase", string0);
      assertEquals("com.landlord.dto.base.DTOModelBase", estateDTO0.getAddress());
      assertNotNull(string0);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      byte[] byteArray0 = new byte[1];
      BigDecimal bigDecimal0 = new BigDecimal((long) (byte)17);
      EstateDTO estateDTO0 = new EstateDTO("", byteArray0, "", bigDecimal0, bigDecimal0, (Date) null);
      estateDTO0.setName("");
      String string0 = estateDTO0.getName();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      EstateDTO estateDTO0 = new EstateDTO();
      BigDecimal bigDecimal0 = estateDTO0.getMonthlyRent();
      assertNull(bigDecimal0);
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      byte[] byteArray0 = new byte[7];
      BigDecimal bigDecimal0 = new BigDecimal((double) (byte)55);
      EstateDTO estateDTO0 = new EstateDTO((String) null, byteArray0, (String) null, bigDecimal0, bigDecimal0, (Date) null);
      BigDecimal bigDecimal1 = estateDTO0.getMonthlyRent();
      assertSame(bigDecimal0, bigDecimal1);
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      EstateDTO estateDTO0 = new EstateDTO();
      BigDecimal bigDecimal0 = new BigDecimal(0);
      estateDTO0.setMonthlyRent(bigDecimal0);
      BigDecimal bigDecimal1 = estateDTO0.getMonthlyRent();
      assertEquals((short)0, bigDecimal1.shortValue());
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      EstateDTO estateDTO0 = new EstateDTO();
      BigDecimal bigDecimal0 = new BigDecimal((-1880));
      estateDTO0.monthlyRent = bigDecimal0;
      BigDecimal bigDecimal1 = estateDTO0.getMonthlyRent();
      assertSame(bigDecimal1, bigDecimal0);
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      EstateDTO estateDTO0 = new EstateDTO();
      List<ChatMessageDTO> list0 = estateDTO0.getMessageList();
      assertNull(list0);
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      EstateDTO estateDTO0 = new EstateDTO();
      estateDTO0.setImageUrl("C\bsJ7ygm9D%JlE");
      String string0 = estateDTO0.getImageUrl();
      assertEquals("C\bsJ7ygm9D%JlE", string0);
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      EstateDTO estateDTO0 = new EstateDTO();
      estateDTO0.setImageUrl("");
      String string0 = estateDTO0.getImageUrl();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      byte[] byteArray0 = new byte[7];
      BigDecimal bigDecimal0 = new BigDecimal((double) (byte)55);
      EstateDTO estateDTO0 = new EstateDTO((String) null, byteArray0, (String) null, bigDecimal0, bigDecimal0, (Date) null);
      byte[] byteArray1 = estateDTO0.getImage();
      assertEquals(7, byteArray1.length);
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      byte[] byteArray0 = new byte[0];
      EstateDTO estateDTO0 = new EstateDTO("", byteArray0, "", (BigDecimal) null, (BigDecimal) null, (Date) null);
      byte[] byteArray1 = estateDTO0.getImage();
      assertSame(byteArray1, byteArray0);
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      BigDecimal bigDecimal0 = new BigDecimal((-1863L));
      Date date0 = new Date();
      EstateDTO estateDTO0 = new EstateDTO((String) null, (byte[]) null, (String) null, bigDecimal0, bigDecimal0, date0);
      estateDTO0.setId(2029);
      int int0 = estateDTO0.getId();
      assertEquals(2029, estateDTO0.id);
      assertEquals(2029, int0);
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      EstateDTO estateDTO0 = new EstateDTO();
      estateDTO0.setId((-2010));
      int int0 = estateDTO0.getId();
      assertEquals((-2010), int0);
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      byte[] byteArray0 = new byte[7];
      BigDecimal bigDecimal0 = new BigDecimal((double) (byte)55);
      EstateDTO estateDTO0 = new EstateDTO((String) null, byteArray0, (String) null, bigDecimal0, bigDecimal0, (Date) null);
      Date date0 = estateDTO0.getDueDate();
      assertNull(date0);
  }

  @Test(timeout = 4000)
  public void test23()  throws Throwable  {
      byte[] byteArray0 = new byte[1];
      BigDecimal bigDecimal0 = new BigDecimal((long) (byte)0);
      EstateDTO estateDTO0 = new EstateDTO("", byteArray0, "$URfr01<`*3jg", bigDecimal0, bigDecimal0, (Date) null);
      assertEquals("", estateDTO0.getDescription());
      
      estateDTO0.description = "QdUT}f";
      String string0 = estateDTO0.getDescription();
      assertNotNull(string0);
      assertEquals("QdUT}f", string0);
  }

  @Test(timeout = 4000)
  public void test24()  throws Throwable  {
      byte[] byteArray0 = new byte[0];
      EstateDTO estateDTO0 = new EstateDTO("", byteArray0, "", (BigDecimal) null, (BigDecimal) null, (Date) null);
      String string0 = estateDTO0.getDescription();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      EstateDTO estateDTO0 = new EstateDTO();
      estateDTO0.setAddress("gdIj8y\"SY8=j**W*");
      String string0 = estateDTO0.getAddress();
      assertEquals("gdIj8y\"SY8=j**W*", string0);
  }

  @Test(timeout = 4000)
  public void test26()  throws Throwable  {
      byte[] byteArray0 = new byte[1];
      BigDecimal bigDecimal0 = new BigDecimal((long) (byte)17);
      EstateDTO estateDTO0 = new EstateDTO("", byteArray0, "", bigDecimal0, bigDecimal0, (Date) null);
      String string0 = estateDTO0.getAddress();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test27()  throws Throwable  {
      EstateDTO estateDTO0 = new EstateDTO();
      byte[] byteArray0 = estateDTO0.getImage();
      assertNull(byteArray0);
  }

  @Test(timeout = 4000)
  public void test28()  throws Throwable  {
      BigDecimal bigDecimal0 = new BigDecimal((-1017));
      Date date0 = new Date();
      EstateDTO estateDTO0 = new EstateDTO((String) null, (byte[]) null, (String) null, bigDecimal0, bigDecimal0, date0);
      String string0 = estateDTO0.getName();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test29()  throws Throwable  {
      BigDecimal bigDecimal0 = new BigDecimal((-1017));
      Date date0 = new Date();
      EstateDTO estateDTO0 = new EstateDTO((String) null, (byte[]) null, (String) null, bigDecimal0, bigDecimal0, date0);
      int int0 = estateDTO0.getId();
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test30()  throws Throwable  {
      BigDecimal bigDecimal0 = new BigDecimal((-1017));
      Date date0 = new Date();
      EstateDTO estateDTO0 = new EstateDTO((String) null, (byte[]) null, (String) null, bigDecimal0, bigDecimal0, date0);
      List<ChatMessageDTO> list0 = estateDTO0.getMessageList();
      assertTrue(list0.isEmpty());
  }

  @Test(timeout = 4000)
  public void test31()  throws Throwable  {
      EstateDTO estateDTO0 = new EstateDTO();
      List<UserDTO> list0 = estateDTO0.getUsers();
      assertNull(list0);
  }

  @Test(timeout = 4000)
  public void test32()  throws Throwable  {
      EstateDTO estateDTO0 = new EstateDTO();
      BigDecimal bigDecimal0 = estateDTO0.getOwedAmount();
      assertNull(bigDecimal0);
  }

  @Test(timeout = 4000)
  public void test33()  throws Throwable  {
      BigDecimal bigDecimal0 = new BigDecimal((-1017));
      Date date0 = new Date();
      EstateDTO estateDTO0 = new EstateDTO((String) null, (byte[]) null, (String) null, bigDecimal0, bigDecimal0, date0);
      String string0 = estateDTO0.getAddress();
      assertNull(string0);
  }

//  @Test(timeout = 4000)
//  public void test34()  throws Throwable  {
//      BigDecimal bigDecimal0 = new BigDecimal((-1017));
//      Date date0 = new Date();
//      doReturn("").when(date0).toString();
//      EstateDTO estateDTO0 = new EstateDTO((String) null, (byte[]) null, (String) null, bigDecimal0, bigDecimal0, date0);
//      Date date1 = estateDTO0.getDueDate();
//      assertSame(date1, date0);
//  }

  @Test(timeout = 4000)
  public void test35()  throws Throwable  {
      BigDecimal bigDecimal0 = new BigDecimal((-1017));
      Date date0 = new Date();
      EstateDTO estateDTO0 = new EstateDTO((String) null, (byte[]) null, (String) null, bigDecimal0, bigDecimal0, date0);
      String string0 = estateDTO0.getImageUrl();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test36()  throws Throwable  {
      BigDecimal bigDecimal0 = new BigDecimal((-1017));
      Date date0 = new Date();
      EstateDTO estateDTO0 = new EstateDTO((String) null, (byte[]) null, (String) null, bigDecimal0, bigDecimal0, date0);
      String string0 = estateDTO0.getDescription();
      assertNull(string0);
  }
}
