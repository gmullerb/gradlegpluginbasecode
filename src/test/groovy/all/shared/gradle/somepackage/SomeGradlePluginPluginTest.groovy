//  Copyright (c) 2018 SomeDeveloper/SomeCompany.
//  Licensed under the SOME License, see LICENSE.txt
package all.shared.gradle.somepackage

import all.shared.gradle.testfixtures.SpyProjectFactory

import groovy.transform.CompileStatic

import org.gradle.api.Project

import org.junit.jupiter.api.Test

import static org.junit.jupiter.api.Assertions.assertFalse
import static org.junit.jupiter.api.Assertions.assertNotNull
import static org.junit.jupiter.api.Assertions.assertTrue

import static org.mockito.Matchers.eq
import static org.mockito.Mockito.verify

@CompileStatic
class SomeGradlePluginPluginTest {
  private final Project spyProject = SpyProjectFactory.build()

  @Test
  void shouldComplement() {
    final boolean result = SomeGradlePluginPlugin.complement(spyProject)

    assertTrue(result)
    assertNotNull(spyProject.extensions.getByName(SomeGradlePluginPlugin.EXTENSION_NAME))
    verify(spyProject.logger)
      .debug(eq('Added some-gradle-plugin extension'))
  }

  @Test
  void shouldNotComplement() {
    spyProject.extensions.add(SomeGradlePluginPlugin.EXTENSION_NAME, 'someValue')

    final boolean result = SomeGradlePluginPlugin.complement(spyProject)

    assertFalse(result)
    verify(spyProject.logger)
      .error(eq('Couldn\'t add some-gradle-plugin extension'))
  }

  @Test
  void shouldApplyPlugin() {
    final SomeGradlePluginPlugin plugin = new SomeGradlePluginPlugin()

    plugin.apply(spyProject)

    verify(spyProject.logger)
      .debug(eq('Added some-gradle-plugin extension'))
  }
}
