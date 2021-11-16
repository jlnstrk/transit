---
title: Transit
---

# Transit

Transit is a [Kotlin Multiplatform](https://kotlinlang.org/docs/reference/multiplatform.html) library for consuming
public transport schedule data from providers.

So far, it offers API bindings for the following popular journey planner systems:

- [HAFAS HCI](api/hci.md) (_HAFAS Client Interface_)
- [HAFAS HAPI](api/hapi.md) (_HAFAS REST_ or _OpenAPI_)
- [EFA](api/efa.md) (_Elektronische Fahrplanauskunft_)
- [TRIAS](api/trias.md) (_Travellors Realtime Information Advisory Standard_)

### What does this solve
Because of the heterogeneous landscape of journey planner systems in use, consuming these sort of APIs is hard.
Furthermore, if this is to be done across multiple systems in a unified way, things get especially complicated.

The biggest pain points usually are vendors' continued efforts to keep service documentation behind the curtain,
so it becomes a tedious process of reverse-engineering to get a working implementation of even a tiny subset of the
possible features.

Since public transport schedule data has uses on a range of platforms (Web, Mobile etc.), there exist
numerous implementations for the different platforms. Some of them are merely half-baked and vary in the supported
feature sets.
Most importantly, collecting public knowledge of closed-source APIs in a decentralized way, e.g. distributed over
platforms and repositories, does everything but expedite the process and the end result of generated documentation is
subpar.

Kotlin Multiplatform plays the crucial role here. It is a game changer in that it now allows to write API implementations once centrally,
but then build them for several platform targets so they can be used in the domain where the actual applications live.

### Credits
The following pioneer projects laid the necessary groundwork for this project. It wouldn't exist if not for these and
the people working on them.

- [public-transport-enabler](https://github.com/schildbach/public-transport-enabler)
- [hafas-client](https://github.com/public-transport/hafas-client)
- [BahnhofsAbfahrten](https://github.com/marudor/BahnhofsAbfahrten)