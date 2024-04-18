package com.example.testingtesting123

import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class UniqueCollectionTest {

    lateinit var collection: UniqueCollection

    @Before
    fun setUp() {
        collection = UniqueCollection()
    }

    @Test
    fun addAnItem() {
        collection.addItem(Item("Item1"))
        val item = collection.get(0)
        assert(item.name == "Item1")
    }

    @Test
    fun addUniqueItem() {
        collection.addItem(Item("Item1"))
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        assert (collection.size() == 2)
    }

    @Test
    fun clearAllItems() {
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        val originalSize = collection.size()
        collection.clear()
        val newSize = collection.size();

        assert(originalSize == 2 && newSize == 0) {"Items not cleared"}
    }

    @Test
    fun getItemInCollection() {
        val i = Item("Item1")
        assert(collection.get(0) == i) {"No items in list to get"}
        collection.addItem(i)

        assert(collection.get(0) == i) {"Item is retrieved properly"}

        assert(collection.get(8) == i) {"Item out of bounds cannot be removed"}
    }

    @Test
    fun getWrongItemInCollection() {
        val first = Item("One")
        val second = Item("Two")

        collection.addItem(first)
        collection.addItem(second)

        assert(collection.get(0) != second && collection.get(1) == second) {"Gets correct item"}
    }

    @Test
    fun removeItemInCollection() {
        val i = Item("Item")

        collection.addItem(i)
        collection.remove(Item("Test"))
        assert(collection.size() == 0) {"Item Removed"}
    }

    @Test
    fun removeWrongItem() {

    }

}