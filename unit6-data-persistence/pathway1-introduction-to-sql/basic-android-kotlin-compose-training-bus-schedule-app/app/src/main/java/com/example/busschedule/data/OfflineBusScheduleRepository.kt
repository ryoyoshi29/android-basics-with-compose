package com.example.busschedule.data

import kotlinx.coroutines.flow.Flow

class OfflineBusScheduleRepository(private val itemDao: BusScheduleDao): BusScheduleRepository {
    override fun getAllBusSchedule(): Flow<List<BusSchedule>> {
        return itemDao.getAllBusSchedule()
    }

    override fun getBusScheduleByStopName(stopName: String): Flow<List<BusSchedule>> {
        return itemDao.getBusScheduleByStopName(stopName)
    }
}