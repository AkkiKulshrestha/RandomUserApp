package com.example.randomuser.utils.wrappers

import com.example.randomuser.model.network.Response
import io.ktor.client.features.*
import java.net.UnknownHostException

suspend fun <T> safeCall(block: suspend () -> Response<T>): Response<T> {
    return try {
        block.invoke()
    } catch (e: UnknownHostException) {
        e.printStackTrace()
        Response.UnknownHostException()
    } catch (e: RedirectResponseException) {
        e.printStackTrace()
        Response.InvalidPathException()
    } catch (e: ClientRequestException) {
        e.printStackTrace()
        Response.InvalidRequestException()
    } catch (e: ServerResponseException) {
        e.printStackTrace()
        Response.ServerException()
    } catch (e: Exception) {
        e.printStackTrace()
        Response.UnknownException()
    }
}