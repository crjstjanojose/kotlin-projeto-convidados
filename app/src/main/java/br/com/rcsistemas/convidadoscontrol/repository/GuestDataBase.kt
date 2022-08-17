package br.com.rcsistemas.convidadoscontrol.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import br.com.rcsistemas.convidadoscontrol.constants.DataBaseConstants

class GuestDataBase(context: Context) : SQLiteOpenHelper(context, NAME, null, VERSION) {

    companion object {
        private const val NAME = "guestdb"
        private const val VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        // CRIACAO DO BANCO DE DADOS
        db.execSQL(
            "CREATE TABLE " + DataBaseConstants.GUEST.TABLE_NAME + " (" +
                    DataBaseConstants.GUEST.COLUMNS.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    DataBaseConstants.GUEST.COLUMNS.NAME + " TEXT, " +
                    DataBaseConstants.GUEST.COLUMNS.PRESENCE + " INTEGER);"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

        // ATUALIZACAO DO BANCO DE DADOS É EXECUTADA AQUI NESTE METODO

        if (oldVersion == 1) {
            when (newVersion) {
                2 -> {
                    // ATUALIZACAO DO BANCO DE DADOS
                }
                3 -> {
                    // ATUALIZACAO DO BANCO DE DADOS
                }
                else -> {
                    // ATUALIZACAO DO BANCO DE DADOS
                }
            }
        }
    }

}