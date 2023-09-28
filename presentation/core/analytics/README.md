# YAAUM

## :presentation:core:analytics

This module contains subscriber-publisher pattern implementation for analytics.

__Subscriber__ - analytics source (Firebase, HTTP client, etc).

__Publisher__ - events aggregator - sent generic analytic event to all _subscribers_.

### :presentation:core:analytics:core

Contains base models for analytics artifact.

[BaseAnalyticModel](core%2Fsrc%2Fmain%2Fkotlin%2Fdev%2Fyaaum%2Fpresentation%2Fcore%2Fanalytics%2Fcore%2Fmodel%2Fbase%2FBaseAnalyticModel.kt) -
represent generic analytic event.

[BaseAnalyticEvent](core%2Fsrc%2Fmain%2Fkotlin%2Fdev%2Fyaaum%2Fpresentation%2Fcore%2Fanalytics%2Fcore%2Fmodel%2Fbase%2FBaseAnalyticEvent.kt) -
top of event hierarchy; stores event name and set of key-values.

[BaseAnalyticProperty](core%2Fsrc%2Fmain%2Fkotlin%2Fdev%2Fyaaum%2Fpresentation%2Fcore%2Fanalytics%2Fcore%2Fmodel%2Fbase%2FBaseAnalyticProperty.kt) -
represent some kind of analytics properties like age, gender etc.

### :presentation:core:analytics:logger

The main goal is to provide DSL way to log events.

### :presentation:core:analytics:publisher

Publisher abstraction & implementation.

### :presentation:core:analytics:subscriber

Subscriber abstraction & implementation for each service.
