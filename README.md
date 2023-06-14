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
[![Contribute](https://www.eclipse.org/che/contribute.svg)](https://workspaces.openshift.com#https://github.com/rafaeltuelho/openliberty-starter-app.git)

# Open Liberty starter App sample
This repo contains a Open Liberty sample starter App with support for building and deploying as Container on Kubernetes or Openshift environment.

See: https://github.com/OpenLiberty/devfile-stack/blob/main/README.md for getting started info

---

# Inner Loop using Gradle

to start the app in dev mode:

```shell
./gradlew libertyDev
```

> **NOTE:** in dev mode you can attach the Java debugger to the default debug port `7777`

to test the app:

```shell
./gradlew test
```

to generate a `WAR` file

```shell
./gradlew war
```

to see available gradle tasks

```shell
./gradlew tasks
```

# Building the app Container Image (OCI)

## using Docker or Podman CLI

```shell
#podman
docker build -f src/main/docker/Dockerfile.gradle -t openliberty-starter-app-test .
```

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

to test the app do:

```shell
curl -w localhost:9080/api/hello/OpenLiberty
```

to test the health endpoint
```shell
curl -w localhost:9080/health
```

to access the OpenAPI (former Swagger) UI: http://localhost:9080/openapi/ui


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