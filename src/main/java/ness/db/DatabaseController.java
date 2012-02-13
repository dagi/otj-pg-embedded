/**
 * Copyright (C) 2012 Ness Computing, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ness.db;


import org.skife.jdbi.v2.DBI;

import com.google.inject.Module;

/**
 * Allows creation and dropping of databases.
 */
public interface DatabaseController
{
    /**
     * Create the database in the database engine.
     */
    void create();

    /**
     * Remove the database from the database engine.
     */
    void drop();

    /**
     * Returns true if the database exists and can be accessed.
     * @return
     */
    boolean exists();

    /**
     * Returns a DBI connected to the database. The database must have been created before.
     * @return
     */
    DBI getDbi();

    /**
     * Return a Guice module to bind the database represented by this controller. The module will
     * be bound using the visibleName. If the database does not exist, it will be created.
     *
     * This is not the actual JDBC module! The JDBC module must still be bound. This module will modify
     * a JDBC module bound with the same name to point at the test database.
     *
     * @param visibleDbName The name used to bind all elements in the guice module. This is not the name of the physical database instance.
     * @return A guice module that can be installed.
     */
    Module getGuiceModule(String visibleDbName);
}