package com.vivek.spring.intl.worldisfamily.configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

/*AcceptHeaderLocaleResolver is:
 *	LocaleResolver implementation that simply uses the primary localespecified in the "accept-language" header of the 
 *	HTTP request (that is,the locale sent by the client browser, normally that of the client's OS). 
 */

/*
 * Defines callback methods to customize the Java-based configuration forSpring MVC enabled via @EnableWebMvc.
 */

/*
 * Indicates that a class declares one or more @Bean methods andmay be processed by the 
 * Spring container to generate bean definitions andservice requests for those beans at runtime, 
 */
@Configuration
public class CustomLocaleResolver 
             extends AcceptHeaderLocaleResolver 
             implements WebMvcConfigurer {

   List<Locale> LOCALES = Arrays.asList(
         new Locale("en"),
         new Locale("fr"));

   @Override
   public Locale resolveLocale(HttpServletRequest request) {
      String headerLang = request.getHeader("Accept-Language");
      return headerLang == null || headerLang.isEmpty()
            ? Locale.getDefault()
            : Locale.lookup(Locale.LanguageRange.parse(headerLang), LOCALES);
   }
   /*@Bean
    * Indicates that a method produces a bean to be managed by the Spring container. 
    */
   @Bean
   public ResourceBundleMessageSource messageSource() {
      ResourceBundleMessageSource rs = new ResourceBundleMessageSource();
      rs.setBasename("messages");
      rs.setDefaultEncoding("UTF-8");
      rs.setUseCodeAsDefaultMessage(true);
      return rs;
   }
}