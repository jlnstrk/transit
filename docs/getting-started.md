---
title: Getting started
---

NOTE: This is a draft, nothing's been published yet!

### Using Gradle

Add the maven central repository:
```
repositories {
    mavenCentral()
}
```

For snapshot builds, add the snapshots repository:
```
repositories {
    maven("https://oss.sonatype.org/content/repositories/snapshots")
}
```

#### Artifacts
Get artifacts (multiplatform modules):

```
// Get all artifacts
implementation("io.github.jlnstrk.transit:transit:0.1.0-SNAPSHOT")

// Get just HCI
implementation("io.github.jlnstrk.transit:api-hci:0.1.0-SNAPSHOT")
// Get HCI with interop
implementation("io.github.jlnstrk.transit:interop-hci:0.1.0-SNAPSHOT")

// Get just HAPI
implementation("io.github.jlnstrk.transit:api-hapi:0.1.0-SNAPSHOT")
// Get HAPI with interop
implementation("io.github.jlnstrk.transit:interop-hapi:0.1.0-SNAPSHOT")

// Get just EFA
implementation("io.github.jlnstrk.transit:api-efa:0.1.0-SNAPSHOT")
// Get EFA with interop
implementation("io.github.jlnstrk.transit:interop-efa:0.1.0-SNAPSHOT")

// Get just TRIAS
implementation("io.github.jlnstrk.transit:api-trias:0.1.0-SNAPSHOT")
// Get TRIAS with interop
implementation("io.github.jlnstrk.transit:interop-trias:0.1.0-SNAPSHOT")
```