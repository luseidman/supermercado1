class Producto implements Comparable<Producto> {
    private String nombre;
    private String atributo;
    private double precio;

    public Producto(String nombre, String atributo, double precio) {
        this.nombre = nombre;
        this.atributo = atributo;
        this.precio = precio;
    }

    @Override
    public int compareTo(Producto otroProducto) {
        return Double.compare(this.precio, otroProducto.precio);
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " /// " + atributo + " /// Precio: $" + precio;
    }

    public String getNombre() {
        return nombre;
    }
}

class Main {
    public static void main(String[] args) {
        Producto[] productos = cargarProductos();
        imprimirLista(productos);
        imprimirProductosMasCaroYMasBarato(productos);
    }

    private static Producto[] cargarProductos() {
        Producto[] productos = new Producto[4];
        productos[0] = new Producto("Coca-Cola Zero", "Litros: 1.5", 20);
        productos[1] = new Producto("Coca-Cola", "Litros: 1.5", 18);
        productos[2] = new Producto("Shampoo Sedal", "Contenido: 500ml", 19);
        productos[3] = new Producto("Frutillas", "Precio: $64 /// Unidad de venta: kilo", 64);
        return productos;
    }

    private static void imprimirLista(Producto[] productos) {
        for (Producto producto : productos) {
            System.out.println(producto);
        }
        System.out.println("=============================");
    }

    private static void imprimirProductosMasCaroYMasBarato(Producto[] productos) {
        // Encontrar el producto más caro y más barato
        Producto masCaro = productos[0];
        Producto masBarato = productos[0];

        for (Producto producto : productos) {
            if (producto.compareTo(masCaro) > 0) {
                masCaro = producto;
            }
            if (producto.compareTo(masBarato) < 0) {
                masBarato = producto;
            }
        }

        System.out.println("Producto más caro: " + masCaro.getNombre());
        System.out.println("Producto más barato: " + masBarato.getNombre());
    }
}