package com.gildedrose

class GildedRose(val items: List<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            val item = items[i]
            when (item.name){
                "Aged Brie" -> updateAgedBrie(item)
                "Sulfuras, Hand of Ragnaros" -> updateSulfuras(item)
                "Backstage passes to a TAFKAL80ETC concert" -> updateBackstage(item)
                else -> updateItemQuality(item)
            }
        }
    }

    private fun updateItemQuality(item: Item) {
        if (item.quality > 0) item.quality--
            item.sellIn--

        if (item.sellIn < 0 && item.quality > 0) item.quality--
    }

    private fun updateAgedBrie(item: Item) {
        if (item.name != "Aged Brie") return

        if (item.quality < 50) item.quality++
        item.sellIn--

        if (item.sellIn < 0 && item.quality < 50) item.quality++

    }

    private fun updateSulfuras(item: Item) {
        if (item.name != "Sulfuras, Hand of Ragnaros") return

        if (item.quality < 50) item.quality++
    }

    private fun updateBackstage(item: Item) {
        if (item.name != "Backstage passes to a TAFKAL80ETC concert") return

        if (item.quality < 50) {
            item.quality++

                if (item.sellIn < 11 && item.quality < 50) item.quality++

                if (item.sellIn < 6 && item.quality < 50) item.quality++
        }

        item.sellIn--

        if (item.sellIn < 0) {
            item.quality = 0
        }

    }


}

