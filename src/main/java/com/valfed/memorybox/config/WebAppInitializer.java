package com.valfed.memorybox.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
  @Override
  protected Class<?>[] getRootConfigClasses() {
    return null;
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class[]{SpringConfig.class};
  }

  @Override
  protected String[] getServletMappings() {
    return new String[]{"/"};
  }

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    super.onStartup(servletContext);
    registerHiddenFieldFilter(servletContext);
    registerCharEncodingFilter(servletContext);
  }

  private void registerHiddenFieldFilter(ServletContext servletContext) {
    servletContext.addFilter("hiddenHttpMethodFilter",
            new HiddenHttpMethodFilter())
            .addMappingForUrlPatterns(null, true, "/*");
  }

  private void registerCharEncodingFilter(ServletContext servletContext) {
    FilterRegistration charEncodingFilterReg =
            servletContext.addFilter("CharacterEncodingFilter", CharacterEncodingFilter.class);
    charEncodingFilterReg.setInitParameter("encoding", "UTF-8");
    charEncodingFilterReg.setInitParameter("forceEncoding", "true");
    charEncodingFilterReg.addMappingForUrlPatterns(null, false, "/*");
  }
}
