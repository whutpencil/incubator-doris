// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package org.apache.doris.datasource.paimon;

import org.apache.doris.catalog.Column;
import org.apache.doris.datasource.SchemaCacheValue;

import org.apache.paimon.table.Table;

import java.util.List;

public class PaimonSchemaCacheValue extends SchemaCacheValue {

    private Table paimonTable;
    private List<Column> partitionColumns;
    private PaimonPartitionInfo partitionInfo;

    private long snapshootId;

    public PaimonSchemaCacheValue(List<Column> schema, List<Column> partitionColumns, Table paimonTable,
            long snapshootId,
            PaimonPartitionInfo partitionInfo) {
        super(schema);
        this.partitionColumns = partitionColumns;
        this.paimonTable = paimonTable;
        this.snapshootId = snapshootId;
        this.partitionInfo = partitionInfo;
    }

    public Table getPaimonTable() {
        return paimonTable;
    }

    public List<Column> getPartitionColumns() {
        return partitionColumns;
    }

    public PaimonPartitionInfo getPartitionInfo() {
        return partitionInfo;
    }

    public long getSnapshootId() {
        return snapshootId;
    }
}
