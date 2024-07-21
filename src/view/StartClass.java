package view;

import business.ToyService;
import business.imp.ToyServiceImp;
import model.dto.ToyDTO;

import java.util.Arrays;

public class StartClass {

    public static void main(String[] args) {
        ToyService toyService = new ToyServiceImp();
        ToyDTO[] allToys = toyService.getAllToys();
        System.out.printf(Arrays.toString(allToys));
    }
}
