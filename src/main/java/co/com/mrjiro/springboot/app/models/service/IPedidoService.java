package co.com.mrjiro.springboot.app.models.service;
import java.util.List;
import co.com.mrjiro.springboot.app.models.entity.Pedido;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPedidoService {
	public List<Pedido> findAll();
	public Page<Pedido> findAll(Pageable pageable);
	public void save(Pedido pedido);
	public Pedido findOne(Long idPedido);
	public void  delete(Long idPedido);
}
