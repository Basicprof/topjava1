package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.User;

import java.util.List;
import java.util.Optional;
@Transactional
public interface CrudMealRepository extends JpaRepository<Meal, Integer> {
    @Transactional
    @Modifying
//    @Query(name = User.DELETE)
    @Query("DELETE FROM Meal m WHERE m.id=:id AND m.user.id =: userId ")
    int delete(@Param("id") int id,@Param("userId") int userId);

    @Override
    @Transactional
    Meal save(Meal meal);

    @Override
    Optional<Meal> findById(Integer id);

    @Override
    List<Meal> findAll();

    @Override
    List<Meal> findAll(Sort sort);

    @Override
    List<Meal> findAllById(Iterable<Integer> iterable);

    @Override
    <S extends Meal> List<S> saveAll(Iterable<S> iterable);

    @Override
    void flush();

    @Override
    <S extends Meal> S saveAndFlush(S s);

    @Override
    void deleteInBatch(Iterable<Meal> iterable);

    @Override
    void deleteAllInBatch();

    @Override
    Meal getOne(Integer integer);

    @Override
    <S extends Meal> List<S> findAll(Example<S> example);

    @Override
    <S extends Meal> List<S> findAll(Example<S> example, Sort sort);

    User getByEmail(String email);
}
