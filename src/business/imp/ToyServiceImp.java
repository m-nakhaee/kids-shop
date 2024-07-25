package business.imp;

import business.ToyService;
import convertor.ToyMapper;
import model.dao.ToyDAO;
import model.dao.imp.ToyDAOImp;
import model.dto.ToyDTO;
import model.entity.Toy;
import org.mapstruct.factory.Mappers;

public class ToyServiceImp implements ToyService {
    @Override
    public ToyDTO[] getAllToys() {
        ToyDAO toyDAO = new ToyDAOImp();
        Toy[] allToys = toyDAO.getAllToys();
        ToyMapper toyMapper = Mappers.getMapper(ToyMapper.class);
        return  toyMapper.toDTOs(allToys);
    }

    @Override
    public void setToys(ToyDTO[] toys) {
        ToyMapper toyMapper = Mappers.getMapper(ToyMapper.class);
        Toy[] entities = toyMapper.toEntities(toys);
        ToyDAO toyDAO = new ToyDAOImp();
        toyDAO.setToys(entities);
    }

    @Override
    public void deleteToys(ToyDTO[] toys) {
        ToyMapper toyMapper = Mappers.getMapper(ToyMapper.class);
        Toy[] entities = toyMapper.toEntities(toys);
        ToyDAO toyDAO = new ToyDAOImp();
        toyDAO.deleteToys(entities);
    }

    @Override
    public void updateToys(ToyDTO[] toys) {
        ToyMapper toyMapper = Mappers.getMapper(ToyMapper.class);
        Toy[] entities = toyMapper.toEntities(toys);
        //TODO setting edited flag
        ToyDAO toyDAO = new ToyDAOImp();
        toyDAO.updateToys(entities);
    }
}
