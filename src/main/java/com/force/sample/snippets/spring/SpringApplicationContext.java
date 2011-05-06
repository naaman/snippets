package com.force.sample.snippets.spring;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.util.StringUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * Extends Spring's default web application context to allow relative
 * resource paths. Resources without explicitly specified URL protocol
 * and / or leading slash are loaded relative to the first location
 * from getConfigLocations().
 */

public class SpringApplicationContext extends XmlWebApplicationContext {

  @Override
  protected Resource getResourceByPath(String path) {
    path = StringUtils.cleanPath(path);
    if (path.startsWith("/") || (path.indexOf(':')>0)) {
      return super.getResourceByPath(path);
    }
    try {
      return super.getResourceByPath(getConfigLocations()[0])
        .createRelative(path);
    } catch (IOException E) {
      // failed to create relative resource - default to standard implementation
      return super.getResourceByPath(path);
    }
  } // getResourceByPath()
}
