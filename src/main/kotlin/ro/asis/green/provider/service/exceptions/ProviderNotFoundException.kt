package ro.asis.green.provider.service.exceptions

import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ProviderControllerAdvice {
    @ExceptionHandler(ProviderNotFoundException::class)
    @ResponseStatus(NOT_FOUND)
    fun handleProviderNotFoundException(exception: ProviderNotFoundException): ApiError =
        ApiError(exception.localizedMessage)
}

data class ApiError(val message: String)

class ProviderNotFoundException(message: String?) : RuntimeException(message)
