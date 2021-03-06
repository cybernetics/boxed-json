package com.vladsch.boxed.json;

import javax.json.*;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;

public class MutableJsArray extends AbstractList<JsonValue> implements JsonArray, MutableJsValue {
    private final MutableJsList myList;

    public MutableJsArray() {
        myList = new MutableJsList();
    }

    public MutableJsArray(int initialSize) {
        myList = new MutableJsList(initialSize);
    }

    public MutableJsArray(JsonArray other) {
        myList = new MutableJsList(other);
    }

    public MutableJsArray(final List<? extends JsonValue> other) {
        myList = new MutableJsList(other);
    }

    public int size() {
        return myList.size();
    }

    @Override
    public JsonValue get(final int index) {
        return myList.get(index);
    }

    public JsonObject getJsonObject(int index) {
        return (JsonObject) get(index);
    }

    public JsonArray getJsonArray(int index) {
        return (JsonArray) get(index);
    }

    public JsonNumber getJsonNumber(int index) {
        return (JsonNumber) myList.getRaw(index);
    }

    public JsonString getJsonString(int index) {
        return (JsonString) myList.getRaw(index);
    }

    public <T extends JsonValue> List<T> getValuesAs(Class<T> clazz) {
        return (List<T>) myList;
    }

    public String getString(int index) {
        return getJsonString(index).getString();
    }

    public String getString(int index, String defaultValue) {
        try {
            return getString(index);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public int getInt(int index) {
        return getJsonNumber(index).intValue();
    }

    public int getInt(int index, int defaultValue) {
        try {
            return getInt(index);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public boolean getBoolean(int index) {
        JsonValue jsonValue = myList.getRaw(index);
        if (jsonValue == JsonValue.TRUE) {
            return true;
        } else if (jsonValue == JsonValue.FALSE) {
            return false;
        } else {
            throw new ClassCastException();
        }
    }

    public boolean getBoolean(int index, boolean defaultValue) {
        try {
            return getBoolean(index);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public boolean isNull(int index) {
        return myList.get(index).equals(JsonValue.NULL);
    }

    public ValueType getValueType() {
        return ValueType.ARRAY;
    }

    public String toString() {
        StringWriter sw = new StringWriter();
        JsonWriter jw = Json.createWriter(sw);
        jw.writeArray(this);
        jw.close();
        return sw.toString();
    }

    public JsonValue getRaw(final int index) {return myList.getRaw(index);}

    @Override
    public void add(final int index, final JsonValue element) {myList.add(index, element);}

    public JsonValue set(final int index, final JsonValue element) {return myList.set(index, element);}

    public boolean add(final JsonValue o) {return myList.add(o);}

    public JsonValue set(final int index, int value) { return set(index, JsNumber.of(value)); }
    public JsonValue set(final int index, long value) { return set(index, JsNumber.of(value)); }
    public JsonValue set(final int index, BigInteger value) { return set(index, JsNumber.of(value)); }
    public JsonValue set(final int index, double value) { return set(index, JsNumber.of(value)); }
    public JsonValue set(final int index, BigDecimal value) { return set(index, JsNumber.of(value)); }
    public JsonValue set(final int index, String value) { return set(index, JsString.of(value)); }
    public JsonValue set(final int index, boolean value) { return set(index, value ? JsonValue.TRUE : JsonValue.FALSE); }
    public JsonValue setNull(final int index) { return set(index, JsonValue.NULL); }

    public JsonValue add(final int index, int value) { return set(index, JsNumber.of(value)); }
    public JsonValue add(final int index, long value) { return set(index, JsNumber.of(value)); }
    public JsonValue add(final int index, BigInteger value) { return set(index, JsNumber.of(value)); }
    public JsonValue add(final int index, double value) { return set(index, JsNumber.of(value)); }
    public JsonValue add(final int index, BigDecimal value) { return set(index, JsNumber.of(value)); }
    public JsonValue add(final int index, String value) { return set(index, JsString.of(value)); }
    public JsonValue add(final int index, boolean value) { return set(index, value ? JsonValue.TRUE : JsonValue.FALSE); }
    public JsonValue addNull(final int index) { return set(index, JsonValue.NULL); }

    public JsonValue add(int value) { myList.add(JsNumber.of(value)); return this; }
    public JsonValue add(long value) { myList.add(JsNumber.of(value)); return this; }
    public JsonValue add(BigInteger value) { myList.add(JsNumber.of(value)); return this; }
    public JsonValue add(double value) { myList.add(JsNumber.of(value)); return this; }
    public JsonValue add(BigDecimal value) { myList.add(JsNumber.of(value)); return this; }
    public JsonValue add(String value) { myList.add(JsString.of(value)); return this; }
    public JsonValue add(boolean value) { myList.add(value ? JsonValue.TRUE : JsonValue.FALSE); return this; }
    public JsonValue addNull() { myList.add(JsonValue.NULL); return this; }
}
