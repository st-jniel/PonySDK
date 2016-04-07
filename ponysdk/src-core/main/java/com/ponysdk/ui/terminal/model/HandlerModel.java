package com.ponysdk.ui.terminal.model;

public enum HandlerModel {

    HANDLER_DOM_HANDLER,
    HANDLER_EMBEDED_STREAM_REQUEST_HANDLER,
    HANDLER_BOOLEAN_VALUE_CHANGE_HANDLER,
    HANDLER_DATE_VALUE_CHANGE_HANDLER,
    HANDLER_KEY_SHOW_RANGE,
    HANDLER_CHANGE_HANDLER,
    HANDLER_POPUP_POSITION_CALLBACK,
    HANDLER_RESIZE_HANDLER,
    HANDLER_STRING_VALUE_CHANGE_HANDLER,
    HANDLER_COMMAND,
    HANDLER_BEFORE_SELECTION_HANDLER,
    HANDLER_SELECTION_HANDLER,
    HANDLER_STRING_SELECTION_HANDLER,
    HANDLER_STREAM_REQUEST_HANDLER,
    HANDLER_SHOW_RANGE,
    HANDLER_SUBMIT_COMPLETE_HANDLER,
    HANDLER_CLOSE_HANDLER,
    HANDLER_OPEN_HANDLER,
    HANDLER_SCHEDULER,
    HANDLER_KEY_SCHEDULER, // Not used ?
    HANDLER_KEY_RESIZE_HANDLER, // Not used ?
    HANDLER_KEY, // Not used ?
    HANDLER_KEY_COMMAND; // Not used ?;

    public String toStringValue() {
        return String.valueOf(ordinal());
    }

    public byte getValue() {
        return (byte) ordinal();
    }
}
