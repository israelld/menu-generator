package dev.israelld.foodorganizer.services;


import dev.israelld.foodorganizer.models.FoodPerMeal;
import dev.israelld.foodorganizer.models.Meal;
import dev.israelld.foodorganizer.repositories.FoodPerMealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodPerMealService {

    @Autowired
    private FoodPerMealRepository repository;
    @Autowired
    private MealService mealService;
    @Autowired
    private FoodService foodService;



    public FoodPerMeal findById(Long id) {
        Optional<FoodPerMeal> obj = repository.findById(id);
        return obj.orElse(null);
    }

    public List<FoodPerMeal> findAll() {
        return repository.findAll();
    }

    public List<FoodPerMeal> findByMeal(Meal meal) {
        List<FoodPerMeal> obj = this.repository.findByMeal(meal);
        return obj;
    }

    public FoodPerMeal updateById(Long id, FoodPerMeal obj) {
        FoodPerMeal newObj = findById(id);
        newObj.setId(id);
        newObj.setFood(obj.getFood());
        newObj.setMeal(obj.getMeal());
        newObj.setQuantity(obj.getQuantity());
        return repository.save(newObj);
    }

    public FoodPerMeal update(FoodPerMeal obj) {
        FoodPerMeal newObj = findById(obj.getId());
        newObj.setId(obj.getId());
        newObj.setFood(obj.getFood());
        newObj.setMeal(obj.getMeal());
        newObj.setQuantity(obj.getQuantity());
        return repository.save(newObj);
    }

    public FoodPerMeal create(FoodPerMeal obj) {
        return repository.save(obj);
    }
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }
}
