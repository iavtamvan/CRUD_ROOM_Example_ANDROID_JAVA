package com.example.root.crud_room.Room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by khoiron on 16/01/18.
 */
@Dao
public interface MahasiswaDao {

    @Query("SELECT * FROM mahasiswa")
    List<Mahasiswa> getAll();

    @Query("SELECT * FROM mahasiswa WHERE token LIKE :token ")
    Mahasiswa findByName(String token);

    @Query("DELETE FROM mahasiswa WHERE token =:token ")
    void hapus(String token);

    @Query("UPDATE mahasiswa SET nama =:nama, npm=:npm WHERE token=:token")
    void updateMhs(String nama, String npm, String token);


// TODO tambahan saja bawah ini
    @Insert
    void insertAll(Mahasiswa mahasiswa);

//    @Delete
//    public void deleteUsers(Mahasiswa users);
//
//    @Update
//    public void update(Mahasiswa mahasiswa);
//
//    @Delete
//    public void deleteAll(Mahasiswa user1, Mahasiswa user2);

}
