package model.dao;

import model.entity.Toy;

public interface ToyDAO {
    Toy[] getAllToys();
    void setToys(Toy[] toys);
    void deleteToys(Toy[] toys);
    void updateToys(Toy[] toys);

}
