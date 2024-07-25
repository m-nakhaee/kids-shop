package business;

import model.dto.ToyDTO;

public interface ToyService {
    ToyDTO[] getAllToys();
    void setToys(ToyDTO[] toys);
    void deleteToys(ToyDTO[] toys);
    void updateToys(ToyDTO[] toys);
}
