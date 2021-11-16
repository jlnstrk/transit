@file:Suppress("NOTHING_TO_INLINE")

package de.jlnstrk.transit.util.response.base

public sealed class ServiceResult<in R, in E> {

    public data class Success<R> @PublishedApi internal constructor(
        val result: R
    ) : ServiceResult<R, Any>()

    public object NoResult : ServiceResult<Any, Any>()

    public data class Failure<E> @PublishedApi internal constructor(
        val exception: Exception?,
        val error: E?,
        val message: String?
    ) : ServiceResult<Any, E>()

    public interface Data

    public companion object {

        public inline fun <R : Data> success(result: R): ServiceResult<R, Any> = Success(result)

        public inline fun noResult(): ServiceResult<Any, Any> = NoResult

        public inline fun <E : Enum<E>> failure(
            exception: Exception? = null,
            error: E? = null,
            message: String? = null
        ): ServiceResult<Any, E> = Failure(exception, error, message)
    }
}