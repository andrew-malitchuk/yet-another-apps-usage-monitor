# YAAUM

## :presentation:core:navigation

### General info

For multi-modular navigation in this Jetpack Compose
application, [Voyager](https://voyager.adriel.cafe/).

This module (`:presentation:core:navigation`) contains navigation
graph ([RouteGraph](src%2Fmain%2Fkotlin%2Fdev%2Fyaaum%2Fnavigation%2FRouteGraph.kt)).

`RouteGraph` is a root of graph. Each feature (e.g. `:presentation:feature:onboarding`) is a leaf.
Each leaf (aka feature) can has own nested graph.

### Navigation from feature to feature

To navigate from one feature to another you have to:

- add new leaf in ([RouteGraph](src%2Fmain%2Fkotlin%2Fdev%2Fyaaum%2Fnavigation%2FRouteGraph.kt));
- in your feature module, you have to specify `screenModule`;
- feature-level `screenModule` has to added
  in [HostRoute](..%2F..%2Ffeature%2Fhost%2Fsrc%2Fmain%2Fkotlin%2Fdev%2Fyaaum%2Fhost%2Fnavigation%2FHostRoute.kt) (`:presentation:feaure:host`);
- `HostRoute().init()` has to be called in Application class.

### Graph overview

Here is a navigation graph represented as a interaction overview diagram.

TODO: add interaction overview diagram

### Package dependency overview

Dependencies between navigation-related stuff specified in a package diagram.

TODO: add package diagram

## References

- https://voyager.adriel.cafe
