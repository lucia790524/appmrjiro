package co.com.mrjiro.springboot.app.models.dao;
import co.com.mrjiro.springboot.app.models.entity.Pedido;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IPedidoDao extends PagingAndSortingRepository<Pedido,Long> {
}
