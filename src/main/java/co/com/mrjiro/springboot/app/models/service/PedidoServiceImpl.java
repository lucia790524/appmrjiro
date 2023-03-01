package co.com.mrjiro.springboot.app.models.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.mrjiro.springboot.app.models.dao.IPedidoDao;
import co.com.mrjiro.springboot.app.models.entity.Pedido;

@Service
public class PedidoServiceImpl implements IPedidoService {


    @Autowired
    private IPedidoDao PedidoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Pedido> findAll() {
        return (List<Pedido>) PedidoDao.findAll();
    }

    @Override
    @Transactional
    public void save(Pedido pedido) {
        PedidoDao.save(pedido);
    }

    @Override
    @Transactional(readOnly = true)
    public Pedido findOne(Long idPedido) {
        return (Pedido) PedidoDao.findById(idPedido).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long idPedido) {
        PedidoDao.deleteById(idPedido);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Pedido> findAll(Pageable pageable) {
        return PedidoDao.findAll(pageable);
    }

}
