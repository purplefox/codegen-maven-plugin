/*
 * Copyright 2014 Red Hat, Inc.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Apache License v2.0 which accompanies this distribution.
 *
 * The Eclipse Public License is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * The Apache License v2.0 is available at
 * http://www.opensource.org/licenses/apache2.0.php
 *
 * You may elect to redistribute this code under either of these licenses.
 */

package io.vertx.codegen.plugin;

import io.vertx.codegen.Generator;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

/**
 * Goal which shows the project details
 *
 * @goal validateAPI
 *
 * @phase validate
 */
public class GenerateMojo extends AbstractMojo {

  /**
   * Example of a plugin configured output directory
   *
   * @parameter
   * @required
   */
  protected String fileExtension;

  /**
   * The package name
   *
   * @parameter
   * @required
   */
  protected String packageName;

  public void execute() throws MojoExecutionException  {
    getLog().info("Starting");

    Generator gen = new Generator();
    try {
      System.out.println("**** valudating package: " + packageName);
      gen.validatePackage(packageName, packageName -> !packageName.contains("impl"));
    } catch (Exception e) {
      throw new MojoExecutionException(e.getMessage());
    }
  }
}
