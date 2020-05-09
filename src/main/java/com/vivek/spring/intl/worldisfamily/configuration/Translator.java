package com.vivek.spring.intl.worldisfamily.configuration;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;
/*
 * Indicates that an annotated class is a "component".
 * Such classes are considered as candidates for auto-detectionwhen using annotation-based configuration and
 * classpath scanning. 
 */
@Component
public class Translator {

   private static ResourceBundleMessageSource messageSource;
   /*
    * Marks a constructor, field, setter method, or config method as to be 
    * autowired bySpring's dependency injection facilities
    */
   @Autowired
   Translator(ResourceBundleMessageSource messageSource) {
      Translator.messageSource = messageSource;
   }
   /*
    * A Locale object represents a specific geographical, political,or cultural region. 
    * An operation that requires a Locale to performits task is called locale-
    */
   
   /*LocaleContextHolder is:
    * Simple holder class that associates a LocaleContext instancewith the current thread.
    * The LocaleContext will be inheritedby any child threads spawned by the current thread if 
    * the inheritable flag is set to true. 
    */
   public static String toLocale(String msgCode) {
      Locale locale = LocaleContextHolder.getLocale();
      return messageSource.getMessage(msgCode, null, locale);
   }
   
}
