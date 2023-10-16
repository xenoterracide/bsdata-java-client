group = "com.xenoterracide"
version = "0.1.0-SNAPSHOT"

buildscript.dependencyLocking.lockAllConfigurations()

plugins {
  id("our.bom")
  id("our.java-compile")
  id("our.spotbugs")
  id("com.intershop.gradle.jaxb").version("6.+")
  `maven-publish`
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

publishing {
  publications {
    create<MavenPublication>("maven") {
      from(components["java"])
      withBuildIdentifier()
      pom {
        licenses {
          license {
            name = "The Apache License, Version 2.0"
            url = "http://www.apache.org/licenses/LICENSE-2.0.txt"
          }
        }
      }
    }
  }
}
