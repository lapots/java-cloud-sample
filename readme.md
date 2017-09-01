# Java Cloud Sample [![Build Status](https://travis-ci.org/lapots/java-cloud-sample.svg?branch=master)](https://travis-ci.org/lapots/java-cloud-sample)

Please add `toolchain` to local `.m2` repository if needed to compile `java 9` application

```
<toolchains>
  <toolchain>
    <type>jdk</type>
    <provides>
      <version>1.9</version>
      <vendor>oracle</vendor>
    </provides>
    <configuration>
      <jdkHome>path/to/jdk-9</jdkHome>
    </configuration>
  </toolchain>
  <toolchain>
    <type>jdk</type>
    <provides>
      <version>1.8</version>
      <vendor>oracle</vendor>
    </provides>
    <configuration>
      <jdkHome>path/to/jdk1.8.0_121</jdkHome>
    </configuration>
  </toolchain>
</toolchains>
```

# Stack

Current application stack

- Java 9
- Maven 3
- Travis-CI
- Heroku
