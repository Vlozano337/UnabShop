package co.edu.unab.valerialozano.unabshop


import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import co.edu.unab.valerialozano.unabshop.ProductoRepository
import co.edu.unab.valerialozano.unabshop.Producto

class ProductoViewModel : ViewModel() {

    private val repository = ProductoRepository()

    var listaProductos = mutableStateOf<List<Producto>>(emptyList())
        private set

    var cargando = mutableStateOf(false)
        private set

    fun cargarProductos() {
        cargando.value = true
        repository.obtenerProductos {
            listaProductos.value = it
            cargando.value = false
        }
    }

    fun agregarProducto(nombre: String, descripcion: String, precio: Double) {
        val producto = Producto(nombre = nombre, descripcion = descripcion, precio = precio)
        repository.agregarProducto(producto) { exito ->
            if (exito) cargarProductos()
        }
    }

    fun eliminarProducto(id: String) {
        repository.eliminarProducto(id) { exito ->
            if (exito) cargarProductos()
        }
    }
}