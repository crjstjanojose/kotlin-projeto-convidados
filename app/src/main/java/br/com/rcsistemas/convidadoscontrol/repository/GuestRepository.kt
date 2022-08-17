package br.com.rcsistemas.convidadoscontrol.repository

import android.content.ContentValues
import android.content.Context
import br.com.rcsistemas.convidadoscontrol.constants.DataBaseConstants
import br.com.rcsistemas.convidadoscontrol.model.GuestModel

class GuestRepository private constructor(context: Context) {

    private val guestDataBase = GuestDataBase(context)

    // SINGLETON
    companion object {

        private lateinit var repository: GuestRepository

        fun getInstance(context: Context): GuestRepository {
            if (!Companion::repository.isInitialized) {
                repository = GuestRepository(context)
            }
            return repository
        }
    }


    fun insert(guest: GuestModel): Boolean {

        return try {
            val db = guestDataBase.writableDatabase
            val presence = if (guest.presence) 1 else 0

            val values = ContentValues()
            values.put(DataBaseConstants.GUEST.COLUMNS.NAME, guest.name)
            values.put(DataBaseConstants.GUEST.COLUMNS.PRESENCE, presence)

            db.insert(DataBaseConstants.GUEST.TABLE_NAME, null, values)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun update() {}

}