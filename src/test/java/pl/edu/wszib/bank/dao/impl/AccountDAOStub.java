package pl.edu.wszib.bank.dao.impl;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import pl.edu.wszib.bank.dao.IAccountDAO;
import pl.edu.wszib.bank.model.Account;
import pl.edu.wszib.bank.model.User;

import java.util.List;
import java.util.Optional;

public class AccountDAOStub implements IAccountDAO {
    @Override
    public Account findAccountByAccNumber(String accountNumTo) {
        return null;
    }

    @Override
    public Account findAccountById(int id) {
        return null;
    }

    @Override
    public List<Account> findAccountsByUserID(User user) {
        return null;
    }

    @Override
    public List<Account> findAll() {
        return null;
    }

    @Override
    public List<Account> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Account> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Account> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Account account) {

    }

    @Override
    public void deleteAll(Iterable<? extends Account> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Account> S save(S s) {
        return null;
    }

    @Override
    public <S extends Account> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Account> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Account> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Account> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Account getOne(Integer integer) {
        return null;
    }

    @Override
    public <S extends Account> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Account> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Account> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Account> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Account> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Account> boolean exists(Example<S> example) {
        return false;
    }
}
