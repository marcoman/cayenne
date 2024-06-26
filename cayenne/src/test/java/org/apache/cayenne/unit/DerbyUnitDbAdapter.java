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

import org.apache.cayenne.dba.DbAdapter;
import org.apache.cayenne.exp.parser.ASTExtract;

/**
 * 
 */
public class DerbyUnitDbAdapter extends UnitDbAdapter {

    static {
        // as of Derby 10.1 Alpha, this is needed for Mac OS X:
        // http://issues.apache.org/jira/browse/DERBY-1
        System.setProperty("derby.storage.fileSyncTransactionLog", "true");
    }

    public DerbyUnitDbAdapter(DbAdapter adapter) {
        super(adapter);
    }

    @Override
    public boolean supportsBinaryPK() {
        return false;
    }

    @Override
    public boolean supportsCaseInsensitiveOrder() {
        return false;
    }
    
    @Override
    public boolean supportsLobs() {
        return true;
    }

    @Override
    public boolean supportsExpressionInHaving() {
        return false;
    }

    @Override
    public boolean supportsExtractPart(ASTExtract.DateTimePart part) {
        switch (part) {
            case DAY_OF_YEAR:
            case DAY_OF_WEEK:
            case WEEK:
                return false;
        }
        return true;
    }

    @Override
    public boolean supportsLongIn() {
        return false;
    }

    @Override
    public boolean supportsNullComparison() {
        return false;
    }

    @Override
    public boolean supportsPreciseTime() {
        return false;
    }
}
