package com.lookroulette.android.model

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson

data class YouTubeResponse(val items: ArrayList<Items>) {

    class Deserializer: ResponseDeserializable<YouTubeResponse> {
        override fun deserialize(content: String): YouTubeResponse? = Gson().fromJson(content, YouTubeResponse::class.java)

    }

}

data class Items(val id: Id) {

    class Deserializer: ResponseDeserializable<Items> {
        override fun deserialize(content: String): Items? = Gson().fromJson(content, Items::class.java)
    }

}

data class Id(var videoId: String) {

    class Deserializer: ResponseDeserializable<Id> {
        override fun deserialize(content: String): Id? = Gson().fromJson(content, Id::class.java)
    }

}


data class Thumbnails(val medium: Medium) {

    class Deserializer: ResponseDeserializable<Thumbnails> {
        override fun deserialize(content: String): Thumbnails? = Gson().fromJson(content, Thumbnails::class.java)
    }

}

data class Medium(val url: String) {

    class Deserializer: ResponseDeserializable<Medium> {
        override fun deserialize(content: String): Medium? = Gson().fromJson(content, Medium::class.java)
    }

}


/**
 * Response represents Youtube Video list API Response.
 *
 * Information from: https://developers.google.com/youtube/v3/docs/videos/list
 */
data class YouTubeVideoResponse(val snippet: Snippet) {

    class Deserializer: ResponseDeserializable<YouTubeVideoResponse> {
        override fun deserialize(content: String): YouTubeVideoResponse? = Gson().fromJson(content, YouTubeVideoResponse::class.java)
    }

}

data class Snippet(val title: String, val description: String, val tags: Array<String>) {

    class Deserializer: ResponseDeserializable<Snippet> {
        override fun deserialize(content: String): Snippet? = Gson().fromJson(content, Snippet::class.java)
    }

}