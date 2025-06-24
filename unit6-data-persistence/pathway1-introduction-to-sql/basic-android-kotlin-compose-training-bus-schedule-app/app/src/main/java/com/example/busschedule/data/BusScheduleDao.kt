package com.example.busschedule.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BusScheduleDao {
    @Query("select * from Schedule")
    fun getAllBusSchedule(): Flow<List<BusSchedule>>

    @Query("select * from Schedule where stop_name = :stopName")
    fun getBusScheduleByStopName(stopName: String): Flow<List<BusSchedule>>
}