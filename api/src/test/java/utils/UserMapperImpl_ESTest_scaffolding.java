/**
 * Scaffolding file used to store all the setups needed to run 
 * tests automatically generated by EvoSuite
 * Tue Nov 13 10:48:28 GMT 2018
 */

package utils;

import org.evosuite.runtime.annotation.EvoSuiteClassExclude;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.evosuite.runtime.sandbox.Sandbox;
import org.evosuite.runtime.sandbox.Sandbox.SandboxMode;

@EvoSuiteClassExclude
public class UserMapperImpl_ESTest_scaffolding {

  @org.junit.Rule 
  public org.evosuite.runtime.vnet.NonFunctionalRequirementRule nfr = new org.evosuite.runtime.vnet.NonFunctionalRequirementRule();

  private static final java.util.Properties defaultProperties = (java.util.Properties) System.getProperties().clone();

  private org.evosuite.runtime.thread.ThreadStopper threadStopper =  new org.evosuite.runtime.thread.ThreadStopper (org.evosuite.runtime.thread.KillSwitchHandler.getInstance(), 3000);


  @BeforeClass 
  public static void initEvoSuiteFramework() { 
    org.evosuite.runtime.RuntimeSettings.className = "com.landlord.utils.UserMapperImpl"; 
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
    System.setProperty("user.dir", "D:\\TelerikAlfaAcademy\\FinalProject\\Project\\Landlord\\api\\src\\main");
    System.setProperty("user.home", "C:\\Users\\rumy");
    System.setProperty("user.language", "en");
    System.setProperty("user.name", "rumy");
    System.setProperty("user.timezone", "Europe/Helsinki");
  }

  private static void initializeClasses() {
    org.evosuite.runtime.classhandling.ClassStateSupport.initializeClasses(UserMapperImpl_ESTest_scaffolding.class.getClassLoader() ,
      "com.landlord.dto.UserDTO",
      "org.springframework.core.ParameterNameDiscoverer",
      "org.springframework.util.ConcurrentReferenceHashMap$Reference",
      "org.springframework.core.type.ClassMetadata",
      "org.springframework.util.ConcurrentReferenceHashMap$Segment",
      "org.springframework.beans.factory.support.BeanDefinitionRegistry",
      "org.springframework.core.env.PropertyResolver",
      "org.springframework.core.MethodParameter",
      "org.springframework.util.ConcurrentReferenceHashMap$Segment$1",
      "org.springframework.core.ParameterizedTypeReference$1",
      "org.springframework.core.ResolvableType",
      "org.springframework.context.annotation.ImportSelector",
      "org.springframework.boot.autoconfigure.AutoConfigurationPackages$Registrar",
      "org.springframework.core.NestedExceptionUtils",
      "org.springframework.core.io.Resource",
      "org.springframework.boot.autoconfigure.AutoConfigurationImportSelector",
      "org.springframework.core.NestedRuntimeException",
      "org.springframework.core.io.ResourceLoader",
      "org.springframework.core.type.AnnotationMetadata",
      "org.springframework.core.AliasRegistry",
      "org.apache.logging.log4j.util.BiConsumer",
      "org.springframework.core.AttributeAccessor",
      "org.springframework.core.SerializableTypeWrapper$TypeProvider",
      "com.landlord.models.RatingVote",
      "org.springframework.core.AttributeAccessorSupport",
      "org.springframework.core.env.Environment",
      "org.springframework.core.io.InputStreamSource",
      "org.springframework.core.ResolvableType$VariableResolver",
      "org.springframework.beans.factory.BeanClassLoaderAware",
      "org.springframework.util.ConcurrentReferenceHashMap$Task",
      "org.springframework.beans.PropertyValues",
      "org.springframework.util.ConcurrentReferenceHashMap$Restructure",
      "org.springframework.core.Ordered",
      "org.springframework.boot.autoconfigure.AutoConfigurationPackage",
      "org.springframework.util.ConcurrentReferenceHashMap$Entry",
      "com.landlord.models.base.ModelBase",
      "org.springframework.context.annotation.DeferredImportSelector",
      "org.springframework.core.ParameterizedTypeReference",
      "com.landlord.utils.UserMapperImpl",
      "org.springframework.beans.factory.Aware",
      "org.springframework.util.ConcurrentReferenceHashMap$TaskOption",
      "org.apache.logging.log4j.util.PropertySource",
      "org.springframework.beans.BeanMetadataAttribute",
      "com.landlord.dto.EstateDTO",
      "org.springframework.util.ConcurrentReferenceHashMap$ReferenceManager",
      "org.springframework.util.ConcurrentReferenceHashMap",
      "org.springframework.util.ConcurrentReferenceHashMap$ReferenceType",
      "org.springframework.beans.factory.config.ConstructorArgumentValues",
      "org.springframework.context.annotation.ImportBeanDefinitionRegistrar",
      "org.springframework.beans.BeanMetadataAttributeAccessor",
      "org.springframework.beans.factory.BeanFactoryAware",
      "org.springframework.beans.factory.config.ConstructorArgumentValues$ValueHolder",
      "com.landlord.dto.base.DTOModelBase",
      "org.springframework.beans.factory.config.BeanDefinition",
      "org.springframework.stereotype.Indexed",
      "org.springframework.core.ResolvableType$EmptyType",
      "org.springframework.util.ConcurrentReferenceHashMap$1",
      "org.springframework.beans.BeanMetadataElement",
      "org.springframework.util.ConcurrentReferenceHashMap$2",
      "com.landlord.models.ChatMessage",
      "org.springframework.util.ConcurrentReferenceHashMap$3",
      "com.landlord.models.Estate",
      "org.springframework.util.ConcurrentReferenceHashMap$4",
      "org.springframework.boot.autoconfigure.EnableAutoConfiguration",
      "org.springframework.beans.FatalBeanException",
      "com.landlord.models.User",
      "org.springframework.beans.PropertyValue",
      "org.springframework.context.ResourceLoaderAware",
      "org.springframework.context.annotation.Import",
      "org.springframework.util.MultiValueMap",
      "org.springframework.util.ConcurrentReferenceHashMap$Entries",
      "org.apache.logging.log4j.util.EnvironmentPropertySource",
      "org.springframework.beans.BeansException",
      "org.springframework.beans.MutablePropertyValues",
      "org.springframework.beans.factory.BeanDefinitionStoreException",
      "com.landlord.utils.base.DTOMapper",
      "org.springframework.boot.context.annotation.DeterminableImports",
      "org.springframework.stereotype.Component",
      "com.landlord.models.base.UserType",
      "org.springframework.core.ResolvableType$1",
      "org.springframework.context.EnvironmentAware",
      "org.springframework.beans.factory.BeanFactory",
      "org.springframework.beans.factory.NoSuchBeanDefinitionException",
      "org.springframework.core.type.AnnotatedTypeMetadata",
      "org.springframework.util.ConcurrentReferenceHashMap$5",
      "org.springframework.util.Assert"
    );
  } 

  private static void resetClasses() {
    org.evosuite.runtime.classhandling.ClassResetter.getInstance().setClassLoader(UserMapperImpl_ESTest_scaffolding.class.getClassLoader()); 

    org.evosuite.runtime.classhandling.ClassStateSupport.resetClasses(
      "com.landlord.utils.UserMapperImpl",
      "com.landlord.models.User",
      "com.landlord.dto.base.DTOModelBase",
      "com.landlord.dto.UserDTO",
      "com.landlord.models.RatingVote",
      "com.landlord.models.ChatMessage",
      "com.landlord.models.Estate",
      "com.landlord.dto.EstateDTO"
    );
  }
}
