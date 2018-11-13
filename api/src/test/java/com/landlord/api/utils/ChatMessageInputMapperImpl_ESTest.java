/*
 * This file was automatically generated by EvoSuite
 * Tue Nov 13 11:14:05 GMT 2018
 */

package com.landlord.api.utils;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import static org.mockito.Mockito.mock;

import com.landlord.dto.ChatMessageInputDTO;
import com.landlord.models.ChatMessage;
import com.landlord.services.base.LandlordService;
import com.landlord.utils.ChatMessageInputMapperImpl;
import java.util.List;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class ChatMessageInputMapperImpl_ESTest extends ChatMessageInputMapperImpl_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      LandlordService<ChatMessage> landlordService0 = (LandlordService<ChatMessage>) mock(LandlordService.class, new ViolatedAssumptionAnswer());
      ChatMessageInputMapperImpl chatMessageInputMapperImpl0 = new ChatMessageInputMapperImpl(landlordService0);
      // Undeclared exception!
      try { 
        chatMessageInputMapperImpl0.map((ChatMessageInputDTO) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("com.landlord.utils.ChatMessageInputMapperImpl", e);
      }
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      ChatMessageInputMapperImpl chatMessageInputMapperImpl0 = new ChatMessageInputMapperImpl((LandlordService) null);
      List<ChatMessageInputDTO> list0 = chatMessageInputMapperImpl0.mapMany((List<ChatMessage>) null);
      assertNull(list0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      ChatMessageInputMapperImpl chatMessageInputMapperImpl0 = new ChatMessageInputMapperImpl((LandlordService) null);
      List<ChatMessage> list0 = chatMessageInputMapperImpl0.mapManyToModel((List<ChatMessageInputDTO>) null);
      assertNull(list0);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      ChatMessageInputMapperImpl chatMessageInputMapperImpl0 = new ChatMessageInputMapperImpl((LandlordService) null);
      ChatMessageInputDTO chatMessageInputDTO0 = chatMessageInputMapperImpl0.map((ChatMessage) null);
      assertNull(chatMessageInputDTO0);
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      LandlordService<ChatMessage> landlordService0 = (LandlordService<ChatMessage>) mock(LandlordService.class, new ViolatedAssumptionAnswer());
      ChatMessageInputMapperImpl chatMessageInputMapperImpl0 = new ChatMessageInputMapperImpl(landlordService0);
      ChatMessageInputDTO chatMessageInputDTO0 = mock(ChatMessageInputDTO.class, new ViolatedAssumptionAnswer());
      // Undeclared exception!
      try { 
        chatMessageInputMapperImpl0.map(chatMessageInputDTO0);
        fail("Expecting exception: NumberFormatException");
      
      } catch(NumberFormatException e) {
         //
         // null
         //
         verifyException("java.lang.Integer", e);
      }
  }
}
