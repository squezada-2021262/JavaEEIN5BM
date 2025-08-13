
package modelo;
 
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
 
public class CuentasDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

    public Cuentas validar(String correoCuenta, String contrasenaCuenta) {
        Cuentas cuenta = new Cuentas();
        String sql = "select * from Cuentas where correoCuenta = ? and contrasenaCuenta = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareCall(sql);
            ps.setString(1, correoCuenta);
            ps.setString(2, contrasenaCuenta);
            rs = ps.executeQuery();
            while (rs.next()) {
                cuenta.setCodigoCuenta(rs.getInt("codigoCuenta"));
                cuenta.setCodigoUsuario(rs.getInt("codigoUsuario"));
                cuenta.setContrasenaCuenta(rs.getString("contrasenaCuenta"));
                cuenta.setCorreoCuenta(rs.getString("correoCuenta"));
                cuenta.setNombreCuenta(rs.getString("correoCuenta"));
            }
        } catch (Exception e) {
            System.out.println("El usuario o contraseña son incorrectos");
            e.printStackTrace();
        }
        return cuenta;
    }
}
