# Gradle Plugin's Base Code in Groovy

[![license](https://img.shields.io/badge/license-UNLICENSE-green.svg)](/UNLICENSE.txt)

**This project is build with the purpose of given a base code from where to start developing a Gradle plugin in Groovy with little effort.**

[This project is unlicensed](/UNLICENSE.txt).

## Goals

* Base code for Gradle plugins development in Groovy with basic validations.

## Features

* Adds required plugins:
  * **groovy**.
  * **com.gradle.plugin-publish**.
* Adds additional useful plugins:
  * **all.shared.gradle.project-style-checker**.
  * **jacoco**.
* Configures basic important Gradle's tasks:
  * `assemble`.
  * `assessCommon`.
  * `assessGradle`.
  * `codenarcMain`.
  * `codenarcTest`.
  * `jacocoTestReport`.
  * `jacocoTestCoverageVerification`.
* Provides the basic folder structure.
* Adds additional useful `md` files.

## Extending/Developing

### Prerequisites

* [Java](http://www.oracle.com/technetwork/java/javase/downloads).
* [Git](https://git-scm.com/downloads) (only if you are going to clone the project).

### Getting it

Clone or download the project[1], in the desired folder execute:

```sh
git clone https://github.com/gmullerb/gradlegpluginbasecode
```

> [1] [Cloning a repository](https://help.github.com/articles/cloning-a-repository/)

### Set up

* **No need**, only download and run (It's Gradle! Yes!).

### Folders structure

```
  /src
    /main
      /groovy
    /test
      /groovy
```

- `src/main/groovy`: Source code files.
  - [SomeGradlePluginPlugin](src/main/groovy/all/shared/gradle/somePackage/SomeGradlePluginPlugin.groovy) is the entry point of the plugin.
  - [SomeGradlePluginExtension](src/main/groovy/all/shared/gradle/somePackage/SomeGradlePluginExtension.groovy) extension of the plugin.
- `src/test/groovy`: Test code files[1]:
  - [SomeGradlePluginPluginTest](src/test/groovy/all/shared/gradle/somePackage/SomeGradlePluginPluginTest.groovy) some test for the plugin.

> [1] Tests are done with [JUnit](http://junit.org) and [Mockito](http://javadoc.io/page/org.mockito/mockito-core/latest/org/mockito/Mockito.html).

### Customizing it

1 . Rename `somepackage`/`SomeGradlePlugin`/`some-gradle-plugin` based on the plugin name:

* `somepackage`:
  * In folders.
  * In package declaration in code files: `package all.shared.gradle.somepackage`:
    * [SomeGradlePluginPlugin](src/main/groovy/all/shared/gradle/somepackage/SomeGradlePluginPlugin.groovy).
    * [SomeGradlePluginExtension](src/main/groovy/all/shared/gradle/somepackage/SomeGradlePluginExtension.groovy).
    * [SomeGradlePluginPluginTest](src/test/groovy/all/shared/gradle/somepackage/SomeGradlePluginPluginTest.groovy).
* `SomeGradlePlugin`:
  * Code files names:
    * [SomeGradlePluginPlugin](src/main/groovy/all/shared/gradle/somepackage/SomeGradlePluginPlugin.groovy).
    * [SomeGradlePluginExtension](src/main/groovy/all/shared/gradle/somepackage/SomeGradlePluginExtension.groovy).
    * [SomeGradlePluginPluginTest](src/test/groovy/all/shared/gradle/somepackage/SomeGradlePluginPluginTest.groovy).
  * Classes names:
    * [`SomeGradlePluginPlugin`](src/main/groovy/all/shared/gradle/somepackage/SomeGradlePluginPlugin.groovy).
    * [`SomeGradlePluginExtension`](src/main/groovy/all/shared/gradle/somepackage/SomeGradlePluginExtension.groovy).
    * [`SomeGradlePluginPluginTest`](src/test/groovy/all/shared/gradle/somepackage/SomeGradlePluginPluginTest.groovy).
* `some-gradle-plugin`:
  * Plugin file name: [all.shared.gradle.some-gradle-plugin.properties](src/main/resources/META-INF/gradle-plugins/all.shared.gradle.some-gradle-plugin.properties).
    * Change implementation class: `all.shared.gradle.somepackage.SomeGradlePluginPlugin`.
  * [Gradle's settings file](settings.gradle):

  ```gradle
    rootProject.name = 'some-gradle-plugin'
  ```

  * [Gradle's build file](build.gradle) (if required):

  ```gradle
    apply plugin: 'all.shared.gradle.some-gradle-plugin'
  ```

  * Logs:
    * Change the following messages:
      * `'Added some-gradle-plugin extension'`.
      * `'Couldn\'t add some-gradle-plugin extension'`.
    * In the following files:
      * [`SomeGradlePluginPlugin`](src/main/groovy/all/shared/gradle/somepackage/SomeGradlePluginPlugin.groovy).
      * [`SomeGradlePluginPluginTest`](src/test/groovy/all/shared/gradle/somepackage/SomeGradlePluginPluginTest.groovy).

2 . Adjust the License according to requirements:

* Add `License.txt` file (and remove `UNLICENSE.txt`).
* Modify header on Code files and any other file that requires it:

```gradle
  //  Copyright (c) 2018 SomeDeveloper/SomeCompany.
  //  Licensed under the SOME License, see LICENSE.txt
```

3 . Adjust plugin publishing information in [Gradle's build file](build.gradle):

* site.
* description.
* tags.
* id (can fix it here or [set it by command line](#Building-it))
* title.

```gradle
final PLUGIN_SITE = 'plugin site'
..
pluginBundle {
  ..
  description = 'plugin description'
  tags = ['plugin tag 1', 'plugin tag 2']
  plugins {
    thePlugin {
      id = project.hasProperty('PLUGIN_ID')
        ? property('PLUGIN_ID')
        : 'Set plugin id'
      displayName = 'plugin title'
    }
  }
}

```

4 . If the plugin is not going to be used in the same project that creates the plugin, then remove:

* the `/buildSrc` folder.
* the whole `apply plugin: 'all.shared.gradle.some-gradle-plugin'` block from [Gradle's build file](build.gradle).

Optional . Run `gradlew`, this will run default task, should get `BUILD SUCCESSFUL` indicating every change went well.

5 . Modify `README.md` file according to requirements.

6 . Modify `CHANGELOG.md` file according to requirements.

* Change title.
* Clear logs.

7 . Add additional required code and Source files.

8 . Add additional required tests and Test files.

* if `gradleTestKit()`  is not required, then remove it from [Gradle's build file](build.gradle).

9 . Remove `.git` folder.

For actual use examples, see:

* [code-common-tasks project](https://github.com/gmullerb/code-common-tasks).  
* [base-style-config-wrapper project](https://github.com/gmullerb/base-style-config-wrapper).  
* [file-lister project](https://github.com/gmullerb/file-lister).  
* [project-style-checker project](https://github.com/gmullerb/project-style-checker).

### Building it

* To build it:
  * `gradlew`: this will run default task, or
  * `gradlew build`.

* To assess files:
  * `gradlew assessCommon`: will check common style of files.
  * `gradlew assessGradle`: will check code style of Gradle's.
  * `gradlew codenarcMain`: will check code style of Groovy's source files.
  * `gradlew codenarcTest`: will check code style of Groovy's test files.
  * `assemble` task depends on these four tasks.

* To test code: `gradlew test`
  * This will run jacoco code coverage [1].

* To publish plugin: `./gradlew -PPLUGIN_ID=all.shared.gradle.some-gradle-plugin publishPlugins`
  * `-PPLUGIN_ID` indicates the plugin id.

* To get all the tasks for the project: `gradlew tasks --all`

> [1] May not get 100% since Groovy adds some extra code, that may not be tested.

### Convention over Configuration

All `all.shared.gradle` plugins define:

* _PluginName_**Plugin**: which contains the class implements `Plugin` interface.
* _PluginName_**Extension**: which represent the extension of the plugin.
* If Tasks are define, then their names will be _TaskName_**Task**.
* If Actions are define, then their names will be _ActionName_**Action**.

All `all.shared.gradle` plugins have two **`static`** members:

* `String EXTENSION_NAME`: This will have the name of the extension that the plugin add.
  * if the plugin does not add an extension the this field will not exist.

* `boolean complement(final Project project)`: will apply the plugin and return true if successful, false otherwise.
  * this methods is **exactly equivalent to the instance `apply` method**, but without instantiate the class if not required.

Both may be useful when applying the plugin when creating custom plugins.

All `all.shared.gradle` plugins "silently" fail when the extension can not be added.

Due to delays in the approval on [Gradle Plugin Repository](https://plugins.gradle.org/u/gmullerb)[1], is possible that the plugin is not available from there, consequently, always recommend to the plugin's user to add the following to `settings.gradle`:

```gradle
  pluginManagement {
    repositories {
        gradlePluginPortal()
        maven {
          url 'the plugin repository'
        }
    }
  }
```

e.g. [2]:

```gradle
  pluginManagement {
    repositories {
        gradlePluginPortal()
        maven {
          url 'https://dl.bintray.com/gmullerb/all.shared.gradle'
        }
    }
  }
```

> [1] Due to new Gradle Plugin Repository policies, delays of several days, without answer, for approval of the plugin publication can happen.  
> [2] For an actual use example, see [basecode - settings.gradle](https://github.com/gmullerb/basecode/blob/master/settings.gradle).

## Documentation

* [`CHANGELOG.md`](CHANGELOG.md): add information of notable changes for each version here, chronologically ordered [1].

> [1] [Keep a Changelog](http://keepachangelog.com)

## License

[Unlicense](/UNLICENSE.txt)
