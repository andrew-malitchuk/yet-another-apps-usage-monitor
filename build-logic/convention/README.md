# YAAUM

## :build-logic:convention

To improve code maintenance, a number of plugins have been developed.

They are grouped by subject area:

- Android application [+Compose];
- Android features [+Compose];
- Android tests (aka integration tests);
- Kotlin library;
- Unit tests;
- some other plugins for code smell reducing.

### Convention plugins

#### Android

##### AndroidApplicationConventionPlugin

[AndroidApplicationConventionPlugin](src%2Fmain%2Fkotlin%2Fdev%2Fyaaum%2Fconvention%2Fconventionplugin%2Fandroid%2FAndroidApplicationConventionPlugin.kt) -
contains all specific stuff for project-level configuration, like, compile sdk, target sdk, version
code... etc.

##### AndroidApplicationComposeConventionPlugin

[AndroidApplicationConventionPlugin](src%2Fmain%2Fkotlin%2Fdev%2Fyaaum%2Fconvention%2Fconventionplugin%2Fandroid%2FAndroidApplicationConventionPlugin.kt) = [AndroidApplicationConventionPlugin](src%2Fmain%2Fkotlin%2Fdev%2Fyaaum%2Fconvention%2Fconventionplugin%2Fandroid%2FAndroidApplicationConventionPlugin.kt) +
Compose related stuff.

##### AndroidFeatureConventionPlugin

[AndroidFeatureConventionPlugin](src%2Fmain%2Fkotlin%2Fdev%2Fyaaum%2Fconvention%2Fconventionplugin%2Fandroid%2FAndroidFeatureConventionPlugin.kt) -
contains default re-usable configuration for feature-module.

##### AndroidFeatureComposeConventionPlugin

[AndroidFeatureComposeConventionPlugin](src%2Fmain%2Fkotlin%2Fdev%2Fyaaum%2Fconvention%2Fconventionplugin%2Fandroid%2FAndroidFeatureComposeConventionPlugin.kt) = [AndroidFeatureConventionPlugin](src%2Fmain%2Fkotlin%2Fdev%2Fyaaum%2Fconvention%2Fconventionplugin%2Fandroid%2FAndroidFeatureConventionPlugin.kt) +
Compose

##### AndroidTestConventionPlugin

[AndroidTestConventionPlugin](src%2Fmain%2Fkotlin%2Fdev%2Fyaaum%2Fconvention%2Fconventionplugin%2Fandroid%2FAndroidTestConventionPlugin.kt) -
configuration for integration test (aka Android-platform tests).

#### Kotlin

##### KotlinLibraryConventionPlugin

[KotlinLibraryConventionPlugin](src%2Fmain%2Fkotlin%2Fdev%2Fyaaum%2Fconvention%2Fconventionplugin%2Fkotlin%2FKotlinLibraryConventionPlugin.kt) -
in case, if you need configure module only with vanilla Kotlin.

##### KotlinTestConventionPlugin

[KotlinTestConventionPlugin](src%2Fmain%2Fkotlin%2Fdev%2Fyaaum%2Fconvention%2Fconventionplugin%2Fkotlin%2FKotlinTestConventionPlugin.kt) -
well, hypothetically you can use this plugin in case of unit-tests, where you don't need any Android
dependencies.

#### Common

##### DetektConventionPlugin

[DetektConventionPlugin](src%2Fmain%2Fkotlin%2Fdev%2Fyaaum%2Fconvention%2Fconventionplugin%2Fcommon%2FDetektConventionPlugin.kt) -
configuration for [Detekt](https://github.com/detekt/detekt)

##### KtlintConventionPlugin

[KtlintConventionPlugin](src%2Fmain%2Fkotlin%2Fdev%2Fyaaum%2Fconvention%2Fconventionplugin%2Fcommon%2FKtlintConventionPlugin.kt) -
configuration for [kotliner-gradle](https://github.com/jeremymailen/kotlinter-gradle)

### Project Configuration

All stuff for project-level configuration are located in:

- [ProjectConfig](src%2Fmain%2Fkotlin%2Fdev%2Fyaaum%2Fconvention%2Fconfig%2FProjectConfig.kt);
- [VersionConfig](src%2Fmain%2Fkotlin%2Fdev%2Fyaaum%2Fconvention%2Fconfig%2FVersionConfig.kt).