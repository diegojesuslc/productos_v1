package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Categoria;
import model.Producto;
import utils.MySqlConexion;

public class ProductoDAOImpl implements ProductoDAO{
	
	@Override
	public ArrayList<Producto> listarProductos() {
		ArrayList<Producto> list = new ArrayList<Producto>();
		Connection cn = null;
		CallableStatement cs = null;
        ResultSet rs = null;
		
        try {
        	cn = MySqlConexion.getConexion(); 
            cs = cn.prepareCall("{CALL ListarProductos}");
            rs = cs.executeQuery();
            
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setIdProd(rs.getInt(1));
                producto.setNombreProd(rs.getString(2));
                producto.setNombreCat(rs.getString(3));
                producto.setDesProd(rs.getString(4));
                producto.setImagen(rs.getString(5));
                producto.setPrecio(rs.getDouble(6));
                producto.setCalificacion(rs.getDouble(7));

                list.add(producto);
            }
        } catch (Exception e) {
            // Manejo de excepciones
        	System.out.println(e.getMessage());
        } finally {
            // Cierre de recursos
        	try {
        		if(rs!=null) rs.close();
        		if(cs!=null) cs.close();
        		if(cn!=null) cn.close();
			} catch (SQLException e2) {
				System.out.println(e2.getMessage());
			}
        }
		return list;
	}

	@Override
	public int agregarProducto(Producto prod) {
		Connection cn = null;
		CallableStatement cs= null;
		 try {
			 cn = MySqlConexion.getConexion();
			 cs = cn.prepareCall("{call InsertarProducto(?,?,?,?,?,?)}");
			 cs.setString(1, prod.	getNombreProd());
			 cs.setInt(2, prod.getIdCat());
			 cs.setString(3, prod.getDesProd());
			 cs.setString(4, prod.getImagen());			 
			 cs.setDouble(5, prod.getPrecio());
			 cs.setDouble(6, prod.getCalificacion());
			 cs.executeUpdate();
		 }
		 catch(Exception error) {
			 System.out.println(error.getMessage());
		 } finally {
			 try {
					if(cs!=null) cs.close();
					if(cn!=null) cn.close();
				} catch (SQLException e2) {
					System.out.println(e2.getMessage());
				}
		}
		return 0;
	}

	@Override
	public int actualizarProducto(Producto prod) {
		Connection cn = null;
		CallableStatement cs= null;
		 try {
			 cn = MySqlConexion.getConexion();
			 cs = cn.prepareCall("{CALL ActualizarProducto(?,?,?,?,?,?,?)}");
			 cs.setInt(1, prod.getIdProd());
			 cs.setString(2, prod.	getNombreProd());
			 cs.setInt(3, prod.getIdCat());
			 cs.setString(4, prod.getDesProd());
			 cs.setString(5, prod.getImagen());			 
			 cs.setDouble(6, prod.getPrecio());
			 cs.setDouble(7, prod.getCalificacion());
			 int response = cs.executeUpdate();
			 cn.close();
			 return response;
		 }
		 catch(Exception error) {
			 System.out.println(error.getMessage());
		 } finally {
			 try {
					if(cs!=null) cs.close();
					if(cn!=null) cn.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
		}
		return 0;
	}

	@Override
	public boolean eliminarProducto(int id) {
		Connection cn = null;
		CallableStatement cs= null;
		 try {
			 cn = MySqlConexion.getConexion();
			 cs = cn.prepareCall("{CALL EliminarProducto(?)}");
			 cs.setInt(1, id);
			 cs.executeUpdate();
			 return true;
		 }
		 catch(Exception error) {
			 System.out.println(error.getMessage());
		 } finally {
			 try {
					if(cs!=null) cs.close();
					if(cn!=null) cn.close();
				} catch (SQLException e2) {
					System.out.println(e2.getMessage());
				}
		}
		return false;
	}

	@Override
	public Producto buscarProducto(int id) {
		Producto producto = null;
		Connection cn = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		try {
			 cn = MySqlConexion.getConexion();
			 cs = cn.prepareCall("{CALL BuscarProductoPorID(?)}");
			 cs.setInt(1, id);
			 rs = cs.executeQuery();
			 while (rs.next()) {
				producto = new Producto(
						rs.getInt("id_prod"),
						rs.getString("nombre_prod"),
						rs.getInt("id_cat"),
						rs.getString("des_prod"),
						rs.getString("imagen"),
						rs.getDouble("precio"),
						rs.getDouble("calificacion")
						);
			}
		 }
		 catch(Exception error) {
			 System.out.println(error.getMessage());
		 } finally {
			 try {
					if(cs!=null) cs.close();
					if(cn!=null) cn.close();
				} catch (SQLException e2) {
					System.out.println(e2.getMessage());
				}
		}
		return producto;
	}

	@Override
	public ArrayList<Categoria> listarCategorias() {
		ArrayList<Categoria> list = null;
		Connection cn = null;
		PreparedStatement ps = null;
        ResultSet rs = null;
		
        try {
        	cn = MySqlConexion.getConexion(); 
        	String sql = "select * from categoria";
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            list = new ArrayList<Categoria>();
            while (rs.next()) {
                Categoria categorias = new Categoria();
                categorias.setIdCat(rs.getInt(1));
                categorias.setNombreCat(rs.getString(2));
                categorias.setDescCat(rs.getString(3));
                
                list.add(categorias);
            }
        } catch (SQLException e) {
            // Manejo de excepciones
        	System.out.println(e.getMessage());
        } finally {
            // Cierre de recursos
        	try {
				rs.close();
				ps.close();
				cn.close();
			} catch (SQLException e2) {
				System.out.println(e2.getLocalizedMessage());
			}
        }
		return list;
	}

}
