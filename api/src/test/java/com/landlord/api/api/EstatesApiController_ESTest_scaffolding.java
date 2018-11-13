/**
 * Scaffolding file used to store all the setups needed to run 
 * tests automatically generated by EvoSuite
 * Tue Nov 13 12:20:41 GMT 2018
 */

package com.landlord.api.api;

import org.evosuite.runtime.annotation.EvoSuiteClassExclude;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.evosuite.runtime.sandbox.Sandbox;
import org.evosuite.runtime.sandbox.Sandbox.SandboxMode;

import static org.mockito.Mockito.mock;

@EvoSuiteClassExclude
public class EstatesApiController_ESTest_scaffolding {

  @org.junit.Rule 
  public org.evosuite.runtime.vnet.NonFunctionalRequirementRule nfr = new org.evosuite.runtime.vnet.NonFunctionalRequirementRule();

  private static final java.util.Properties defaultProperties = (java.util.Properties) System.getProperties().clone();

  private org.evosuite.runtime.thread.ThreadStopper threadStopper =  new org.evosuite.runtime.thread.ThreadStopper (org.evosuite.runtime.thread.KillSwitchHandler.getInstance(), 3000);


  @BeforeClass 
  public static void initEvoSuiteFramework() { 
    org.evosuite.runtime.RuntimeSettings.className = "com.landlord.api.EstatesApiController"; 
    org.evosuite.runtime.GuiSupport.initialize(); 
    org.evosuite.runtime.RuntimeSettings.maxNumberOfThreads = 100; 
    org.evosuite.runtime.RuntimeSettings.maxNumberOfIterationsPerLoop = 10000; 
    org.evosuite.runtime.RuntimeSettings.mockSystemIn = true; 
    org.evosuite.runtime.RuntimeSettings.sandboxMode = SandboxMode.RECOMMENDED;
    Sandbox.initializeSecurityManagerForSUT();
    org.evosuite.runtime.classhandling.JDKClassResetter.init();
    setSystemProperties();
    initializeClasses();
    org.evosuite.runtime.Runtime.getInstance().resetRuntime(); 
    try { initMocksToAvoidTimeoutsInTheTests(); } catch(ClassNotFoundException e) {} 
  } 

  @AfterClass 
  public static void clearEvoSuiteFramework(){ 
    Sandbox.resetDefaultSecurityManager(); 
    System.setProperties((java.util.Properties) defaultProperties.clone());
  } 

  @Before 
  public void initTestCase(){ 
    threadStopper.storeCurrentThreads();
    threadStopper.startRecordingTime();
    org.evosuite.runtime.jvm.ShutdownHookHandler.getInstance().initHandler(); 
    Sandbox.goingToExecuteSUTCode();
    setSystemProperties(); 
    org.evosuite.runtime.GuiSupport.setHeadless(); 
    org.evosuite.runtime.Runtime.getInstance().resetRuntime(); 
    org.evosuite.runtime.agent.InstrumentingAgent.activate(); 
  } 

  @After 
  public void doneWithTestCase(){ 
    threadStopper.killAndJoinClientThreads();
    org.evosuite.runtime.jvm.ShutdownHookHandler.getInstance().safeExecuteAddedHooks(); 
    org.evosuite.runtime.classhandling.JDKClassResetter.reset(); 
    resetClasses(); 
    Sandbox.doneWithExecutingSUTCode();
    org.evosuite.runtime.agent.InstrumentingAgent.deactivate(); 
    org.evosuite.runtime.GuiSupport.restoreHeadlessMode(); 
  } 

  public static void setSystemProperties() {
 
    System.setProperties((java.util.Properties) defaultProperties.clone());
    System.setProperty("file.encoding", "Cp1252");
    System.setProperty("java.awt.headless", "true");
    System.setProperty("java.io.tmpdir", "C:\\Users\\rumy\\AppData\\Local\\Temp\\");
    System.setProperty("user.country", "US");
    System.setProperty("user.dir", "D:\\TelerikAlfaAcademy\\FinalProject\\Landlord-RefactorSpring-11.13\\Landlord\\api\\src\\main");
    System.setProperty("user.home", "C:\\Users\\rumy");
    System.setProperty("user.language", "en");
    System.setProperty("user.name", "rumy");
    System.setProperty("user.timezone", "Europe/Helsinki");
  }

  private static void initializeClasses() {
    org.evosuite.runtime.classhandling.ClassStateSupport.initializeClasses(EstatesApiController_ESTest_scaffolding.class.getClassLoader() ,
      "org.springframework.core.Ordered",
      "org.springframework.boot.autoconfigure.AutoConfigurationPackage",
      "com.landlord.models.base.ModelBase",
      "org.springframework.context.annotation.DeferredImportSelector",
      "com.landlord.utils.UserMapperImpl",
      "org.springframework.beans.factory.annotation.Autowired",
      "org.springframework.web.bind.annotation.RequestMapping",
      "org.springframework.beans.factory.Aware",
      "org.springframework.stereotype.Controller",
      "com.landlord.dto.EstateDTO",
      "org.springframework.beans.factory.BeanFactoryAware",
      "com.landlord.dto.base.DTOModelBase",
      "org.springframework.stereotype.Indexed",
      "org.springframework.context.annotation.ImportSelector",
      "com.landlord.utils.ChatMessageMapperImpl",
      "org.springframework.boot.autoconfigure.AutoConfigurationImportSelector",
      "com.landlord.models.ChatMessage",
      "com.landlord.models.Estate",
      "org.springframework.boot.autoconfigure.EnableAutoConfiguration",
      "com.landlord.models.User",
      "org.springframework.context.ResourceLoaderAware",
      "org.springframework.web.bind.annotation.RequestMethod",
      "org.springframework.context.annotation.Import",
      "org.springframework.web.bind.annotation.ResponseBody",
      "org.springframework.web.bind.annotation.RestController",
      "com.landlord.utils.base.DTOMapper",
      "com.landlord.services.base.EstateService",
      "org.springframework.stereotype.Component",
      "org.springframework.context.EnvironmentAware",
      "org.springframework.beans.factory.BeanClassLoaderAware",
      "com.landlord.api.EstatesApiController",
      "com.landlord.utils.EstateMapperImpl",
      "org.springframework.web.bind.annotation.Mapping"
    );
  } 
  private static void initMocksToAvoidTimeoutsInTheTests() throws ClassNotFoundException { 
    mock(Class.forName("com.landlord.models.Estate", false, EstatesApiController_ESTest_scaffolding.class.getClassLoader()));
    mock(Class.forName("com.landlord.services.base.EstateService", false, EstatesApiController_ESTest_scaffolding.class.getClassLoader()));
    mock(Class.forName("com.landlord.utils.EstateMapperImpl", false, EstatesApiController_ESTest_scaffolding.class.getClassLoader()));
  }

  private static void resetClasses() {
    org.evosuite.runtime.classhandling.ClassResetter.getInstance().setClassLoader(EstatesApiController_ESTest_scaffolding.class.getClassLoader()); 

    org.evosuite.runtime.classhandling.ClassStateSupport.resetClasses(
      "com.landlord.api.EstatesApiController",
      "org.springframework.web.bind.annotation.RequestMethod",
      "com.landlord.utils.EstateMapperImpl",
      "com.landlord.models.Estate",
      "com.landlord.dto.base.DTOModelBase",
      "com.landlord.dto.EstateDTO"
    );
  }
}