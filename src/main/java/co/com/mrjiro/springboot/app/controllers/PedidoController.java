package co.com.mrjiro.springboot.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import co.com.mrjiro.springboot.app.models.dao.IProductoDao;
import co.com.mrjiro.springboot.app.models.entity.Pedido;
import co.com.mrjiro.springboot.app.models.entity.PedidosProducto;
import co.com.mrjiro.springboot.app.models.entity.Producto;
import co.com.mrjiro.springboot.app.models.service.IPedidoService;

@Controller
@SessionAttributes ("pedido")
public class PedidoController {

	
		@Autowired
		private IProductoDao productoDao;
		
		@Autowired
		private IPedidoService pedidoService;
		
		@RequestMapping(value="/registro/pedido", method = RequestMethod.GET)
		public String listar(Model model) {
			model.addAttribute("titulo", "Listado de Pedidos");
			model.addAttribute("productos", productoDao.findAll());
			
			Pedido pedido = new Pedido();
			
			model.addAttribute("pedido",pedido);
			return "formularios/frm_registro_pedido";
		}
		
		@RequestMapping(value="/pedido/agregar",  method = RequestMethod.POST)
		public String agregarProductoAlPedido(@ModelAttribute("pedido") Pedido pedido, @RequestParam("precio") int precio, @RequestParam("accion") String accion) {
		   // pedido.agregarProducto(pedidoProducto);
			pedido.setPrecio(precio);
		    return "redirect:/registro/pedido";
		}
}
