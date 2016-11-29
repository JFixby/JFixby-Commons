
package com.jfixby.cmns.db.mysql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jfixby.cmns.api.collections.Collection;
import com.jfixby.cmns.api.collections.Collections;
import com.jfixby.cmns.api.collections.List;

public class MySQLTableSchema {

	private final MySQLTable mySQLTable;
	private final List<String> columns = Collections.newList();
	private boolean loaded = false;

	public MySQLTableSchema (final MySQLTable mySQLTable) {
		this.mySQLTable = mySQLTable;
	}

	void load () throws SQLException {
		// --- LISTING DATABASE COLUMN NAMES ---
		final MySQLConnection connection = this.mySQLTable.db.obtainConnection();
		final Connection mysql_connection = connection.getConnection();
		final DatabaseMetaData meta = mysql_connection.getMetaData();
		final ResultSet resultSet = meta.getColumns(this.mySQLTable.db.getDBName(), null, this.mySQLTable.sql_table_name, "%");
		while (resultSet.next()) {
			this.columns.add(resultSet.getString(4));
// log.info("Column Name of table " + tableName + " = " + );
		}
		this.loaded = true;
		this.mySQLTable.db.releaseConnection(connection);
	}

	public Collection<String> getColumns () throws SQLException {
		this.loadIfNotLoaded();
		return this.columns;
	}

	public MySQLTableSchema loadIfNotLoaded () throws SQLException {
		if (this.loaded) {
			return this;
		}
		this.load();
		return this;
	}

	public void print () {
		this.columns.print("schema");
	}

	public int indexOf (final String key) throws SQLException {
		final int result = this.columns.indexOf(key);
		if (result == -1) {
			this.print();
			throw new SQLException("key not found " + key);
		}
		return result;
	}

}
