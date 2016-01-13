package esyt.framework.com.core.foundation.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;

import org.apache.commons.dbcp.DelegatingStatement;
import org.apache.commons.dbcp.PoolableConnection;

import dwz.cache.memcache.client.Logger;

/**
 * <p>Title:��װ Statement 创建自定义Statement</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2013</p>
 *
 * <p>Company: </p>
 *
 * @author ES
 * @version 1.0
 */
public class JStatement implements Statement {

	/**
	 * Statement
	 */
	private Statement statement;
	private PoolableConnection conn;
	public static int iCreateCount = 0;
	public static int mCloseCount = 0;
	protected static Logger logger = Logger.getLogger(JStatement.class.getName());
	
	public JStatement() {
		iCreateCount++;
	}

	public JStatement(PoolableConnection conn, Statement statement) {
		this.conn = conn;
		this.statement = statement;
		iCreateCount++;
	}
	
	public JStatement(Statement statement) {
		this.statement = statement;
		iCreateCount++;
	}

	public void addBatch(String sql) throws SQLException {
		logger.debug(sql);
		statement.addBatch(sql);
	}

	public void cancel() throws SQLException {
		statement.cancel();
	}

	public void clearBatch() throws SQLException {
		statement.clearBatch();
	}

	public void clearWarnings() throws SQLException {
		statement.clearWarnings();
	}

	public void close() throws SQLException {
		mCloseCount++;
		statement.close();
	}

	public boolean execute(String sql) throws SQLException {
		long t1 = System.currentTimeMillis();
		try {
			return statement.execute(sql);
		} finally {
			long t2 = System.currentTimeMillis();
			logger.debug(sql + " execute time:" + (t2 - t1));
		}
	}

	public boolean execute(String sql, int autoGeneratedKeys) throws SQLException {
		long t1 = System.currentTimeMillis();
		try {
			return statement.execute(sql, autoGeneratedKeys);
		} finally {
			long t2 = System.currentTimeMillis();
			logger.debug(sql + " execute time:" + (t2 - t1));
		}
	}

	public boolean execute(String sql, int[] columnIndexes) throws SQLException {
		long t1 = System.currentTimeMillis();
		try {
			return statement.execute(sql, columnIndexes);
		} finally {
			long t2 = System.currentTimeMillis();
			logger.debug(sql + " execute time:" + (t2 - t1));
		}
	}

	public boolean execute(String sql, String[] columnNames) throws SQLException {
		long t1 = System.currentTimeMillis();
		try {
			return statement.execute(sql, columnNames);
		} finally {
			long t2 = System.currentTimeMillis();
			logger.debug(sql + " execute time:" + (t2 - t1));
		}
	}

	public int[] executeBatch() throws SQLException {
		long t1 = System.currentTimeMillis();
		try {
			return statement.executeBatch();
		} finally {
			long t2 = System.currentTimeMillis();
			logger.debug("batch execute time:" + (t2 - t1));
		}

	}

	public ResultSet executeQuery(String sql) throws SQLException {
		long t1 = System.currentTimeMillis();
		try {
			return statement.executeQuery(sql);
		} finally {
			long t2 = System.currentTimeMillis();
			logger.debug(sql + " execute time:" + (t2 - t1));
		}
	}

	public int executeUpdate(String sql) throws SQLException {
		long t1 = System.currentTimeMillis();
		try {
			return statement.executeUpdate(sql);
		} finally {
			long t2 = System.currentTimeMillis();
			logger.debug(sql + " execute time:" + (t2 - t1));
		}
	}

	public int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
		long t1 = System.currentTimeMillis();
		try {
			return statement.executeUpdate(sql, autoGeneratedKeys);
		} finally {
			long t2 = System.currentTimeMillis();
			logger.debug(sql + " execute time:" + (t2 - t1));
		}
	}

	public int executeUpdate(String sql, int[] columnIndexes) throws SQLException {
		long t1 = System.currentTimeMillis();
		try {
			return statement.executeUpdate(sql, columnIndexes);
		} finally {
			long t2 = System.currentTimeMillis();
			logger.debug(sql + " execute time:" + (t2 - t1));
		}
	}

	public int executeUpdate(String sql, String[] columnNames) throws SQLException {
		long t1 = System.currentTimeMillis();
		try {
			return statement.executeUpdate(sql, columnNames);
		} finally {
			long t2 = System.currentTimeMillis();
			logger.debug(sql + " execute time:" + (t2 - t1));
		}
	}

	public Connection getConnection() throws SQLException {
		// return statement.getConnection();
		return this.conn;
	}

	public int getFetchDirection() throws SQLException {
		return statement.getFetchDirection();
	}

	public int getFetchSize() throws SQLException {
		return statement.getFetchSize();
	}

	public ResultSet getGeneratedKeys() throws SQLException {
		return statement.getGeneratedKeys();
	}

	public int getMaxFieldSize() throws SQLException {
		return statement.getMaxFieldSize();
	}

	public int getMaxRows() throws SQLException {
		return statement.getMaxRows();
	}

	public boolean getMoreResults() throws SQLException {
		return statement.getMoreResults();
	}

	public boolean getMoreResults(int current) throws SQLException {
		return statement.getMoreResults(current);
	}

	public int getQueryTimeout() throws SQLException {
		return statement.getQueryTimeout();
	}

	public ResultSet getResultSet() throws SQLException {
		return statement.getResultSet();
	}

	public int getResultSetConcurrency() throws SQLException {
		return statement.getResultSetConcurrency();
	}

	public int getResultSetHoldability() throws SQLException {
		return statement.getResultSetHoldability();
	}

	public int getResultSetType() throws SQLException {
		return statement.getResultSetType();
	}

	public int getUpdateCount() throws SQLException {
		return statement.getUpdateCount();
	}

	public SQLWarning getWarnings() throws SQLException {
		return statement.getWarnings();
	}

	public void setCursorName(String name) throws SQLException {
		statement.setCursorName(name);
	}

	public void setEscapeProcessing(boolean enable) throws SQLException {
		statement.setEscapeProcessing(enable);
	}

	public void setFetchDirection(int direction) throws SQLException {
		statement.setFetchDirection(direction);
	}

	public void setFetchSize(int rows) throws SQLException {
		statement.setFetchSize(rows);
	}

	public void setMaxFieldSize(int max) throws SQLException {
		statement.setMaxFieldSize(max);
	}

	public void setMaxRows(int max) throws SQLException {
		statement.setMaxRows(max);
	}

	public void setQueryTimeout(int seconds) throws SQLException {
		statement.setQueryTimeout(seconds);
	}

	public boolean isClosed() throws SQLException {
		return false;
	}

	public boolean isPoolable() throws SQLException {
		return false;
	}

	public void setPoolable(boolean poolable) throws SQLException {

	}

	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return false;
	}

	public <T> T unwrap(Class<T> iface) throws SQLException {
		return null;
	}

}