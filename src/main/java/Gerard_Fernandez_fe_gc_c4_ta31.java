
public class Gerard_Fernandez_fe_gc_c4_ta31 {

	public static void main(String[] args) {
		Mysql_Connection connexion= new Mysql_Connection();
		
		connexion.createDB("TA_31");
		
		connexion.createTable("TA_31", "Fabricantes", 
					"Codigo int,"
					+ "Nombre nvarchar(100),"
					+ "Primary key(Codigo)"
				);
		
		connexion.createTable("TA_31", "Articulos", 
				"Codigo int,"
				+ "Nombre nvarchar(100),"
				+ "Precio int,"
				+ "Fabricante int,"
				+ "Primary key(Codigo),"
				+ "FOREIGN KEY(Fabricante) REFERENCES Fabricantes(Codigo)"
				+ " ON DELETE CASCADE"
				+ " ON UPDATE CASCADE"
			);
		
		connexion.insertData("TA_31", "Fabricantes", "Codigo, Nombre", "\"0\", \"Samsung\"");
		connexion.insertData("TA_31", "Fabricantes", "Codigo, Nombre", "'1', 'Huawei'");
		connexion.insertData("TA_31", "Fabricantes", "Codigo, Nombre", "'2', 'Oppo'");
		connexion.insertData("TA_31", "Fabricantes", "Codigo, Nombre", "'3', 'Xiaomi'");
		connexion.insertData("TA_31", "Fabricantes", "Codigo, Nombre", "'4', 'Apple'");
		
		connexion.insertData("TA_31", "Articulos", "Codigo, Nombre, Precio, Fabricante", "'0', 'Iphone30XXL', '10000', '4'");
		connexion.insertData("TA_31", "Articulos", "Codigo, Nombre, Precio, Fabricante", "'1', 'SamsungSAM150', '950', '0'");
		connexion.insertData("TA_31", "Articulos", "Codigo, Nombre, Precio, Fabricante", "'2', 'Xiaomi13', '150', '3'");
		connexion.insertData("TA_31", "Articulos", "Codigo, Nombre, Precio, Fabricante", "'3', 'OppoAA20', '140', '2'");
		connexion.insertData("TA_31", "Articulos", "Codigo, Nombre, Precio, Fabricante", "'4', 'HuaweiBet17X', '280', '1'");
		
		System.out.println();
		System.out.println("===FABRICANTES====");
		String[] valuesFabricante= {"Codigo", "Nombre"};
		connexion.getValues("TA_31", "Fabricantes", valuesFabricante);
		
		System.out.println();
		System.out.println("===ARTICULOS====");
		String[] valuesArticulos= {"Codigo", "Nombre", "Precio", "Fabricante"};
		connexion.getValues("TA_31", "Articulos", valuesArticulos);
		
		connexion.closeConnection();

	}

}
