/**
 * Scaffolding file used to store all the setups needed to run 
 * tests automatically generated by EvoSuite
 * Tue Nov 13 11:15:47 GMT 2018
 */

package com.landlord.api.utils;

import org.evosuite.runtime.annotation.EvoSuiteClassExclude;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.evosuite.runtime.sandbox.Sandbox;
import org.evosuite.runtime.sandbox.Sandbox.SandboxMode;

import static org.mockito.Mockito.mock;

@EvoSuiteClassExclude
public class VotingInputMapperImpl_ESTest_scaffolding {

  @org.junit.Rule 
  public org.evosuite.runtime.vnet.NonFunctionalRequirementRule nfr = new org.evosuite.runtime.vnet.NonFunctionalRequirementRule();

  private static final java.util.Properties defaultProperties = (java.util.Properties) System.getProperties().clone();

  private org.evosuite.runtime.thread.ThreadStopper threadStopper =  new org.evosuite.runtime.thread.ThreadStopper (org.evosuite.runtime.thread.KillSwitchHandler.getInstance(), 3000);


  @BeforeClass 
  public static void initEvoSuiteFramework() { 
    org.evosuite.runtime.RuntimeSettings.className = "com.landlord.utils.VotingInputMapperImpl"; 
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
    System.setProperty("user.dir", "D:\\TelerikAlfaAcademy\\FinalProject\\Project\\Landlord\\api\\src\\main");
    System.setProperty("user.home", "C:\\Users\\rumy");
    System.setProperty("user.language", "en");
    System.setProperty("user.name", "rumy");
    System.setProperty("user.timezone", "Europe/Helsinki");
  }

