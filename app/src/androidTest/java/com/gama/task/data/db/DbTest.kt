package com.gama.saudi2go.data.db


import androidx.arch.core.executor.testing.CountingTaskExecutorRule
import org.junit.Rule

abstract class DbTest {
    @Rule
    @JvmField
    val countingTaskExecutorRule = CountingTaskExecutorRule()

//    private lateinit var _db: Saudi2GoDb
//
//    val db: Saudi2GoDb
//        get() = _db
//
//    @Before
//    fun initDb() {
//        _db = Room.inMemoryDatabaseBuilder(
//            ApplicationProvider.getApplicationContext(),
//            Saudi2GoDb::class.java
//        ).build()
//    }
//
//    @After
//    fun closeDb() {
//        countingTaskExecutorRule.drainTasks(15, TimeUnit.SECONDS)
//        _db.close()
//    }
}
