package com.cameloper.jUbar;

/**
 * Type used to pass results around
 * @param <T> Type of the result value
 */
class Result<T> {
    private static final String PARAMETER_STRING = "&p";
    /**
     * Value of result, if successful
     */
    final T value;
    /**
     * The reason result is not successful or a warning
     */
    final Error error;

    /**
     * Parameter that will replace &p (if exists) in error message
     */
    String errorParameter = "";

    /**
     * Constructor for {@link Result}
     *
     * @param value result value
     * @param error first error that occurred
     */
    Result(T value, Error error) {
        this.value = value;
        this.error = error;
    }

    /**
     * Constructor for {@link Result}
     *
     * @param value result value
     * @param error first error that occurred
     * @param errorParameter Error parameter
     */
    Result(T value, Error error, String errorParameter) {
        this.value = value;
        this.error = error;
        this.errorParameter = errorParameter == null ? "" : errorParameter;
    }

    /**
     * Gives the user-friendly error message with parameters
     *
     * @return Display message for current error
     */
    String errorMessage() {
        if (error == null) return null;

        return error.toString().replaceAll(PARAMETER_STRING, errorParameter);
    }

    /**
     * Boolean method whether the operation should be considered as successful or not
     *
     * @return boolean isSuccessful
     */
    boolean isSuccessful() {
        return value != null || error == null;
    }
}