  private static void initializeClasses() {
    org.evosuite.runtime.classhandling.ClassStateSupport.initializeClasses(VotingInputMapperImpl_ESTest_scaffolding.class.getClassLoader() ,
      "org.apache.logging.log4j.message.FlowMessage",
      "org.hibernate.engine.spi.NamedQueryDefinition",
      "org.hibernate.CustomEntityDirtinessStrategy",
      "org.hibernate.jpa.HibernateEntityManagerFactory",
      "org.apache.logging.log4j.message.ReusableMessageFactory",
      "org.springframework.beans.factory.annotation.Autowired",
      "org.apache.logging.log4j.Level",
      "org.hibernate.cache.spi.QueryCache",
      "org.hibernate.metadata.ClassMetadata",
      "org.apache.logging.log4j.spi.StandardLevel",
      "org.hibernate.engine.profile.FetchProfile",
      "org.apache.logging.slf4j.MDCContextMap",
      "org.hibernate.engine.jdbc.LobCreationContext",
      "com.landlord.repositories.SqlRepositoryImpl",
      "org.springframework.stereotype.Repository",
      "org.apache.logging.log4j.util.LoaderUtil$ThreadContextClassLoaderGetter",
      "org.apache.logging.log4j.MarkerManager$Log4jMarker",
      "org.hibernate.id.IdentifierGenerator",
      "org.hibernate.Metamodel",
      "org.hibernate.SessionFactory",
      "org.apache.logging.log4j.util.StringBuilderFormattable",
      "org.hibernate.cache.spi.OptimisticCacheSource",
      "org.apache.logging.log4j.Logger",
      "com.landlord.models.RatingVote",
      "org.hibernate.dialect.Dialect",
      "org.hibernate.internal.util.MarkerObject",
      "org.hibernate.query.spi.QueryParameterBindingTypeResolver",
      "org.hibernate.collection.internal.AbstractPersistentCollection",
      "org.apache.logging.log4j.message.MessageFormatMessageFactory",
      "org.apache.logging.log4j.util.Strings",
      "org.hibernate.HibernateException",
      "org.hibernate.persister.collection.CollectionPersister",
      "com.landlord.services.base.LandlordService",
      "org.apache.logging.log4j.util.PropertySource$Util",
      "org.apache.logging.log4j.spi.ThreadContextMap2",
      "org.springframework.boot.autoconfigure.AutoConfigurationPackage",
      "org.hibernate.AssertionFailure",
      "org.hibernate.engine.spi.SessionBuilderImplementor",
      "org.apache.logging.log4j.util.ProviderUtil",
      "com.landlord.models.base.ModelBase",
      "org.hibernate.persister.walking.spi.CollectionDefinition",
      "org.apache.logging.log4j.message.FlowMessageFactory",
      "org.hibernate.TypeHelper",
      "com.landlord.utils.UserMapperImpl",
      "org.hibernate.StatelessSession",
      "org.hibernate.Session",
      "org.apache.logging.slf4j.SLF4JLogger",
      "org.hibernate.boot.spi.SessionFactoryOptions",
      "org.apache.logging.log4j.spi.Provider",
      "org.apache.logging.log4j.spi.LoggerContext",
      "org.hibernate.engine.spi.Mapping",
      "org.jboss.logging.BasicLogger",
      "org.hibernate.service.Service",
      "org.hibernate.dialect.function.SQLFunctionRegistry",
      "org.apache.logging.log4j.spi.LoggerRegistry$ConcurrentMapFactory",
      "org.springframework.stereotype.Service",
      "com.landlord.dto.base.DTOModelBase",
      "org.hibernate.persister.walking.spi.AttributeSource",
      "org.springframework.stereotype.Indexed",
      "org.hibernate.service.spi.ServiceRegistryImplementor",
      "org.jboss.logging.LoggingLocale$1",
      "org.apache.logging.log4j.Marker",
      "org.hibernate.metamodel.spi.MetamodelImplementor",
      "org.apache.logging.slf4j.SLF4JProvider",
      "org.apache.logging.log4j.simple.SimpleLogger",
      "org.apache.logging.log4j.message.MessageFactory",
      "org.apache.logging.log4j.util.PropertiesUtil$Environment",
      "org.springframework.boot.autoconfigure.EnableAutoConfiguration",
      "org.hibernate.query.spi.QueryProducerImplementor",
      "com.landlord.models.User",
      "org.hibernate.jpa.HibernateEntityManager",
      "org.springframework.context.annotation.Import",
      "org.apache.logging.log4j.util.EnvironmentPropertySource",
      "org.hibernate.engine.jdbc.spi.JdbcServices",
      "com.landlord.utils.base.DTOMapper",
      "org.hibernate.loader.CollectionAliases",
      "org.hibernate.engine.jdbc.spi.SqlExceptionHelper",
      "org.hibernate.engine.spi.CacheImplementor",
      "org.apache.logging.log4j.message.MessageFactory2",
      "com.landlord.dto.UserDTO",
      "org.apache.logging.log4j.util.PropertiesPropertySource",
      "org.hibernate.collection.internal.AbstractPersistentCollection$LazyInitializationWork",
      "org.apache.logging.log4j.message.AbstractMessageFactory",
      "org.apache.logging.log4j.message.ParameterizedMessageFactory",
      "org.hibernate.persister.entity.EntityPersister",
      "org.jboss.logging.LoggerProvider",
      "org.hibernate.query.QueryProducer",
      "org.hibernate.context.spi.CurrentTenantIdentifierResolver",
      "org.hibernate.Interceptor",
      "com.landlord.services.LandlordServiceImpl",
      "org.hibernate.query.spi.NamedQueryRepository",
      "org.apache.logging.log4j.spi.LoggerRegistry$MapFactory",
      "org.hibernate.engine.jndi.JndiException",
      "org.hibernate.collection.spi.PersistentCollection",
      "org.hibernate.SessionFactoryObserver",
      "org.apache.logging.log4j.util.PropertyFilePropertySource",
      "org.apache.logging.log4j.util.SystemPropertiesPropertySource",
      "org.hibernate.exception.spi.ConversionContext",
      "org.apache.logging.slf4j.SLF4JLoggerContext",
      "org.hibernate.cache.spi.UpdateTimestampsCache",
      "org.apache.logging.slf4j.SLF4JLogger$1",
      "org.hibernate.engine.spi.SessionFactoryDelegatingImpl",
      "org.hibernate.internal.CoreMessageLogger_$logger",
      "org.hibernate.stat.Statistics",
      "org.apache.logging.log4j.spi.LoggerRegistry",
      "org.hibernate.engine.spi.SessionFactoryImplementor",
      "org.hibernate.proxy.EntityNotFoundDelegate",
      "org.hibernate.SessionBuilder",
      "org.apache.logging.log4j.message.DefaultFlowMessageFactory",
      "org.hibernate.persister.walking.spi.EntityDefinition",
      "org.hibernate.stat.spi.StatisticsImplementor",
      "com.landlord.dto.RatingVoteDTO",
      "org.hibernate.metadata.CollectionMetadata",
      "org.hibernate.exception.spi.SQLExceptionConverter",
      "org.hibernate.resource.jdbc.spi.JdbcSessionOwner",
      "org.apache.logging.log4j.MarkerManager",
      "org.apache.logging.log4j.util.BiConsumer",
      "org.jboss.logging.Logger$1",
      "org.hibernate.engine.spi.FilterDefinition",
      "org.hibernate.MappingException",
      "org.apache.logging.log4j.spi.CleanableThreadContextMap",
      "org.hibernate.SharedSessionContract",
      "org.hibernate.cache.spi.Region",
      "org.hibernate.engine.spi.SharedSessionContractImplementor",
      "org.apache.logging.log4j.LoggingException",
      "org.apache.logging.slf4j.SLF4JLoggerContextFactory",
      "org.apache.logging.log4j.util.Constants",
      "org.jboss.logging.Log4j2Logger",
      "org.hibernate.internal.CoreMessageLogger",
      "org.hibernate.engine.spi.NamedSQLQueryDefinition",
      "org.jboss.logging.LoggerProviders$1",
      "org.jboss.logging.Logger",
      "org.hibernate.id.factory.IdentifierGeneratorFactory",
      "org.apache.logging.log4j.util.LoaderUtil",
      "org.apache.logging.log4j.util.PropertySource",
      "org.apache.logging.log4j.message.ParameterizedNoReferenceMessageFactory",
      "org.apache.logging.log4j.util.PropertiesUtil",
      "org.hibernate.cfg.Settings",
      "org.apache.logging.log4j.message.ExitMessage",
      "org.hibernate.cache.spi.access.RegionAccessStrategy",
      "org.hibernate.engine.jndi.JndiNameException",
      "org.jboss.logging.LoggingLocale",
      "org.apache.logging.log4j.message.Message",
      "org.hibernate.StatelessSessionBuilder",
      "org.apache.logging.log4j.spi.AbstractLogger",
      "org.jboss.logging.LoggerProviders",
      "org.hibernate.type.descriptor.WrapperOptions",
      "com.landlord.repositories.base.GenericRepository",
      "com.landlord.models.ChatMessage",
      "com.landlord.models.Estate",
      "org.apache.logging.log4j.status.StatusLogger$BoundedQueue",
      "org.apache.logging.log4j.util.PropertiesUtil$Environment$1",
      "org.hibernate.collection.internal.PersistentIdentifierBag",
      "org.apache.logging.log4j.spi.LoggerContextFactory",
      "org.jboss.logging.DelegatingBasicLogger",
      "org.apache.logging.log4j.util.PropertySource$Comparator",
      "org.hibernate.service.ServiceRegistry",
      "org.apache.logging.log4j.message.EntryMessage",
      "org.hibernate.engine.ResultSetMappingDefinition",
      "org.hibernate.Cache",
      "org.springframework.stereotype.Component",
      "org.hibernate.engine.spi.SessionFactoryImplementor$DeserializationResolver",
      "org.apache.logging.log4j.spi.ThreadContextMap",
      "org.jboss.logging.Logger$Level",
      "org.jboss.logging.Log4j2LoggerProvider",
      "org.hibernate.LazyInitializationException",
      "org.apache.logging.log4j.status.StatusLogger",
      "org.hibernate.resource.transaction.spi.TransactionCoordinatorBuilder$Options",
      "org.hibernate.type.TypeResolver",
      "org.apache.logging.log4j.spi.ExtendedLogger",
      "com.landlord.utils.VotingInputMapperImpl",
      "org.hibernate.engine.query.spi.QueryPlanCache",
      "org.hibernate.internal.CoreLogging",
      "org.apache.logging.log4j.LogManager",
      "org.hibernate.type.Type"
    );
  } 
  private static void initMocksToAvoidTimeoutsInTheTests() throws ClassNotFoundException { 
    mock(Class.forName("com.landlord.services.base.LandlordService", false, VotingInputMapperImpl_ESTest_scaffolding.class.getClassLoader()));
  }

