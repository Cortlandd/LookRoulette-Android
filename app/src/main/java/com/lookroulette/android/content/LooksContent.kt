package com.lookroulette.android.content

import com.lookroulette.android.R
import java.util.*

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object LooksContent {

    /**
     * An array of Look items.
     */
    val ITEMS: MutableList<LookItem> = ArrayList()

    /**
     * A map of sample Look items, by ID.
     */
    val ITEM_MAP: MutableMap<String, LookItem> = HashMap()

    private val COUNT = 3

    init {
        // Add some sample items.
        //for (i in 1..COUNT) {  }
        ITEMS.add(LookItem(Random().nextInt(10).toString(), "https://youtube.com", R.drawable.example1))
        ITEMS.add(LookItem(Random().nextInt(10).toString(), "https://youtube.com", R.drawable.example2))
        ITEMS.add(LookItem(Random().nextInt(10).toString(), "https://youtube.com", R.drawable.example3))
        ITEMS.add(LookItem(Random().nextInt(10).toString(), "https://youtube.com", R.drawable.example3))

    }

    private fun addItem(item: LookItem) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id, item)
    }

    private fun createLookItem(position: Int): LookItem {
        return LookItem(position.toString(), "Item " + position, null)
    }

    private fun makeDetails(position: Int): String {
        val builder = StringBuilder()
        builder.append("Details about Item: ").append(position)
        for (i in 0..position - 1) {
            builder.append("\nMore details information here.")
        }
        return builder.toString()
    }

    /**
     * A Look item representing a piece of content.
     */
    data class LookItem(val id: String, val youtubeURL: String, val youtubeThumbnail: Int?) {
        override fun toString(): String = youtubeURL
    }
}