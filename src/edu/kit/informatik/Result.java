package edu.kit.informatik;

/**
 * Type used to pass results around
 * @param <T> Type of the result value
 */
class Result<T> {
    /**
     * Value of result, if successful
     */
    final T value;
    /**
     * The reason result is not successful or a warning
     */
    final Error error;

    /**
     * Constructor for {@link Result}
     *
     * @param value result value
     * @param error first error that occured
     */
    Result(T value, Error error) {
        this.value = value;
        this.error = error;
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