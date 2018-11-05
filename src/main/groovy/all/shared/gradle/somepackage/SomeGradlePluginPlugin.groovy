//  Copyright (c) 2018 SomeDeveloper/SomeCompany.
//  Licensed under the SOME License, see LICENSE.txt
package all.shared.gradle.somepackage

import groovy.transform.CompileStatic

import org.gradle.api.Plugin
import org.gradle.api.Project

@CompileStatic
class SomeGradlePluginPlugin implements Plugin<Project> {
  public static final String EXTENSION_NAME = 'someName'

  static final boolean complement(final Project project) {
    if (project.extensions.findByName(EXTENSION_NAME) == null) {
      project.extensions.create(EXTENSION_NAME, SomeGradlePluginExtension)
      project.logger.debug('Added some-gradle-plugin extension')
      true
    }
    else {
      project.logger.error('Couldn\'t add some-gradle-plugin extension')
      false
    }
  }

  void apply(final Project project) {
    complement(project)
  }
}
