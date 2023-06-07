<!-- PROJECT LOGO -->

<p align="center">
  <a href="https://openliberty.io/">
    <img src="https://openliberty.io/img/spaceship.svg" alt="Logo">
  </a>
</p>
<p align="center">
  <a href="https://openliberty.io/">
    <img src="https://github.com/OpenLiberty/open-liberty/blob/master/logos/logo_horizontal_light_navy.png" alt="title" width="400">
  </a>
</p>
<br />

[![License](https://img.shields.io/badge/License-ASL%202.0-green.svg)](https://opensource.org/licenses/Apache-2.0)

# devfile-stack-starters
Starters for the java-openliberty devfile-stack.

See: https://github.com/OpenLiberty/devfile-stack/blob/main/README.md for getting started info

---

# Building the app Container Image (OCI)

## using [**Cloud Native Buildpacks**](https://buildpacks.io/)

to build using [**pack CLI**](https://buildpacks.io/docs/tools/pack/) 

> make sure you have `pack` CLI installed! If not install it before.

```shell
pack build \
--env BP_JAVA_APP_SERVER=liberty \
--env BP_LIBERTY_PROFILE=microProfile6 \
--env BP_GRADLE_BUILT_ARTIFACT="build/libs/*.[ejw]ar src/main/liberty/config/*" \
--buildpack paketo-buildpacks/eclipse-openj9 \
--buildpack paketo-buildpacks/java openliberty-starter-app
```

to run the app using the built container image with docker:

```shell
docker run --name openliberty-starter-default --rm \
-p 9080:9080 \
-e WLP_LOGGING_MESSAGE_FORMAT=basic \
-e WLP_LOGGING_CONSOLE_FORMAT=basic \
openliberty-starter-app
```

# Reference Notes

## Gradle

Openliberty starter: https://openliberty.io/start
Openliberty Gradle quickstart: https://openliberty.io/guides/gradle-intro.html#a-few-more-pieces

Openliberty Gradle plugin docs.
 * https://github.com/OpenLiberty/ci.gradle
 * https://www.ibm.com/docs/en/wasdtfe?topic=projects-developing-liberty-gradle-plug-in

Openliberty Devfile-stack public repo
 * https://github.com/OpenLiberty/devfile-stack/

## Container Image build with Buildpacks

 * https://openliberty.io/blog/2022/04/01/cloud-native-liberty-buildpack.html