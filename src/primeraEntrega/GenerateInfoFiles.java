package primeraEntrega;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.text.NumberFormat;
import java.util.Locale;

public class GenerateInfoFiles {
    public static void main(String[] args) {
        int numFiles = 5; // El n�mero de archivos a generar se defini� en 5

        // Generar los archivos
        for (int i = 1; i <= numFiles; i++) {
            String salesFilename = "archivo_ventas" + i + ".txt"; // Nombre del archivo de ventas
            String sellersFilename = "archivo_vendedores" + i + ".txt"; // Nombre del archivo de vendedores
            String productsFilename = "archivo_productos" + i + ".txt"; // Nombre del archivo de productos

            generateSalesFile(salesFilename); // Generar el archivo de ventas
            generateSellersFile(sellersFilename); // Generar el archivo de vendedores
            generateProductsFile(productsFilename); // Generar el archivo de productos
        }

        System.out.println("Archivos generados exitosamente.");
    }
 
    // M�todos para generar los archivos
    private static void generateSalesFile(String filename) {
        try {
            FileWriter writer = new FileWriter(filename);

            // Escribir el tipo y n�mero de documento del vendedor
            String tipoDocumento = generateRandomTipoDocumento();
            String numeroDocumento = generateRandomNumeroDocumento();
            writer.write(tipoDocumento + ";" + numeroDocumento + "\n"); // Separar el tipo y n�mero de documento con ; e imprimir nueva l�nea

            // Escribir informaci�n de productos vendidos
            Random random = new Random();
            for (int i = 1; i <= 10; i++) { // Suponiendo que se venden 10 productos
                String productoID = generateRandomProductID(); // Generar ID del producto
                int cantidadVendida = random.nextInt(100); // Cantidad vendida entre 0 y 100
                writer.write(productoID + ";" + cantidadVendida + "\n"); // Separar el ID del producto y la cantidad vendida con ; e imprimir nueva l�nea
            }

            writer.close(); // Cerrar el escritor
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo de ventas: " + filename);
            e.printStackTrace();
        }
    }

    private static void generateSellersFile(String filename) {
        try {
            FileWriter writer = new FileWriter(filename);

            // Escribir informaci�n de vendedores
            String tipoDocumento = generateRandomTipoDocumento();
            String numeroDocumento = generateRandomNumeroDocumento();
            String nombresVendedor = generateRandomNames();
            String apellidosVendedor = generateRandomLastNames();
            writer.write(tipoDocumento + ";" + numeroDocumento + ";" + nombresVendedor + ";" + apellidosVendedor + "\n"); //Separar tipo, n�mero de documento, nombres y apellidos del vendedor con ; e imprimir nueva l�nea

            writer.close(); // Cerrar el escritor
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo de vendedores: " + filename);
            e.printStackTrace();
        }
    }

    private static void generateProductsFile(String filename) {
        try {
            FileWriter writer = new FileWriter(filename);

            // Escribir informaci�n de productos
            Random random = new Random();
            for (int i = 1; i <= 10; i++) { // Suponiendo que hay 10 productos
                String productoID = generateRandomProductID(); // Generar ID del producto
                String nombreProducto = generateRandomProductName(); // Generar nombre del producto
                int precioPorUnidad = 1000 + random.nextInt(9000); // Generar precio del producto entre 1000 y 9999
                String formattedPrice = NumberFormat.getNumberInstance(Locale.US).format(precioPorUnidad); // Formatear con separadores de miles
                writer.write(productoID + ";" + nombreProducto + ";" + formattedPrice + "\n"); // Separar ID del producto, nombre del producto y precio por unidad con ; e imprimir nueva l�nea
            }

            writer.close(); // Cerrar el escritor
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo de productos: " + filename);
            e.printStackTrace();
        }
    }

    // M�todos para generar datos aleatorios
    private static String generateRandomTipoDocumento() {
        String[] tiposDocumentos = {"CC", "TI", "CE","PAS"}; // Tipos de documento
        Random random = new Random();
        int index = random.nextInt(tiposDocumentos.length);
        return tiposDocumentos[index];
    }

    private static String generateRandomNumeroDocumento() {
        Random random = new Random();
        StringBuilder numeroDocumento = new StringBuilder();
        for (int i = 0; i < 10; i++) { // Documento de 10 d�gitos
            numeroDocumento.append(random.nextInt(10));
        }
        return numeroDocumento.toString();
    }

    private static String generateRandomNames() {
        String[] nombres = {"Juan Manuel", "Ana Mar�a", "Luis Carlos", "Luisa Fernanda", "Pedro", "Luz Mery"}; //Ejemplos de nombres
        Random random = new Random();
        int index = random.nextInt(nombres.length);
        return nombres[index];
    }

    private static String generateRandomLastNames() {
        String[] apellidos = {"Garc�a Diaz", "Mart�nez Perez", "Rodr�guez Rios", "Fern�ndez Alba", "L�pez Botello", "G�mez Barrera"}; //Ejemplos de apellidos
        Random random = new Random();
        int index = random.nextInt(apellidos.length);
        return apellidos[index];
    }

    private static String generateRandomProductID() {
        Random random = new Random();
        StringBuilder productID = new StringBuilder();
        for (int i = 0; i < 10; i++) { // ID de producto de 10 d�gitos
            productID.append(random.nextInt(10)); // D�gito aleatorio entre 0 y 9
        }
        return productID.toString();
    }

    private static String generateRandomProductName() {
        String[] nombresProductos = {"Producto1", "Producto2", "Producto3", "Producto4", "Producto5"}; //Ejemplos de nombres de productos
        Random random = new Random();
        int index = random.nextInt(nombresProductos.length);
        return nombresProductos[index];
    }
}
