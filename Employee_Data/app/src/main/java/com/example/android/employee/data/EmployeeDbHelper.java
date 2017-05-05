/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.employee.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class EmployeeDbHelper extends SQLiteOpenHelper {
    public static final String LOG_TAG = EmployeeDbHelper.class.getSimpleName();

    private static final String DATABASE_NAME = "employee.db";
    private static final int DATABASE_VERSION = 1;
    public EmployeeDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

            // Create a String that contains the SQL statement to create the pets table
            String SQL_CREATE_EMPLOYEE_TABLE =  "CREATE TABLE " + EmployeeContract.EmployeeEntry.TABLE_NAME+ " ("
                    + EmployeeContract.EmployeeEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + EmployeeContract.EmployeeEntry.COLUMN_EMPLOYEE_NAME + " TEXT NOT NULL, "
                    + EmployeeContract.EmployeeEntry.COLUMN_EMPLOYEE_SIRNAME + " TEXT, "
                    + EmployeeContract.EmployeeEntry.COLUMN_EMPLOYEE_DATE + " TEXT, "
                    + EmployeeContract.EmployeeEntry.COLUMN_EMPLOYEE_GENDER + " INTEGER NOT NULL, "
                    + EmployeeContract.EmployeeEntry.COLUMN_EMPLOYEE_EMAIL + " TEXT );";

        db.execSQL(SQL_CREATE_EMPLOYEE_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // The database is still at version 1, so there's nothing to do be done here.
    }

}