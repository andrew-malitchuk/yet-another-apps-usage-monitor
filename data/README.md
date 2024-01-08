# YAAUM

## :data

The data layer serves as the bridge between the application and its data sources, such as databases,
network services, or local storage.

It is designed to provide a clean and modular approach to handling data, ensuring maintainability
and flexibility.

### Components 

#### :data:core

Base module; contains artifacts (such as exceptions) which are widely used in the data-layer.

#### :data:source

Set of sources for data. 

#### :data:repository

Aggregator over the [:data:source](source); centralizes the data access logic in one place.

