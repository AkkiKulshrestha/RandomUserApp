package com.example.randomuser.utils

object Constants {

    const val RESULT_SIZE = 10

    private const val EMOJI_MONOCLE_FACE = "\uD83E\uDDD0"
    private const val EMOJI_TURTLE = "\uD83D\uDC22"
    private const val EMOJI_EXPLODING_HEAD = "\uD83E\uDD2F"
    private const val EMOJI_SPIRAL_EYES = "\uD83D\uDE35\u200D\uD83D\uDCAB"
    private const val THINKING_EMOJI = "\uD83E\uDD14"
    const val REQUEST_FAILED_MESSAGE = "Something went wrong... $THINKING_EMOJI"
    const val ERROR_MESSAGE_INVALID_PATH = "We couldn't find the data... $EMOJI_SPIRAL_EYES"
    const val ERROR_MESSAGE_INVALID_REQUEST = "Failed to process the request... $EMOJI_MONOCLE_FACE"
    const val ERROR_MESSAGE_SERVER_EXCEPTION =
        "Servers are down! Please try again later... $EMOJI_TURTLE"
    const val ERROR_MESSAGE_UNKNOWN = "Something went wrong... $EMOJI_EXPLODING_HEAD"
    const val NOT_AVAILABLE = "N/A"
}