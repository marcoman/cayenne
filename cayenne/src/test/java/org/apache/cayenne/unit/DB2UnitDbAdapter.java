/*****************************************************************
 *   Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    https://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 ****************************************************************/


package org.apache.cayenne.unit;

import java.sql.Connection;
import java.util.Collection;

import org.apache.cayenne.dba.DbAdapter;
import org.apache.cayenne.map.DataMap;

/**
 */
public class DB2UnitDbAdapter extends UnitDbAdapter {

    public DB2UnitDbAdapter(DbAdapter adapter) {
        super(adapter);
    }
    
    @Override
    public void willDropTables(Connection conn, DataMap map, Collection tablesToDrop) throws Exception {
        // avoid dropping constraints...  
    }

    @Override
    public boolean supportsBinaryPK() {
        return false;
    }

    @Override
    public boolean supportsLobs() {
        return true;
    }

    @Override
    public boolean supportsStoredProcedures() {
        return false;
    }

    @Override
    public boolean supportsGeneratedKeysDrop() {
        return true;
    }

    @Override
    public boolean supportsGeneratedKeysAdd() {
        return true;
    }

    @Override
    public boolean supportsExpressionInHaving() {
        return false;
    }

    @Override
    public boolean supportsSelectBooleanExpression() {
        return false;
    }

    @Override
    public boolean supportsPreciseTime() {
        return false;
    }
}
