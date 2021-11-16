[![build](https://github.com/jlnstrk/transit/workflows/Assemble/badge.svg)](https://github.com/jlnstrk/transit/actions?query=workflow%3Assemble)
[![tests](https://github.com/jlnstrk/transit/workflows/Tests/badge.svg)](https://github.com/jlnstrk/transit/actions?query=workflow%3ATests)
[![license](https://img.shields.io/badge/license-Apache%202.0-blue.svg)](./LICENSE.md)
[![latest snapshot](https://img.shields.io/nexus/snapshots/https/oss.sonatype.org/io.github.jlnstrk.transit/transit.svg?label=latest%20snapshot")](https://oss.sonatype.org/content/repositories/snapshots/io/github/jlnstrk/transit/)
[![latest release](https://img.shields.io/maven-central/v/io.github.jlnstrk.transit/transit.svg?label=latest%20release")](https://search.maven.org/search?q=g:io.github.jlnstrk.transit)

# transit _[WIP]_

Transit is a [Kotlin Multiplatform](https://kotlinlang.org/docs/reference/multiplatform.html) library for consuming
public transport schedule data from providers.

For more information, have a look at the [docs](https://jlnstrk.github.io/transit).

## Feedback & Contributions

This library is in a very early stage. I'm happy to hear your feedback or design suggestions, just go open an issue!

If you want to contribute, these are the major TODOs right now:

- Finalize an initial interop API
- Add missing HCI services
- Get TRIAS running
  - Set up model generation from XSD as build task
- Better test coverage for API services
- Interop services
- Tests for interop modules