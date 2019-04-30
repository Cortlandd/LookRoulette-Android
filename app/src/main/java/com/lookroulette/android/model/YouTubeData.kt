package com.lookroulette.android.model

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson

/*
* For better random results, return a video, and based on video chosen
* get related videos as opposed to whole results.
*/
data class YouTubeSearchResponse(val items: Array<Items>) {

    class Deserializer: ResponseDeserializable<YouTubeSearchResponse> {
        override fun deserialize(content: String): YouTubeSearchResponse? = Gson().fromJson(content, YouTubeSearchResponse::class.java)

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

}