package com.ipartek.formacion.uf2213.accesodatos;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedHashSet;

import com.ipartek.formacion.uf2213.dtos.ClienteDTO;

import static com.ipartek.formacion.uf2213.accesodatos.AccesoDatos.*;

public class ClienteAccesoDatos {
	private static final String SQL_SELECT = "CALL clientes_select()";
	private static final String SQL_SELECT_ID = "CALL clientes_select_id(?)";

	private static final String SQL_INSERT = "CALL clientes_insert(?,?,?,?,?)";
	private static final String SQL_UPDATE = "CALL clientes_update(?,?,?,?,?,?)";
	private static final String SQL_DELETE = "CALL clientes_delete(?)";

	public static LinkedHashSet<ClienteDTO> obtenerTodos() throws SQLException {
		CallableStatement cst = con.prepareCall(SQL_SELECT);
		ResultSet rs = cst.executeQuery();

		var clientes = new LinkedHashSet<ClienteDTO>();

		ClienteDTO cliente;

		while (rs.next()) {
			cliente = filaACliente(rs);
			clientes.add(cliente);
		}

		return clientes;
	}

	public static ClienteDTO obtenerPorId(long id) throws SQLException {
		CallableStatement cst = con.prepareCall(SQL_SELECT_ID);

		cst.setLong(1, id);

		ResultSet rs = cst.executeQuery();

		ClienteDTO cliente = null;

		if (rs.next()) {
			cliente = filaACliente(rs);
		}

		return cliente;
	}

	public static void insertar(ClienteDTO cliente) throws SQLException {
		CallableStatement cst = con.prepareCall(SQL_INSERT);

		cst.setString(1, cliente.dni());

		Integer dniDiferencial = cliente.dniDiferencial();

		if (dniDiferencial == null) {
			dniDiferencial = 0;
		}

		cst.setInt(2, dniDiferencial);
		cst.setString(3, cliente.nombre());
		cst.setString(4, cliente.apellidos());
		cst.setDate(5, cliente.fechaNacimiento() != null ? java.sql.Date.valueOf(cliente.fechaNacimiento()) : null);

		cst.executeUpdate();
	}

	public static void modificar(ClienteDTO cliente) throws SQLException {
		CallableStatement cst = con.prepareCall(SQL_UPDATE);

		cst.setLong(1, cliente.id());
		cst.setString(2, cliente.dni());

		Integer dniDiferencial = cliente.dniDiferencial();

		if (dniDiferencial == null) {
			dniDiferencial = 0;
		}

		cst.setInt(3, dniDiferencial);
		cst.setString(4, cliente.nombre());
		cst.setString(5, cliente.apellidos());
		cst.setDate(6, cliente.fechaNacimiento() != null ? java.sql.Date.valueOf(cliente.fechaNacimiento()) : null);

		cst.executeUpdate();
	}

	public static void borrar(long id) throws SQLException {
		CallableStatement cst = con.prepareCall(SQL_DELETE);

		cst.setLong(1, id);

		cst.executeUpdate();
	}

	public static ClienteDTO filaACliente(ResultSet rs) throws SQLException {
		ClienteDTO cliente;
	
		java.sql.Date fechaBdd = rs.getDate("fecha_nacimiento");
		LocalDate fechaNacimiento = fechaBdd == null ? null : fechaBdd.toLocalDate();
	
		cliente = new ClienteDTO(rs.getLong("id"), rs.getString("dni"), rs.getInt("dni_diferencial"),
				rs.getString("nombre"), rs.getString("apellidos"), fechaNacimiento);
		
		return cliente;
	}
}