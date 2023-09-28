group = "com.xenoterracide"
version = "0.1.0-SNAPSHOT"

buildscript.dependencyLocking.lockAllConfigurations()

plugins {
  id("our.java-library")
  id("com.intershop.gradle.jaxb").version("6.+")
}

jaxb {
  javaGen {
    register("Catalogue") {
      schema = file("src/main/resources/xsd/Catalogue.xsd")
    }
  }
}

dependencies {
  implementation(platform(libs.spring.platform))
  implementation(libs.log4j.api)
  implementation(libs.jaxb.api)
}