  private static void resetClasses() {
    org.evosuite.runtime.classhandling.ClassResetter.getInstance().setClassLoader(VotingInputMapperImpl_ESTest_scaffolding.class.getClassLoader()); 

    org.evosuite.runtime.classhandling.ClassStateSupport.resetClasses(
      "com.landlord.utils.VotingInputMapperImpl",
      "com.landlord.repositories.SqlRepositoryImpl",
      "org.hibernate.engine.spi.SessionFactoryDelegatingImpl",
      "com.landlord.utils.UserMapperImpl",
      "com.landlord.services.LandlordServiceImpl",
      "com.landlord.dto.base.DTOModelBase",
      "com.landlord.dto.RatingVoteDTO",
      "com.landlord.models.RatingVote",
      "org.hibernate.internal.CoreLogging",
      "org.jboss.logging.Logger",
      "org.jboss.logging.LoggingLocale$1",
      "org.jboss.logging.LoggingLocale",
      "org.jboss.logging.Logger$1",
      "org.jboss.logging.DelegatingBasicLogger",
      "org.hibernate.internal.CoreMessageLogger_$logger",
      "org.jboss.logging.LoggerProviders$1",
      "org.apache.logging.log4j.MarkerManager",
      "org.apache.logging.log4j.MarkerManager$Log4jMarker",
      "org.apache.logging.log4j.util.PropertiesUtil$Environment",
      "org.apache.logging.log4j.util.PropertiesPropertySource",
      "org.apache.logging.log4j.util.PropertyFilePropertySource",
      "org.apache.logging.log4j.util.LoaderUtil$ThreadContextClassLoaderGetter",
      "org.apache.logging.log4j.util.LoaderUtil",
      "org.apache.logging.log4j.util.PropertySource$Comparator",
      "org.apache.logging.log4j.util.EnvironmentPropertySource",
      "org.apache.logging.log4j.util.SystemPropertiesPropertySource",
      "org.apache.logging.log4j.util.PropertiesUtil$Environment$1",
      "org.apache.logging.log4j.util.PropertySource$Util",
      "org.apache.logging.log4j.util.PropertiesUtil",
      "org.apache.logging.log4j.util.Constants",
      "org.apache.logging.log4j.spi.AbstractLogger",
      "org.apache.logging.log4j.message.AbstractMessageFactory",
      "org.apache.logging.log4j.message.ParameterizedNoReferenceMessageFactory",
      "org.apache.logging.log4j.message.DefaultFlowMessageFactory",
      "org.apache.logging.log4j.status.StatusLogger$BoundedQueue",
      "org.apache.logging.log4j.simple.SimpleLogger",
      "org.apache.logging.log4j.spi.StandardLevel",
      "org.apache.logging.log4j.util.Strings",
      "org.apache.logging.log4j.Level",
      "org.apache.logging.log4j.status.StatusLogger",
      "org.apache.logging.log4j.util.ProviderUtil",
      "org.apache.logging.log4j.spi.Provider",
      "org.apache.logging.slf4j.SLF4JProvider",
      "org.apache.logging.slf4j.SLF4JLoggerContext",
      "org.apache.logging.log4j.spi.LoggerRegistry",
      "org.apache.logging.log4j.spi.LoggerRegistry$ConcurrentMapFactory",
      "org.apache.logging.slf4j.SLF4JLoggerContextFactory",
      "org.apache.logging.log4j.LogManager",
      "org.jboss.logging.Log4j2LoggerProvider",
      "org.jboss.logging.Log4j2Logger",
      "org.apache.logging.slf4j.SLF4JLogger",
      "org.apache.logging.log4j.message.ParameterizedMessageFactory",
      "org.apache.logging.log4j.message.MessageFormatMessageFactory",
      "org.jboss.logging.Logger$Level",
      "org.apache.logging.slf4j.SLF4JLogger$1",
      "org.jboss.logging.LoggerProviders",
      "org.hibernate.internal.util.MarkerObject",
      "org.hibernate.collection.internal.AbstractPersistentCollection",
      "org.hibernate.collection.internal.PersistentIdentifierBag",
      "org.hibernate.engine.spi.SessionDelegatorBaseImpl"
    );
  }
}
