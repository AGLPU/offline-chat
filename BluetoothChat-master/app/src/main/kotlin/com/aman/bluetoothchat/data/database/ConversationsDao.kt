package com.aman.bluetoothchat.data.database

import android.arch.persistence.room.*
import com.aman.bluetoothchat.data.entity.Conversation
import com.aman.bluetoothchat.data.entity.ConversationWithMessages

@Dao
interface ConversationsDao {

    @Query("SELECT * FROM conversation")
    fun getContacts(): List<Conversation>

    @Transaction
    @Query("SELECT * FROM conversation")
    fun getAllConversationsWithMessages(): List<ConversationWithMessages>

    @Query("SELECT * FROM conversation WHERE address = :address")
    fun getConversationByAddress(address: String): Conversation?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(conversations: Conversation)

    @Query("DELETE FROM conversation WHERE address = :address")
    fun delete(address: String)
}
