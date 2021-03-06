## BoxedJson

[TOC levels=3,6]: # "Version History"

### Version History
- [0.5.18](#0518)
- [0.5.16](#0516)
- [0.5.14](#0514)
- [0.5.12](#0512)
- [0.5.10](#0510)
- [0.5.8](#058)
- [0.5.6](#056)


### 0.5.18

* Fix: bump up javax/json to 1.1.4

### 0.5.16

* Fix: add missing MutableJsArray `add()` by Java type.

### 0.5.14

* Fix: add constructor for `Map<String, JsonValue>` to `MutableJsObject()`

### 0.5.12

* Fix: add constructor for `List<? extends JsonValue>` `MutableJsArray(JsonArray)` constructor

### 0.5.10

* Fix: add missing public keyword on `MutableJsArray(JsonArray)` constructor

### 0.5.8

* Add: `MutableJson.copyOf(JsonValue)` and `BoxedJson.copyOf(JsonValue)` methods to make deep
  copies of passed in values.
* Add: `float` versions of methods where `double` was available
* Add: `isTrue(boolean defaultValue)` and `isFalse(boolean defaultValue)` to allow specifying a
  default value if the `BoxedJsValue` object is invalid.
* Add: methods for eval of specific types that take default values if the result of eval is
  invalid. ie. `evalInt(String)` now also `evalInt(String, int)`, same for other eval types

### 0.5.6

* First working maven version

