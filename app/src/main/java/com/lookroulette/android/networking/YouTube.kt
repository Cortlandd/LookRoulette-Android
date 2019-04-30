package com.lookroulette.android.networking

import android.content.res.Resources
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.gson.responseObject
import com.github.kittinunf.result.Result
import android.R
import android.util.Log
import com.lookroulette.android.model.YouTubeSearchResponse
import com.lookroulette.android.model.YouTubeVideoResponse
import com.lookroulette.android.util.Constants

open class YouTube {

    // Pure Imagination video: A-DuOmA75lI
    val constants = Constants()

    fun fetchVideoData(videoId: String) {

        var videoParams = listOf(
                "part" to "snippet",
                "id" to videoId,
                "key" to constants.apiKey
        )

        var (request, response, result) = Fuel.get(constants.youtubeVideoURL, videoParams).responseObject<YouTubeVideoResponse>()

        when (result) {
            is Result.Success -> {
                println("Success")
            }

            is Result.Failure -> {
                println("Error ")
            }
        }

    }

    fun fetchRelatedVideos(videoId: String) {

        var relatedVideoParams = listOf(
                "key" to constants.apiKey,
                "relatedToVideoId" to videoId,
                "part" to "id, snippet",
                "type" to "video"
        )

        // HTTP Request. Calling on NONE blocking mode in
        val (request, response, result) = Fuel.get(constants.youtubeSearchURL, relatedVideoParams).responseObject<YouTubeSearchResponse>()

        when (result) {

            is Result.Success -> {

            }

            is Result.Failure -> {

            }

        }


    }

}